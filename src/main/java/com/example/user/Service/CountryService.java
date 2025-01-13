package com.example.user.Service;

import com.example.user.Model.Country;
import com.example.user.Model.User;
import com.example.user.Repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    @Autowired
    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public Country insertCountry(Country country){
        return countryRepository.save(country);
    }

    public Country updateCountry(Country country){return countryRepository.save(country);}




}
