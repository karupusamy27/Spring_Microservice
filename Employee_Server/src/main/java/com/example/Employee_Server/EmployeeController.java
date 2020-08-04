package com.example.Employee_Server;

import java.util.List; 

import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class EmployeeController {
	@Autowired
    private EmployeeService service;
	Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@GetMapping("/")
	public String Controller() {
		logger.info("Welcome HomePage");
	    return "Welcome";
	}
	@GetMapping("/employees")
	public List<Employee> list() {
		logger.info("Welcome to List Of Employee Page");
	    return service.listAll();
	}
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> get(@PathVariable Integer id) {
	    try {
	        Employee employee = service.get(id);
	        logger.info("Welcome To "+ employee.getName()+" Employee Page");
	        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
	    }      
	}
	@PostMapping("/employees/add")
	public void add(@RequestBody Employee employee) {
		logger.info("SuccesFully Added To List Page");
	    service.save(employee);
	}
	@DeleteMapping("/employees/delete/{id}")
	public void delete(@PathVariable Integer id) {
		logger.info("SuccesFully Deleted To List Page");
	    service.delete(id);
	}
}
