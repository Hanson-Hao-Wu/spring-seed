package org.hao.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hao.enumerate.AccountRole;
import org.hao.model.User;
import org.hao.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping(value="/admin")
public class AdminController{
	
	Logger logger = LoggerFactory.getLogger(AdminController.class);
	

	@Autowired
	UserService userService;
	
	@GetMapping(value="")
	public String getHome(Map<String, Object> map) {
		
		logger.info("go to admin home page");
		
		Iterator<User> it = userService.getAllUsers(0, 10).iterator();
		
		List<User> users = new ArrayList<>();
		
		while (it.hasNext()) {
			users.add(it.next());
		}
			
		map.put("users", (List<User>)users);
		
		return "/admin/adminHome";
	}
	
	@PostMapping(value="/addUser")
	public String addUser(Map<String, Object> map, User user) {
		
		

		logger.info(String.format("add user %s", user.getUsername()));
		
		user.setRole(AccountRole.ROLE_USER);
		
		userService.addUser(user);

		return "redirect:/admin";
	}
}
