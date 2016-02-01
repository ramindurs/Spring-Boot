/**
 * Black Crow Systems Limited.
 * 2016.
 * This code is released under GNU General Public License Version 3.
 * See LICENSE for full details of the license conditions.
 */
package com.bcs.db.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ramindursingh
 *
 */
@Entity
@Table(name = "Department")
public class Department implements Serializable {

    private static final long serialVersionUID = -1734546180153072994L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer departmentId;
    
    private String name;
    
    @OneToMany( mappedBy="department", fetch = FetchType.LAZY)
    Set<Employee> employees = new HashSet<>();

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
