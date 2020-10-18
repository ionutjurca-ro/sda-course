package com.sda.spring.data.jpa.config;

import com.sda.spring.data.jpa.model.Person;
import com.sda.spring.data.jpa.repository.PersonJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

//@Configuration
public class JpaRepositoryConfig {

    private static final Logger logger = LoggerFactory.getLogger(JpaRepository.class);
    @Autowired
    private PersonJpaRepository repository;

    @Bean
    public CommandLineRunner jpaData() {
        return args -> {
            loadData();
            testJpaMethods();
        };
    }

    private void testJpaMethods() {
        Long idOfFirstPerson = repository.findAll().get(0).getId();

        //need a valid id
        Person existingPerson = repository.getOne(idOfFirstPerson);

        //find first two people paginated
        Pageable firstTwoElements = PageRequest.of(0, 2);
        Page<Person> firstTwoPersonsPage = repository.findAll(firstTwoElements);

        repository.deleteInBatch(firstTwoPersonsPage.getContent());

        repository.deleteAllInBatch();

    }

    //save people using jpa repository
    private void loadData() {
        logger.info("loading data...");
        //save people in db
        //page 1
        repository.save(new Person("paul", 32));
        repository.save(new Person("alina", 28));
        //page 2
        repository.save(new Person("kazimir", 34));
        repository.save(new Person("lidia", 32));
        //page 3
        repository.save(new Person("violeta", 32));

    }


    //save people using jpa repository
}
