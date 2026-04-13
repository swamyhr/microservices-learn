package com.employee.controller;

import com.employee.model.dto.EmployeeDTO;
import com.employee.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/employees")
public class EmployeeController {


  private final EmployeeService employeeService;

  public EmployeeController(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @PostMapping
  public ResponseEntity<EmployeeDTO> saveEmployee(
      @RequestBody EmployeeDTO employeeDTO
  ) {

    EmployeeDTO employee = employeeService.saveEmployee(employeeDTO);
    return new ResponseEntity<>(employee, HttpStatus.CREATED);
  }

  @PutMapping("/update/{id}")
  public ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody EmployeeDTO
                                                          employeeDto, @PathVariable UUID id) {
    EmployeeDTO response = employeeService.updateEmployee(id, employeeDto);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<String> deleteEmployee(@PathVariable UUID id) {
    employeeService.deleteEmployee(id);
    return new ResponseEntity<>("Employee deleted successfully", HttpStatus.OK);
  }
}
