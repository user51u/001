package com.boots.service;

import com.boots.entity.WorkplaceStatus;
import com.boots.entity.User;
import com.boots.entity.Workplace;
import com.boots.repository.WorkplaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.List;

@Service
public class WorkplaceService {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    WorkplaceRepository workplaceRepository;

    /*  public User findUserById(Long userId) {
          Optional<User> userFromDb = userRepository.findById(userId);
          return userFromDb.orElse(new User());
      }

      public List<User> allUsers() {
          return userRepository.findAll();
      }
  */
    public List<Workplace> allWorkplace() {
        return workplaceRepository.findAll();
    }


    public boolean saveWorkplace(Workplace workplace) {

        Workplace workplaceRepositoryById = workplaceRepository.findByNumber(workplace.getNumber());
        System.out.println("saveWorkplace---001 workplaceRepositoryById=" + workplaceRepositoryById);
        if (workplaceRepositoryById != null) {

            workplace.setId(workplaceRepositoryById.getId());
            workplace.setNumber(workplaceRepositoryById.getNumber());
            workplace.setDetail(workplaceRepositoryById.getDetail());
            workplace.setStatus(workplaceRepositoryById.getStatus());
        } else {
            workplace.setWorkplaceStatuses(Collections.singleton(new WorkplaceStatus(2L, "ROLE_USER")));
        }
        workplaceRepository.save(workplace);
        return true;
    }

    public boolean deleteWorkplace(Long aLong) {
        System.out.println("deleteWorkplace---001 " + aLong);

        if (workplaceRepository.findById(aLong).isPresent()) {
            workplaceRepository.deleteById(aLong);
            return true;
        }
        return false;
    }

    public List<User> usergtList(Long idMin) {
        return entityManager.createQuery("SELECT u FROM User u WHERE u.id > :paramId", User.class)
                .setParameter("paramId", idMin).getResultList();
    }
}