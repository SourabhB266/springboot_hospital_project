package com.ty.springboot_hospital_project.exception;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ty.springboot_hospital_project.util.ResponseStructure;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> idNotFoundExeption(IdNotFoundException ex) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage(ex.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("Id Not Found ");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<ResponseStructure<String>> noSuchElementExeption(NoSuchElementException ex) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("Id Not Found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<ObjectError> error = ex.getAllErrors();
		Map<String, String> map = new LinkedHashMap<String, String>();
		for (ObjectError er : error) {
			String feildName = ((FieldError) er).getField();
			String message = ((FieldError) er).getDefaultMessage();
			map.put(feildName, message);
		}
		return new ResponseEntity<Object>(map, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Object> constraintViolationException(ConstraintViolationException ex){
		Set<ConstraintViolation<?>> set = ex.getConstraintViolations();
		List<String> list = new ArrayList<>();
		for(ConstraintViolation<?> constraintViolationException:set) {
			String name =constraintViolationException.getMessage();
			list.add(name);
		}
		return new ResponseEntity<Object>(list, HttpStatus.BAD_REQUEST);	
	}
	
	@ExceptionHandler(AddressNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> addressNotFoundException(AddressNotFoundException ex) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("Address Not Found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(HospitalNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> hospitalNotFoundException(HospitalNotFoundException ex) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("Hospital Not Found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(BranchNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> branchNotFoundException(BranchNotFoundException ex) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("Branch Not Found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(PersonNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> personNotFoundException(PersonNotFoundException ex) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("Person Not Found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(EncounterNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> encounterNotFoundException(EncounterNotFoundException ex) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("Encounter Not Found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MedOrderNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> medOrderNotFoundException(MedOrderNotFoundException ex) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("MedOrder Not Found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MedItemsNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> medItemsNotFoundException(MedItemsNotFoundException ex) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("MedItem Not Found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
}
