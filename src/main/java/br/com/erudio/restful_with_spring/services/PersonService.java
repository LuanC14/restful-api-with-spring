package br.com.erudio.restful_with_spring.services;

import br.com.erudio.restful_with_spring.VO.v2.PersonVOV2;
import br.com.erudio.restful_with_spring.utils.mapper.v1.DozerMapper;
import br.com.erudio.restful_with_spring.utils.mapper.v2.PersonMapperV2;
import br.com.erudio.restful_with_spring.exceptions.ResourceNotFoundException;
import br.com.erudio.restful_with_spring.models.Person;
import br.com.erudio.restful_with_spring.VO.v1.PersonVO;
import br.com.erudio.restful_with_spring.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return DozerMapper.parseObject(entity, PersonVO.class);
    }

    public List<PersonVO> findAll() {
        logger.info("Find all peoples in database");
        return DozerMapper.parseListObjects(personRepository.findAll(), PersonVO.class);
    }

    public PersonVO createPerson(PersonVO personVO) {
        Person entity = DozerMapper.parseObject(personVO, Person.class);
        Person createdEntity = personRepository.save(entity);
        return DozerMapper.parseObject(createdEntity, PersonVO.class);
    }

    public PersonVOV2 createPersonV2(PersonVOV2 personVO) {
        Person entity = PersonMapperV2.convertVoToEntity(personVO);
        return PersonMapperV2.convertEntityToVo(personRepository.save(entity));
    }

    public PersonVO updatePerson(PersonVO person) {
        Person entity = personRepository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("User not found."));
        entity.setFirstname(person.getFirstname());
        entity.setLastname(person.getLastname());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        Person resultUpdate = personRepository.save(entity);
        return DozerMapper.parseObject(resultUpdate, PersonVO.class) ;
    }

    public void deletePerson(Long id) {
        var entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found."));
        personRepository.delete(entity);
    }
}
