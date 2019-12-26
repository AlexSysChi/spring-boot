package com.sidenis.springbootapp.dao;

import com.sidenis.springbootapp.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("mockAccessService")
public class MockPersonRepositoryImpl implements PersonRepository {

    private static List<Person> storedPersons = new ArrayList<>();
    @Override
    public int addPersonWithId(UUID id, Person person) {
        storedPersons.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> getAllPersons() {
        return storedPersons;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return storedPersons.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> deletionCandidate = selectPersonById(id);
        if (deletionCandidate.isPresent()) {
            storedPersons.remove(deletionCandidate.get());
            return 1;
        }
        return 0;
    }

    @Override
    public int updatePersonById(UUID id, Person personUpdates) {
        Optional<Person> optionalPerson = selectPersonById(id);
        if (!optionalPerson.isPresent()) {
            return 0;
        } else {
            Person person = optionalPerson.get();
            storedPersons.set(storedPersons.indexOf(person), new Person(id, personUpdates.getName()));
            return 1;
        }
    }
}
