package plus.jqm.hello.common.http.service.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.http.client.ClientHttpRequestInterceptor;

import java.lang.annotation.*;

/**
 * 远程调用客户端
 *
 * @author xjq
 * @date 2024/04/26
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface HelloHttpServiceClient {
    /**
     * @return 服务名
     */
    @AliasFor("name")
    String value() default "";

    @AliasFor("value")
    String name() default "";

    Class<? extends ClientHttpRequestInterceptor>[] interceptors() default {};

    /**
     * @return 服务地址
     */
    String url() default "";

    /**
     * @return 所有方法的路径前缀
     */
    String path() default "";
}
