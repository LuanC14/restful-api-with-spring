package br.com.erudio.restful_with_spring.controllers;

import br.com.erudio.restful_with_spring.models.Person;
import br.com.erudio.restful_with_spring.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> findById(@PathVariable(value = "id") Long id) {
        Person person = personService.findById(id);
        return ResponseEntity.ok().body(person);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Person>> findAll() {
        List<Person> persons = personService.findAll();
        return ResponseEntity.ok().body(persons);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> create(@RequestBody Person request) {
        Person person = personService.createPerson(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(person);
    }

    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> update(@RequestBody Person request) {
        Person person = personService.updatePerson(request);
        return ResponseEntity.ok().body(person);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        personService.deletePerson(id);
        return ResponseEntity.noContent().build();
    }
}
