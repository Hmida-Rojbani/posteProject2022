package tn.poste.projet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.poste.projet.entities.MetEntity;

public interface MetRepository extends JpaRepository<MetEntity, Long>{

}
