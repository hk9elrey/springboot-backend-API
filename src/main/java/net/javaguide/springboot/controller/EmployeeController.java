package net.javaguide.springboot.controller;

import net.javaguide.springboot.exception.ResourceeNotFound;
import net.javaguide.springboot.model.Employee;
import net.javaguide.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.CreateEmployee(employee);
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeebyID(@PathVariable Long id){
        Employee employee = employeeService.getEmployeebyID(id).getBody();
        return ResponseEntity.ok(employee);
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> UpdateEmployee(@PathVariable Long id ,@RequestBody Employee EmployeeDetaills){
        Employee updateEmployee = employeeService.UpdateEmployee(id,EmployeeDetaills).getBody();

        return ResponseEntity.ok(updateEmployee);
    }

    @DeleteMapping("{id}")
public ResponseEntity<HttpStatus> DeleteEmployee(@PathVariable Long id){
        ResponseEntity<HttpStatus> employee = employeeService.DeleteEmployee(id);

         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}


}
