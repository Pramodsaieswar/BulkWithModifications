package com.bulkdata.service;

import com.bulkdata.entity.Employee;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


public interface EmpService {

;
    public void saveAllEmployee (MultipartFile file);

    public List<Employee> getAllEmployees();



    Employee getEmployeeById(int employeid);

    //kak
    Integer save(Employee employee);

}
