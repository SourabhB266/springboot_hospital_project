package com.ty.springboot_hospital_project.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_hospital_project.dto.Encounter;
import com.ty.springboot_hospital_project.dto.Hospital;
import com.ty.springboot_hospital_project.dto.MedOrder;
import com.ty.springboot_hospital_project.repository.MedOrderRepository;

@Repository
public class MedOrderDao {
	@Autowired
	private MedOrderRepository repository;

	public MedOrder saveMedOrder(MedOrder medOrder) {
		return repository.save(medOrder);
	}

	public MedOrder updateMedOrder(int id, MedOrder medOrder) {
		if (repository.findById(id).isPresent()) {
			medOrder.setId(id);
			return repository.save(medOrder);
		} else {
			return null;
		}
	}

	public MedOrder deleteMedOrder(int id) {
		if (repository.findById(id).isPresent()) {
			MedOrder medOrder = repository.findById(id).get();
			repository.delete(medOrder);
			return medOrder;
		} else {
			return null;
		}
	}
	public MedOrder getMedOrderById(int id) {
		if (repository.findById(id).isPresent()) {
			MedOrder medOrder = repository.findById(id).get();
			return medOrder;
		} else {
			return null;
		}
	}
}
