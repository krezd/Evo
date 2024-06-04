package com.example.person.service;


import com.example.person.model.Weather;
import com.example.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<Weather> getWeather(int id) {
        if (personRepository.existsById(id)) {
            String location = personRepository.findById(id).get().getLocation();
            Weather weather = restTemplate.getForObject("http://localhost:8086/location?location="+location, Weather.class);
            return new ResponseEntity(weather, HttpStatus.OK);
        }
        return new ResponseEntity(null, HttpStatus.NOT_FOUND);
    }
}
