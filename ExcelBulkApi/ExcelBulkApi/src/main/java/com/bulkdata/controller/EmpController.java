package com.bulkdata.controller;

import com.bulkdata.entity.Employee;
import com.bulkdata.helper.ExcelHelper;
import com.bulkdata.repo.EmpRepo;
import com.bulkdata.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class EmpController {

    @Autowired
    EmpRepo  empRepo;
@Autowired
private EmpService empService;
@PostMapping("/upload")
public ResponseEntity<?>upload(@RequestParam("file")MultipartFile file){
    if (ExcelHelper.checkExcelFormat(file))
    {
        this.empService.saveAllEmployee(file);

        return  ResponseEntity.ok(Map.of("message","file uploaded successfully"));
    }
    return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("PLEASE UPLOAD EXCEL FILE");
}

@GetMapping("/getall")
    public List<Employee> getAllEmployee(){

    return this.empService.getAllEmployees();
}

    @GetMapping("/employee/{employeid}")
    public ResponseEntity<?> getClientDeatilsById(@PathVariable("employeid") int employeid) {
        if (empRepo.findById(employeid).isPresent()) {
            Employee cid = empService.getEmployeeById(employeid);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(cid);
        } else {
            return ResponseEntity.ok(Map.of("message", "the id not found"));
        }
    }

    @PutMapping("/update/{employeid}")
    public ResponseEntity<?> updateEmployee(@RequestBody Employee employee,@PathVariable("employeid") int employeid) {
        Employee employee1 = empService.getEmployeeById(employeid);
        employee1.setEmployeeName(employee.getEmployeeName());
        employee1.setEmployeeCabin(employee.getEmployeeCabin());
        if (employee.getPhoneNumber() == employee1.getPhoneNumber()) {
            return ResponseEntity.ok(Map.of("message", "the phonenumber is already there"));
        } else {
            employee1.setPhoneNumber(employee.getPhoneNumber());
        }
                         employee1.setDesignation(employee.getDesignation());
                         employee1.setBranch(employee.getBranch());
                         int ids = empService.save(employee1);
            return ResponseEntity.ok(Map.of("message","the data is updated"+employee1.getEmployeid()));
    }
    @PostMapping("/saveonedata")
    public ResponseEntity<?> saveaAnotherEmployee(@RequestBody Employee employee){
        employee.setEmployeeName(employee.getEmployeeName());
        employee.setEmployeeCabin(employee.getEmployeeCabin());
        if (employee.getPhoneNumber() == employee.getPhoneNumber()) {
            return  ResponseEntity.ok(Map.of("message","the phonenumber is already there"));
        }else{
            employee.setPhoneNumber(employee.getPhoneNumber());
        }
        employee.setDesignation(employee.getDesignation());
        employee.setBranch(employee.getBranch());
    Integer id = empService.save(employee);
    return ResponseEntity.ok(Map.of("message"," single file uploaded successfully"));
    }


}
