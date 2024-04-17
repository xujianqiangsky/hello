package plus.jqm.hello.common.annotation;

import org.springframework.context.annotation.Import;
import plus.jqm.hello.common.config.MessageSourceConfiguration;

import java.lang.annotation.*;

/**
 * 启动 MessageSource 通用配置
 *
 * @author xjq
 * @date 2024/04/17
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(MessageSourceConfiguration.class)
public @interface EnableCommonMessageSource {}
