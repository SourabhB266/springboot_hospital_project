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

import com.ty.springboot_hospital_project.dto.MedOrder;
import com.ty.springboot_hospital_project.service.MedOrderService;
import com.ty.springboot_hospital_project.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class MedOrderController {
	@Autowired
	private MedOrderService service;
	
	@ApiOperation(value = "Save MedOrder", notes = "Api is used to Save the MedOrder")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully Created"),
			@ApiResponse(code = 404, message = "MedOrder Not Saved Give Proper Input") })	
	@PostMapping("/medorder")
	public ResponseEntity<ResponseStructure<MedOrder>> saveMedOrder(@RequestBody MedOrder medOrder,
			@RequestParam int eid) {
		return service.saveMedOrder(medOrder, eid);
	}
	
	@ApiOperation(value = "Update MedOrder" ,notes = "Api is used to update MedOrder with the id")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "Successfully Updated"),
			@ApiResponse(code = 404,message = "MedOrder Not Updated Give Proper Input")})
	@PutMapping("/medorder")
	public ResponseEntity<ResponseStructure<MedOrder>> updateMedOrder(@RequestBody MedOrder medOrder,
			@RequestParam int mid, @RequestParam int eid) {
		return service.updateMedOrder(medOrder, mid, eid);
	}

	@ApiOperation(value = "Delete MedOrder", notes = "Api is used to Delete the MedOrder")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully Deleted"),
			@ApiResponse(code = 404, message = "MedOrder Not deleted Give Proper Input") })

	@DeleteMapping("/medorder")
	public ResponseEntity<ResponseStructure<MedOrder>> deleteMedOrder(@RequestParam int mid) {
		return service.deleteMedOrder(mid);
	}
	
	@ApiOperation(value = "Get MedOrder", notes = "Api is used to Get the MedOrder By Particular Id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully Found The MedOrder"),
			@ApiResponse(code = 404, message = "MedOrder Not Found Give Proper Input") })

	@GetMapping("/medorder")
	public ResponseEntity<ResponseStructure<MedOrder>> getMedOrderById(@RequestParam int mid) {
		return service.getMedOrderById(mid);
	}

}
