package com.example.person.service;


import com.example.person.model.Person;
import com.example.person.model.Weather;
import com.example.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    @Value("${location.url}")
    private String locationUrl;

    public ResponseEntity<Weather> getWeather(int id) {
        if (personRepository.existsById(id)) {
            String location = personRepository.findById(id).get().getLocation();
            Weather weather = restTemplate.getForObject("http://"+locationUrl+"/location/weather?name="+location, Weather.class);
            return new ResponseEntity(weather, HttpStatus.OK);
        }
        return new ResponseEntity(null, HttpStatus.NOT_FOUND);
    }


    public ResponseEntity<HttpStatus> delete(int id) {
        if (personRepository.existsById(id)) {
            personRepository.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    public  ResponseEntity<Person> update(int id,Person person) {
        if (personRepository.existsById(id)) {
            person.setId(id);
            personRepository.save(person);
            return new ResponseEntity(person, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

}
