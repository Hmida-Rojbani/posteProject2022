package tn.poste.projet.repositories;


import org.springframework.data.jpa.repository.JpaRepository;


import tn.poste.projet.entities.ClientEntity;

public interface ClientRepository extends JpaRepository<ClientEntity, Integer>{

}
