package com.ty.springboot_hospital_project.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "Branch")
@Data
public class Branch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "Name should not be blank")
	@NotNull(message = "Name should not be null")
	private String name;
	private long phone;
	@NotBlank(message = "manager should not be blank")
	@NotNull(message = "manager should not be null")
	private String manager;

	@ManyToOne
	private Hospital hospital;

	@OneToOne
	private Address address;

}
