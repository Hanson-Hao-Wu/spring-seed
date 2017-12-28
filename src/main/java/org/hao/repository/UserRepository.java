package org.hao.repository;

import java.util.List;

import org.hao.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, String>{
	
	Page<User> findAll(Pageable pageable);
	
	List<User> findByActive(boolean active, Pageable pageable);

	List<User> findAllByOrderByCreationTimeDesc(Pageable pageable);

	List<User> findAllByOrderByLastUpdatedTimeDesc(Pageable pageable);
	
	User findByUsername(String username);	
	
	User findByEmail(String email);

}
