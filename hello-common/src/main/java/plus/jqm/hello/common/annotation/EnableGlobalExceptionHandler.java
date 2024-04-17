package plus.jqm.hello.common.annotation;

import org.springframework.context.annotation.Import;
import plus.jqm.hello.common.handler.GlobalExceptionHandler;

import java.lang.annotation.*;

/**
 * 启用全局异常处理
 *
 * @author xjq
 * @date 2024/04/17
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(GlobalExceptionHandler.class)
public @interface EnableGlobalExceptionHandler {}
