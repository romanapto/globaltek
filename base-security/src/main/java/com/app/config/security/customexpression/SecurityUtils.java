package com.app.config.security.customexpression;

import org.springframework.security.core.context.SecurityContextHolder;

import com.app.persistence.model.es.user.User;

public interface SecurityUtils {

	

	static String getAuthenticatedEmail() {
		return (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}

	static User getAuthenticatedUser() {
		OAuth2AuthenticationUser authentication = (OAuth2AuthenticationUser) SecurityContextHolder.getContext()
				.getAuthentication();
		return (authentication != null && authentication.getUser() != null ? authentication.getUser() : new User());
	}

	


}
