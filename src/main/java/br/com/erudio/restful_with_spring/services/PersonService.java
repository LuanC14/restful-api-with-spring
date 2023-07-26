package br.com.erudio.restful_with_spring.services;

import br.com.erudio.restful_with_spring.VO.v2.PersonVOV2;
import br.com.erudio.restful_with_spring.controllers.PersonController;
import br.com.erudio.restful_with_spring.utils.mapper.v1.DozerMapper;
import br.com.erudio.restful_with_spring.utils.mapper.v2.PersonMapperV2;
import br.com.erudio.restful_with_spring.exceptions.ResourceNotFoundException;
import br.com.erudio.restful_with_spring.models.Person;
import br.com.erudio.restful_with_spring.VO.v1.PersonVO;
import br.com.erudio.restful_with_spring.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;
    private final Logger logger = Logger.getLogger(PersonService.class.getName());

    public PersonVO findById(Long id) {
        logger.info("Finding one person.");
        Person entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found."));

        PersonVO vo = DozerMapper.parseObject(entity, PersonVO.class);
        vo.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());

        return vo;
    }

    public List<PersonVO> findAll() {
        logger.info("Find all peoples in database");
        List<PersonVO> persons = DozerMapper.parseListObjects(personRepository.findAll(), PersonVO.class);
        persons.forEach(p -> p.add(linkTo(methodOn(PersonController.class).findAll()).withSelfRel()));
        return persons;
    }

    public PersonVO createPerson(PersonVO person) {
        Person entity = DozerMapper.parseObject(person, Person.class);

        PersonVO vo = DozerMapper.parseObject(personRepository.save(entity), PersonVO.class);
        vo.add(linkTo(methodOn(PersonController.class).create(person)).withSelfRel());
        return vo;
    }

//    public PersonVOV2 createPersonV2(PersonVOV2 personVO) {
//        Person entity = PersonMapperV2.convertVoToEntity(personVO);
//        return PersonMapperV2.convertEntityToVo(personRepository.save(entity));
//    }

    public PersonVO updatePerson(PersonVO person) {
        Person entity = personRepository.findById(person.getKey()).orElseThrow(() -> new ResourceNotFoundException("User not found."));
        entity.setFirstname(person.getFirstname());
        entity.setLastname(person.getLastname());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        PersonVO vo = DozerMapper.parseObject(personRepository.save(entity), PersonVO.class);
        vo.add(linkTo(methodOn(PersonController.class).update(person)).withSelfRel());

        return vo;
    }

    public void deletePerson(Long id) {
        var entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found."));
        personRepository.delete(entity);
    }
}
