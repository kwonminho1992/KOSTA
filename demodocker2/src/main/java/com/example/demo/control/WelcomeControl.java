package com.example.demo.control;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeControl {

	@GetMapping("/")
	public String welcome() {
		return "welcome";
	}
}
