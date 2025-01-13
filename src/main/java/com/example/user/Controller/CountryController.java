package com.example.user.Controller;

import com.example.user.Model.Country;
import com.example.user.Model.User;
import com.example.user.Service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {
    @Autowired
    private CountryService countryService;

    @PostMapping("/admin/insert")
    public Country insertCountry(@RequestBody Country country) {
        return countryService.insertCountry(country);
    }

    @PutMapping("/update")
    public Country updateCountry(@RequestBody Country country) {
        return countryService.updateCountry(country);
    }
}
