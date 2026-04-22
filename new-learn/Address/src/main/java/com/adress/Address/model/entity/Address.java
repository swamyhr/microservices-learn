package com.adress.Address.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Address {

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Long id;
  private Long empId;

  private String street;

  private Long pinCode;

  private String city;

  private String country;
}
