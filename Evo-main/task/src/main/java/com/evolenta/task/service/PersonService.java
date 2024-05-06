package com.evolenta.task.service;

import com.evolenta.task.dto.Message;
import com.evolenta.task.dto.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    List<Person> getAllPersons();
    Optional<Person> getPerson(int id);
    Person addPerson(Person person);
    Person updatePerson(int id ,Person person);
    Boolean deletePerson(int id);
    List<Message> getMessagesByPersonId(int id);
    Optional<Message> getMessageByP_IdM_id(int P_id,int M_id);
    Person addMessageById(int id,Message message);
    Boolean deleteMessageById(int P_id,int M_id);
    Boolean personExists(int id);
}
