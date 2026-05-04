package com.adress.Address.service.impl;

import com.adress.Address.model.dto.AddressDTO;
import com.adress.Address.model.dto.AddressRequest;
import com.adress.Address.model.dto.AddressRequestDTO;
import com.adress.Address.model.entity.Address;
import com.adress.Address.repository.AddressRepository;
import com.adress.Address.service.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

  private final AddressRepository addressRepository;
  private final ModelMapper modelMapper;

  public AddressServiceImpl(AddressRepository addressRepository, ModelMapper modelMapper) {
    this.addressRepository = addressRepository;
    this.modelMapper = modelMapper;
  }

  @Override
  public List<AddressDTO> saveAddress(AddressRequest addressRequest) {
    // TODO -> check if emoloyee exists

    List<Address> addressToSave = new ArrayList<>();
    // this.addressRepository.save(addressRequest);
    for(AddressRequestDTO addressDTO: addressRequest.getAddressRequestDTOList()) {
      Address address = new Address();
      address.setStreet(addressDTO.getStreet());
      address.setCity(addressDTO.getCity());
      address.setCountry(addressDTO.getCountry());
      address.setPinCode(addressDTO.getPinCode());
      address.setAddressType(addressDTO.getAddressType());
      address.setEmpId(addressRequest.getEmpId());

      addressToSave.add(address);
    }

    List<Address> savedAddress = addressRepository.saveAll(addressToSave);
    return savedAddress.stream().map(address -> modelMapper.map(address, AddressDTO.class)).toList();
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
  public void deleteAddress(Long id) {

  }
}
