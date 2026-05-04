package com.adress.Address.model.dto;

import com.adress.Address.model.enums.AddressType;

public class AddressRequestDTO {

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public Long getPinCode() {
    return pinCode;
  }

  public void setPinCode(Long pinCode) {
    this.pinCode = pinCode;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public AddressType getAddressType() {
    return addressType;
  }

  public void setAddressType(AddressType addressType) {
    this.addressType = addressType;
  }

  private Long id;
  private String street;
  private Long pinCode;
  private String city;
  private String country;
  private AddressType addressType;
}
