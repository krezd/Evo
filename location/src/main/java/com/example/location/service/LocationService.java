package com.example.location.service;

import com.example.location.model.Location;
import com.example.location.model.Weather;
import com.example.location.repository.LocationRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class LocationService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private ObjectMapper objectMapper;

    public Weather getLocation(String location) throws Exception {
        Location searchedLocation = locationRepository.findByLocation(location).orElse(null);
        if (searchedLocation == null) {
            String url = "http://api.openweathermap.org/geo/1.0/direct?q=" + location + "&limit=1&appid=57f5e478ed3aa0d4df28a3803805c2fa&units=metric";
            List<Map<String, Object>> response = restTemplate.getForObject(url, List.class);
            if (response != null && !response.isEmpty()) {
                Map<String, Object> locationData = response.get(0);
                Location loc = objectMapper.convertValue(locationData, Location.class);
                locationRepository.save(loc);
                return restTemplate.getForObject("http://localhost:8087/weather?lat=" + loc.getLat() + "&lon=" + loc.getLon(), Weather.class);
            } else {
                throw new Exception("Location not found");
            }
        }
        return restTemplate.getForObject("http://localhost:8087/weather?lat=" +searchedLocation.getLat() + "&lon=" + searchedLocation.getLon(), Weather.class);
    }


    public ResponseEntity<Location> save(@RequestBody Location location) {
        return locationRepository.findByLocation(location.getLocation()).isPresent()
                ? new ResponseEntity(locationRepository.findByLocation(location.getLocation()), HttpStatus.BAD_REQUEST)
                : new ResponseEntity(locationRepository.save(location), HttpStatus.CREATED);
    }
}
