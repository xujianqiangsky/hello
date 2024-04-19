package plus.jqm.hello.common.core.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.context.annotation.Bean;
import plus.jqm.hello.common.core.jackson.HelloJavaTimeModule;

/**
 * Jackson 定制
 *
 * @author xjq
 * @date 2024/04/16
 */
@ConditionalOnClass(ObjectMapper.class)
@AutoConfiguration(before = JacksonAutoConfiguration.class)
public class JacksonConfiguration {
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
        return jacksonObjectMapperBuilder -> {
            jacksonObjectMapperBuilder.modules(new HelloJavaTimeModule());
        };
    }

}
