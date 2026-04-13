package com.employee.service.impl;

import com.employee.model.dto.EmployeeDTO;
import com.employee.model.entity.Employee;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class EmployeeSeviceImpl implements EmployeeService {

  private final EmployeeRepository employeeRepository;
  private final ModelMapper modelMapper;


  public EmployeeSeviceImpl(EmployeeRepository employeeRepository,
                            ModelMapper modelMapper
  ) {
    this.employeeRepository = employeeRepository;
    this.modelMapper = modelMapper;
  }

  @Override
  public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
    if (employeeDTO.getId() != null) {
      throw new RuntimeException("Employee already exists");
    }

    Employee employee = modelMapper.map(employeeDTO, Employee.class);
    Employee savedEmployee = employeeRepository.save(employee);

    return modelMapper.map(savedEmployee, EmployeeDTO.class);
  }

  @Override
  public EmployeeDTO updateEmployee(UUID id, EmployeeDTO employeeDTO) {

    if (id == null || employeeDTO.getId() == null) {
      throw new RuntimeException("Employee ID must not be null");
    }

    if (!Objects.equals(id, employeeDTO.getId())) {
      throw new RuntimeException("employee ID mismatch");
    }

    employeeRepository.findById(id).orElseThrow(() ->
        new RuntimeException("Employee Not Found"));

    Employee entity = modelMapper.map(employeeDTO, Employee.class);
    Employee updatedEmployee = employeeRepository.save(entity);

    return modelMapper.map(updatedEmployee, EmployeeDTO.class);
  }

  @Override
  public void deleteEmployee(UUID id) {
    Employee employee = employeeRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Employee Not Found Exception"));

    employeeRepository.delete(employee);
  }

  @Override
  public EmployeeDTO getEmployee(UUID id) {
    Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee Not Found"));
    return modelMapper.map(employee, EmployeeDTO.class);
  }

  @Override
  public List<EmployeeDTO> getAllEmployees() {
    List<Employee> employees = employeeRepository.findAll();
    return employees.stream().map(employee ->
        modelMapper.map(employee, EmployeeDTO.class)).toList();
  }
}
