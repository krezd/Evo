package com.evolenta.task.service.serviceImpl;

import com.evolenta.task.dto.Message;
import com.evolenta.task.dto.Person;
import com.evolenta.task.repository.MessageRepository;
import com.evolenta.task.repository.PersonRepository;
import com.evolenta.task.service.MessageService;
import com.evolenta.task.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final MessageRepository messageRepository;


    public PersonServiceImpl(PersonRepository personRepository, MessageRepository messageRepository) {
        this.personRepository = personRepository;
        this.messageRepository = messageRepository;
    }

    private void delMessage(int M_id,Person person){
        List<Message> messages = person.getMessages();

        for(int i = 0; i < messages.size(); i++){
            if(messages.get(i).getId() == M_id){
                messages.remove(i);
                break;
            }
        }
        person.setMessages(messages);
        personRepository.save(person);
    }
    @Override
    public Boolean deleteMessageById(int P_id, int M_id) {
        if (personRepository.existsById(P_id)) {

            Person person = personRepository.findById(P_id).orElse(null);
            delMessage(M_id,person);
            messageRepository.deleteById(M_id);
            return true;
        }
        return false;
    }

    @Override
    public Person addMessageById(int id, Message message) {
        Person person = personRepository.findById(id).orElse(null);
        message.setTime(LocalDateTime.now());
        person.addMessage(message);
        return updatePerson(id,person);
    }

    @Override
    public Optional<Message> getMessageByP_IdM_id(int P_id, int M_id) {
        Person person = personRepository.findById(P_id).get();
        return person.getMessages().stream().filter(m -> m.getId() == M_id).findFirst();
    }

    @Override
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public Optional<Person> getPerson(int id) {
        return personRepository.findById(id);
    }

    @Override
    public Person addPerson(Person person) {
        personRepository.save(person);
        return person;
    }

    @Override
    public Person updatePerson(int id, Person person) {
        Optional<Person> personOptional = personRepository.findById(id);
        if (personOptional.isPresent()) {
            Person newPerson = new Person(
                    id,
                    person.getFirstname(),
                    person.getSurname(),
                    person.getLastname(),
                    person.getBirthday(),
                    person.getMessages()
                    );
            personRepository.save(newPerson);
            return newPerson;
        }
        return addPerson(person);
    }

    @Override
    public List<Message> getMessagesByPersonId(int id) {
        Person person = personRepository.findById(id).get();
        return person.getMessages();
    }

    @Override
    public Boolean personExists(int id) {
        return personRepository.existsById(id);
    }

    @Override
    public Boolean deletePerson(int id) {
        if (personRepository.existsById(id)) {
            personRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
