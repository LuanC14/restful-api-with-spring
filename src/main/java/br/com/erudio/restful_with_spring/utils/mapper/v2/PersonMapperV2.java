package br.com.erudio.restful_with_spring.utils.mapper.v2;

import br.com.erudio.restful_with_spring.VO.v2.PersonVOV2;
import br.com.erudio.restful_with_spring.models.Person;

import java.util.Date;

public class PersonMapperV2 {

    public static PersonVOV2 convertEntityToVo(Person entity) {
        PersonVOV2 vo = new PersonVOV2();
        vo.setId(entity.getId());
        vo.setAddress(entity.getAddress());
        vo.setCreatedAt(new Date());
        vo.setFirstname(entity.getFirstname());
        vo.setLastname(entity.getLastname());
        vo.setGender(entity.getGender());
        return vo;
    }

    public static Person convertVoToEntity(PersonVOV2 vo) {
        Person entity = new Person();
        entity.setId(vo.getId());
        entity.setAddress(vo.getAddress());
        entity.setFirstname(vo.getFirstname());
        entity.setLastname(vo.getLastname());
        entity.setGender(vo.getGender());
        return entity;
    }
}
