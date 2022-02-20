package tn.poste.projet.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import tn.poste.projet.dto.ClientReq;
import tn.poste.projet.dto.ClientRes;
import tn.poste.projet.entities.ClientEntity;
import tn.poste.projet.errors.ClientNotFoundException;
import tn.poste.projet.errors.ClientSaveException;
import tn.poste.projet.repositories.ClientRepository;

@Service
@AllArgsConstructor
public class ClientService {
	
	private ClientRepository clientRepository;
	private ModelMapper mapper;
	
	public ClientRes addClient(ClientReq req) {
//		ClientEntity clientEntity = new ClientEntity();
//		clientEntity.setNom(req.getNom());
//		clientEntity.setPrenom(req.getPrenom());
		ClientEntity clientEntity = mapper.map(req, ClientEntity.class);
		try {
			clientRepository.save(clientEntity);	
		}catch(Exception e) {
			throw new ClientSaveException(e.getMessage());
		}
			
		return mapper.map(clientEntity, ClientRes.class);
	}

	public List<ClientRes> getAllClient() {
		
		return clientRepository.findAll()
				.stream()
				.map(ce-> mapper.map(ce,ClientRes.class))
				.collect(Collectors.toList());
	}

	public ClientRes getClientById(int id) {
		Optional<ClientEntity> opt = clientRepository.findById(id);
		
		ClientEntity clientEntity = opt
				.orElseThrow(ClientNotFoundException::new);
		return mapper.map(clientEntity, ClientRes.class);
	}
	
	public ClientRes getClientByEmail(String email) {
		return mapper.map(clientRepository.findByEmail(email)
				.orElseThrow(ClientNotFoundException::new), ClientRes.class);
	}
	
	public List<ClientRes> getClientByDateBetween(LocalDate begin, LocalDate end) {
		return  clientRepository.dateBetween(begin, end).stream()
				.map(ce-> mapper.map(ce,ClientRes.class))
				.collect(Collectors.toList());
		
	}
}
