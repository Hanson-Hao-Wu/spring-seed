package org.hao.service;

import java.util.List;

import org.hao.model.User;
import org.springframework.data.domain.Page;

public interface UserService {

	User addUser(User user);

    void deleteUser(String id);

    Page<User> getAllUsers(int page, int size);

    User updateUser(User user);

    User getUserById(String id);

    User getUserByUsername(String username);
    
    User getUserByEmail(String email);

    void deleteAll();

    List<User> findAllByOrderByLastUpdatedTimeDesc(int page, int size);
}
