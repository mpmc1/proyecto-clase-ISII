package com.mipresupuesto.personalbudget.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class BudgetHomeController {
	 @GetMapping("/")
	    public String home(Model model, @AuthenticationPrincipal OidcUser principal) {
	        if (principal != null) {
	            model.addAttribute("profile", principal.getClaims());
	        }
	        return "index";
	    }

}
