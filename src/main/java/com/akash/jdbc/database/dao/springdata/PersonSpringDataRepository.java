package com.akash.jdbc.database.dao.springdata;

import com.akash.jdbc.database.entity.jpa.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonSpringDataRepository extends JpaRepository<Person, Integer> {

}
