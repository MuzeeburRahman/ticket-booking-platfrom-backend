package com.sapient.adminservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapient.adminservice.model.Showing;

@Repository
public interface ShowingRepository extends JpaRepository<Showing, String> {

}
