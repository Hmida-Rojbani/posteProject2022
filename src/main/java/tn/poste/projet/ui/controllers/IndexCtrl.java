package tn.poste.projet.ui.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexCtrl {
	@GetMapping({"/","/index"})
	public String getIndex(Model model) {
		model.addAttribute("msg", "Poste TN");
		return "index";
	}

}
