package plus.jqm.hello.common.annotation;

import org.springframework.context.annotation.Import;
import plus.jqm.hello.common.util.SpringUtils;

import java.lang.annotation.*;

/**
 * 激活 SpringUtil
 *
 * @author xjq
 * @date 2024/04/16
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(SpringUtils.class)
public @interface EnableSpringUtils {}
