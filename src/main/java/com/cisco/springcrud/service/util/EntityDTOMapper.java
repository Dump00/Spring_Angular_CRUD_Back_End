package com.cisco.springcrud.service.util;

import com.cisco.springcrud.dto.EmployeeDTO;
import com.cisco.springcrud.entity.Employee;

import java.util.List;
import java.util.stream.Collectors;

public class EntityDTOMapper {

    public static EmployeeDTO toEmployeeDTO(Employee e){
        return new EmployeeDTO(e.getId(), e.getFirstName(), e.getLastName(), e.getEmail());
    }

    public static Employee fromEmployeeDTO(EmployeeDTO e){
        return new Employee(e.getId(), e.getFirstName(), e.getLastName(), e.getEmail());
    }

    public static List<EmployeeDTO> toEmployeeDTOList(List<Employee> employees){
        return employees.stream().map(EntityDTOMapper::toEmployeeDTO).collect(Collectors.toList());
    }

    public static List<Employee> fromEmployeeDTOList(List<EmployeeDTO> employees){
        return employees.stream().map(EntityDTOMapper::fromEmployeeDTO).collect(Collectors.toList());
    }
}
