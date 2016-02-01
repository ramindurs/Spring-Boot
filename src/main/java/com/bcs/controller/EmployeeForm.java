/**
 * Black Crow Systems Limited.
 * 2016.
 * This code is released under GNU General Public License Version 3.
 * See LICENSE for full details of the license conditions.
 */
package com.bcs.controller;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author ramindursingh
 *
 */
public class EmployeeForm {

    private Integer employeeId;
    
    @NotEmpty
    @Length(min = 3, max = 50)
    private String firstname;
    
    @NotEmpty
    @Length(min = 3, max = 50)
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
}
