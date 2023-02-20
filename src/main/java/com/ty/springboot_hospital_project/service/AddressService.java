package com.ty.springboot_hospital_project.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospital_project.dao.AddressDao;
import com.ty.springboot_hospital_project.dto.Address;
import com.ty.springboot_hospital_project.exception.AddressNotFoundException;
import com.ty.springboot_hospital_project.exception.IdNotFoundException;
import com.ty.springboot_hospital_project.util.ResponseStructure;

@Service
public class AddressService {

	@Autowired
	private AddressDao dao;

	public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address) {
		ResponseStructure<Address> structure = new ResponseStructure<>();
		structure.setMessage("Saved");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveAddress(address));
		return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Address>> updateAddress(int id, Address address) {
		ResponseStructure<Address> structure = new ResponseStructure<>();
		if (dao.updateAddres(id, address) != null) {
			structure.setMessage("updated");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.updateAddres(id, address));
			return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.OK);
		} else {
			throw new AddressNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Address>> deleteAddress(int id) {
		ResponseStructure<Address> structure = new ResponseStructure<>();
		if (dao.deleteAddress(id) != null) {
			structure.setMessage("deleted");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.deleteAddress(id));
			return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.OK);
		} else {
			throw new AddressNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Address>> getAddressById(int id) {
		ResponseStructure<Address> structure = new ResponseStructure<>();
		if (dao.getAddressById(id) != null) {
			structure.setMessage("found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dao.getAddressById(id));
			return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.FOUND);
		} else {
			throw new AddressNotFoundException();
		}
	}
}