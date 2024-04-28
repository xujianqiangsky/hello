package plus.jqm.hello.common.http.service.annotation;

import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.AliasFor;
import plus.jqm.hello.common.http.service.handler.HelloHttpServiceClientsRegistrar;

import java.lang.annotation.*;

/**
 * 启用 HelloServiceClient
 *
 * @author xjq
 * @date 2024/04/26
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(HelloHttpServiceClientsRegistrar.class)
public @interface EnableHelloHttpServiceClients {
    @AliasFor("basePackages")
    String[] value() default {};

    @AliasFor("value")
    String[] basePackages() default {};

    Class<?>[] basePackageClasses() default {};
}
