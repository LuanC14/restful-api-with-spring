package br.com.erudio.restful_with_spring.services;

import br.com.erudio.restful_with_spring.exceptions.ResourceNotFoundException;
import br.com.erudio.restful_with_spring.models.Person;
import br.com.erudio.restful_with_spring.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;
    private final AtomicLong counter = new AtomicLong();
    private final Logger logger = Logger.getLogger(PersonService.class.getName());

    public Person findById(Long id) {
        logger.info("Finding one person.");
        return personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found."));
    }

    public List<Person> findAll() {
        logger.info("Find all peoples in database");
        return personRepository.findAll();
    }

    public Person createPerson(Person request) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstname(request.getFirstname());
        person.setLastname(request.getLastname());
        person.setAddress(request.getAddress());
        person.setGender(request.getGender());

        personRepository.save(person);

        return person;
    }

    public Person updatePerson(Person person) {

        var entity = personRepository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("User not found."));

        entity.setFirstname(person.getFirstname());
        entity.setLastname(person.getLastname());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return personRepository.save(entity);
    }

    public void deletePerson(Long id) {
        var entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found."));
        personRepository.delete(entity);
    }

}
