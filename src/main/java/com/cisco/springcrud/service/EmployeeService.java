package com.cisco.springcrud.service;

import com.cisco.springcrud.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAllEmployees();

    Employee findEmployee(Long id);

    Employee updateEmployee(Long id, Employee emp);

    Employee saveEmployee(Employee emp);

    void deleteEmployee(Long id);
}
