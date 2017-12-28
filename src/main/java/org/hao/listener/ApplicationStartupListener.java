package org.hao.listener;

import org.hao.enumerate.AccountRole;
import org.hao.model.User;
import org.hao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ApplicationStartupListener implements ApplicationListener<ContextRefreshedEvent> {


	@Autowired
	UserService userService;

	@Value("${app.default.admin.username}")
	String defaultAdminUsername;

	@Value("${app.default.admin.password}")
	String defaultAdminPassword;

	@Value("${app.default.admin.email}")
	String defaultAdminEmail;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {

		User userByUsername = userService.getUserByUsername(defaultAdminUsername);

		if (userByUsername == null) {
			User user = new User();
			user.setUsername(defaultAdminUsername);
			user.setPassword(defaultAdminPassword);
			user.setEmail(defaultAdminEmail);
			user.setRole(AccountRole.ROLE_ADMIN);
			user.setActive(true);
			userService.addUser(user);
		}
	}


}
