package com.sapient.userauthservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "tb_secret_questions")
@Data
public class SecretQuestion {
	@Id
	private Long id;

	private String question;
}
