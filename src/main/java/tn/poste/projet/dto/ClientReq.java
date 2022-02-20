package tn.poste.projet.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class ClientReq {
	@NotBlank(message = "Nom is required")
	@Size(min = 3)
	private String nom;
	@NotBlank(message = "Nom is required")
	private String prenom;
	@Past
	private LocalDate dateDeNaissance;
	@Email
	private String email;
	@Pattern(regexp = "^[0-9]{8,}$")
	private String telephone;
	
	public void setDate(String date) {
		this.dateDeNaissance = LocalDate.parse(date);
	}
	
	public String getDate() {
		return null;
	}

}
