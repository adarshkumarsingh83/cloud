package com.espark.adarsh.listener;

import com.espark.adarsh.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import com.espark.adarsh.repository.EmployeeRepository;

import java.util.UUID;
import java.util.stream.Stream;

@Slf4j
@Component
public class ApplicationListener {

    @Autowired
    private EmployeeRepository reservationRepository;


    @EventListener(ApplicationReadyEvent.class)
    public void setup() {

        this.reservationRepository.deleteAll();

        Stream.of("adarsh", "radha")
                .map(name -> new Employee(UUID.randomUUID().toString(), name))
                .forEach(this.reservationRepository::save);
        this.reservationRepository.findAll().forEach(r -> log.info(r.toString()));
    }
}
