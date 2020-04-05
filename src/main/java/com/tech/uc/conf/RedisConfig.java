package com.tech.uc.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

/**
 * @author zhuyz
 * @date 2020/4/4 0004 14:26
 * @description redis config
 */
@Configuration
public class RedisConfig {

    /**
     * 设置redis序列化方式
     * @param redisConnectionFactory
     * @return
     */
    @Bean
    public RedisTemplate<Object, Object> jsonRedisTemplate(
            RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setDefaultSerializer(new Jackson2JsonRedisSerializer(Object.class));
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }

}
