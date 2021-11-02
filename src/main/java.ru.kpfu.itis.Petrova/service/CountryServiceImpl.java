package service;

import models.Country;
import repositories.CountryRepository;
import repositories.CountryRepositoryImpl;

import java.util.List;

public class CountryServiceImpl implements CountryService {

    private static CountryRepository countryRepository = new CountryRepositoryImpl();


    @Override
    public Country find(Integer id) {
        return countryRepository.find(id);
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public void save(Country country) {
        countryRepository.save(country);
    }

    @Override
    public void update(Country country) {
        countryRepository.update(country);
    }

    @Override
    public Integer findIdByName(String name) {
        return countryRepository.findIdByName(name);
    }
}
