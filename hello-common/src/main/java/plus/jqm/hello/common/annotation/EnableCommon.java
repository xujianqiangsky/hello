package plus.jqm.hello.common.annotation;

import java.lang.annotation.*;

/**
 * 启用通用配置
 *
 * @author xjq
 * @date 2024/04/17
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@EnableCommonJackson
@EnableCommonMessageSource
@EnableCommonRedis
@EnableSpringUtils
@EnableGlobalExceptionHandler
public @interface EnableCommon {}
