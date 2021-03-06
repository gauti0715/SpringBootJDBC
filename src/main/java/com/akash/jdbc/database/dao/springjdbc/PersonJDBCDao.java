package com.akash.jdbc.database.dao.springjdbc;

import com.akash.jdbc.database.entity.springjdbc.Person;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * this talks to the database and get values from there
 */

@Repository
public class PersonJDBCDao {

  @Autowired
  JdbcTemplate jdbcTemplate;

  class PersonRowMapper implements RowMapper<Person> {

    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
      Person person = new Person();
      person.setId(rs.getInt("id"));
      person.setName(rs.getString("name"));
      person.setLocation(rs.getString("location"));
      person.setBirthDate(rs.getTimestamp("birth_date"));
      return person;
    }
  }

  public List<Person> findAll() {
//    return jdbcTemplate.query("select * from person"
//        , new BeanPropertyRowMapper<Person>(Person.class));// whenever we use this mapper on a particular bean, that bean should have a no arg constructor
      return jdbcTemplate.query("select * from person"
        , new PersonRowMapper());
  }

  public Person findById(int id) {
//    return jdbcTemplate.queryForObject("select * from person where id = ?",new BeanPropertyRowMapper<Person>(Person.class));
    return jdbcTemplate.queryForObject("select * from person where id = ?", new Object[]{id}
        , new BeanPropertyRowMapper<Person>(Person.class));// whenever we use this mapper on a particular bean, that bean should have a no arg constructor
  }

  public int deleteById(int id) {
    return jdbcTemplate.update("delete from person where id = ?"
        , new Object[]{id});
  }

  public int insert(Person person) {
    return jdbcTemplate.update("insert into person ( id, name, location, birth_date )\n"
            + "values( ?, ?, ?, ?);"
        ,
        person.getId(),person.getName(),person.getLocation(),new Timestamp(person.getBirthDate().getTime()));
  }

  public int update(Person person) {
    return jdbcTemplate.update("update person set name = ?, location = ?, birth_date = ?"
            + "where id = ?"
        , person.getName(),person.getLocation(),new Timestamp(person.getBirthDate().getTime()),person.getId());
  }
}
