package tn.poste.projet.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

}
