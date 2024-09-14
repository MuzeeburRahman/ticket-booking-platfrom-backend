package com.sapient.userauthservice.repository;

import com.sapient.userauthservice.model.SecretQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecretQuestionRepository extends JpaRepository<SecretQuestion, Long> {

}
