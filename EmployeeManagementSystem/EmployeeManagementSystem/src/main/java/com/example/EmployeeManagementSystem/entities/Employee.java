package com.example.EmployeeManagementSystem.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Entity
@Table(name = "employees")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false)
    private long id;

    @NotBlank
    private String name;

    @NotBlank
    @Email
    @Column(unique = true)
    private String email;

    @Enumerated(value = EnumType.STRING)
    private GENDER gender;

    @NotBlank
    private String jobtitle;

    @Pattern(regexp = "^\\d{10}$")
    private String phone;

    @NotBlank
    private String imageurl;

    @Column(updatable = false,unique = true,name = "empcode")
    @NotBlank
    private String empcode;

    @Lob
    private String about;

}
