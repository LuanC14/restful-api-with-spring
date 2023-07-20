package br.com.erudio.restful_with_spring.VO.v1;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class PersonVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private long id;
    private String firstname;
    private String lastname;
    private String address;
    private String gender;

    public PersonVO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonVO personVO = (PersonVO) o;
        return id == personVO.id && Objects.equals(firstname, personVO.firstname) && Objects.equals(lastname, personVO.lastname) && Objects.equals(address, personVO.address) && Objects.equals(gender, personVO.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, address, gender);
    }
}
