package com.ty.springboot_hospital_project.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Encounter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "reason should not be blank")
	@NotNull(message = "reason should not be null")
	private String reason;
	private long cost;
	@ManyToOne
	private Person person;
	@OneToMany
	private List<Branch> branchs;
}
