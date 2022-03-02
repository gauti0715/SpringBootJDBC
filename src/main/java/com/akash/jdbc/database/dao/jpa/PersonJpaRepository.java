package com.akash.jdbc.database.dao.jpa;

import com.akash.jdbc.database.entity.jpa.Person;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class PersonJpaRepository {

//  All operations are stored in the below annotation.
  @PersistenceContext
  EntityManager entityManager; // this is the interface to the persistence context

  public Person findById(int id) {
    return entityManager.find(Person.class,id);
  }
}
