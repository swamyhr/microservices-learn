package com.adress.Address.model.dto;

import java.util.List;

public class AddressRequest {

  private Long empId;
  private List<AddressRequestDTO> addressRequestDTOList;

  public Long getEmpId(){
    return empId;
  }

  public void setEmpId(Long empId) {
    this.empId = empId;
  }

  public List<AddressRequestDTO> getAddressRequestDTOList() {
    return addressRequestDTOList;
  }

  public void setAddressRequestDTOList(List<AddressRequestDTO> addressRequestDTOList) {
    this.addressRequestDTOList = addressRequestDTOList;
  }
}
