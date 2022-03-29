package com.example.springpatterns.patterns.creational.builder;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Employee {

    private Long id;
    private String username;
    private String email;
    private Double salary;
    private Boolean married;
    private Integer age;
    private LocalDate birthDate;
    private Integer workYears;

    private Employee(Long id, String username, String email, Double salary, Boolean married, Integer age, LocalDate birthDate, Integer workYears) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.salary = salary;
        this.married = married;
        this.age = age;
        this.birthDate = birthDate;
        this.workYears = workYears;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Boolean getMarried() {
        return married;
    }

    public void setMarried(Boolean married) {
        this.married = married;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getWorkYears() {
        return workYears;
    }

    public void setWorkYears(Integer workYears) {
        this.workYears = workYears;
    }

    public static final class EmployeeBuilder {
        private Long id;
        private String username;
        private String email;
        private Double salary;
        private Boolean married;
        private Integer age;
        private LocalDate birthDate;
        private Integer workYears;

        private EmployeeBuilder(Long id, String username, String email, Double salary, Boolean married, Integer age, LocalDate birthDate, Integer workYears) {
            this.id = id;
            this.username = username;
            this.email = email;
            this.salary = salary;
            this.married = married;
            this.age = age;
            this.birthDate = birthDate;
            this.workYears = workYears;
        }

        public static EmployeeBuilder aEmployee(Long id, String username, String email, Double salary, Boolean married, Integer age, LocalDate birthDate, Integer workYears) {
            return new EmployeeBuilder(id, username, email, salary, married, age, birthDate, workYears);
        }

        public Employee build() {
            Employee employee = new Employee(id, username, email, salary, married, age, birthDate, workYears);
            return employee;
        }
    }
}
