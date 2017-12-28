
package org.hao.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hao.enumerate.AccountRole;
import org.hao.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="")
public class AppController{
	
	Logger logger = LoggerFactory.getLogger(AppController.class);

	
	@GetMapping(value= {"","/login"})
	public String getLoginPage() {
		
		logger.info("Go to login page");
		
		return "login";
	}
	
	
	@GetMapping("/error")
    public String getErrorPage() {

        logger.info("Go to the error page");
        return "error";
    }

	@GetMapping("/access-denied")
    public String getAccessDeniedPage() {

        logger.info("Go to the access-denied page");
        return "access-denied";
    }

	
    @PostMapping("/home")
    public String getHomepage(HttpServletRequest request){
    	
        logger.info("After Spring Security redirect to home page");
        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        GrantedAuthority authority = authentication.getAuthorities().iterator().next();
        AccountRole accountRole = AccountRole.valueOf(authority.getAuthority());

        HttpSession session = request.getSession(true);

        User user = (User) authentication.getPrincipal();
        session.setAttribute("user", user);

        return getReturnString(accountRole, session);
    }



    private String getReturnString(AccountRole role, HttpSession session) {

        switch (role) {
            case ROLE_ADMIN:
            	logger.info("redirect to the admin home page");
                session.setAttribute("role", "admin");
                return "redirect:/admin/";
            case ROLE_USER:
            	logger.info("redirect to the user home page");
                session.setAttribute("role", "user");
                return "redirect:/user/";
            default:
                return "redirect:/login";
        }
    }
}
