package com.example.JDBCEMPLOYEE;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeejdbcImplementation employeejdbcImplementation;

    public EmployeeController(EmployeejdbcImplementation employeejdbcImplementation) {
        this.employeejdbcImplementation = employeejdbcImplementation;
    }
    @GetMapping("/employee/{id}")
    Employee getEmployee(@PathVariable Integer id) {
        return employeejdbcImplementation.queryEmployeeById(id);
    }

    @GetMapping("/employee")
    List<Employee> getEmployees() {
        return employeejdbcImplementation.queryFromDatabase(100);
    }

    @DeleteMapping("/employees/{id}")
    public String deleteById(@PathVariable int id) {
        return employeejdbcImplementation.delete(id)+" Employee(s) delete from the database";
    }


    @PostMapping("/employees")
    public String save(@RequestBody Employee e) {
        return employeejdbcImplementation.save(e)+" Employee(s) saved successfully";
    }
}
