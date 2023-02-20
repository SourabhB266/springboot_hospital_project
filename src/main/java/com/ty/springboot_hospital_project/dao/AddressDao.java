package com.ty.springboot_hospital_project.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_hospital_project.dto.Address;
import com.ty.springboot_hospital_project.repository.Addressrepository;

@Repository
public class AddressDao {

	@Autowired
	private Addressrepository repository;

	public Address saveAddress(Address address) {
		return repository.save(address);

	}

	public Address updateAddres(int id, Address address) {
		if (repository.findById(id).isPresent()) {
			address.setId(id);
			return repository.save(address);
		} else {
			return null;

		}

	}

	public Address deleteAddress(int id) {
		if (repository.findById(id).isPresent()) {
			Address address = repository.findById(id).get();
			repository.delete(address);
			return address;
		} else {
			return null;

		}

	}

	public Address getAddressById(int id) {
		if (repository.findById(id).isPresent()) {
			Address address = repository.findById(id).get();
			return address;
		} else {
			return null;

		}

	}
}
