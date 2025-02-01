package com.sandalliyasarcan.controller;

import com.sandalliyasarcan.model.Employee;
import com.sandalliyasarcan.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/api")
public class RestEmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //EmployeeService employeeService2 = new EmployeeService(); --> Neden böyle olmadı da AutoWired dı kullandık ??

    @GetMapping(path = "/employee-list")
    public List<Employee> getEmployeeList() {
        return employeeService.getEmployeeList();
        //return employeeService2.getEmployeeList();
    }
}
