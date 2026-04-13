package com.employee.service;

import com.employee.model.dto.EmployeeDTO;

import java.util.UUID;
import java.util.List;

public interface EmployeeService {

  EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);

  EmployeeDTO updateEmployee(UUID id, EmployeeDTO employeeDTO);

  void deleteEmployee(UUID id);

  EmployeeDTO getEmployee(UUID id);

  List<EmployeeDTO> getAllEmployees();

}
