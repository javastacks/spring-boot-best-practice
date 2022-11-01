package cn.javastack.springboot.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * 微信公众号：Java技术栈
 */
@Slf4j
@Service
public class CacheService {

    @Cacheable("calc")
    public int multiply(int a, int b) {
        int c = a * b;
        log.info("{} * {} = {}", a, b, c);
        return c;
    }

}