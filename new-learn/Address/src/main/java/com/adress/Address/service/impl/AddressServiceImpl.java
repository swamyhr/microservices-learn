package com.adress.Address.service.impl;

import com.adress.Address.model.dto.AddressDTO;
import com.adress.Address.model.dto.AddressRequest;
import com.adress.Address.repository.AddressRepository;
import com.adress.Address.service.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements  AddressService{

  private final AddressRepository addressRespository;
  private final ModelMapper modelMapper;

  public AddressServiceImpl(AddressRepository addressRepository, ModelMapper modelMapper  ) {
    this.addressRespository = addressRepository;
    this.modelMapper = modelMapper;
  }

  @Override
  public AddressDTO saveAddress(AddressRequest addressRequest) {
  // TODO -> check if emoloyee exists

    this.addressRespository.save(addressRequest);
  }

  @Override
  public AddressDTO updateAddress(AddressRequest addressRequest) {
    return null;
  }

  @Override
  public AddressDTO getSingleAddress(Long id) {
    return null;
  }

  @Override
  public List<AddressDTO> getAllAddress() {
    return null;
  }

  @Override
  public void deleteAddresss(Long id) {

  }
}
