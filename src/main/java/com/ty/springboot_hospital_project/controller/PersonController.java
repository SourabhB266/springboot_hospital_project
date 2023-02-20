package com.ty.springboot_hospital_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springboot_hospital_project.dto.Person;
import com.ty.springboot_hospital_project.service.PersonService;
import com.ty.springboot_hospital_project.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class PersonController {
	@Autowired
	private PersonService service;

	@ApiOperation(value = "Save Person", notes = "Api is used to Save the Person")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully Created"),
			@ApiResponse(code = 404, message = "Person Not Saved Give Proper Input") })
	@PostMapping("/person")
	public ResponseEntity<ResponseStructure<Person>> savePerson(@RequestBody Person person) {
		return service.savePerson(person);
	}

	@ApiOperation(value = "Update Person", notes = "Api is used to update Person with the id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully Updated"),
			@ApiResponse(code = 404, message = "Person Not Updated Give Proper Input") })
	@PutMapping("/person")
	public ResponseEntity<ResponseStructure<Person>> updatePerson(@RequestParam int id, @RequestBody Person person) {
		return service.updatePerson(id, person);
	}

	@ApiOperation(value = "Delete Person", notes = "Api is used to Delete the Person")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully Deleted"),
			@ApiResponse(code = 404, message = "Person Not deleted Give Proper Input") })

	@DeleteMapping("/person")
	public ResponseEntity<ResponseStructure<Person>> deletePerson(@RequestParam int id) {
		return service.deletePerson(id);
	}

	@ApiOperation(value = "Get Person", notes = "Api is used to Get the Person By Particular Id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully Found The Person"),
			@ApiResponse(code = 404, message = "Person Not Found Give Proper Input") })

	@GetMapping("/person")
	public ResponseEntity<ResponseStructure<Person>> getPersonById(@RequestParam int id) {
		return service.getPersonById(id);
	}
}
