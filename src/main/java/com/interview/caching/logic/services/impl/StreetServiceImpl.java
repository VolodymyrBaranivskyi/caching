package com.interview.caching.logic.services.impl;

import com.interview.caching.daos.interfaces.StreetDao;
import com.interview.caching.logic.services.StreetService;
import com.interview.caching.model.Street;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Random;

import static java.lang.String.format;
import static java.time.LocalDateTime.now;

@Slf4j
@Service
public class StreetServiceImpl implements StreetService {

    private final StreetDao streetDao;

    @Autowired
    public StreetServiceImpl(StreetDao streetDao) {
        this.streetDao = streetDao;
    }

    @Override
    @Cacheable
    public Street getCordinateByName(String name) {
        if(streetDao.getCordinate(name).size() != 0 ) {
            return  streetDao.getCordinate(name).get(0);
        }
        Street street = save(name);
        streetDao.saveStreet(street);
        return street;
    }

    @Override
    @CachePut
    public Street save(String name) {
        Street street = new Street();
        street.setName(name);
        street.setLastModified(now());
        street.setCordinates(setRandomCordinates());
        streetDao.saveStreet(street);
        return street;
    }

    private String setRandomCordinates() {
        Random rd = new Random();
        return format("(%f ; %f)", rd.nextFloat(), rd.nextFloat());
    }

}
