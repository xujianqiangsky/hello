package plus.jqm.hello.system.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.BlockAttackInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import plus.jqm.hello.system.handler.MyBatisPlusMetaObjectHandler;
import plus.jqm.hello.common.core.constant.DbConstants;

/**
 * 应用配置
 *
 * @author xjq
 * @date 2024/04/16
 */
@Configuration(proxyBeanMethods = false)
public class AppConfiguration {
    @Bean
    public MyBatisPlusMetaObjectHandler metaObjectHandler() {
        return new MyBatisPlusMetaObjectHandler();
    }

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor();
        paginationInnerInterceptor.setOverflow(DbConstants.PAGE_OVERFLOW);
        paginationInnerInterceptor.setMaxLimit(DbConstants.PAGE_MAX_LIMIT);
        interceptor.addInnerInterceptor(new BlockAttackInnerInterceptor());
        interceptor.addInnerInterceptor(paginationInnerInterceptor);
        return interceptor;
    }
}
