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

import com.ty.springboot_hospital_project.dto.Address;
import com.ty.springboot_hospital_project.service.AddressService;
import com.ty.springboot_hospital_project.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class AddressController {

	@Autowired
	private AddressService service;
	@ApiOperation(value = "Save Address", notes = "Api is used to Save the Address")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully Created"),
			@ApiResponse(code = 404, message = "Address Not Saved Give Proper Input") })
	
	@PostMapping("/address")
	public ResponseEntity<ResponseStructure<Address>> saveAddress(@RequestBody Address address) {
		return service.saveAddress(address);
	}
	@ApiOperation(value = "Update Address" ,notes = "Api is used to update Address with the id")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "Successfully Updated"),
			@ApiResponse(code = 404,message = "Address Not Updated Give Proper Input")})
	
	@PutMapping("/address")
	public ResponseEntity<ResponseStructure<Address>> updateAddress(@RequestBody Address address,
			@RequestParam int id) {
		return service.updateAddress(id, address);
	}
	@ApiOperation(value = "Delete Address", notes = "Api is used to Delete the Address")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully Deleted"),
			@ApiResponse(code = 404, message = "Address Not deleted Give Proper Input") })

	@DeleteMapping("/address")
	public ResponseEntity<ResponseStructure<Address>> deleteAddress(@RequestParam int id) {
		return service.deleteAddress(id);
	}
	
	@ApiOperation(value = "Get Address", notes = "Api is used to Get the Address By Particular Id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully Found The Address"),
			@ApiResponse(code = 404, message = "Address Not Found Give Proper Input") })

	@GetMapping("/address")
	public ResponseEntity<ResponseStructure<Address>> getAddressById(@RequestParam int id) {
		return service.getAddressById(id);
	}
}
