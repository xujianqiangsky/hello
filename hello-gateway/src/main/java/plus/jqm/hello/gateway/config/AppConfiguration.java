package plus.jqm.hello.gateway.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import plus.jqm.hello.gateway.handler.HelloExceptionHandler;
import plus.jqm.hello.gateway.handler.impl.GlobalExceptionHandler;
import plus.jqm.hello.gateway.handler.impl.NoResourceFoundExceptionHandler;

/**
 * 应用配置
 *
 * @author xjq
 * @date 2024/04/20
 */
@Slf4j
@Configuration
public class AppConfiguration {
    @Bean
    public NoResourceFoundExceptionHandler noResourceFoundExceptionHandler() {
        return new NoResourceFoundExceptionHandler();
    }

    @Bean
    public GlobalExceptionHandler globalExceptionHandler(ObjectProvider<HelloExceptionHandler> helloExceptionHandlers, ObjectMapper objectMapper) {
        return new GlobalExceptionHandler(objectMapper, helloExceptionHandlers.stream().toList());
    }
}
