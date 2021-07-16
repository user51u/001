package com.boots.repository;

import com.boots.entity.User;
import com.boots.entity.Workplace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkplaceRepository extends JpaRepository<Workplace, Long> {
    Workplace findByNumber(Long number);
}
