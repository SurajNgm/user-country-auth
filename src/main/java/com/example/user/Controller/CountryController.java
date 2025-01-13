package com.example.user.Controller;

import com.example.user.Model.Country;
import com.example.user.Model.User;
import com.example.user.Service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CountryController {
    @Autowired
    private CountryService countryService;

    @PostMapping("/user/insert")
    public Country insertCountry(@RequestBody Country country) {
        return countryService.insertCountry(country);
    }

    @PutMapping("/user/update")
    public Country updateCountry(@RequestBody Country country) {
        return countryService.updateCountry(country);
    }
    @DeleteMapping("/user/delete/{id}")
    public String deleteCountry(@PathVariable Long id) {
        boolean isDeleted = countryService.deleteCountry(id);
        if (isDeleted) {
            return "Country with ID " + id + " deleted successfully.";
        } else {
            return "Country with ID " + id + " not found.";
        }
    }
}
