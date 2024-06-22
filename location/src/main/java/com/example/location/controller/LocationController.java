package com.example.location.controller;


import com.example.location.model.Location;
import com.example.location.model.Weather;
import com.example.location.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/location")
public class LocationController {
    @Autowired
    private LocationService locationService;

    @GetMapping("/weather")
    public Weather getRequestLocations(@RequestParam("name") String location) throws Exception {
        return locationService.getLocForWeather(location);
    }

    @GetMapping()
    public ResponseEntity<List<Location>> getLocations() throws Exception {
        return locationService.getGeodatas();
    }

    @GetMapping("/")
    public ResponseEntity<Location> getLocation(@RequestParam("name") String location) throws Exception {
        return locationService.getGeodata(location);
    }

    @PostMapping
    public ResponseEntity<Location> save(@RequestBody Location location) {
        return locationService.save(location);
    }

    @PutMapping("/")
    public ResponseEntity<Location> update(@RequestBody Location location) {
        return locationService.updateLocation(location);
    }
    @DeleteMapping("/")
    public ResponseEntity<HttpStatus> delete(@RequestParam("name") String location) throws Exception {
        return locationService.deleteLocation(location);
    }







}
