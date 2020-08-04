package com.example.User_Server;


import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name="employee-server",url="localhost:8080",fallback=FallBackHystrix.class)
public interface EmployeeDetails {
	@GetMapping("/employees/{id}")
	public Employee get(@PathVariable Integer id);
	@GetMapping("/employees")
	public List<Employee> list();
	@PostMapping("/employees/add")
	public void add(@RequestBody Employee employee);
	@DeleteMapping("/employees/delete/{id}")
	public void delete(@PathVariable Integer id);
}
