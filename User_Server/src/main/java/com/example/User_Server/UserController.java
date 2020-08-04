package com.example.User_Server;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
	@Autowired
	private EmployeeDetails employeeDetails;
	Logger logger = LoggerFactory.getLogger(FallBackHystrix.class);
	@GetMapping("/user")
	public List<Employee> list() {
		List<Employee> response=employeeDetails.list();
		logger.info("List of Employee Users Fetched!!!");
		return response;
	}
	@GetMapping("/user/{id}")
	public Employee get(@PathVariable Integer id) {
		Employee response=employeeDetails.get(id);
		logger.info("Employee "+response.getName()+"Fetched !!!");
		return response;
	}

	@PostMapping("/user/add")
	public void add(@RequestBody Employee employee) {
		logger.info("Successfully Added To List!!!");
		employeeDetails.add(employee);
	}
	@DeleteMapping("/user/delete/{id}")
	public void delete(@PathVariable Integer id) {
		logger.info("Successfully Deleted From List!!!");
		employeeDetails.delete(id);
	}

}
