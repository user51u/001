package com.boots.repository;

import com.boots.entity.Workplace;
import com.boots.entity.WorkplaceBron;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WorkplaceBronRepository extends JpaRepository<WorkplaceBron, Long> {

  // "SELECT f.id, f.title, p.title, g.title FROM Film f, Produsser p, Genre g WHERE f.id_genre =g.id and f.id_produsser =p.id"

   @Query(value ="SELECT * FROM public.t_workplace_bron where number = :number", nativeQuery = true)
   /* @Query(value ="SELECT wb.id, " +
            "wb.number," +
            "wb.number_workplace," +
            "wb.login_user," +
            "wb.detail," +
            "wb.id_user," +
            "wb.date_start2," +
            "wb.date_stop, " +
            "wp.number " +
            "FROM public.t_workplace_bron wb, public.t_workplace wp where wb.number = :number and  wb.number = wp.id ", nativeQuery = true)
*/

   List<WorkplaceBron> getWorkplaceById(@Param(value="number") int number);
}
