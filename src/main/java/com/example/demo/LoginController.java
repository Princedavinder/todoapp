package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.service.LoginService;

@Controller
@SessionAttributes("name")
public class LoginController {
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String showLogin(ModelMap model) {
		model.put("name", "prince");
		return "welcome";
	}
	
}
