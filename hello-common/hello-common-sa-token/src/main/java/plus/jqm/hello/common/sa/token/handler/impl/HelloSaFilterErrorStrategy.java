package plus.jqm.hello.common.sa.token.handler.impl;

import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.context.model.SaResponse;
import cn.dev33.satoken.filter.SaFilterErrorStrategy;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import plus.jqm.hello.common.core.constant.StatusConstants;
import plus.jqm.hello.common.core.util.MessageSourceUtils;
import plus.jqm.hello.common.core.util.R;
import plus.jqm.hello.common.sa.token.handler.HelloSaTokenExceptionHandler;

import java.util.List;

/**
 * SaToken 异常处理策略
 *
 * @author xjq
 * @date 2024/04/25
 */
@Slf4j
@RequiredArgsConstructor
public class HelloSaFilterErrorStrategy implements SaFilterErrorStrategy {
    private final ObjectMapper objectMapper;
    private final List<HelloSaTokenExceptionHandler> handlers;

    @Override
    public Object run(Throwable throwable) {
        SaResponse response = SaHolder.getResponse();
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
        Object result = process(response, throwable);
        try {
            return objectMapper.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            log.error("json processing error: {}", e.getMessage(), e);
        }
        return new Object();
    }

    private Object process(SaResponse response, Throwable throwable) {
        for (HelloSaTokenExceptionHandler handler : handlers) {
            if (handler.support(throwable)) {
                return handler.handle(response, throwable);
            }
        }
        String message = MessageSourceUtils.getMessage("user.error");
        return R.build(StatusConstants.USER_ERROR, message, null);
    }
}
