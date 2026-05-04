package com.adress.Address.service;

import com.adress.Address.model.dto.AddressDTO;
import com.adress.Address.model.dto.AddressRequest;

import java.util.List;

public interface AddressService {
  List<AddressDTO> saveAddress(AddressRequest addressRequest);

  AddressDTO updateAddress(AddressRequest addressRequest);

  AddressDTO getSingleAddress(Long id);

  List<AddressDTO> getAllAddress();

  void deleteAddress(Long id);
}
