package com.akash.jdbc.database;

import com.akash.jdbc.database.dao.springjdbc.PersonJDBCDao;
import com.akash.jdbc.database.entity.springjdbc.Person;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class DatabaseApplication implements CommandLineRunner {

  @Autowired
  PersonJDBCDao personJDBCDao;


  public static void main(String[] args) {
    SpringApplication.run(DatabaseApplication.class, args);
  }

  /**
   * This code launches as soon as the spring context is ready
   *
   * @param args
   * @throws Exception
   */
  @Override
  public void run(String... args) throws Exception {
    log.info("All users -> {}", personJDBCDao.findAll());
    log.info("User Id -> {}", personJDBCDao.findById(1001));
    log.info("Deleting 1002.Number of rows affected-> {}", personJDBCDao.deleteById(1002));
    log.info("Inserting 1004 -> {}"
        , personJDBCDao.insert(Person.builder().id(1004).location("Lucknow").name("Akash Gautam").birthDate(new Date())
            .build()));
    log.info("Updating 1003 -> {}"
        , personJDBCDao.update(Person.builder().id(1003).location("Ghaziabad").name("Gauti").birthDate(new Date()).build()));
  }
}
