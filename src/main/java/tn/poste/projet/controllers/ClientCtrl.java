package tn.poste.projet.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import tn.poste.projet.dto.ClientReq;
import tn.poste.projet.dto.ClientRes;
import tn.poste.projet.errors.ClientSaveException;
import tn.poste.projet.services.ClientService;

@RestController
@AllArgsConstructor
public class ClientCtrl {
	
	private ClientService clientService;

	@PostMapping("/api/clients/add")
	public ClientRes addClient(@RequestBody ClientReq req) {
		return clientService.addClient(req);
	}
	
	@GetMapping("/api/clients")
	public List<ClientRes> getAllClient(){
		return clientService.getAllClient();
	}
	
	@GetMapping("/api/clients/date/{b}/{e}")
	public List<ClientRes> getAllClientByDateBetween(@PathVariable String b,@PathVariable String e){
		LocalDate begin = LocalDate.parse(b);
		LocalDate end = LocalDate.parse(e);
		return clientService.getClientByDateBetween(begin, end);
	}
	
	
}

