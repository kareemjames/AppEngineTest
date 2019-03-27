package com.detroitlabs.appenginetest.Controller;

import com.detroitlabs.appenginetest.Model.Employee;
import com.detroitlabs.appenginetest.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/list")
    public String listAllEmployees(ModelMap modelMap) {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        modelMap.put("allEmployees", allEmployees);

        return "employee-list";
    }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
    public String addEmployee(ModelMap modelMap) {
        Employee employee = new Employee();
        modelMap.put("employee", employee);

        return "employee-form";
    }

    @RequestMapping(value = "/updateEmployee/{id}", method = RequestMethod.GET)
    public String updateEmployee(@PathVariable("id") long id, ModelMap modelMap) {
        Employee employee = employeeService.getEmployeeById(id);
        modelMap.put("employee", employee);

        return "employee-form";
    }

    @RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {

        employeeService.saveOrUpdate(employee);

        return "redirect:/employee/list";
    }

    @RequestMapping(value = "/deleteEmployee/{id}", method = RequestMethod.GET)
    public String deleteEmployee(@PathVariable("id") long id) {
        employeeService.deleteEmployee(id);

        return "redirect:/employee/list";
    }

}
