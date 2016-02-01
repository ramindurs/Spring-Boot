/**
 * Black Crow Systems Limited.
 * 2016.
 * This code is released under GNU General Public License Version 3.
 * See LICENSE for full details of the license conditions.
 */
package com.bcs.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bcs.db.domain.Employee;

/**
 * @author ramindursingh
 *
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
