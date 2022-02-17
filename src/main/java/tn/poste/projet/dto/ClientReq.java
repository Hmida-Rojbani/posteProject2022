package tn.poste.projet.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ClientReq {
	
	private String nom;
	private String prenom;
	private LocalDate dateDeNaissance;
	private String email;
	private String telephone;

}
