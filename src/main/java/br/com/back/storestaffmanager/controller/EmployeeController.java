package br.com.back.storestaffmanager.controller;

import br.com.back.storestaffmanager.model.Employee;
import br.com.back.storestaffmanager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployee(){
        List<Employee> employees = employeeService.getAllEmployee();

        return ResponseEntity.status(HttpStatus.OK).body(employees);
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee (@RequestBody Employee employee){
        Employee createdEmployee = employeeService.createEmployee(employee);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> deleteEmployee (@PathVariable Long id){
        Employee employee = new Employee();
        employeeService.deleteEmployee(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
