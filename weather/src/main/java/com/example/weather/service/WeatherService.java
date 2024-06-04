package com.example.weather.service;

import com.example.weather.model.Weather;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public Weather getWeather(String lat,String lon) throws JsonProcessingException {
        String url = "https://api.openweathermap.org/data/2.5/weather?lat="+lat+"&lon="+lon+"&appid=57f5e478ed3aa0d4df28a3803805c2fa&units=metric";
        String response = restTemplate.getForObject(url, String.class);
        Weather weather = objectMapper.readValue(response, Weather.class);
        return weather;
    }
}
