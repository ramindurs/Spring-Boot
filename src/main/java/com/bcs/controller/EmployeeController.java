/**
 * Black Crow Systems Limited.
 * 2016.
 * This code is released under GNU General Public License Version 3.
 * See LICENSE for full details of the license conditions.
 */
package com.bcs.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bcs.db.domain.Employee;
import com.bcs.service.EmployeeService;

/**
 * @author ramindursingh
 *
 */
@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
    
    @Autowired
    EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Employee> getAllEmployees(){
        return employeeService.get();
    }
    
    @RequestMapping(value = "/{employeeId}", method = RequestMethod.GET)
    public Employee getEmployeeById(@PathVariable Integer employeeId) {
        return employeeService.get(employeeId);
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public Employee updateEmployee(@Valid @RequestBody EmployeeForm form) {
        Employee employee = employeeService.get(form.getEmployeeId());
        employee.setFirstname(form.getFirstname());
        employee.setLastname(form.getLastname());
        return employeeService.update(employee);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public Employee saveNewEmployee(@Valid @RequestBody EmployeeForm form) {
        Employee employee = new Employee();
        employee.setFirstname(form.getFirstname());
        employee.setLastname(form.getLastname());
        return employeeService.save(employee);
    }
}
