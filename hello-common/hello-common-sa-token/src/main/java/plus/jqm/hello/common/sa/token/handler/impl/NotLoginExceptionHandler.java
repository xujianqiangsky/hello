package plus.jqm.hello.common.sa.token.handler.impl;

import cn.dev33.satoken.context.model.SaResponse;
import cn.dev33.satoken.exception.NotLoginException;
import org.springframework.http.HttpStatus;
import plus.jqm.hello.common.core.constant.StatusConstants;
import plus.jqm.hello.common.core.util.MessageSourceUtils;
import plus.jqm.hello.common.core.util.R;
import plus.jqm.hello.common.sa.token.handler.HelloSaTokenExceptionHandler;

/**
 * 未登录异常处理
 *
 * @author xjq
 * @date 2024/04/25
 */
public class NotLoginExceptionHandler implements HelloSaTokenExceptionHandler {
    @Override
    public boolean support(Throwable throwable) {
        return throwable instanceof NotLoginException;
    }

    @Override
    public Object handle(SaResponse response, Throwable throwable) {
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        String message = MessageSourceUtils.getMessage("user.not.logged.in");
        return R.build(StatusConstants.USER_ACCESS_UNAUTHORIZED, message, null);
    }
}
