package plus.jqm.hello.gateway.handler;

import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.AbstractErrorWebExceptionHandler;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.*;
import plus.jqm.hello.common.core.constant.StatusConstants;
import plus.jqm.hello.common.core.util.MessageSourceUtils;
import plus.jqm.hello.common.core.util.R;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * 全局异常处理
 *
 * @author xjq
 * @date 2024/04/21
 */
@Order(-1)
public class GlobalExceptionHandler extends AbstractErrorWebExceptionHandler {
    public GlobalExceptionHandler(ErrorAttributes errorAttributes, WebProperties.Resources resources, ApplicationContext applicationContext) {
        super(errorAttributes, resources, applicationContext);
    }

    @Override
    protected RouterFunction<ServerResponse> getRoutingFunction(ErrorAttributes errorAttributes) {
        return RouterFunctions.route(RequestPredicates.all(), this::renderErrorResponse);
    }

    protected Mono<ServerResponse> renderErrorResponse(ServerRequest request) {
        ErrorAttributeOptions errorAttributeOptions = ErrorAttributeOptions.defaults();
        Map<String, Object> error = getErrorAttributes(request, errorAttributeOptions);
        String message = MessageSourceUtils.getMessage("system.execution.failure");
        return ServerResponse.status(getHttpStatus(error))
                             .contentType(MediaType.APPLICATION_JSON)
                             .body(BodyInserters.fromValue(R.build(StatusConstants.SYSTEM_EXECUTION_ERROR, message, null)));
    }

    protected int getHttpStatus(Map<String, Object> errorAttributes) {
        return (int) errorAttributes.get("status");
    }
}
