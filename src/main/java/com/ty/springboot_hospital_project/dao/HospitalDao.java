package com.ty.springboot_hospital_project.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_hospital_project.dto.Hospital;
import com.ty.springboot_hospital_project.repository.HospitalRepository;

@Repository
public class HospitalDao {

	@Autowired
	private HospitalRepository repository;

	public Hospital saveHospital(Hospital hospital) {
		return repository.save(hospital);
	}

	public Hospital updateHospital(int id, Hospital hospital) {
		if (repository.findById(id).isPresent()) {
			hospital.setId(id);
			return repository.save(hospital);
		} else {
			return null;
		}
	}

	public Hospital deleteHospital(int id) {
		if (repository.findById(id).isPresent()) {
			Hospital hospital = repository.findById(id).get();
			repository.delete(hospital);
			return hospital;
		} else {
			return null;
		}
	}

	public Hospital getHospitalById(int id) {
		if (repository.findById(id).isPresent()) {
			Hospital hospital = repository.findById(id).get();
			return hospital;
		} else {
			return null;
		}
	}

	public List<Hospital> getAllHospital() {
		return repository.findAll();
	}

	public Hospital getHospitalByEmail(String email) {
		return repository.findByEmail(email);
	}
}
