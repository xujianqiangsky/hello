package plus.jqm.hello.common.sa.token.config;

import cn.dev33.satoken.dao.SaTokenDaoRedisJackson;
import cn.dev33.satoken.filter.SaFilterErrorStrategy;
import cn.dev33.satoken.filter.SaServletFilter;
import cn.dev33.satoken.jwt.StpLogicJwtForSimple;
import cn.dev33.satoken.same.SaSameUtil;
import cn.dev33.satoken.spring.SaBeanInject;
import cn.dev33.satoken.stp.StpLogic;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import plus.jqm.hello.common.sa.token.factory.YamlPropertySourceFactory;
import plus.jqm.hello.common.sa.token.handler.HelloSaTokenExceptionHandler;
import plus.jqm.hello.common.sa.token.handler.impl.*;

/**
 * SaToken 配置
 *
 * @author xjq
 * @date 2024/04/23
 */
@AutoConfiguration(before = SaBeanInject.class)
@PropertySource(value = "classpath:common-sa-token.yml", factory = YamlPropertySourceFactory.class)
public class SaTokenConfiguration {
    @Autowired
    public void saTokenDao(SaTokenDaoRedisJackson saTokenDao, StringRedisTemplate stringRedisTemplate, RedisTemplate<String, Object> objectRedisTemplate) {
        saTokenDao.objectRedisTemplate = objectRedisTemplate;
        saTokenDao.stringRedisTemplate = stringRedisTemplate;
    }

    @Bean
    public StpLogic getStpLogicJwt() {
        return new StpLogicJwtForSimple();
    }

    @Bean
    public StpInterfaceImpl stpInterface() {
        return new StpInterfaceImpl();
    }

    @Bean
    public NotLoginExceptionHandler notLoginExceptionHandler() {
        return new NotLoginExceptionHandler();
    }

    @Bean
    public NotPermissionExceptionHandler notPermissionExceptionHandler() {
        return new NotPermissionExceptionHandler();
    }

    @Bean
    public SameTokenInvalidExceptionHandler sameTokenInvalidExceptionHandler() {
        return new SameTokenInvalidExceptionHandler();
    }

    @Bean
    public HelloSaFilterErrorStrategy helloSaFilterErrorStrategy(ObjectProvider<HelloSaTokenExceptionHandler> handlers, ObjectMapper objectMapper) {
        return new HelloSaFilterErrorStrategy(objectMapper, handlers.stream().toList());
    }

    @Configuration(proxyBeanMethods = false)
    @ConditionalOnClass(SaServletFilter.class)
    private static class SaServletFilterConfiguration {
        @Bean
        public SaServletFilter saServletFilter(SaFilterErrorStrategy saFilterErrorStrategy) {
            return new SaServletFilter()
                    .addInclude("/**")
                    .addExclude("/favicon.ico")
                    .setAuth(auth -> SaSameUtil.checkCurrentRequestToken())
                    .setError(saFilterErrorStrategy);
        }
    }
}
