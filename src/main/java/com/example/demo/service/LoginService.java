package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	public boolean validatedUser(String userid,String password) {
		return userid.equalsIgnoreCase("prince") && password.equalsIgnoreCase("davinder");
	}
}
