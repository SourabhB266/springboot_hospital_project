package com.ty.springboot_hospital_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.springboot_hospital_project.dto.MedItems;

public interface MedItemsRepository extends JpaRepository<MedItems, Integer> {

}
