package com.akash.jdbc.database;

import com.akash.jdbc.database.dao.jpa.PersonJpaRepository;
import com.akash.jdbc.database.entity.jpa.Person;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class JpaDatabaseApplication implements CommandLineRunner {

  @Autowired
  PersonJpaRepository personJpaRepository;


  public static void main(String[] args) {
    SpringApplication.run(JpaDatabaseApplication.class, args);
  }

  /**
   * This code launches as soon as the spring context is ready
   *
   * @param args
   * @throws Exception
   */
  @Override
  public void run(String... args) throws Exception {
    log.info("All users -> {}", personJpaRepository.findAll());
    log.info("User Id -> {}", personJpaRepository.findById(1001));
    personJpaRepository.deleteById(1002);
    log.info("Inserting 1004 -> {}"
        , personJpaRepository.insert(Person.builder().location("Lucknow").name("Akash Gautam").birthDate(new Date())
            .build()));
    log.info("Updating 1003 -> {}"
        , personJpaRepository.update(Person.builder().id(1003).location("Ghaziabad").name("Gauti").birthDate(new Date()).build()));
  }
}
