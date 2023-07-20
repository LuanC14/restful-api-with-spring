package br.com.erudio.restful_with_spring.controllers;

import br.com.erudio.restful_with_spring.VO.v1.PersonVO;
import br.com.erudio.restful_with_spring.VO.v2.PersonVOV2;
import br.com.erudio.restful_with_spring.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person/v1")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonVO> findById(@PathVariable(value = "id") Long id) {
        PersonVO person = personService.findById(id);
        return ResponseEntity.ok().body(person);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PersonVO>> findAll() {
        List<PersonVO> persons = personService.findAll();
        return ResponseEntity.ok().body(persons);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonVO> create(@RequestBody PersonVO personVO) {
        PersonVO person = personService.createPerson(personVO);

        return ResponseEntity.status(HttpStatus.CREATED).body(person);
    }

//    @PostMapping(value = "/v2", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<PersonVOV2> createV2(@RequestBody PersonVOV2 personVO) {
//        PersonVOV2 person = personService.createPersonV2(personVO);
//        return ResponseEntity.status(HttpStatus.CREATED).body(person);
//    }

    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonVO> update(@RequestBody PersonVO personVO) {
        PersonVO person = personService.updatePerson(personVO);
        return ResponseEntity.ok().body(person);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        personService.deletePerson(id);
        return ResponseEntity.noContent().build();
    }
}
