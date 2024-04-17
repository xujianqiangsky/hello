package plus.jqm.hello.common.config;

import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import plus.jqm.hello.common.jackson.HelloJavaTimeModule;

/**
 * Jackson 定制
 *
 * @author xjq
 * @date 2024/04/16
 */
@Configuration(proxyBeanMethods = false)
public class JacksonConfiguration {
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
        return jacksonObjectMapperBuilder -> {
            jacksonObjectMapperBuilder.modules(new HelloJavaTimeModule());
        };
    }

}
