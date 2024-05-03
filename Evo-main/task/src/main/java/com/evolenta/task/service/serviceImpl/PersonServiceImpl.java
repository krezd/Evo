package com.evolenta.task.service.serviceImpl;

import com.evolenta.task.dto.Person;
import com.evolenta.task.repository.PersonRepository;
import com.evolenta.task.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
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
                    person.getBirthday()
                    );
            personRepository.save(newPerson);
            return newPerson;
        }
        return addPerson(person);
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
