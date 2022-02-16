package tn.poste.projet.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;
import tn.poste.projet.services.TestService;

@RestController
@Log4j2
public class TestController {
	
	
	private TestService testService;
	
	private TestService testService2;
	
	
	
	public TestController(TestService testService,@Qualifier("testServiceImplV2") TestService testService2) {
		super();
		this.testService = testService;
		this.testService2 = testService2;
		log.info("Object Test Controller created");
	}

	//@RequestMapping(path = "/hello",method = RequestMethod.GET)
	@GetMapping({"/","/hello"})
	public String helloWorld() {
		return testService.hello();
	}
	
	@GetMapping("/hello2")
	public String helloWorld2() {
		return testService2.hello();
	}
	
	//@RequestMapping(path = "/hello",method = RequestMethod.GET)
		@GetMapping({"/hello/{name}"})
		public String helloWorld2(@PathVariable("name") String nom) {
			return testService2.hello(nom);
		}
	
	//@RequestMapping(path = "/hello",method = RequestMethod.POST)
	@PostMapping("/hello")
	public String helloWorldPost() {
		return "Hello World Post!";
	}
	
	@GetMapping("/data")
	public ResponseEntity<Data> getData() {
		Data d = new Data();
		d.age=33; d.name= "Ali";
		return new ResponseEntity<Data>(d, HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/data")
	public ResponseEntity<Data> postData(@RequestBody Data d) {
		
		return new ResponseEntity<Data>(d, HttpStatus.ACCEPTED);
	}

}
