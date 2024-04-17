package plus.jqm.hello.common.annotation;

import org.springframework.context.annotation.Import;
import plus.jqm.hello.common.config.RedisConfiguration;

import java.lang.annotation.*;

/**
 * 启动 Redis 通用配置
 *
 * @author xjq
 * @date 2024/04/17
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(RedisConfiguration.class)
public @interface EnableCommonRedis {
}
