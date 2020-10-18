package com.sda.spring.data.jpa.repository;

import com.sda.spring.data.jpa.model.Person;
import com.sda.spring.data.jpa.model.User;
import com.sda.spring.data.jpa.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PersonCrudRepositoryIntegrationTest {
    @Autowired
    private PersonCrudRepository personCrudRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    void givenTwoPeople_whenFindByName_thenReturnCorrectPerson() {
        // given
        personCrudRepository.save(new Person("ana", 25));
        String expected = "paul";
        personCrudRepository.save(new Person(expected, 30));

        // when
        Person paul = personCrudRepository.findByName(expected)
                .orElseThrow(() -> new RuntimeException());

        // then
        assertThat(paul.getName()).isEqualTo(expected);
    }

    @Test
    void givenTwoPeople_whenDelete_thenOk() {
        Person george = new Person("george", 26);
        Person mihai = new Person("mihai", 31);
        personCrudRepository.save(george);
        personCrudRepository.save(mihai);

        // count people before delete
        List<Person> initialPersons = (List<Person>) personCrudRepository.findAll();
        int initialNumberOfPersons = initialPersons.size();

        // delete
        personCrudRepository.delete(mihai);

        // count people after delete
        List<Person> updatedPersons = (List<Person>) personCrudRepository.findAll();
        int updatedNumberOfPersons = updatedPersons.size();

        // if before > after
        assert initialNumberOfPersons > updatedNumberOfPersons;
    }

    @Test
    void givenUsers_whenCreateNewUser_thenOk() {
        int initialNumberOfUsers = userService.findAll().size();

        userService.create(new User());

        int updatedNumberOfUsers = userService.findAll().size();

        assertThat(initialNumberOfUsers).isLessThan(updatedNumberOfUsers);
    }
}
