package tn.poste.projet.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class TicketEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long numero;
	
	private int nbCouvert;
	
	private LocalDateTime date;
	
	private double addition;

}
