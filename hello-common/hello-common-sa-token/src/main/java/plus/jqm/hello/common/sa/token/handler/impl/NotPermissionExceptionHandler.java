package plus.jqm.hello.common.sa.token.handler.impl;

import cn.dev33.satoken.context.model.SaResponse;
import cn.dev33.satoken.exception.NotPermissionException;
import org.springframework.http.HttpStatus;
import plus.jqm.hello.common.core.constant.StatusConstants;
import plus.jqm.hello.common.core.util.MessageSourceUtils;
import plus.jqm.hello.common.core.util.R;
import plus.jqm.hello.common.sa.token.handler.HelloSaTokenExceptionHandler;

/**
 * 权限认证未通过异常处理
 *
 * @author xjq
 * @date 2024/04/25
 */
public class NotPermissionExceptionHandler implements HelloSaTokenExceptionHandler {
    @Override
    public boolean support(Throwable throwable) {
        return throwable instanceof NotPermissionException;
    }

    @Override
    public Object handle(SaResponse response, Throwable throwable) {
        response.setStatus(HttpStatus.FORBIDDEN.value());
        String message = MessageSourceUtils.getMessage("user.access.denied");
        return R.build(StatusConstants.USER_ACCESS_DENIED, message, null);
    }
}
