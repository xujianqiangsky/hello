package plus.jqm.hello.gateway.config;

import cn.dev33.satoken.filter.SaFilterErrorStrategy;
import cn.dev33.satoken.reactor.filter.SaReactorFilter;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import plus.jqm.hello.common.core.constant.AuthConstants;
import plus.jqm.hello.gateway.filter.ForwardAuthFilter;

/**
 * SaToken 配置
 *
 * @author xjq
 * @date 2024/04/24
 */
@Configuration(proxyBeanMethods = false)
public class SaTokenConfiguration {
    @Bean
    public ForwardAuthFilter forwardAuthFilter() {
        return new ForwardAuthFilter();
    }

    @Bean
    public SaReactorFilter saReactorFilter(SaFilterErrorStrategy saFilterErrorStrategy) {
        return new SaReactorFilter().addInclude("/**")
                                    .addExclude("/favicon.ico")
                                    .setAuth(obj -> {
                                        SaRouter.match("/**")
                                                .notMatch(AuthConstants.LOGIN_PATH)
                                                .check(r -> StpUtil.checkLogin());
                                    })
                                    .setError(saFilterErrorStrategy);
    }
}
