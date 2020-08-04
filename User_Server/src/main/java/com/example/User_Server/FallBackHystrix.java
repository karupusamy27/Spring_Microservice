package com.example.User_Server;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class FallBackHystrix implements EmployeeDetails{
	Logger logger = LoggerFactory.getLogger(FallBackHystrix.class);

	@Override
	public Employee get(Integer id) {
		// TODO Auto-generated method stub
		return new Employee(1,"karupu",12345);
	}

	@Override
	public List<Employee> list() {
		// TODO Auto-generated method stub
		logger.info("Server Goes Down!!!");
		return Arrays.asList(new Employee(1,"karupu",12345),new Employee(2,"dark",54321));
	}

	@Override
	public void add(Employee employee) {
		// TODO Auto-generated method stub
		 logger.error("Server Goes Down!!!");
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		 logger.error("Server Goes Down!!!");
	}

}
