package com.sandalliyasarcan.services;

import com.sandalliyasarcan.model.Employee;
import com.sandalliyasarcan.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployeeList() {
        return employeeRepository.getEmployeeList();
        //return employeeRepository.getEmployeeList2();
    }

    public Employee getEmployeeById(String  id) {
        return employeeRepository.getEmployeeById(id);
    }

    public List<Employee> getEmployeeListWithParams(String firstName, String lastName) {
        return employeeRepository.getEmployeeWithParams(firstName, lastName);
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.saveEmployee(employee);
    }


    public boolean deleteEmployee(String id) {
        return employeeRepository.deleteEmployee(id);
    }

    public boolean deleteEmployeeWithJson(Employee employee) {
        return  employeeRepository.deleteEmployeeWithJson(employee);
    }

}
