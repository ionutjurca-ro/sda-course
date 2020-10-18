package com.sda.spring.data.jpa.repository;

import com.sda.spring.data.jpa.model.Person;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonPagingAndSortingPersonRepository extends PagingAndSortingRepository<Person, Long> {
}
