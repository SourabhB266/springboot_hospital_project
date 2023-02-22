package com.ty.springboot_hospital_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospital_project.dao.HospitalDao;
import com.ty.springboot_hospital_project.dto.Hospital;
import com.ty.springboot_hospital_project.exception.HospitalNotFoundException;
import com.ty.springboot_hospital_project.util.ResponseStructure;

@Service
public class HospitalService {

	@Autowired
	private HospitalDao dao;

	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(Hospital hospital) {
		ResponseStructure<Hospital> structure = new ResponseStructure<>();
		Hospital daoHospital = dao.saveHospital(hospital);
		structure.setMessage("Successfully Saved");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(daoHospital);
		return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(int id, Hospital hospital) {
		ResponseStructure<Hospital> structure = new ResponseStructure<>();
		Hospital daoHospital = dao.updateHospital(id, hospital);
		if (daoHospital != null) {
			structure.setMessage("Successfully Updated");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(daoHospital);
			return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.OK);
		} else {
			throw new HospitalNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Hospital>> deleteHospital(int id) {
		ResponseStructure<Hospital> structure = new ResponseStructure<>();
		Hospital daoHospital = dao.deleteHospital(id);
		if (daoHospital != null) {
			structure.setMessage("Successfully Deleted");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(daoHospital);
			return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.OK);
		} else {
			throw new HospitalNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Hospital>> getHospitalById(int id) {
		ResponseStructure<Hospital> structure = new ResponseStructure<>();
		Hospital daoHospital = dao.getHospitalById(id);
		if (daoHospital != null) {
			structure.setMessage("Found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(daoHospital);
			return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.FOUND);
		} else {
			throw new HospitalNotFoundException();
		}
	}
}
