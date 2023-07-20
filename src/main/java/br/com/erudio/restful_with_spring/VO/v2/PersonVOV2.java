package br.com.erudio.restful_with_spring.VO.v2;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class PersonVOV2 implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private long id;
    private String firstname;
    private String lastname;
    private String address;
    private String gender;
    private Date createdAt;

    public PersonVOV2() {
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonVOV2 personVOV2 = (PersonVOV2) o;
        return id == personVOV2.id && Objects.equals(firstname, personVOV2.firstname) && Objects.equals(lastname, personVOV2.lastname) && Objects.equals(address, personVOV2.address) && Objects.equals(gender, personVOV2.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, address, gender);
    }
}