package tn.poste.projet.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class TableEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long numero;
	
	private int nbCouvert;
	
	private TableType type;
	
	private double supplement;
	
	@OneToMany(mappedBy = "table")
	private List<TicketEntity> tickets;

}
