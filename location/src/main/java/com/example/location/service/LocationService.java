package com.example.location.service;

import com.example.location.model.Location;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class LocationService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public String getLocation(String location) throws Exception {
        String url ="http://api.openweathermap.org/geo/1.0/direct?q="+location+"&limit=1&appid=57f5e478ed3aa0d4df28a3803805c2fa&units=metric";
        List<Map<String, Object>> response = restTemplate.getForObject(url, List.class);
        if (response != null && !response.isEmpty()) {
            Map<String, Object> locationData = response.get(0);
            Location loc = objectMapper.convertValue(locationData, Location.class);
            return "lat="+loc.getLat() + "&lon=" + loc.getLon();
        } else {
            throw new Exception("Location not found");
        }
    }
}
