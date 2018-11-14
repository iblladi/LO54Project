package fr.utbm.lo54.coursesession.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

		/**																							**
				 * 	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*																	*
				 * 				CONTROLLEUR DE LA PARTIE SECURITÉ						*
				 * 						DANS LA COUCHE WEB								*
				 * 	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*								
		**																							**/


@Controller
public class SecurityController {
	
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/login?logout";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
	}
}
