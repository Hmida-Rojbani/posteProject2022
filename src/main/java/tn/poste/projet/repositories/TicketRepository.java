package tn.poste.projet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.poste.projet.entities.TicketEntity;

public interface TicketRepository extends JpaRepository<TicketEntity, Long>{

}
