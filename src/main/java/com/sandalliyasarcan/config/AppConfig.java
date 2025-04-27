package com.sandalliyasarcan.config;

import com.sandalliyasarcan.model.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    public List<Employee> getEmployeeList() {

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("1","Yaşar Can","Sandallı"));
        employeeList.add(new Employee("2","M","Y")); // ?
        employeeList.add(new Employee("3","Ensar","Kibaroğlu"));
        employeeList.add(new Employee("4","Hamza","Keleş"));
        employeeList.add(new Employee("5","Elif Tuğçe","Eren"));
        employeeList.add(new Employee("6","Enes","Bayram"));
        return employeeList;
    }

}
