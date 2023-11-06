package com.example.EmployeeManagementSystem.Controllers;

import com.example.EmployeeManagementSystem.Repositories.EmployeeRepo;
import com.example.EmployeeManagementSystem.Services.EmployeeService;
import com.example.EmployeeManagementSystem.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class EmployeeController {

    @Autowired
    private EmployeeService service;


    @GetMapping("/all")
    private ResponseEntity<?> getAll()
    {
        List<Employee> all = service.getAllEmployees();

        if(all.size()==0)
        {
            return ResponseEntity.badRequest().body("No Employee found !");
        }

        return ResponseEntity.ok(all);

    }


    @GetMapping("/{id}")
    private ResponseEntity<?> getbyid(@PathVariable int id)
    {
        Optional<Employee> emp = service.getEmployeeByID(id);

        if(emp.isPresent())
        {
            return ResponseEntity.ok(emp.get());
        }

        return ResponseEntity.badRequest().body("No employee found !!");

    }


    @PostMapping("/add")
    private ResponseEntity<?> add(@RequestBody Employee emp)
    {
        service.addEmployee(emp);

        return new ResponseEntity<>(emp, HttpStatus.CREATED);
    }

    @PostMapping("/add/all")
    private ResponseEntity<?> addAll(@RequestBody List<Employee> emp)
    {
        service.addAllEmployess(emp);

        return new ResponseEntity<>(emp, HttpStatus.CREATED);
    }


    @GetMapping("/about/{id}")
    private ResponseEntity<?> getAbout(@PathVariable long id)
    {
        Optional<Employee> byAbout = service.getAbout(id);

        return ResponseEntity.ok(byAbout.get().getAbout());

    }

    @DeleteMapping("delete/{id}")
    private ResponseEntity<?> delete(@PathVariable long id)
    {
        boolean b = service.deleteByID(id);
        if(b)
            return ResponseEntity.ok("Deleted Successfully of id - "+id);
        return ResponseEntity.notFound().build();
    }

    @PutMapping("update/{id}")
    private ResponseEntity<?> update(@PathVariable long id, @RequestBody Employee employee)
    {
        boolean b = service.updateById(id, employee);

        if(b)
        {
           return new ResponseEntity<>(employee,HttpStatus.ACCEPTED);
        }

        return ResponseEntity.notFound().build();
    }


}
