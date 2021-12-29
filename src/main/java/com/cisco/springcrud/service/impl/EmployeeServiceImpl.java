package com.cisco.springcrud.service.impl;

import com.cisco.springcrud.dto.EmployeeDTO;
import com.cisco.springcrud.entity.Employee;
import com.cisco.springcrud.exception.ResourceNotFoundException;
import com.cisco.springcrud.repository.EmployeeRepository;
import com.cisco.springcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.cisco.springcrud.service.util.EntityDTOMapper.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeDTO> findAllEmployees() {
        return toEmployeeDTOList(employeeRepository.findAll());
    }

    @Override
    public EmployeeDTO findEmployee(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("There is no employee associated with the given id " + id));
        return toEmployeeDTO(employee);
    }

    @Override
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO emp) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("There is no employee associated with the given id " + id));
        employee.setFirstName(fromEmployeeDTO(emp).getFirstName());
        employee.setLastName(fromEmployeeDTO(emp).getLastName());
        employee.setEmail(fromEmployeeDTO(emp).getEmail());
        Employee updatedEmployee = employeeRepository.save(employee);
        return toEmployeeDTO(updatedEmployee);
    }

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO emp) {
        return toEmployeeDTO(employeeRepository.save(fromEmployeeDTO(emp)));
    }


    @Override
    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("There is no employee associated with the given id " + id));
        employeeRepository.delete(employee);
    }
}
