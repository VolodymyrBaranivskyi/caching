package com.interview.caching.daos.interfaces;

import com.interview.caching.model.Street;

import java.util.List;

public interface StreetDao extends AbstractDao{
    List<Street> getCordinate(String name);
    void saveStreet(Street street);
}
