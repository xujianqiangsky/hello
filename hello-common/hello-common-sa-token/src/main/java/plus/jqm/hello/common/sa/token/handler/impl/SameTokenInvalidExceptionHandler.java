package plus.jqm.hello.common.sa.token.handler.impl;

import cn.dev33.satoken.context.model.SaResponse;
import cn.dev33.satoken.exception.SameTokenInvalidException;
import org.springframework.http.HttpStatus;
import plus.jqm.hello.common.core.constant.StatusConstants;
import plus.jqm.hello.common.core.util.MessageSourceUtils;
import plus.jqm.hello.common.core.util.R;
import plus.jqm.hello.common.sa.token.handler.HelloSaTokenExceptionHandler;

/**
 * 无效 SameToken 异常处理
 *
 * @author xjq
 * @date 2024/04/26
 */
public class SameTokenInvalidExceptionHandler implements HelloSaTokenExceptionHandler {
    @Override
    public boolean support(Throwable throwable) {
        return throwable instanceof SameTokenInvalidException;
    }

    @Override
    public Object handle(SaResponse response, Throwable throwable) {
        response.setStatus(HttpStatus.FORBIDDEN.value());
        String message = MessageSourceUtils.getMessage("user.access.illegal");
        return R.build(StatusConstants.USER_ACCESS_ILLEGAL, message, null);
    }
}
