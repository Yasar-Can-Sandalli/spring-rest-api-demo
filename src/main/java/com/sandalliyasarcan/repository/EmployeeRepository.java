package com.sandalliyasarcan.repository;

import com.sandalliyasarcan.config.AppConfig;
import com.sandalliyasarcan.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;

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
}
