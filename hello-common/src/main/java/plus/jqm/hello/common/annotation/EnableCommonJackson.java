package plus.jqm.hello.common.annotation;

import org.springframework.context.annotation.Import;
import plus.jqm.hello.common.config.JacksonConfiguration;

import java.lang.annotation.*;

/**
 * 启用 Jackson 通用配置
 *
 * @author xjq
 * @date 2024/04/17
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(JacksonConfiguration.class)
public @interface EnableCommonJackson {}
