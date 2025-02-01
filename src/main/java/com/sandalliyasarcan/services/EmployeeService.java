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
}
