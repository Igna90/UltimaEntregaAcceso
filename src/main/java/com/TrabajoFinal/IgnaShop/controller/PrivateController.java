package com.TrabajoFinal.IgnaShop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.TrabajoFinal.IgnaShop.Constant.ViewConstant;
import com.TrabajoFinal.IgnaShop.entity.UsersEntity;
import com.TrabajoFinal.IgnaShop.service.UserService;

@Controller
@RequestMapping("/")
public class PrivateController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String index(Authentication auth, HttpSession session, Model model) {

		String email = auth.getName();

		if (session.getAttribute("user") == null ) {
			UsersEntity user = userService.findUserByEmail(email);
			user.setPassword(null);
			session.setAttribute("user", user);

		}

		return ViewConstant.INDEX;
	}
	
	



}