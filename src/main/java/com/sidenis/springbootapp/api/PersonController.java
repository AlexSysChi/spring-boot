package com.sidenis.springbootapp.api;

import com.sidenis.springbootapp.dao.PersonRepository;
import com.sidenis.springbootapp.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/person")
@RestController
public class PersonController {
    private final PersonRepository dbService;

    @Autowired
    public PersonController(@Qualifier("H2") PersonRepository dbService) {
        this.dbService = dbService;
    }

    @PostMapping
    public void addPerson(@Valid @NotNull @RequestBody Person person) {
        dbService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPersons() {
        return dbService.getAllPersons();
    }

    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id") UUID id) {
        return dbService.selectPersonById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") UUID id) {
        dbService.deletePersonById(id);
    }

    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable("id") UUID id, @Valid @NotNull @RequestBody Person personToUpdate) {
        dbService.updatePersonById(id, personToUpdate);
    }
}
