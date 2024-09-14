package com.sapient.theatre.mgt.repository;

import com.sapient.theatre.mgt.entity.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, String> {
}
