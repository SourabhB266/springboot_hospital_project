package com.ty.springboot_hospital_project.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Hospital {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message = "Name should not be Null")
	@NotBlank(message = "Name should not be blank")
	private String name;
	@NotNull(message = "Email Cannot be Null")
	@NotBlank(message = "Email Should not blank")
	private String email;
	@NotBlank(message = "gst canot be blank")
	@NotNull(message = "gst should not be null")
	private String gst;

}
