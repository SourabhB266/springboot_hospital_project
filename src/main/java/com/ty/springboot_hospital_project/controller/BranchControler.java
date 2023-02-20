package com.ty.springboot_hospital_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springboot_hospital_project.dto.Branch;
import com.ty.springboot_hospital_project.service.BranchService;
import com.ty.springboot_hospital_project.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class BranchControler {

	@Autowired
	private BranchService service;
	
	@ApiOperation(value = "Save Branch", notes = "Api is used to Save the Branch")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully Created"),
			@ApiResponse(code = 404, message = "Branch Not Saved Give Proper Input") })
	@PostMapping("/branch")
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@RequestBody Branch branch, @RequestParam int hid,@RequestParam int aid) {
		return service.saveBranch(branch, hid,aid);
	}
	@ApiOperation(value = "Update Branch" ,notes = "Api is used to update Branch with the id")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "Successfully Updated"),
			@ApiResponse(code = 404,message = "Branch Not Updated Give Proper Input")})
	@PutMapping("/branch")
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(@RequestBody Branch branch, @RequestParam int id,
			@RequestParam int hid,@RequestParam int aid) {
		return service.updateBranch(hid,id,branch, aid);
	}
	
	@ApiOperation(value = "Delete Branch", notes = "Api is used to Delete the Branch")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully Deleted"),
			@ApiResponse(code = 404, message = "Branch Not deleted Give Proper Input") })

	@DeleteMapping("/branch")
	public ResponseEntity<ResponseStructure<Branch>> deleteBranch(@RequestParam int id){
		return service.deleteBranch(id);
	}
	
	@ApiOperation(value = "Get Branch", notes = "Api is used to Get the Branch By Particular Id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully Found The Branch"),
			@ApiResponse(code = 404, message = "Branch Not Found Give Proper Input") })

	@GetMapping("/branch")
	public ResponseEntity<ResponseStructure<Branch>> getBranchById(@RequestParam int id){
		return service.getBranchById(id);
	}
	
	@GetMapping("/allbranch")
	public ResponseEntity<ResponseStructure<List<Branch>>> getBranchesByHospitalId(@RequestParam int id){
		return service.getAllBranchByHOspitalId(id);
	}
	
}
