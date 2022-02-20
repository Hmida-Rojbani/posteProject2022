package tn.poste.projet.ui.controllers;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.AllArgsConstructor;
import tn.poste.projet.dto.ClientReq;
import tn.poste.projet.services.ClientService;

@Controller
@AllArgsConstructor
public class ClientController {
	private ClientService clientService;
	
	@GetMapping("/show/clients")
	public String getClients(Model model) {
		model.addAttribute("clients", clientService.getAllClient());
		return "clients/show";
	}

	@GetMapping("/add/client")
	public String addClients(Model model) {
		model.addAttribute("client", new ClientReq());
		return "clients/add";
	}
	
	@PostMapping("/clients/add")
	public String addClientsPost( @ModelAttribute("client") @Valid ClientReq req, BindingResult result) { 
		if(result.hasErrors()) {
			return "clients/add";
		}
		clientService.addClient(req);
		return "redirect:/show/clients";
	}
}