/**
 * Black Crow Systems Limited.
 * 2016.
 * This code is released under GNU General Public License Version 3.
 * See LICENSE for full details of the license conditions.
 */
package com.bcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bcs.db.domain.Employee;
import com.bcs.db.repository.EmployeeRepository;

/**
 * @author ramindursingh
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;
    
    /* (non-Javadoc)
     * @see com.bcs.service.EmployeeService#get()
     */
    @Override
    public List<Employee> get() {
        return repository.findAll();
    }

    /* (non-Javadoc)
     * @see com.bcs.service.EmployeeService#get(java.lang.Integer)
     */
    @Override
    public Employee get(Integer employeeId) {
        return repository.getOne(employeeId);
    }

    /* (non-Javadoc)
     * @see com.bcs.service.EmployeeService#update(com.bcs.db.domain.Employee)
     */
    @Override
    public Employee update(Employee employee) {
        return repository.save(employee);
    }

    /* (non-Javadoc)
     * @see com.bcs.service.EmployeeService#save(com.bcs.db.domain.Employee)
     */
    @Override
    @Transactional
    public Employee save(Employee employee) {
        return repository.save(employee);
    }

}
