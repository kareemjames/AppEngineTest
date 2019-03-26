package com.detroitlabs.appenginetest.Service;

import com.detroitlabs.appenginetest.Model.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmployees();
    public Employee getEmployeeById(long id);
    public void saveOrUpdate(Employee employee);
    public void deleteEmployee(long id);

}
