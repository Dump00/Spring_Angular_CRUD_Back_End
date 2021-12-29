package com.cisco.springcrud.service;

import com.cisco.springcrud.dto.EmployeeDTO;
import com.cisco.springcrud.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDTO> findAllEmployees();

    EmployeeDTO findEmployee(Long id);

    EmployeeDTO updateEmployee(Long id, EmployeeDTO emp);

    EmployeeDTO saveEmployee(EmployeeDTO emp);

    void deleteEmployee(Long id);
}
