package com.akash.jdbc.database.entity.jpa;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Data
// Java by default provides the default constructor if parameterized constructor is not defined
@Builder
@Entity
//@Table(name="person") // don't need this because table name is same as class
public class Person {

  @Id
  @GeneratedValue
  private int id;
  //  @Column(name="name")// again don't need it
  private String name;
  private String location;
  private Date birthDate;

  public Person(String name, String location, Date birthDate) {
    this.name = name;
    this.location = location;
    this.birthDate = birthDate;
  }
// Required
  public Person() {
  }
}
