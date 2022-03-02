package com.akash.jdbc.database.dao.jdbc;

import com.akash.jdbc.database.entity.Person;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * this talks to the database and get values from there
 */

@Repository
public class PersonJDBCDao {

  @Autowired
  JdbcTemplate jdbcTemplate;

  public List<Person> findAll() {
    return jdbcTemplate.query("select * from person"
        , new BeanPropertyRowMapper<Person>(Person.class));// whenever we use this mapper on a particular bean, that bean should have a no arg constructor
  }
}
