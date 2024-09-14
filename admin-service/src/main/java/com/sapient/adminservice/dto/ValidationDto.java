package com.sapient.adminservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ValidationDto {
	private boolean status;
	private String userId;
	private String role;

	public ValidationDto(boolean b, String admin) {
	}
}
