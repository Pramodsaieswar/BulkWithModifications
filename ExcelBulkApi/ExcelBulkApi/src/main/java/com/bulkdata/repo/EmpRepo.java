package com.bulkdata.repo;

import com.bulkdata.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepo  extends JpaRepository<Employee,Integer> {
}
