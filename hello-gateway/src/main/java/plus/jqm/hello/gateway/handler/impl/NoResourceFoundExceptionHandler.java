package plus.jqm.hello.gateway.handler.impl;

import org.springframework.web.reactive.resource.NoResourceFoundException;
import org.springframework.web.server.ServerWebExchange;
import plus.jqm.hello.common.core.constant.StatusConstants;
import plus.jqm.hello.common.core.util.MessageSourceUtils;
import plus.jqm.hello.common.core.util.R;
import plus.jqm.hello.gateway.handler.HelloExceptionHandler;

/**
 * NoResourceFound 异常处理器
 *
 * @author xjq
 * @date 2024/04/28
 */
public class NoResourceFoundExceptionHandler implements HelloExceptionHandler {
    @Override
    public boolean support(Throwable throwable) {
        return throwable instanceof NoResourceFoundException;
    }

    @Override
    public Object handle(ServerWebExchange exchange, Throwable throwable) {
        String message = MessageSourceUtils.getMessage("system.resource.not.found");
        return R.build(StatusConstants.SYSTEM_RESOURCE_NOT_FOUND, message, null);
    }
}
