package service;

import models.Country;

import java.util.List;

public interface CountryService {

    Country find(Integer id);

    List<Country> findAll();

    void save(Country country);

    void update(Country country);

    Integer findIdByName(String name);

}
