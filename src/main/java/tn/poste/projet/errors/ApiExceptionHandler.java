package tn.poste.projet.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {
	
	@ExceptionHandler(ClientSaveException.class)
	public ResponseEntity<String> handleClientSaveException(ClientSaveException e){
		return new ResponseEntity<String>("Error in Saving client : " +e.getMessage(), HttpStatus.BAD_REQUEST);
	}

}
