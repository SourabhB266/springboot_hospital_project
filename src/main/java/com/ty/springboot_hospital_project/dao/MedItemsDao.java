package com.ty.springboot_hospital_project.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_hospital_project.dto.Hospital;
import com.ty.springboot_hospital_project.dto.MedItems;
import com.ty.springboot_hospital_project.repository.MedItemsRepository;

@Repository
public class MedItemsDao {
	@Autowired
	private MedItemsRepository repository;

	public MedItems saveMedItems(MedItems items) {
		return repository.save(items);
	}

	public MedItems updateMedItems(int id, MedItems items) {
		if (repository.findById(id).isPresent()) {
			items.setId(id);
			return repository.save(items);
		} else {
			return null;
		}
	}

	public MedItems deleteMedItem(int id) {
		if (repository.findById(id).isPresent()) {
			MedItems items = repository.findById(id).get();
			repository.delete(items);
			return items;
		} else {
			return null;
		}
	}

	public MedItems getMedItemsById(int id) {
		if (repository.findById(id).isPresent()) {
			MedItems medItems = repository.findById(id).get();
			return medItems;
		} else {
			return null;
		}
	}
}
