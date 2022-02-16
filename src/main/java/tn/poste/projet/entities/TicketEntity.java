package tn.poste.projet.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

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
	
	@ManyToOne
	private ClientEntity client;
	
	@ManyToOne
	@JoinColumn(name = "table_num")
	private TableEntity table;
	
	@ManyToMany
	@JoinTable(name = "compose", 
	joinColumns = @JoinColumn(name = "ticket"),
	inverseJoinColumns = @JoinColumn(name = "met"))
	private List<MetEntity> mets;

}
