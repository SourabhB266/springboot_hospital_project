package com.ty.springboot_hospital_project.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Entity
@Data
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message = "Name should not be null")
	@NotBlank(message = "Name should not be blank")
	private String name;
	@NotBlank(message = "email should not be blank")
	@NotNull(message = "email should not be null")
	@Pattern(regexp = "[a-zA-Z0-9_/-/.]+[@][a-z]+[/.][a-z]{2,3}",message = ("email"))
	private String email;
	@Pattern(regexp = "[6-9][0-9]{9}",message = ("Phone Number"))
	private long phone;
}
