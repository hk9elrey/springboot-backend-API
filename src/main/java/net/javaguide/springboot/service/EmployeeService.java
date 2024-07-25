package net.javaguide.springboot.service;

import net.javaguide.springboot.exception.ResourceeNotFound;
import net.javaguide.springboot.model.Employee;
import net.javaguide.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee CreateEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    public ResponseEntity<Employee> getEmployeebyID( Long id){
        Employee employee = employeeRepository.findById(id).
                orElseThrow(()-> new ResourceeNotFound("Employees not exist" + id));
        return ResponseEntity.ok(employee);
    }

    public ResponseEntity<Employee> UpdateEmployee( Long id ,Employee EmployeeDetaills){
        Employee updateEmployee = employeeRepository.findById(id).
                orElseThrow(()-> new ResourceeNotFound("Employee not Found" + id));

        updateEmployee.setFirstName(EmployeeDetaills.getFirstName());
        updateEmployee.setLastName(EmployeeDetaills.getLastName());
        updateEmployee.setEmailId(EmployeeDetaills.getEmailId());

        employeeRepository.save(updateEmployee);

        return ResponseEntity.ok(updateEmployee);
    }

    public ResponseEntity<HttpStatus> DeleteEmployee(Long id){
        Employee employee = employeeRepository.findById(id).
                orElseThrow(()-> new ResourceeNotFound("Employee not found" + id));
        employeeRepository.delete(employee);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
