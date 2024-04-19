package plus.jqm.hello.common.core.config;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import com.fasterxml.jackson.databind.jsontype.impl.StdTypeResolverBuilder;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

/**
 * Redis 定制
 *
 * @author xjq
 * @date 2024/04/16
 */
@EnableCaching
@ConditionalOnClass(RedisOperations.class)
@AutoConfiguration(before = RedisAutoConfiguration.class)
public class RedisConfiguration {
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory, Jackson2ObjectMapperBuilder builder) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        ObjectMapper objectMapper = objectMapper(builder);
        template.setDefaultSerializer(new GenericJackson2JsonRedisSerializer(objectMapper));
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }

    @Bean
    public RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer(Jackson2ObjectMapperBuilder builder) {
        return cacheManagerBuilder -> {
            ObjectMapper objectMapper = objectMapper(builder);
            RedisCacheConfiguration redisCacheConfiguration = cacheManagerBuilder.cacheDefaults();
            redisCacheConfiguration = redisCacheConfiguration.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer(objectMapper)));
            cacheManagerBuilder.cacheDefaults(redisCacheConfiguration);
        };
    }

    private ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder) {
        ObjectMapper objectMapper = builder.build();
        StdTypeResolverBuilder stdTypeResolverBuilder = ObjectMapper.DefaultTypeResolverBuilder.construct(ObjectMapper.DefaultTyping.NON_FINAL, LaissezFaireSubTypeValidator.instance)
                                                                                               .init(JsonTypeInfo.Id.CLASS, null)
                                                                                               .inclusion(JsonTypeInfo.As.PROPERTY);
        objectMapper.setDefaultTyping(stdTypeResolverBuilder);
        return objectMapper;
    }

}
