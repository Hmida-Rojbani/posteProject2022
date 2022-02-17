package tn.poste.projet.errors;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {
	
	@ExceptionHandler(ClientSaveException.class)
	public ResponseEntity<String> handleClientSaveException(ClientSaveException e){
		return new ResponseEntity<String>("Error in Saving client : " +e.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	  public ResponseEntity<String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
	    List<String> details = new ArrayList<>();
	    for(FieldError error : ex.getBindingResult().getFieldErrors()) {
	      details.add(error.getField() +" : " + error.getDefaultMessage());
	    }
	    String error = "Validation Failed : \n" + details.stream().collect(Collectors.joining(".\n"));
	    return new ResponseEntity<String>(error, HttpStatus.BAD_REQUEST);
	  }
}
