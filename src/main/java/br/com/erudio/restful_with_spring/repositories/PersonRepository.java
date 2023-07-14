package br.com.erudio.restful_with_spring.repositories;

import br.com.erudio.restful_with_spring.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
