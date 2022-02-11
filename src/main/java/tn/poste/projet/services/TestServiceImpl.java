package tn.poste.projet.services;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Primary
public class TestServiceImpl implements TestService{
	
	
	
	public String hello() {
		return "hello world!! ";
	}
	
	public String hello(String name) {
		return "hello "+name;
	}

}
