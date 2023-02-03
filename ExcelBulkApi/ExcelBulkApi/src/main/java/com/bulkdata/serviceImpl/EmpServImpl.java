package com.bulkdata.serviceImpl;

import com.bulkdata.entity.Employee;
import com.bulkdata.helper.ExcelHelper;
import com.bulkdata.repo.EmpRepo;
import com.bulkdata.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class EmpServImpl implements EmpService {


    @Autowired
    EmpRepo empRepo;
    public void saveAllEmployee (MultipartFile file){
        try{
            //dto
            List<Employee> employees =   ExcelHelper.convertExcelToListOfProduct(file.getInputStream());
            this.empRepo.saveAll(employees);
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
    public List<Employee> getAllEmployees(){
        return this.empRepo.findAll();
    }

    @Override
    public Employee getEmployeeById(int employeid) {

        return  empRepo.findById(employeid).get();
    }


////asas
@Override
public Integer save(Employee employee) {

        return empRepo.save(employee).getEmployeid();
}

}
