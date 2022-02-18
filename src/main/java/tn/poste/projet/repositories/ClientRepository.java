package tn.poste.projet.repositories;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.poste.projet.entities.ClientEntity;

public interface ClientRepository extends JpaRepository<ClientEntity, Integer>{
	List<ClientEntity> findByPrenom(String x);
	Optional<ClientEntity> findByEmail(String email);
	Optional<ClientEntity> findByEmailAndTelephone(String email,String telphone);
	
	//@Query("Select c.nom from ClientEntity c")
	@Query(nativeQuery = true, value = "Select nom from Client")
	List<String> clientNames();
	@Query("Select c from ClientEntity c where c.dateDeNaissance >= :b and c.dateDeNaissance <= :e")
	List<ClientEntity> dateBetween(@Param("b") LocalDate begin,@Param("e")  LocalDate end);

}
