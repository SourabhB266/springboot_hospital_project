package com.ty.springboot_hospital_project.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospital_project.dao.PersonDao;
import com.ty.springboot_hospital_project.dto.Person;
import com.ty.springboot_hospital_project.exception.IdNotFoundException;
import com.ty.springboot_hospital_project.exception.PersonNotFoundException;
import com.ty.springboot_hospital_project.util.ResponseStructure;

@Service
public class PersonService {
	@Autowired
	private PersonDao dao;

	public ResponseEntity<ResponseStructure<Person>> savePerson(Person person) {
		ResponseStructure<Person> structure = new ResponseStructure<>();
		Person daoPerson = dao.savePerson(person);
		structure.setMessage("Saved");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(daoPerson);
		return new ResponseEntity<ResponseStructure<Person>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Person>> updatePerson(int id, Person person) {
		ResponseStructure<Person> structure = new ResponseStructure<>();
		Person daoPerson = dao.updatePerson(id, person);
		if (daoPerson != null) {
			structure.setMessage("Updated Succussfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(daoPerson);
			return new ResponseEntity<ResponseStructure<Person>>(structure, HttpStatus.OK);

		} else {
			throw new PersonNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Person>> deletePerson(int id) {
		ResponseStructure<Person> structure = new ResponseStructure<>();
		Person daoPerson = dao.deletePerson(id);
		if (daoPerson != null) {
			structure.setMessage("deleted Successfuly");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(daoPerson);
			return new ResponseEntity<ResponseStructure<Person>>(structure, HttpStatus.OK);
		} else {
			throw new PersonNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Person>> getPersonById(int id) {
		ResponseStructure<Person> structure = new ResponseStructure<>();
		Person daoPerson = dao.getPersonById(id);
		if (daoPerson != null) {
			structure.setMessage("Found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(daoPerson);
			return new ResponseEntity<ResponseStructure<Person>>(structure, HttpStatus.FOUND);
		} else {
			throw new PersonNotFoundException();
		}
	}

}
