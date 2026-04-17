package com.demo.EMS.Controller;

import com.demo.EMS.Entity.Employee;
import com.demo.EMS.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployee (){
        return ResponseEntity.ok(employeeService.getAllEmployee());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id){
        return ResponseEntity.ok(employeeService.getEmployee(id));
    }

    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return ResponseEntity.ok(employeeService.saveEmployee(employee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails){

        Employee employee = employeeService.updateEmployee(id, employeeDetails);

        return ResponseEntity.ok(employee);


    }



}
