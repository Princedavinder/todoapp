//package com.example.demo;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.AutoConfigureOrder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.SessionAttributes;
//
//import com.example.demo.service.LoginService;
//
////@Controller
////@SessionAttributes("name")
//public class logincontrollerbefore {
//	@Autowired
//	LoginService loginService;
//	
//	@RequestMapping(value="/login",method=RequestMethod.GET)
//	public String showLogin(Model model) {
//		
//		return "login";
//	}
//	@RequestMapping(value="/login",method=RequestMethod.POST)
//	public String welcomeLogin(Model model,@RequestParam String name,String password) {
//		boolean isValid = loginService.validatedUser(name, password);
//		
//		if(isValid) {
//			model.addAttribute("name",name);
//			return "welcome";
//		}
//		else {
//			model.addAttribute("errorMsg","Wrong Credentials...Try Again");
//			return "login";
//		}
//	}
//	
//	
//}
