package com.ty.springboot_hospital_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.springboot_hospital_project.dto.Address;

public interface Addressrepository extends JpaRepository<Address, Integer>{

}
