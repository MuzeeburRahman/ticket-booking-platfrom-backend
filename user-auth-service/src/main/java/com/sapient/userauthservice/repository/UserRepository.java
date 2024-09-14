package com.sapient.userauthservice.repository;

import java.util.Optional;

import com.sapient.userauthservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
	boolean existsByEmail(String email);

	Optional<User> findByEmail(String email);
}
