package com.youn.have.repository;

import com.youn.have.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Employee findEmployeeById(Integer id);  //, Integer departmentId);

}
