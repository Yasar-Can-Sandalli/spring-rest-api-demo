package com.sandalliyasarcan.controller;

import com.sandalliyasarcan.model.Employee;
import com.sandalliyasarcan.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/employee")
public class RestEmployeeController {


    @Autowired
    private EmployeeService employeeService;

    //EmployeeService employeeService2 = new EmployeeService(); --> Neden böyle olmadı da AutoWired dı kullandık ??

    @GetMapping(path = "/list")
    public List<Employee> getEmployeeList() {
        return employeeService.getEmployeeList();
        //return employeeService2.getEmployeeList();
    }


    @GetMapping(path = "/list/{id}")
    public Employee getEmployeeById(@PathVariable(name = "id", required = true) String id)  {
        return employeeService.getEmployeeById(id);
    }


    @GetMapping(path = "/with-params")
    public List<Employee> getEmployeeWithParams(@RequestParam(name = "firstName", required = false) String firstName, @RequestParam(name = "lastName",required = false) String lastName) {
        return employeeService.getEmployeeListWithParams(firstName, lastName);
    }

    @PostMapping(path = "/save-employee")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @DeleteMapping(path = "/delete-employee/{id}")
    public boolean deleteEmployee(@PathVariable(name = "id", required = true) String id) {
        return employeeService.deleteEmployee(id);
    }

    @DeleteMapping(path = "/delete-employee/json")
    public boolean deleteEmployeeWithJson(@RequestBody Employee employee) {
        return employeeService.deleteEmployeeWithJson(employee);
    }

    @PutMapping(path = "/update-employee/{id}")
    public Employee updateEmployee(@PathVariable(name = "id", required = true) String id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }



}
