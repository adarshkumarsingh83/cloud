package com.espark.adarsh.service;

import com.espark.adarsh.bean.Person;

import java.util.List;

public interface PersonService {

    Person savePerson(Person person);

    Person updatePerson(Long personId, Person person);

    Person findPerson(Long personId);

    List<Person> findPersons();

    Person deletePerson(Long personId);
}
