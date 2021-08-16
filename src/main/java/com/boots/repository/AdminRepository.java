package com.boots.repository;

import com.boots.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminRepository extends JpaRepository<User, Long> {
    @Query(value ="INSERT INTO public.t_status_workplace(id, name)\n" +
            "    VALUES  (0, 'неизвестен'), (1, 'занято'), (2, 'свободно'), (3, 'выбрано'), (4, 'недоступно');", nativeQuery = true)
    void createStatus();
}
