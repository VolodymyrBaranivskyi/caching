package com.interview.caching.logic.services;

import com.interview.caching.model.Street;
import org.springframework.cache.annotation.CacheConfig;

@CacheConfig(cacheNames={"streets"})
public interface StreetService {
    Street getCordinateByName(String name);
    Street save(String name);
}
