package com.example.demo.docker.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.docker.dto.Test;
import com.example.demo.docker.repository.TestRepository;



@RestController
public class WelcomeControl {
	@Autowired
	private TestRepository repository;

	@GetMapping("/")
	public String welcome() {
		return "welcome";
	}
	@GetMapping("/list")
	public List<Test> list() {
		return repository.findAll();
	}
	@GetMapping("/add")
	public void add() {
		for (int i = 0; i < 10; i++) {
			Test test = new Test();
			test.setA("a"+i);
			test.setB(new Integer(i));
			repository.save(test);
		}
	}
}
