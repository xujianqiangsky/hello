package plus.jqm.hello.gateway.config;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.web.reactive.result.view.ViewResolver;
import plus.jqm.hello.gateway.handler.GlobalExceptionHandler;

/**
 * 应用配置
 *
 * @author xjq
 * @date 2024/04/20
 */
@Configuration
public class AppConfiguration {
    @Bean
    public GlobalExceptionHandler globalExceptionHandler(ErrorAttributes errorAttributes,
                                                         WebProperties webProperties,
                                                         ObjectProvider<ViewResolver> viewResolvers,
                                                         ServerCodecConfigurer serverCodecConfigurer,
                                                         ApplicationContext applicationContext) {
        GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler(errorAttributes, webProperties.getResources(), applicationContext);
        globalExceptionHandler.setViewResolvers(viewResolvers.orderedStream().toList());
        globalExceptionHandler.setMessageWriters(serverCodecConfigurer.getWriters());
        globalExceptionHandler.setMessageReaders(serverCodecConfigurer.getReaders());
        return globalExceptionHandler;
    }
}
