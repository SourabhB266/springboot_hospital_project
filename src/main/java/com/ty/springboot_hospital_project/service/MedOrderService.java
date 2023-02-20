package com.ty.springboot_hospital_project.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospital_project.dao.EncounterDao;
import com.ty.springboot_hospital_project.dao.MedOrderDao;
import com.ty.springboot_hospital_project.dto.Encounter;
import com.ty.springboot_hospital_project.dto.MedOrder;
import com.ty.springboot_hospital_project.exception.EncounterNotFoundException;
import com.ty.springboot_hospital_project.exception.IdNotFoundException;
import com.ty.springboot_hospital_project.exception.MedOrderNotFoundException;
import com.ty.springboot_hospital_project.util.ResponseStructure;

@Service
public class MedOrderService {
	@Autowired
	private MedOrderDao medOrderDao;
	@Autowired
	private EncounterDao encounterDao;

	public ResponseEntity<ResponseStructure<MedOrder>> saveMedOrder(MedOrder medOrder, int eid) {
		Encounter encounter = encounterDao.getEncounterById(eid);
		ResponseStructure<MedOrder> structure = new ResponseStructure<>();
		if (encounter != null) {
			medOrder.setEncounter(encounter);
			structure.setMessage("Successfully Saved");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(medOrderDao.saveMedOrder(medOrder));
			return new ResponseEntity<ResponseStructure<MedOrder>>(structure, HttpStatus.CREATED);
		} else {
			throw new EncounterNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<MedOrder>> updateMedOrder(MedOrder medOrder, int mid, int eid) {
		Encounter encounter = encounterDao.getEncounterById(eid);
		MedOrder daoMedOrder = medOrderDao.getMedOrderById(mid);
		ResponseStructure<MedOrder> structure = new ResponseStructure<>();
		if (daoMedOrder != null) {
			if (encounter == null) {
				throw new EncounterNotFoundException();
			} else {
				medOrder.setEncounter(encounter);
				structure.setMessage("Successfully Updated");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(medOrderDao.updateMedOrder(mid, medOrder));
				return new ResponseEntity<ResponseStructure<MedOrder>>(structure, HttpStatus.OK);
			}
		} else {
			throw new MedOrderNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<MedOrder>> deleteMedOrder(int mid) {
		ResponseStructure<MedOrder> structure = new ResponseStructure<>();
		if (medOrderDao.getMedOrderById(mid) != null) {
			structure.setMessage("Successfully Deleted");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(medOrderDao.deleteMedOrder(mid));
			return new ResponseEntity<ResponseStructure<MedOrder>>(structure, HttpStatus.OK);
		} else {
			throw new MedOrderNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<MedOrder>> getMedOrderById(int id) {
		ResponseStructure<MedOrder> structure = new ResponseStructure<>();
		if (medOrderDao.getMedOrderById(id) != null) {
			structure.setMessage("Found");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(medOrderDao.getMedOrderById(id));
			return new ResponseEntity<ResponseStructure<MedOrder>>(structure, HttpStatus.OK);
		} else {
			throw new MedOrderNotFoundException();
		}
	}

}
