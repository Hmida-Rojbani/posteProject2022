package tn.poste.projet.errors;

public class ClientNotFoundException extends RuntimeException{

	public ClientNotFoundException() {
		super("Client With this id is not found");
	}

	public ClientNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	
}
