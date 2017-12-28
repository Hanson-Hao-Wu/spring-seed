package org.hao.controller;

import java.util.Map;

import org.hao.model.Customer;
import org.hao.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value="customer")
public class CustomerController {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@GetMapping(value="/")
	public @ResponseBody Iterable<Customer> getAllCustomers(Map<String, Object> map) {
		
		// This returns a JSON or XML with the users
		return customerRepository.findAll();
		
		
	}
	
	@GetMapping(value="/add")
	public @ResponseBody Customer addCustomer() {
		
		// This returns a JSON or XML with the users
		Customer c = new Customer();
		
		c.setFirstName("Hao");
		c.setLastName("Wu");
		
		customerRepository.save(c);
		
		return c;
	}
	
	@GetMapping(value="/lastname/{lastName}")
	public @ResponseBody Iterable<Customer> findByLastName(@PathVariable String lastName) {
		
		
		return customerRepository.findByLastName(lastName);
	}


}
