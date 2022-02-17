package tn.poste.projet.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	
}

