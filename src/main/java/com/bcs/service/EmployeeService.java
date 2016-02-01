/**
 * Black Crow Systems Limited.
 * 2016.
 * This code is released under GNU General Public License Version 3.
 * See LICENSE for full details of the license conditions.
 */
package com.bcs.service;

import java.util.List;

import com.bcs.db.domain.Employee;

/**
 * @author ramindursingh
 *
 */
public interface EmployeeService {

    /**
     * Gets a list of employees, all of them.
     * 
     * @return list of employees
     */
    List<Employee> get();

    /**
     * Gets an employee by id.
     * 
     * @param employeeId
     *            the employee id
     * @return employee matching id
     */
    Employee get(Integer employeeId);

    /**
     * Updates an existing employee.
     * 
     * @param employee
     *            the employee to update
     * @return updated employee
     */
    Employee update(Employee employee);

    /**
     * Saves a new employee
     * 
     * @param employee
     *            the new employee
     * @return the saved employee
     */
    Employee save(Employee employee);
}
