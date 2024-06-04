package com.example.weather.controller;

import com.example.weather.model.Weather;
import com.example.weather.service.WeatherService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    @Autowired
    private WeatherService weatherService;

    @GetMapping()
    Weather getWeather(@RequestParam("lat") String lat, @RequestParam("lon") String lot) throws JsonProcessingException {
        return weatherService.getWeather(lat,lot);
    }


}