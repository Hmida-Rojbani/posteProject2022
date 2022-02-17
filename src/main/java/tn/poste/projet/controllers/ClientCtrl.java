package tn.poste.projet.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
	
	@ExceptionHandler(ClientSaveException.class)
	public ResponseEntity<String> handleClientSaveException(ClientSaveException e){
		return new ResponseEntity<String>("Error in Saving client : " +e.getMessage(), HttpStatus.BAD_REQUEST);
	}
}

