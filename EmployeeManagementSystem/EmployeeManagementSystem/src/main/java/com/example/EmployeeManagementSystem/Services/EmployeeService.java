package com.example.EmployeeManagementSystem.Services;

import com.example.EmployeeManagementSystem.Repositories.EmployeeRepo;
import com.example.EmployeeManagementSystem.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;


    public Optional<Employee> getEmployeeByID(long id)
    {
        Optional<Employee> byId = employeeRepo.findById(id);
        return byId;
    }

    public void addAllEmployess(List<Employee> emp) {
        employeeRepo.saveAll(emp);
    }

    public void addEmployee(Employee emp) {
        employeeRepo.save(emp);
    }

    public List<Employee> getAllEmployees() {
        List<Employee> all = employeeRepo.findAll();
        return all;
    }

    public Optional<Employee> getAbout(long id) {
        Optional<Employee> employeeByID = this.getEmployeeByID(id);
        return employeeByID;
    }

    public boolean deleteByID(long id) {
        Optional<Employee> employeeByID = this.getEmployeeByID(id);
        if(employeeByID.isPresent())
        {
            employeeRepo.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean updateById(long id, Employee employee) {

        Optional<Employee> op = employeeRepo.findById(id);

        if (op.isPresent())
        {
            Employee existing=op.get();
            System.out.println(existing);

            existing.setId(id);
            existing.setAbout(employee.getAbout());
            existing.setName(employee.getName());
            existing.setGender(employee.getGender());
            existing.setEmail(employee.getEmail());
            existing.setEmail(employee.getEmail());
            existing.setEmpcode(employee.getEmpcode());
            existing.setImageurl(employee.getImageurl());
            existing.setJobtitle(employee.getJobtitle());

            employeeRepo.save(existing);

            return true;

        }
        return false;


    }
}
