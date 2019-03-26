package com.detroitlabs.appenginetest.Repository;

import com.detroitlabs.appenginetest.Model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
