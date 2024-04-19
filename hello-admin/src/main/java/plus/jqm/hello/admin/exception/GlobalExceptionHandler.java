package plus.jqm.hello.admin.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;
import plus.jqm.hello.common.core.constant.StatusConstants;
import plus.jqm.hello.common.core.util.MessageSourceUtils;
import plus.jqm.hello.common.core.util.R;

/**
 * 全局异常处理
 *
 * @author xjq
 * @date 2024/04/19
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NoResourceFoundException.class)
    public R<Object> handleNoResourceFoundException(NoResourceFoundException e) {
        log.warn("resource not found: {}", e.getMessage());
        String message = MessageSourceUtils.getMessage("system.resource.not.found");
        return R.build(StatusConstants.SYSTEM_RESOURCE_NOT_FOUND, message, null);
    }

    @ExceptionHandler(Exception.class)
    public R<Object> handleException(Exception e) {
        log.error("errorMessage: {}", e.getMessage(), e);
        String message = MessageSourceUtils.getMessage("system.execution.failure");
        return R.build(StatusConstants.SYSTEM_EXECUTION_ERROR, message, null);
    }
}
