package plus.jqm.hello.common.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;
import plus.jqm.hello.common.constant.StatusConstants;
import plus.jqm.hello.common.util.MessageSourceUtils;
import plus.jqm.hello.common.util.R;

/**
 * 全局异常处理
 *
 * @author xjq
 * @date 2024/04/17
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NoResourceFoundException.class)
    public R<Object> exception(NoResourceFoundException e) {
        String message = MessageSourceUtils.getMessage("resource.notfound");
        log.warn("No resource found: {}", message);
        return R.build(StatusConstants.SYSTEM_RESOURCE_NOT_FOUND, message, null);
    }

    @ExceptionHandler(Exception.class)
    public R<Object> exception(Exception e) {
        String message = MessageSourceUtils.getMessage(e.getMessage());
        log.error("exception: {}", message, e);
        return R.build(StatusConstants.SYSTEM_EXECUTION_ERROR, message, null);
    }
}
