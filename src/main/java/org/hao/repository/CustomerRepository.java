package org.hao.repository;

import java.util.List;

import org.hao.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
	
	
	List<Customer> findByLastName(String lastName);
	
	List<Customer> findById(long id);

}
