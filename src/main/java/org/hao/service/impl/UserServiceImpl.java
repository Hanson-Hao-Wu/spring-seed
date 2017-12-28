
package org.hao.service.impl;

import java.util.List;

import org.hao.enumerate.AccountRole;
import org.hao.model.User;
import org.hao.repository.UserRepository;
import org.hao.service.UserService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User addUser(User user) {
		
		//userRepository.findByEmail(user.getEmail())==null || userRepository.findByUsername(username)
		
		user.setCreationTime(new DateTime());
		user.setLastUpdatedTime(new DateTime());
		user.setActive(true);
		
		return userRepository.save(user);
		
	}

	@Override
	public void deleteUser(String id) {

		userRepository.delete(id);
	}

	@Override
	public Page<User> getAllUsers(int page, int size) {
		
		return userRepository.findAll(new PageRequest(page, size));
	}

	@Override
	public User updateUser(User user) {
		
		user.setLastUpdatedTime(new DateTime());
		
		return userRepository.save(user);
	}

	@Override
	public User getUserById(String id) {
		return userRepository.findOne(id);
	}

	@Override
	public User getUserByUsername(String username) {
		
		return userRepository.findByUsername(username);
	}

	@Override
	public User getUserByEmail(String email) {
		
		return userRepository.findByEmail(email);
	}

	@Override
	public void deleteAll() {
		
		userRepository.deleteAll();
	}

	@Override
	public List<User> findAllByOrderByLastUpdatedTimeDesc(int page, int size) {

		return userRepository.findAllByOrderByCreationTimeDesc(new PageRequest(page, size));
	}

}
