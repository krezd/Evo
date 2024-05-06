package com.evolenta.task.controller;

import com.evolenta.task.dto.Message;
import com.evolenta.task.dto.Person;
import com.evolenta.task.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping
    public ResponseEntity<?> getAllPerson() {
        return ResponseEntity.ok(personService.getAllPersons());
    }

    @GetMapping("/{id}")
    public Optional<?> findPersonById(@PathVariable int id) {
        return personService.getPerson(id);
    }

    @PostMapping("")
    public ResponseEntity<?> addPerson(@RequestBody Person person) {
        return new ResponseEntity<>(personService.addPerson(person), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePerson(@PathVariable int id, @RequestBody Person person) {
        return new ResponseEntity<>(personService.updatePerson(id,person),HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable int id) {
        personService.deletePerson(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{p_id}/message")
    public ResponseEntity<?> getPersonMessage(@PathVariable int p_id) {
        return new ResponseEntity<>(personService.getMessagesByPersonId(p_id),HttpStatus.OK);
    }
    @GetMapping("/{p_id}/message/{m_id}")
    public ResponseEntity<?> getPersonMessage(@PathVariable int p_id, @PathVariable int m_id) {
       return new ResponseEntity<>(personService.getMessageByP_IdM_id(p_id,m_id), HttpStatus.OK);
    }
    @PostMapping("/{p_id}/message")
    public ResponseEntity<?> addPersonMessage(@PathVariable int p_id, @RequestBody Message message) {
        if(personService.personExists(p_id)){
            return new ResponseEntity<>(personService.addMessageById(p_id,message),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{p_id}/message/{m_id}")
    public ResponseEntity<?> deletePersonMessage(@PathVariable int p_id, @PathVariable int m_id) {
        personService.deleteMessageById(p_id,m_id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
