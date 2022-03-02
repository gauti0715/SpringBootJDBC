package com.akash.jdbc.database.dao.jpa;

import com.akash.jdbc.database.entity.jpa.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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
//  Merge method to update or insert
//  No difference between the below two methods
  public Person update(Person person) {
    return entityManager.merge(person);
  }
  public Person insert(Person person) {
    return entityManager.merge(person);
  }

  public void deleteById(int id) {
    Person person = findById(id);
    entityManager.remove(person);
  }

  public List<Person> findAll() {
    TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_persons",Person.class);
    return namedQuery.getResultList();
  }

}
