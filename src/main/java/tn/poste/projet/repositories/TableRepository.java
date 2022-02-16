package tn.poste.projet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.poste.projet.entities.TableEntity;

public interface TableRepository extends JpaRepository<TableEntity, Long>{

}
