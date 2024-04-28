package plus.jqm.hello.gateway.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;
import plus.jqm.hello.common.core.constant.StatusConstants;
import plus.jqm.hello.common.core.util.MessageSourceUtils;
import plus.jqm.hello.common.core.util.R;
import plus.jqm.hello.gateway.handler.HelloExceptionHandler;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * 全局异常处理
 *
 * @author xjq
 * @date 2024/04/21
 */
@Order(-1)
@Slf4j
@RequiredArgsConstructor
public class GlobalExceptionHandler implements ErrorWebExceptionHandler {
    private final ObjectMapper objectMapper;
    private final List<HelloExceptionHandler> helloExceptionHandlers;

    @Override
    public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {
        ServerHttpResponse response = exchange.getResponse();
        if (response.isCommitted()) {
            return Mono.error(ex);
        }
        if (ex instanceof ResponseStatusException responseStatusException) {
            exchange.getResponse().setStatusCode(responseStatusException.getStatusCode());
        }
        response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
        Object result = process(exchange, ex);
        return response.writeWith(Mono.fromSupplier(() -> {
            DataBufferFactory bufferFactory = response.bufferFactory();
            try {
                return bufferFactory.wrap(objectMapper.writeValueAsBytes(result));
            } catch (JsonProcessingException e) {
                log.error("json processing error: {}", e.getMessage(), e);
            }
            return bufferFactory.wrap(new byte[0]);
        }));
    }

    private Object process(ServerWebExchange exchange, Throwable throwable) {
        for (HelloExceptionHandler helloExceptionHandler : helloExceptionHandlers) {
            if (helloExceptionHandler.support(throwable)) {
                return helloExceptionHandler.handle(exchange, throwable);
            }
        }
        exchange.getResponse().setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
        String message = MessageSourceUtils.getMessage("system.execution.failure");
        return R.build(StatusConstants.SYSTEM_EXECUTION_ERROR, message, null);
    }
}
