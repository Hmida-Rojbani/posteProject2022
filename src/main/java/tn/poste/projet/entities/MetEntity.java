package tn.poste.projet.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class MetEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1381103489583974944L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nom;
	
	private double prix;
	
	@ManyToMany(mappedBy = "mets")
	private List<TicketEntity> tickets;
	

}
