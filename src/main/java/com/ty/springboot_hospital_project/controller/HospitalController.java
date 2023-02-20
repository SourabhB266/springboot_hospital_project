package com.ty.springboot_hospital_project.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springboot_hospital_project.dto.Hospital;
import com.ty.springboot_hospital_project.service.HospitalService;
import com.ty.springboot_hospital_project.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class HospitalController {

	@Autowired
	private HospitalService service;

	@ApiOperation(value = "Save Hospital", notes = "Api is used to Save the Hospital")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully Created"),
			@ApiResponse(code = 404, message = "Hospital Not Saved Give Proper Input") })
	@PostMapping("/hospital")
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(@Valid @RequestBody Hospital hospital) {
		return service.saveHospital(hospital);
	}
	
	@ApiOperation(value = "Update Hospital" ,notes = "Api is used to update Hospital with the id")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "Successfully Updated"),
			@ApiResponse(code = 404,message = "Hospital Not Updated Give Proper Input")})
	@PutMapping("/hospital")
	public ResponseEntity<ResponseStructure<Hospital>> updateHospital( @RequestParam int id,
			@RequestBody Hospital hospital) {
		return service.updateHospital(id, hospital);
	}
	
	@ApiOperation(value = "Delete Hospital", notes = "Api is used to Delete the Hospital")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully Deleted"),
			@ApiResponse(code = 404, message = "Hospital Not deleted Give Proper Input") })

	@DeleteMapping("/hospital")
	public ResponseEntity<ResponseStructure<Hospital>> deleteHospital(@RequestParam int id) {
		return service.deleteHospital(id);
	}
	
	@ApiOperation(value = "Get Hospital", notes = "Api is used to Get the Hospital By Particular Id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully Found The Hospital"),
			@ApiResponse(code = 404, message = "Hospital Not Found Give Proper Input") })

	@GetMapping("/hospital")
	public ResponseEntity<ResponseStructure<Hospital>> getHospitalById(@RequestParam int id) {
		return service.getHospitalById(id);
	}
}
