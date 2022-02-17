package tn.poste.projet.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import tn.poste.projet.dto.ClientReq;
import tn.poste.projet.dto.ClientRes;
import tn.poste.projet.entities.ClientEntity;
import tn.poste.projet.errors.ClientSaveException;
import tn.poste.projet.repositories.ClientRepository;

@Service
@AllArgsConstructor
public class ClientService {
	
	private ClientRepository clientRepository;
	
	public ClientRes addClient(ClientReq req) {
//		ClientEntity clientEntity = new ClientEntity();
//		clientEntity.setNom(req.getNom());
//		clientEntity.setPrenom(req.getPrenom());
		ModelMapper mapper= new ModelMapper();
		ClientEntity clientEntity = mapper.map(req, ClientEntity.class);
		try {
			clientRepository.save(clientEntity);	
		}catch(Exception e) {
			throw new ClientSaveException(e.getMessage());
		}
			
		return mapper.map(clientEntity, ClientRes.class);
	}

}
