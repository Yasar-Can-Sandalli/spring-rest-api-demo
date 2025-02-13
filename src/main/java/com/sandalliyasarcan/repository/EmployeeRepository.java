package com.sandalliyasarcan.repository;

import com.sandalliyasarcan.config.AppConfig;
import com.sandalliyasarcan.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {


    @Autowired
    private List<Employee> employeeList;

    //Bean olarak AnnotationConfigApplicationContext class ı ile de çağırılabilir
    public  List<Employee> getEmployeeList2(){
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        this.employeeList = context.getBean(AppConfig.class).getEmployeeList();
        return this.employeeList;
    }

    public List<Employee> getEmployeeList() {
        //JDBC veya
        //Hibernate ile Veritabanina baglanip verilerin getirilmesi saglayan kodlar yazilacak
        return employeeList;

    }

    public Employee getEmployeeById(String id) {
        Employee findEmployee = null;

        for (Employee employee : employeeList) {
            if (employee.getId().equalsIgnoreCase(id)){
                findEmployee = employee;
                break;
            }
        }

        return findEmployee;
    }

    public List<Employee> getEmployeeWithParams(String firstName, String lastName) {
        List<Employee> employeeListWithParams = new ArrayList<Employee>();
        if (firstName == null && lastName == null) {
            return employeeList;
        } else if (firstName != null && lastName != null) {
            for (Employee employee : employeeList) {
                if (employee.getFirstName().equalsIgnoreCase(firstName) && employee.getLastName().equalsIgnoreCase(lastName)) {
                    employeeListWithParams.add(employee);
                }
            }
        } else if (firstName != null && lastName == null) {
            for (Employee employee : employeeList) {
                if (employee.getFirstName().equalsIgnoreCase(firstName)) {
                    employeeListWithParams.add(employee);
                }
            }
        }else if (firstName == null && lastName != null) {
            for (Employee employee : employeeList) {
                if (employee.getLastName().equalsIgnoreCase(lastName)) {
                    employeeListWithParams.add(employee);
                }
            }
        }


        return employeeListWithParams;
    }

    public Employee saveEmployee(Employee employee) {
        this.employeeList.add(employee);
        System.out.println("Employee saved");
        return employee;
    }

    public boolean deleteEmployee(String id) {
        for (Employee employee : employeeList) {
            if (employee.getId().equals(id)) {
                this.employeeList.remove(employee);
                return true;
            }
        }
        return false;
    }

    public boolean deleteEmployeeWithJson(Employee employee) {
        for (Employee deleteEmployee : employeeList) {
            if (deleteEmployee.getId().equals(employee.getId()) && deleteEmployee.getFirstName().equalsIgnoreCase(employee.getFirstName()) && deleteEmployee.getLastName().equalsIgnoreCase(employee.getLastName())) {
                this.employeeList.remove(deleteEmployee);
                return true;
            }
        }
        return false;
    }



}


