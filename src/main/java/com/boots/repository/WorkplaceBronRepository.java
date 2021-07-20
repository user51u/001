package com.boots.repository;

import com.boots.entity.Workplace;
import com.boots.entity.WorkplaceBron;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkplaceBronRepository extends JpaRepository<WorkplaceBron, Long> {
   // Optional<Workplace> findById(Long number);
}
