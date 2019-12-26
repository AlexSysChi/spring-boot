package com.sidenis.springbootapp.service;

import com.sidenis.springbootapp.dao.PersonRepository;
import com.sidenis.springbootapp.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonRepository dbService;

    @Autowired
    public PersonService(@Qualifier("H2") PersonRepository dbService) {
        this.dbService = dbService;
    }

    public int addPerson(Person person) {
        UUID id = UUID.randomUUID();
        return dbService.addPerson(person);
    }

    public List<Person> getAllPersons() {
        return dbService.getAllPersons();
    }

    public Optional<Person> getPersonById(UUID id) {
        return dbService.selectPersonById(id);
    }

    public int deletePersonById(UUID id){
        return dbService.deletePersonById(id);
    }

    public int updatePersonById(UUID id, Person personUpdates) {
        return dbService.updatePersonById(id, personUpdates);
    }
}
