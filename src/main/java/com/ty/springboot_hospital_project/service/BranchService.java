package com.ty.springboot_hospital_project.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospital_project.dao.AddressDao;
import com.ty.springboot_hospital_project.dao.BranchDao;
import com.ty.springboot_hospital_project.dao.HospitalDao;
import com.ty.springboot_hospital_project.dto.Branch;
import com.ty.springboot_hospital_project.exception.AddressNotFoundException;
import com.ty.springboot_hospital_project.exception.BranchNotFoundException;
import com.ty.springboot_hospital_project.exception.HospitalNotFoundException;
import com.ty.springboot_hospital_project.exception.IdNotFoundException;
import com.ty.springboot_hospital_project.util.ResponseStructure;

@Service
public class BranchService {

	@Autowired
	private BranchDao dao;

	@Autowired
	private HospitalDao hospitalDao;

	@Autowired
	private AddressDao addressDao;

	public ResponseEntity<ResponseStructure<Branch>> saveBranch(Branch branch, int hid, int aid) {
		if (hospitalDao.getHospitalById(hid) != null) {
			if (addressDao.getAddressById(aid) == null) {
				throw new AddressNotFoundException();
			} else {
				ResponseStructure<Branch> structure = new ResponseStructure<>();
				structure.setMessage("Branch Saved");
				structure.setStatus(HttpStatus.CREATED.value());
				structure.setData(dao.saveBranch(branch, hid, aid));
				return new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.CREATED);
			}
		} else {
			throw new HospitalNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> updateBranch(int hid, int id, Branch branch, int aid) {
		ResponseStructure<Branch> structure = new ResponseStructure<>();
		if (dao.updateBranch(hid, id, branch, aid) != null) {
			if (hospitalDao.getHospitalById(hid) == null) {
				throw new HospitalNotFoundException();
			} else if (addressDao.getAddressById(aid) == null) {
				throw new AddressNotFoundException();
			} else {
				structure.setMessage("Updated");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(dao.updateBranch(hid, id, branch, aid));
				return new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.OK);
			}
		} else {
			throw new BranchNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> deleteBranch(int id) {
		ResponseStructure<Branch> structure = new ResponseStructure<>();
		if (dao.deleteBranch(id) != null) {
			structure.setMessage("deleted");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.deleteBranch(id));
			return new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.OK);
		} else {
			throw new BranchNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<List<Branch>>> getAllBranchByHOspitalId(int id) {
		ResponseStructure<List<Branch>> structure = new ResponseStructure<>();
		if (dao.getBranchesByHospitalId(id) != null) {
			structure.setMessage("Fetched");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.getBranchesByHospitalId(id));
			return new ResponseEntity<ResponseStructure<List<Branch>>>(structure, HttpStatus.OK);
		} else {
			throw new NoSuchElementException();
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> getBranchById(int id) {
		ResponseStructure<Branch> structure = new ResponseStructure<>();
		if (dao.getBranchById(id) != null) {
			structure.setMessage("found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dao.getBranchById(id));
			return new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.FOUND);
		} else {
			throw new BranchNotFoundException();
		}
	}
}
