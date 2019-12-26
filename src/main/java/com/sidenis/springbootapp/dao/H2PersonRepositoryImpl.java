package com.sidenis.springbootapp.dao;

import com.sidenis.springbootapp.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("H2")
public class H2PersonRepositoryImpl implements PersonRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public H2PersonRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int addPersonWithId(UUID id, Person person) {
        return 0;
    }

    @Override
    public List<Person> getAllPersons() {
        return jdbcTemplate.query("select * from PERSON",
                (resultSet, i) -> new Person(UUID.fromString(resultSet.getString("id")),
                        resultSet.getString("name"))
        );
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {

        return Optional.ofNullable(
                jdbcTemplate.queryForObject("select * from PERSON where id = ?", new Object[]{id},
                        (resultSet, i) -> new Person(UUID.fromString(resultSet.getString("id")),
                                resultSet.getString("name")))
        );
    }

    @Override
    public int deletePersonById(UUID id) {
        return 0;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return 0;
    }
}
