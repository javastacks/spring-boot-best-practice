package cn.javastack.springboot.cache;

import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;

import java.time.Duration;

/**
 * 微信公众号：Java技术栈
 */
@Configuration
public class CacheConfiguration {

    /**
     * 优先配置文件中的配置
     * @return
     */
    @Bean
    public RedisCacheManagerBuilderCustomizer myRedisCacheManagerBuilderCustomizer() {
        return (builder) -> builder
                .withCacheConfiguration("calc", RedisCacheConfiguration
                        .defaultCacheConfig().entryTtl(Duration.ofSeconds(5)))
                .withCacheConfiguration("test", RedisCacheConfiguration
                        .defaultCacheConfig().entryTtl(Duration.ofMinutes(10)));

    }

}