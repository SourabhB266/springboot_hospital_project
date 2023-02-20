package com.ty.springboot_hospital_project.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospital_project.dao.MedItemsDao;
import com.ty.springboot_hospital_project.dao.MedOrderDao;
import com.ty.springboot_hospital_project.dto.MedItems;
import com.ty.springboot_hospital_project.dto.MedOrder;
import com.ty.springboot_hospital_project.exception.IdNotFoundException;
import com.ty.springboot_hospital_project.exception.MedItemsNotFoundException;
import com.ty.springboot_hospital_project.exception.MedOrderNotFoundException;
import com.ty.springboot_hospital_project.util.ResponseStructure;

@Service
public class MedItemsService {
	@Autowired
	private MedItemsDao medItemsDao;
	@Autowired
	private MedOrderDao medOrderDao;

	public ResponseEntity<ResponseStructure<MedItems>> saveMedItems(MedItems items, int moid) {
		ResponseStructure<MedItems> structure = new ResponseStructure<>();
		MedOrder medOrder = medOrderDao.getMedOrderById(moid);
		if (medOrder != null) {
			items.setMedOrder(medOrder);
			structure.setMessage("Saved");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(medItemsDao.saveMedItems(items));
			return new ResponseEntity<ResponseStructure<MedItems>>(structure, HttpStatus.CREATED);
		} else {
			throw new MedItemsNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<MedItems>> updateItems(MedItems items, int miid, int moid) {
		ResponseStructure<MedItems> structure = new ResponseStructure<>();
		MedItems daoMedItems = medItemsDao.getMedItemsById(miid);
		MedOrder medOrder = medOrderDao.getMedOrderById(moid);
		if (daoMedItems != null) {
			if (medOrder == null) {
				throw new MedOrderNotFoundException();
			} else {
				items.setMedOrder(medOrder);
				structure.setMessage("Updated");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(medItemsDao.updateMedItems(miid, items));
				return new ResponseEntity<ResponseStructure<MedItems>>(structure, HttpStatus.OK);
			}
		} else {
			throw new MedItemsNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<MedItems>> deleteMedItems(int id) {
		ResponseStructure<MedItems> structure = new ResponseStructure<>();
		MedItems items = medItemsDao.getMedItemsById(id);
		if (items != null) {
			structure.setMessage("Deleted");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(medItemsDao.deleteMedItem(id));
			return new ResponseEntity<ResponseStructure<MedItems>>(structure, HttpStatus.OK);
		} else {
			throw new MedItemsNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<MedItems>> getMedItemsById(int id) {
		ResponseStructure<MedItems> structure = new ResponseStructure<>();
		MedItems items = medItemsDao.getMedItemsById(id);
		if (items != null) {
			structure.setMessage("Found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(medItemsDao.getMedItemsById(id));
			return new ResponseEntity<ResponseStructure<MedItems>>(structure, HttpStatus.FOUND);
		} else {
			throw new MedItemsNotFoundException();
		}
	}
}
