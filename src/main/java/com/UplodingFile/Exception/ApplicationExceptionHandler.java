package com.UplodingFile.Exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler{

	/**
	 * 
	 */
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex,WebRequest req){
		
		return new ResponseEntity<Object>(new ErrorMessage(ex.getMessage(),HttpStatus.NOT_FOUND,LocalDateTime.now()),HttpStatus.NOT_FOUND);
		
		
	}
	
	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<Object> handleEmptyInputException(EmptyInputException emptyInput,WebRequest req){
		
		//return new ResponseEntity<String>("Input field is empty, please provide the body",HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Object>(new ErrorMessage(emptyInput.getMessage(),HttpStatus.BAD_REQUEST,LocalDateTime.now()),HttpStatus.BAD_REQUEST);
		
		
	}
	
//	private static final long serialVersionUID = 1527768013800578160L;
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public Map<String,String> handleInvalidArgument(MethodArgumentNotValidException ex){
//		
//		Map<String,String>errorMap=new HashMap();
//		ex.getBindingResult().getFieldErrors().forEach(error->{
//			errorMap.put(error.getField(), error.getDefaultMessage());
//		});
//		return errorMap;
//	}
//	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//	@ExceptionHandler(UserNotFoundException.class)
//	public Map<String,String>handleBusinessException(UserNotFoundException ex){
//		
//		Map<String,String>errorMap=new HashMap<>();
//		errorMap.put("error Message:", ex.getMessage());
//		return errorMap;
//	}
}
