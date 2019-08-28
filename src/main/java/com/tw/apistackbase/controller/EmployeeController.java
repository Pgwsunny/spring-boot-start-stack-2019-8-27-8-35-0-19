package com.tw.apistackbase.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tw.apistackbase.model.Employee;

import net.minidev.json.writer.CollectionMapper.ListClass;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	private static List<Employee> employees = new ArrayList<Employee>() {{
		add(new Employee(0,"Xiaoming",20,"Male"));
		add(new Employee(1,"Xiaohong",19,"Female"));
		add(new Employee(2,"Xiaozhi",15,"Male"));
		add(new Employee(3,"Xiaogang",16,"Male"));
		add(new Employee(4,"Xiaoxia",15,"Female"));
	}};
	
	@GetMapping
	public ResponseEntity<List<Employee>> employee(){    
		return ResponseEntity.ok(employees);
	}
	/**
	@GetMapping
	public ResponseEntity<List<Employee>> employee(@RequestParam(value = "name",required = false) String nameLike){
		List<Employee> employees = new ArrayList<Employee>();
		List<Employee> result = new ArrayList<Employee>();
		Employee employeeA = new Employee(0,"Xiaoming",20,"Male");
	     Employee employeeB = new Employee(1,"Xiaohong",19,"Female");
	     Employee employeeC = new Employee(2,"Xiaozhi",15,"Male");
	     Employee employeeD = new Employee(3,"Xiaogang",16,"Male");
	     Employee employeeE = new Employee(4,"Xiaoxia",15,"Female");
	     employees.add(employeeA);
	     employees.add(employeeB);
	     employees.add(employeeC);
	     employees.add(employeeD);
	     employees.add(employeeE);
	     for(Employee employee:employees) {
	    	 if(employee.getName().contains(nameLike)){
	    		 result.add(employee);
	    	 }
	     }
		return ResponseEntity.ok(result);
	}
	*/
	@GetMapping(path = "/{id}")	
	public ResponseEntity<Employee> employee(@PathVariable int id){
		return ResponseEntity.ok(employees.get(id));
	}

	@PostMapping(consumes = "application/json")
	public ResponseEntity<Employee> addemployee(@RequestBody Employee employee){

		employees.add(employee);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@PutMapping(consumes = "application/json")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
		return ResponseEntity.status(HttpStatus.OK).build();
	}
		
	@DeleteMapping("/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable int id){
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
