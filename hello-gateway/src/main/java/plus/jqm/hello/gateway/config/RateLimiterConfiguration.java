package plus.jqm.hello.gateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

import java.util.Objects;

/**
 * 限流配置
 *
 * @author xjq
 * @date 2024/04/20
 */
@Configuration(proxyBeanMethods = false)
public class RateLimiterConfiguration {
    @Bean
    public KeyResolver remoteAddrKeyResolver() {
        return exchange -> Mono.just(Objects.requireNonNull(Objects.requireNonNull(exchange.getRequest().getRemoteAddress()))
                                            .getAddress()
                                            .getHostAddress());
    }
}
