package com.adress.Address.service.impl;

import com.adress.Address.model.dto.AddressDTO;
import com.adress.Address.model.dto.AddressRequest;
import com.adress.Address.model.dto.AddressRequestDTO;
import com.adress.Address.model.entity.Address;
import com.adress.Address.repository.AddressRepository;
import com.adress.Address.service.AddressService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class AddressServiceImpl implements AddressService {

  private final AddressRepository addressRepository;
  private final ModelMapper modelMapper;

  private Logger logger = LoggerFactory.getLogger(AddressServiceImpl.class);

  public AddressServiceImpl(AddressRepository addressRepository, ModelMapper modelMapper) {
    this.addressRepository = addressRepository;
    this.modelMapper = modelMapper;
  }

  @Override
  public List<AddressDTO> saveAddress(AddressRequest addressRequest) {
    // TODO -> check if emoloyee exists

    List<Address> addressToSave = this.saveOrUpdateRequest(addressRequest);
    List<Address> savedAddress = addressRepository.saveAll(addressToSave);
    return savedAddress.stream().map(address -> modelMapper.map(address, AddressDTO.class)).toList();
  }

  @Override
  public List<AddressDTO> updateAddress(AddressRequest addressRequest) {

//    TODO check f employee exists

    List<Address> adddressOfEmp = addressRepository.findAllByEmpId(addressRequest.getEmpId());

    if(adddressOfEmp.isEmpty()) {
      logger.warn("No address found for empId {} ", addressRequest.getEmpId());
      logger.info("Creating new address for empId {} ", addressRequest.getEmpId());
    }

    List<Address> listToUpdate = this.saveOrUpdateRequest(addressRequest);

    List<Long> upcomingNonNullIds = listToUpdate.stream().map(Address::getId)
        .filter(Objects::nonNull).toList();

    List<Long> existingIds = adddressOfEmp.stream().map(Address::getId).toList();

    List<Long> idsToDelete = existingIds.stream().filter(id -> !upcomingNonNullIds.contains(id)).toList();

    if(!idsToDelete.isEmpty()) {
      addressRepository.deleteAllById(idsToDelete);
    }

    List<Address> updatedAddress = addressRepository.saveAll(listToUpdate);

    return updatedAddress.stream().map(address -> modelMapper.map(address, AddressDTO.class)).toList();
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

  private List<Address> saveOrUpdateRequest(AddressRequest addressRequest) {
    List<Address> addressToSave = new ArrayList<>();
    // this.addressRepository.save(addressRequest);
    for(AddressRequestDTO addressDTO: addressRequest.getAddressRequestDTOList()) {
      Address address = new Address();
      address.setId(addressDTO.getId() != null ? addressDTO.getId() : null);
      address.setStreet(addressDTO.getStreet());
      address.setCity(addressDTO.getCity());
      address.setCountry(addressDTO.getCountry());
      address.setPinCode(addressDTO.getPinCode());
      address.setAddressType(addressDTO.getAddressType());
      address.setEmpId(addressRequest.getEmpId());

      addressToSave.add(address);
    }
    return addressToSave;
  }
}
