/**
 * Black Crow Systems Limited.
 * 2016.
 * This code is released under GNU General Public License Version 3.
 * See LICENSE for full details of the license conditions.
 */
package com.bcs.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.is;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.bcs.Application;
import com.bcs.db.domain.Employee;
import com.bcs.service.EmployeeService;
import com.bcs.util.TestUtil;

/**
 * @author ramindursingh
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( classes = Application.class)
public class EmployeeControllerTest {
    
    private static final String URL = "/employee";
    private MockMvc mockMvc;
    
    private Employee employee1, employee2;
    
    private final int LIST_SIZE = Arrays.asList(employee1, employee2).size();
    
    @Mock
    EmployeeService employeeService;

    @InjectMocks
    private EmployeeController employeeController;
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
        
        employee1 = new Employee();
        employee1.setEmployeeId(Integer.valueOf(1));
        employee2 = new Employee();
        employee2.setEmployeeId(Integer.valueOf(2));
        
        when(employeeService.get()).thenReturn(Arrays.asList(employee1, employee2));
        
        when(employeeService.get(Integer.valueOf(1))).thenReturn(employee1);
    }
    
    @Test
    public void testGettingAllEmployees() throws Exception {
        mockMvc.perform(get(URL).accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json;charset=UTF-8"))
            .andExpect(jsonPath("$", hasSize(LIST_SIZE)));
    }
    
    @Test
    public void testGettingEmployeeById() throws Exception{
        String url = String.format("%s/1", URL);
        mockMvc.perform(get(url).accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json;charset=UTF-8"))
            .andExpect(jsonPath("$.employeeId", is(1)));
    }
    
    @Test
    public void testUpdatingEmployee() throws Exception{
        EmployeeForm form = new EmployeeForm();
        form.setEmployeeId(employee1.getEmployeeId());
        form.setFirstname("Firstname");
        form.setLastname("Lastname");
        mockMvc.perform(put(URL).contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(form)))
                .andExpect(status().isOk());
    }
    
    @Test
    public void testSavingNewEmployee() throws Exception{
        EmployeeForm form = new EmployeeForm();
        form.setEmployeeId(employee1.getEmployeeId());
        form.setFirstname("Firstname");
        form.setLastname("Lastname");
        mockMvc.perform(post(URL).contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(form)))
                .andExpect(status().isOk());
    }
}
