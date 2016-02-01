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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author ramindursingh
 *
 */
@Entity
@Table(name = "Employee")
public class Employee implements Serializable{

    private static final long serialVersionUID = 1618839208300782821L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer employeeId;
    
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name="DepartmentId")
    private Department department;
    
    private String firstname;
    private String lastname;
    
    public Integer getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }
}
