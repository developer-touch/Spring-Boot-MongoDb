package com.ankit.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Document
@AllArgsConstructor
@RequiredArgsConstructor
public class Doctor {
	@Id
	private Integer id;
	private String name;
	private String addrs;
	private String email;
	private String qualification;
}
