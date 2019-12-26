package com.sidenis.springbootapp.dao;

import com.sidenis.springbootapp.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonRepository {
    int addPersonWithId(UUID id, Person person);

    default int addPerson(Person person) {
        UUID id = UUID.randomUUID();
        return addPersonWithId(id, person);
    }

    List<Person> getAllPersons();

    Optional<Person> selectPersonById(UUID id);

    int deletePersonById(UUID id);

    int updatePersonById(UUID id, Person person);
}
