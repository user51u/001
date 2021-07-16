package com.boots.repository;

import com.boots.entity.Workplace;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WorkplaceRepository extends JpaRepository<Workplace, Long> {
   // Optional<Workplace> findById(Long number);
}
