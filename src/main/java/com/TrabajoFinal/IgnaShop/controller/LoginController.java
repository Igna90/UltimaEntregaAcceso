package com.TrabajoFinal.IgnaShop.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.TrabajoFinal.IgnaShop.Constant.ViewConstant;
import com.TrabajoFinal.IgnaShop.model.UsersModel;
import com.TrabajoFinal.IgnaShop.service.impl.UserServiceImplementation;

@Controller
@RequestMapping("/auth")
public class LoginController {

	@Autowired
	@Qualifier("userServiceImpl")
	private UserServiceImplementation userService;
	
	@GetMapping("/")
	public String redirectToLogin() {
		return "redirect:/auth/login";
	}
	
	@GetMapping("/login")
	public String login(Model model, @RequestParam(name="error",required=false)String error,
			@RequestParam(name="logout",required=false)String logout) {
		model.addAttribute("user",new UsersModel());
		model.addAttribute("error",error);
		model.addAttribute("logout",logout);
		return ViewConstant.LOGIN;
	}
	
	
}
