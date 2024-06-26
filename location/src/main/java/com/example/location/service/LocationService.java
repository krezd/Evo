package com.example.location.service;

import com.example.location.model.Location;
import com.example.location.model.Weather;
import com.example.location.repository.LocationRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class LocationService {


    private final RestTemplate loadBalancedRestTemplate;
    private final RestTemplate restTemplate;

    public LocationService(@Qualifier("loadBalancedRestTemplate") RestTemplate loadBalancedRestTemplate,
                             @Qualifier("restTemplate") RestTemplate restTemplate) {
        this.loadBalancedRestTemplate = loadBalancedRestTemplate;
        this.restTemplate = restTemplate;
    }
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private ObjectMapper objectMapper;
    @Value("${weather.url}")
    private String weatherUrl;

    public Weather getLocForWeather(String location) throws Exception {
        Location searchedLocation = locationRepository.findByName(location).orElse(null);
        if (searchedLocation == null) {
            String url = "http://api.openweathermap.org/geo/1.0/direct?q=" + location + "&limit=1&appid=57f5e478ed3aa0d4df28a3803805c2fa&units=metric";
            List<Map<String, Object>> response = restTemplate.getForObject(url, List.class);
            if (response != null && !response.isEmpty()) {
                Map<String, Object> locationData = response.get(0);
                Location loc = objectMapper.convertValue(locationData, Location.class);
                searchedLocation = locationRepository.findByName(loc.getName()).orElse(null);
                if (searchedLocation == null){
                    locationRepository.save(loc);
                }

                return loadBalancedRestTemplate.getForObject("http://"+weatherUrl+"/weather?lat=" + loc.getLongitude() + "&lon=" + loc.getLatitude(), Weather.class);
            } else {
                throw new Exception("Location not found");
            }
        }
        return loadBalancedRestTemplate.getForObject("http://"+weatherUrl+"/weather?lat=" +searchedLocation.getLongitude() + "&lon=" + searchedLocation.getLatitude(), Weather.class);
    }


    public ResponseEntity<Location> save(@RequestBody Location location) {
        return locationRepository.findByName(location.getName()).isPresent()
                ? new ResponseEntity(locationRepository.findByName(location.getName()), HttpStatus.BAD_REQUEST)
                : new ResponseEntity(locationRepository.save(location), HttpStatus.CREATED);
    }

    public ResponseEntity<List<Location>> getGeodatas(){
        return new ResponseEntity(locationRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Location> getGeodata(String name){
        return new ResponseEntity(locationRepository.findByName(name), HttpStatus.OK);
    }

    public ResponseEntity<Location> updateLocation(String name, Location location){
        Location searchedLocation = locationRepository.findByName(name).orElse(null);
        if (searchedLocation != null) {
            searchedLocation.setLongitude(location.getLongitude());
            searchedLocation.setLatitude(location.getLatitude());
            searchedLocation.setName(location.getName());
            return new ResponseEntity(locationRepository.save(searchedLocation), HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<HttpStatus> deleteLocation(String name){
        Location searchedLocation = locationRepository.findByName(name).orElse(null);
        if (searchedLocation != null) {
            locationRepository.delete(searchedLocation);
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
