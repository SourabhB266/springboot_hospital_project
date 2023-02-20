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

import com.ty.springboot_hospital_project.dto.Encounter;
import com.ty.springboot_hospital_project.service.EncounterService;
import com.ty.springboot_hospital_project.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class EncounterController {
	@Autowired
	private EncounterService service;
	

	@ApiOperation(value = "Save Encounter", notes = "Api is used to Save the Encounter")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully Created"),
			@ApiResponse(code = 404, message = "Encounter Not Saved Give Proper Input") })	
	@PostMapping("/encounter")
	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(@RequestBody Encounter encounter,
			@RequestParam int bid, @RequestParam int pid) {
		return service.saveEncounter(encounter, bid, pid);
	}
	
	@ApiOperation(value = "Update Encounter" ,notes = "Api is used to update Encounter with the id")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "Successfully Updated"),
			@ApiResponse(code = 404,message = "Encounter Not Updated Give Proper Input")})
	@PutMapping("/encounter")
	public ResponseEntity<ResponseStructure<Encounter>> updateEncounter(@RequestBody Encounter encounter,
			@RequestParam int bid, @RequestParam int eid) {
		return service.updateEncounter(encounter, bid, eid);
	}
	
	@ApiOperation(value = "Delete Encounter", notes = "Api is used to Delete the Encounter")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully Deleted"),
			@ApiResponse(code = 404, message = "Encounter Not deleted Give Proper Input") })
	@DeleteMapping("/encounter")
	public ResponseEntity<ResponseStructure<Encounter>> deleteEncounter(@RequestParam int id) {
		return service.deleteEncounter(id);
	}
	
	@ApiOperation(value = "Get Encounter", notes = "Api is used to Get the Encounter By id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully Found"),
			@ApiResponse(code = 404, message = "Encounter Not Found Give Proper Input") })
	@GetMapping("/encounter")
	public ResponseEntity<ResponseStructure<Encounter>> getEncounterById(@RequestParam int id) {
		return service.getEncounterById(id);
	}
}
