package com.espark.adarsh.service;

import com.espark.adarsh.bean.Person;
import com.espark.adarsh.exception.ApplicationException;
import com.espark.adarsh.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person savePerson(Person person) {
        return this.personRepository.save(person);
    }

    @Override
    public Person updatePerson(Long personId, Person person) {
        Optional<Person> personOptional = this.personRepository.findById(personId);
        if (personOptional.isPresent()) {
            return this.personRepository.save(person);
        } else {
            throw new ApplicationException("Person not Found with id " + personId);
        }
    }


    @Override
    public Person findPerson(Long personId) {
        Optional<Person> personOptional = this.personRepository.findById(personId);
        if (personOptional.isPresent()) {
            return personOptional.get();
        } else {
            throw new ApplicationException("Person not Found with id " + personId);
        }
    }

    @Override
    public List<Person> findPersons() {
        if (this.personRepository.count() > 0) {
            List<Person> personList = new ArrayList<>();
            Iterable<Person> personIterable = this.personRepository.findAll();
            personIterable.forEach(person -> personList.add(person));
            return personList;
        } else {
            throw new ApplicationException("Persons not Found");
        }
    }

    @Override
    public Person deletePerson(Long personId) {
        Optional<Person> personOptional = this.personRepository.findById(personId);
        if (personOptional.isPresent()) {
            Person person = personOptional.get();
            this.personRepository.delete(person);
            return person;
        } else {
            throw new ApplicationException("Person not Found with id " + personId);
        }
    }
}
