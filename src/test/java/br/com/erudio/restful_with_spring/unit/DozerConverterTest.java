package br.com.erudio.restful_with_spring.unit;

import br.com.erudio.restful_with_spring.utils.mapper.v1.DozerMapper;
import br.com.erudio.restful_with_spring.models.Person;
import br.com.erudio.restful_with_spring.VO.v1.PersonVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DozerConverterTest {

    MockPerson inputObject;

    @BeforeEach
    public void setUp() {
        inputObject = new MockPerson();
    }

    @Test
    void parseEntityToVOTest() {
        PersonVO output = DozerMapper.parseObject(inputObject.mockEntity(), PersonVO.class);
        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("First Name Test0", output.getFirstname());
        assertEquals("Last Name Test0", output.getLastname());
        assertEquals("Addres Test0", output.getAddress());
        assertEquals("Male", output.getGender());
    }

    @Test
    void parseEntityListToVOListTest() {
        List<PersonVO> outputList = DozerMapper.parseListObjects(inputObject.mockEntityList(), PersonVO.class);
        PersonVO outputZero = outputList.get(0);

        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("First Name Test0", outputZero.getFirstname());
        assertEquals("Last Name Test0", outputZero.getLastname());
        assertEquals("Addres Test0", outputZero.getAddress());
        assertEquals("Male", outputZero.getGender());

        PersonVO outputSeven = outputList.get(7);

        assertEquals(Long.valueOf(7L), outputSeven.getId());
        assertEquals("First Name Test7", outputSeven.getFirstname());
        assertEquals("Last Name Test7", outputSeven.getLastname());
        assertEquals("Addres Test7", outputSeven.getAddress());
        assertEquals("Female", outputSeven.getGender());

        PersonVO outputTwelve = outputList.get(12);

        assertEquals(Long.valueOf(12L), outputTwelve.getId());
        assertEquals("First Name Test12", outputTwelve.getFirstname());
        assertEquals("Last Name Test12", outputTwelve.getLastname());
        assertEquals("Addres Test12", outputTwelve.getAddress());
        assertEquals("Male", outputTwelve.getGender());
    }

    @Test
    void parseVOToEntityTest() {
        Person output = DozerMapper.parseObject(inputObject.mockVO(), Person.class);
        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("First Name Test0", output.getFirstname());
        assertEquals("Last Name Test0", output.getLastname());
        assertEquals("Addres Test0", output.getAddress());
        assertEquals("Male", output.getGender());
    }

    @Test
    void parserVOListToEntityListTest() {
        List<Person> outputList = DozerMapper.parseListObjects(inputObject.mockVOList(), Person.class);
        Person outputZero = outputList.get(0);

        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("First Name Test0", outputZero.getFirstname());
        assertEquals("Last Name Test0", outputZero.getLastname());
        assertEquals("Addres Test0", outputZero.getAddress());
        assertEquals("Male", outputZero.getGender());

        Person outputSeven = outputList.get(7);

        assertEquals(Long.valueOf(7L), outputSeven.getId());
        assertEquals("First Name Test7", outputSeven.getFirstname());
        assertEquals("Last Name Test7", outputSeven.getLastname());
        assertEquals("Addres Test7", outputSeven.getAddress());
        assertEquals("Female", outputSeven.getGender());

        Person outputTwelve = outputList.get(12);

        assertEquals(Long.valueOf(12L), outputTwelve.getId());
        assertEquals("First Name Test12", outputTwelve.getFirstname());
        assertEquals("Last Name Test12", outputTwelve.getLastname());
        assertEquals("Addres Test12", outputTwelve.getAddress());
        assertEquals("Male", outputTwelve.getGender());
    }
}