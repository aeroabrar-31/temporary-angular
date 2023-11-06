package com.example.EmployeeManagementSystem.Repositories;

import com.example.EmployeeManagementSystem.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {


}
