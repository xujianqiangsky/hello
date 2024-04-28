package plus.jqm.hello.auth.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import plus.jqm.hello.auth.exception.UsernameOrPasswordException;
import plus.jqm.hello.common.core.constant.StatusConstants;
import plus.jqm.hello.common.core.util.MessageSourceUtils;
import plus.jqm.hello.common.core.util.R;

/**
 * 用户异常处理
 *
 * @author xjq
 * @date 2024/04/28
 */
@Order(1)
@Slf4j
@RestControllerAdvice
public class UserExceptionHandler {
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UsernameOrPasswordException.class)
    public R<Void> handleUsernameOrPasswordException(UsernameOrPasswordException e) {
        String message = MessageSourceUtils.getMessage(e.getMessage());
        return R.build(StatusConstants.USER_LOGIN_FAILURE, message, null);
    }
}
