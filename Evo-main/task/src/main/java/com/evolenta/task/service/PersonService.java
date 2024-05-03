package com.evolenta.task.service;

import com.evolenta.task.dto.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    List<Person> getAllPersons();
    Optional<Person> getPerson(int id);
    Person addPerson(Person person);
    Person updatePerson(int id ,Person person);
    Boolean deletePerson(int id);
}
