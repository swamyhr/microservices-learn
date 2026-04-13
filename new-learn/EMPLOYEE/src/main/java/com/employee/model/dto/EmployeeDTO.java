package com.employee.model.dto;

import java.util.UUID;

public class EmployeeDTO {

  private UUID id;
  private String name;
  private String email;
  private String code;
  private String companyName;

  public UUID getId() {
    return id;
  }

  public EmployeeDTO(){

  }

  public EmployeeDTO(String name, String email, String code, String companyNamae) {
    this.name = name;
    this.email = email;
    this.code = code;
    this.companyName = companyNamae;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  @Override
  public String toString() {
    return "Employee{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", email='" + email + '\'' +
        ", code='" + code + '\'' +
        ", companyNamae='" + companyName + '\'' +
        '}';
  }
}
