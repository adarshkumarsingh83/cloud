package com.espark.adarsh.controller;

import com.espark.adarsh.bean.Person;
import com.espark.adarsh.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/person")
    public Person savePerson(@RequestBody Person person) {
        return this.personService.savePerson(person);
    }

    @PutMapping("/person/{personId}")
    public Person updatePerson(@PathVariable("personId") Long personId, @RequestBody Person person) {
        return this.personService.updatePerson(personId, person);
    }

    @DeleteMapping("/person/{personId}")
    public Person updatePerson(@PathVariable("personId") Long personId) {
        return this.personService.deletePerson(personId);
    }

    @GetMapping("/person/{personId}")
    public Person getPerson(@PathVariable("personId") Long personId) {
        return this.personService.findPerson(personId);
    }

    @GetMapping("/persons")
    public List<Person> getPersons() {
        return this.personService.findPersons();
    }

}
