package com.example.person.controller;

import com.example.person.model.Person;
import com.example.person.model.Weather;
import com.example.person.repository.PersonRepository;
import com.example.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonService personService;

    @GetMapping
    public Iterable<Person> findAll() {
        return personRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Person> findById(@PathVariable int id) {
        return personRepository.findById(id);
    }

    @GetMapping("{id}/weather")
    public ResponseEntity<Weather> getWeather(@PathVariable int id) {
        return personService.getWeather(id);
    }


    @PostMapping
    public ResponseEntity<Person> save(@RequestBody Person person) {
        return personRepository.findById(person.getId()).isPresent()
                ? new ResponseEntity(personRepository.findById(person.getId()), HttpStatus.BAD_REQUEST)
                : new ResponseEntity(personRepository.save(person), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable int id) {
        return personService.delete(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable int id,@RequestBody Person person) {
        return personService.update(id,person);
    }


}
