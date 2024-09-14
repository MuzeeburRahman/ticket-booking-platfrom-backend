package com.sapient.adminservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.sapient.adminservice.dto.ValidationDto;

@FeignClient(name = "auth-client", url = "${user-auth-service.url}")
public interface AuthClient {
	@GetMapping(value = "/validate")
	public ValidationDto validateAuthToken(@RequestHeader(name = "Authorization", required = true) String token);
}
