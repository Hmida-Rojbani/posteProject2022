package tn.poste.projet.entities;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.log4j.Log4j2;

@Entity
@Table(name = "client")
@EqualsAndHashCode(of = "email")
@Data
public class ClientEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 50)
	private String nom;
	private String prenom;
	private LocalDate dateDeNaissance;
	@Column(length = 100, nullable = false, unique = true)
	private String email;
	private String telephone;	
	
	@OneToMany(mappedBy = "client")
	private List<TicketEntity> tickets;
	
	public String getNomComplet() {
		return this.prenom + " " + this.nom;
	}
	
	public int getAge() {
		return (int) ChronoUnit.YEARS
		.between(dateDeNaissance, LocalDate.now());
	}
	
}
