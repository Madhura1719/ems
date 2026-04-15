package com.demo.EMS.Service;

import com.demo.EMS.Entity.Employee;
import com.demo.EMS.Exception.ResourceNotFoundException;
import com.demo.EMS.Repo.EmployeeRepo;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public List<Employee> getAllEmployee(){
        return employeeRepo.findAll();
    }

    public Employee getEmployee(Long id){
        return employeeRepo.findById(id).orElse(null);
    }

    public Employee saveEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    public void deleteEmployee(Long id){
        employeeRepo.deleteById(id);
    }

    public Employee updateEmployee(Long id, @NonNull Employee employeeDetails){
        Employee employee = employeeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee Not Found"));

        employee.setName(employeeDetails.getName());
        employee.setDept(employee.getDept());

        return saveEmployee(employee);
    }

    }

