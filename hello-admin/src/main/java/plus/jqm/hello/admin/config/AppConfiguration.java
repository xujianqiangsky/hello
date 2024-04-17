package plus.jqm.hello.admin.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import plus.jqm.hello.common.annotation.EnableCommon;

/**
 * 应用配置
 *
 * @author xjq
 * @date 2024/04/16
 */
@EnableCommon
@EnableCaching
@Configuration(proxyBeanMethods = false)
public class AppConfiguration {}
