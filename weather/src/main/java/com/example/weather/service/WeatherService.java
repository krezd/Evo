package com.example.weather.service;

import com.example.weather.model.Main;
import com.example.weather.model.Root;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Value("${appid}")
    private String appId;

    @Cacheable(cacheNames="root", key = "#lat + ',' + #lon")
    public Root getRoot(String lat, String lon) throws JsonProcessingException {
        String url = "https://api.openweathermap.org/data/2.5/weather?lat="+lat+"&lon="+lon+"&appid="+appId+"&units=metric";
        String response = restTemplate.getForObject(url, String.class);
        Root root = objectMapper.readValue(response, Root.class);
        return root;
    }

    @Cacheable(cacheNames="main", key = "#lat + ',' + #lon")
    public Main getMain(String lat, String lon) throws JsonProcessingException {
        String url = "https://api.openweathermap.org/data/2.5/weather?lat="+lat+"&lon="+lon+"&appid="+appId+"&units=metric";
        String response = restTemplate.getForObject(url, String.class);
        Main main = objectMapper.readValue(response, Root.class).getMain();
        return main;
    }

}
