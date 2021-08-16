package com.boots.repository;

import com.boots.entity.Workplace;
import com.boots.entity.WorkplaceBron;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface WorkplaceRepository extends JpaRepository<Workplace, Long> {

    //   @Query(value ="SELECT * FROM public.t_workplace_bron where number = :number", nativeQuery = true)
//    @Query(value = "SELECT number FROM public.t_workplace_bron\n" +
//            "where\n" +
//            "date_start2 > '2021-08-10 09:15:00' and date_start2 < '2021-08-10 15:45:00'\n" +
//            "or\n" +
//            "date_stop > '2021-08-10 09:15:00' and date_stop < '2021-08-10 15:45:00'", nativeQuery = true)

    //
//    @Query(value = "SELECT number FROM public.t_workplace_bron\n" +
//            "where\n" +
//            "date_start2 > :start and date_start2 < :stop\n " +
//            "or\n" +
//            "date_stop > :start and date_stop < :stop", nativeQuery = true)
//    List<Integer> getWorkplaceBusy(@Param("start") String start , @Param("stop") String stop);
//
    @Query(value = "SELECT number FROM public.t_workplace_bron where date_start2 > '2021-08-10 09:15:00' and date_start2 < '2021-08-10 15:45:00'  or date_stop > '2021-08-10 09:15:00' and date_stop < '2021-08-10 15:45:00'", nativeQuery = true)
    List<Integer> getWorkplaceBusy(String start, String stop);
}
