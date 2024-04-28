package plus.jqm.hello.auth.handler;

import cn.dev33.satoken.exception.SaTokenException;
import cn.dev33.satoken.spring.SpringMVCUtil;
import cn.dev33.satoken.stp.StpUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;
import plus.jqm.hello.common.core.constant.AuthConstants;
import plus.jqm.hello.common.core.constant.StatusConstants;
import plus.jqm.hello.common.core.util.MessageSourceUtils;
import plus.jqm.hello.common.core.util.R;

/**
 * 全局异常处理
 *
 * @author xjq
 * @date 2024/04/28
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(SaTokenException.class)
    public R<Void> handleSaTokenException(SaTokenException e) {
        HttpServletRequest request = SpringMVCUtil.getRequest();
        log.warn("requestURI:{}, user:{}, errorMessage:{}", request.getRequestURI(), StpUtil.getExtra(AuthConstants.LOGIN_USERNAME), e.getMessage());
        String message = MessageSourceUtils.getMessage("user.access.denied");
        return R.build(StatusConstants.USER_ACCESS_DENIED, message, null);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoResourceFoundException.class)
    public R<Void> handleNoResourceFoundException(NoResourceFoundException e) {
        HttpServletRequest request = SpringMVCUtil.getRequest();
        log.warn("requestURI:{}, errorMessage:{}", request.getRequestURI(), e.getMessage(), e);
        String message = MessageSourceUtils.getMessage("system.resource.not.found");
        return R.build(StatusConstants.SYSTEM_RESOURCE_NOT_FOUND, message, null);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public R<Void> handleException(Exception e) {
        HttpServletRequest request = SpringMVCUtil.getRequest();
        log.error("requestURI:{}, errorMessage:{}", request.getRequestURI(), e.getMessage(), e);
        String message = MessageSourceUtils.getMessage("system.execution.failure");
        return R.build(StatusConstants.SYSTEM_EXECUTION_ERROR, message, null);
    }
}
