package com.boots.repository;

import com.boots.entity.Workplace;
import com.boots.entity.WorkplaceBron;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WorkplaceBronRepository extends JpaRepository<WorkplaceBron, Long> {
   // Optional<Workplace> findById(Long number);
   @Query(value ="SELECT * FROM public.t_workplace_bron where number = :number", nativeQuery = true)
   List<WorkplaceBron> getWorkplaceById(@Param(value="number") int number);
}
