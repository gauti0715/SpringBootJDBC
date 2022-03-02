package com.akash.jdbc.database;

import com.akash.jdbc.database.dao.jdbc.PersonJDBCDao;
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
  }
}
