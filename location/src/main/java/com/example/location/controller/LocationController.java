package com.example.location.controller;


import com.example.location.model.Weather;
import com.example.location.service.LocationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/location")
public class LocationController {
    @Autowired
    private LocationService locationService;

    @GetMapping()
    public Weather getLocations(@RequestParam("location") String location) throws Exception {
        return locationService.getLocation(location);
    }
}
