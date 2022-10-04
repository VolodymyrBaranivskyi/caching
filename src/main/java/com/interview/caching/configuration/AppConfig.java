package com.interview.caching.configuration;

import com.google.common.cache.CacheBuilder;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@Profile("devWithCache")
@Configuration
@EnableCaching
public class AppConfig extends CachingConfigurerSupport {
    @Bean
    @Override
    public CacheManager cacheManager() {
        ConcurrentMapCacheManager cacheManager =
                new ConcurrentMapCacheManager() {
                    @Override
                    protected Cache createConcurrentMapCache(final String name) {
                        return new ConcurrentMapCache(name, CacheBuilder.newBuilder()
                                .expireAfterAccess(10, TimeUnit.SECONDS)
                                .expireAfterWrite(10, TimeUnit.SECONDS)
                                .maximumSize(300).build().asMap(), false);
                    }
                };
        cacheManager.setCacheNames(Arrays.asList("streets"));
        return cacheManager;
    }
}