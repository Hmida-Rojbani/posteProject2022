package tn.poste.projet.services;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImplV2 implements TestService{
	
	
	
	public String hello() {
		return "Hello World !!! ";
	}
	
	public String hello(String name) {
		return "hello "+name;
	}

}
