package com.ty.springboot_hospital_project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospital_project.dao.BranchDao;
import com.ty.springboot_hospital_project.dao.EncounterDao;
import com.ty.springboot_hospital_project.dao.PersonDao;
import com.ty.springboot_hospital_project.dto.Branch;
import com.ty.springboot_hospital_project.dto.Encounter;
import com.ty.springboot_hospital_project.dto.Hospital;
import com.ty.springboot_hospital_project.dto.Person;
import com.ty.springboot_hospital_project.exception.BranchNotFoundException;
import com.ty.springboot_hospital_project.exception.EncounterNotFoundException;
import com.ty.springboot_hospital_project.exception.IdNotFoundException;
import com.ty.springboot_hospital_project.exception.PersonNotFoundException;
import com.ty.springboot_hospital_project.util.ResponseStructure;

@Service
public class EncounterService {

	@Autowired
	private EncounterDao encounterDao;
	@Autowired
	private PersonDao personDao;
	@Autowired
	private BranchDao branchDao;

	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(Encounter encounter, int bid, int pid) {
		if (encounterDao.saveEncounter(encounter) != null) {
			if (personDao.getPersonById(pid) == null) {
				throw new PersonNotFoundException();
			} else if (branchDao.getBranchById(bid)== null) {
				throw new BranchNotFoundException();
			} else {
				Person person = personDao.getPersonById(pid);
				Branch branch = branchDao.getBranchById(bid);

				encounter.setPerson(person);

				List<Branch> list = new ArrayList<>();
				list.add(branch);

				encounter.setBranchs(list);

				ResponseStructure<Encounter> structure = new ResponseStructure<>();
				structure.setMessage("Saved");
				structure.setStatus(HttpStatus.CREATED.value());
				structure.setData(encounterDao.saveEncounter(encounter));
				return new ResponseEntity<ResponseStructure<Encounter>>(structure, HttpStatus.CREATED);
			}
		} else {
			throw new EncounterNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Encounter>> updateEncounter(Encounter encounter, int bid, int eid) {

		if (encounterDao.updateEncounter(eid, encounter) != null) {
			if (branchDao.getBranchById(bid) == null) {
				throw new BranchNotFoundException();
			} else {
				Encounter encounter2 = encounterDao.getEncounterById(eid);
				Branch branch = branchDao.getBranchById(bid);
				List<Branch> list = encounter2.getBranchs();
				list.add(branch);
				encounter.setPerson(encounter2.getPerson());
				encounter.setBranchs(list);

				ResponseStructure<Encounter> structure = new ResponseStructure<>();
				structure.setMessage("Updated");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(encounterDao.updateEncounter(eid, encounter));
				return new ResponseEntity<ResponseStructure<Encounter>>(structure, HttpStatus.OK);
			}
		} else {
			throw new EncounterNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Encounter>> deleteEncounter(int id) {
		ResponseStructure<Encounter> structure = new ResponseStructure<>();
		if (encounterDao.deleteEncounter(id) != null) {
			structure.setMessage("Deleted");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(encounterDao.deleteEncounter(id));
			return new ResponseEntity<ResponseStructure<Encounter>>(structure, HttpStatus.OK);
		} else {
			throw new EncounterNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Encounter>> getEncounterById(int id) {
		ResponseStructure<Encounter> structure = new ResponseStructure<>();
		Encounter daoEncounter = encounterDao.getEncounterById(id);
		if (daoEncounter != null) {
			structure.setMessage("Found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(daoEncounter);
			return new ResponseEntity<ResponseStructure<Encounter>>(structure, HttpStatus.FOUND);
		} else {
			throw new EncounterNotFoundException();
		}
	}
}
