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

import com.ty.springboot_hospital_project.dto.MedItems;
import com.ty.springboot_hospital_project.service.MedItemsService;
import com.ty.springboot_hospital_project.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class MedItemsController {
	@Autowired
	private MedItemsService service;
	
	@ApiOperation(value = "Save MedItems", notes = "Api is used to Save the MedItems")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully Created"),
			@ApiResponse(code = 404, message = "MedItems Not Saved Give Proper Input") })
	@PostMapping("/meditems")
	public ResponseEntity<ResponseStructure<MedItems>> saveMedItems(@RequestBody MedItems items,
			@RequestParam int moid) {
		return service.saveMedItems(items, moid);
	}
	
	@ApiOperation(value = "Update MedItems" ,notes = "Api is used to update MedItems with the id")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "Successfully Updated"),
			@ApiResponse(code = 404,message = "MedItems Not Updated Give Proper Input")})
	@PutMapping("/meditems")
	public ResponseEntity<ResponseStructure<MedItems>> updateMedItems(@RequestBody MedItems items,
			@RequestParam int miid, @RequestParam int moid) {
		return service.updateItems(items, miid, moid);
	}

	@ApiOperation(value = "Delete MedItems", notes = "Api is used to Delete the MedItems")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully Deleted"),
			@ApiResponse(code = 404, message = "MedItems Not deleted Give Proper Input") })
	@DeleteMapping("/meditems")
	public ResponseEntity<ResponseStructure<MedItems>> deleteMedItems(@RequestParam int miid) {
		return service.deleteMedItems(miid);
	}
	
	@ApiOperation(value = "Get MedItems", notes = "Api is used to Get the MedItems By Particular Id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully Found The MedItems"),
			@ApiResponse(code = 404, message = "MedItems Not Found Give Proper Input") })
	@GetMapping("/meditems")
	public ResponseEntity<ResponseStructure<MedItems>> getMedItemsById(@RequestParam int miid) {
		return service.getMedItemsById(miid);
	}

}
