package com.akash.jdbc.database.entity.springjdbc;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor// Java by default provides the default constructor if parameterized constructor is not defined
@AllArgsConstructor
@Builder
public class Person {

  private int id;
  private String name;
  private String location;
  private Date birthDate;
}
