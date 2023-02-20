package com.ty.springboot_hospital_project.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_hospital_project.dto.Address;
import com.ty.springboot_hospital_project.dto.Encounter;
import com.ty.springboot_hospital_project.repository.EncounterRepository;

@Repository
public class EncounterDao {

	@Autowired
	private EncounterRepository repository;

	public Encounter saveEncounter(Encounter encounter) {
		return repository.save(encounter);
	}

	public Encounter updateEncounter(int id, Encounter encounter) {
		if (repository.findById(id).isPresent()) {
			encounter.setId(id);
			return repository.save(encounter);
		} else {
			return null;
		}
	}

	public Encounter getEncounterById(int eid) {
		if (repository.findById(eid).isPresent()) {
			Encounter encounter = repository.findById(eid).get();
			return encounter;
		} else {
			return null;

		}
	}

	public Encounter deleteEncounter(int id) {
		if (repository.findById(id).isPresent()) {
			Encounter encounter = repository.findById(id).get();
			repository.delete(encounter);
			return encounter;
		} else {
			return null;
		}
	}
}
