package tn.poste.projet.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	//@RequestMapping(path = "/hello",method = RequestMethod.GET)
	@GetMapping("/hello")
	public String helloWorld() {
		return "Hello World!";
	}
	
	//@RequestMapping(path = "/hello",method = RequestMethod.POST)
	@PostMapping("/hello")
	public String helloWorldPost() {
		return "Hello World Post!";
	}

}
