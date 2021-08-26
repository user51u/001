package com.boots.service;

import com.boots.entity.*;
import com.boots.repository.WorkplaceBronRepository;
import com.boots.repository.WorkplaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class WorkplaceService {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    WorkplaceRepository workplaceRepository;

    @Autowired
    WorkplaceBronRepository workplaceBronRepository;

    /*  public User findUserById(Long userId) {
          Optional<User> userFromDb = userRepository.findById(userId);
          return userFromDb.orElse(new User());
      }

      public List<User> allUsers() {
          return userRepository.findAll();
      }
  */







    public List<WorkplaceBron> allWorkplaceBron() {
        List<WorkplaceBron> workplaceRepositoryAll = workplaceBronRepository.findAll();


//        Comparator<? super WorkplaceBron> comparator = new Comparator<Workplace>() {
//            @Override
//            public int compare(WorkplaceBron o1, WorkplaceBron o2) {
//                if (o1.getId() > o2.getId()) {
//                    return 1;
//                }
//
//                if (o1.getId() < o2.getId()) {
//                    return -1;
//                }
//                return 0;
//            }
//        };
//        workplaceRepositoryAll.sort(comparator);
        return workplaceRepositoryAll;
    }

    public List<WorkplaceBron> allWorkplaceBronById(Long id) {

       // List<WorkplaceBron> workplaceRepositoryAll = workplaceBronRepository.findById(id);
        List<WorkplaceBron> workplaceRepositoryAll = workplaceBronRepository.findAll(); //БЫЛО
        System.out.println("allWorkplaceBronById---001 Id=" + id);
        ArrayList<WorkplaceBron> workplaceRepository = new ArrayList<>();

        for (int i = 0; i < workplaceRepositoryAll.size(); i++) {


            WorkplaceBron workplaceBron = workplaceRepositoryAll.get(i);

            if (workplaceBron.getNumber()==id) {
                workplaceRepository.add(workplaceBron);
           }
        }


//        Comparator<? super WorkplaceBron> comparator = new Comparator<Workplace>() {
//            @Override
//            public int compare(WorkplaceBron o1, WorkplaceBron o2) {
//                if (o1.getId() > o2.getId()) {
//                    return 1;
//                }
//
//                if (o1.getId() < o2.getId()) {
//                    return -1;
//                }
//                return 0;
//            }
//        };
//        workplaceRepositoryAll.sort(comparator);
        return workplaceRepository;
    }

    public List<Workplace> allWorkplace() {
        List<Workplace> workplaceRepositoryAll = workplaceRepository.findAll();
        Comparator<? super Workplace> comparator = new Comparator<Workplace>() {
            @Override
            public int compare(Workplace o1, Workplace o2) {
                if (o1.getId() > o2.getId()) {
                    return 1;
                }

                if (o1.getId() < o2.getId()) {
                    return -1;
                }
                return 0;
            }
        };
        workplaceRepositoryAll.sort(comparator);
        return workplaceRepositoryAll;
    }


    public boolean saveWorkplace(Workplace workplace) {

        Optional<Workplace> workplaceRepositoryById = workplaceRepository.findById(workplace.getNumber());
        System.out.println("saveWorkplace---001 workplaceRepositoryById=" + workplaceRepositoryById);
        if (workplaceRepositoryById.isPresent()) {
            workplace.setId(workplaceRepositoryById.get().getId());
            workplace.setNumber(workplaceRepositoryById.get().getNumber());
            workplace.setDetail(workplaceRepositoryById.get().getDetail());
            workplace.setStatus(workplaceRepositoryById.get().getStatus());
        } else {
            workplace.setWorkplaceStatuses(Collections.singleton(new WorkplaceStatus(2L, "ROLE_USER")));
        }
        workplaceRepository.save(workplace);
        return true;
    }
//
//
// public boolean bronWorkplace(Workplace workplace) {
//
//        Workplace workplaceRepositoryById = workplaceRepository.findByNumber(workplace.getNumber());
//        System.out.println("saveWorkplace---001 workplaceRepositoryById=" + workplaceRepositoryById);
//        if (workplaceRepositoryById != null) {
//
////            workplace.setId(workplaceRepositoryById.getId());
////            workplace.setNumber(workplaceRepositoryById.getNumber());
////            workplace.setDetail(workplaceRepositoryById.getDetail());
//            workplace.setStatus(1l);
//        } else {
//          // workplace.setWorkplaceStatuses(Collections.singleton(new WorkplaceStatus(2L, "ROLE_USER")));
//        }
//        workplaceRepository.save(workplace);
//        return true;
//    }

    public boolean bronWorkplace(Long id, Long status) {
        System.out.println("bronWorkplace---001 id=" + id);

        Optional<Workplace> workplaceRepositoryById = workplaceRepository.findById(id);

        if (workplaceRepositoryById.isPresent()) {
            Workplace workplace = workplaceRepositoryById.get();
            workplace.setStatus(status);
            Set<WorkplaceStatus> workplaceStatuses = workplaceRepositoryById.get().getWorkplaceStatuses();
            System.out.println("bronWorkplace---005 найден " + id + " " + workplaceRepositoryById);
            System.out.println("bronWorkplace---010 найден " + id + " " + workplaceRepositoryById.get());
            System.out.println("bronWorkplace---015 найден " + workplaceStatuses);
            workplaceStatuses.clear();
            workplaceStatuses.add(new WorkplaceStatus(status, ""));

            //   workplaceRepositoryById.get().setWorkplaceStatuses(Collections.singleton(new WorkplaceStatus()));
//            System.out.println("bronWorkplace---015 найден " + id + " " + workplaceRepositoryById);
//            System.out.println("bronWorkplace---020 найден " + id + " " + workplaceRepositoryById.get());
//            System.out.println("bronWorkplace---025 workplaceRepository " + workplaceRepository);
            //   workplace.setWorkplaceStatuses(Collections.singleton(new WorkplaceStatus(1L, "ROLE_USER")));
            workplace.setWorkplaceStatuses(workplaceStatuses);
            workplaceRepository.save(workplace);
            return true;
        }
        return false;
    }

    public boolean checkWorkplaceBron(Long id, String start, String stop, Long status) {
        System.out.println("bronWorkplaceBron---001 id=" + id);
        WorkplaceBron workplaceBron = new WorkplaceBron();
        workplaceBron.setNumber(id);
       // workplaceBron.setDate_start2(new java.sql.Date(new Date().getTime()));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH:mm");
        Date convertedCurrentDateStart = null;
        Date convertedCurrentDateStop = null;
        try {
            convertedCurrentDateStart = simpleDateFormat.parse(start);
            convertedCurrentDateStop = simpleDateFormat.parse(stop);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //Date convertedCurrentDate = simpleDateFormat.parse("2013-09-18");
      //  String date=simpleDateFormat.format(convertedCurrentDate );


        Timestamp timestampStart = new Timestamp(convertedCurrentDateStart.getTime());
        Timestamp timestampStop = new Timestamp(convertedCurrentDateStop.getTime());
        long dt = timestampStop.getTime() - timestampStart.getTime();
        System.out.println("bronWorkplaceBron---005 dt=" + dt);
        workplaceBron.setDate_start2(timestampStart);
        workplaceBron.setDate_stop(timestampStop);
        workplaceBronRepository.save(workplaceBron);

        String message = "Некорректно введена дата";
        
        return true;


        //  Optional<WorkplaceBron> workplaceRepositoryById = workplaceBronRepository.findById(id);

        //  if (workplaceRepositoryById.isPresent()) {
        //      WorkplaceBron workplaceBron = workplaceRepositoryById.get();
//            workplace.setStatus(status);
//            Set<WorkplaceStatus> workplaceStatuses = workplaceRepositoryById.get().getWorkplaceStatuses();
//            System.out.println("bronWorkplace---005 найден " + id + " " + workplaceRepositoryById);
//            System.out.println("bronWorkplace---010 найден " + id + " " + workplaceRepositoryById.get());
//            System.out.println("bronWorkplace---015 найден " + workplaceStatuses );
//            workplaceStatuses.clear();
//            workplaceStatuses.add(new WorkplaceStatus(status, "ROLE_USER"));

        //   workplaceRepositoryById.get().setWorkplaceStatuses(Collections.singleton(new WorkplaceStatus()));
//            System.out.println("bronWorkplace---015 найден " + id + " " + workplaceRepositoryById);
//            System.out.println("bronWorkplace---020 найден " + id + " " + workplaceRepositoryById.get());
//            System.out.println("bronWorkplace---025 workplaceRepository " + workplaceRepository);
        //   workplace.setWorkplaceStatuses(Collections.singleton(new WorkplaceStatus(1L, "ROLE_USER")));
        //     workplace.setWorkplaceStatuses(workplaceStatuses);
        //      workplaceBronRepository.save( workplaceBron);
        //     return true;
        //  }
        //  return false;
    }
   public boolean bronWorkplaceBron(Long id, String start, String stop, Long status) {
        System.out.println("bronWorkplaceBron---001 id=" + id);
        WorkplaceBron workplaceBron = new WorkplaceBron();
        workplaceBron.setNumber(id);
       // workplaceBron.setDate_start2(new java.sql.Date(new Date().getTime()));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH:mm");
        Date convertedCurrentDateStart = null;
        Date convertedCurrentDateStop = null;
        try {
            convertedCurrentDateStart = simpleDateFormat.parse(start.replaceAll("T","-"));
            convertedCurrentDateStop = simpleDateFormat.parse(stop.replaceAll("T","-"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //Date convertedCurrentDate = simpleDateFormat.parse("2013-09-18");
      //  String date=simpleDateFormat.format(convertedCurrentDate );


        Timestamp timestampStart = new Timestamp(convertedCurrentDateStart.getTime());
        Timestamp timestampStop = new Timestamp(convertedCurrentDateStop.getTime());
        long dt = timestampStop.getTime() - timestampStart.getTime();
        System.out.println("bronWorkplaceBron---005 dt=" + dt);
        workplaceBron.setDate_start2(timestampStart);
        workplaceBron.setDate_stop(timestampStop);
        workplaceBronRepository.save(workplaceBron);

        String message = "Некорректно введена дата";

        return true;


        //  Optional<WorkplaceBron> workplaceRepositoryById = workplaceBronRepository.findById(id);

        //  if (workplaceRepositoryById.isPresent()) {
        //      WorkplaceBron workplaceBron = workplaceRepositoryById.get();
//            workplace.setStatus(status);
//            Set<WorkplaceStatus> workplaceStatuses = workplaceRepositoryById.get().getWorkplaceStatuses();
//            System.out.println("bronWorkplace---005 найден " + id + " " + workplaceRepositoryById);
//            System.out.println("bronWorkplace---010 найден " + id + " " + workplaceRepositoryById.get());
//            System.out.println("bronWorkplace---015 найден " + workplaceStatuses );
//            workplaceStatuses.clear();
//            workplaceStatuses.add(new WorkplaceStatus(status, "ROLE_USER"));

        //   workplaceRepositoryById.get().setWorkplaceStatuses(Collections.singleton(new WorkplaceStatus()));
//            System.out.println("bronWorkplace---015 найден " + id + " " + workplaceRepositoryById);
//            System.out.println("bronWorkplace---020 найден " + id + " " + workplaceRepositoryById.get());
//            System.out.println("bronWorkplace---025 workplaceRepository " + workplaceRepository);
        //   workplace.setWorkplaceStatuses(Collections.singleton(new WorkplaceStatus(1L, "ROLE_USER")));
        //     workplace.setWorkplaceStatuses(workplaceStatuses);
        //      workplaceBronRepository.save( workplaceBron);
        //     return true;
        //  }
        //  return false;
    }

    public boolean deleteWorkplace(Long aLong) {
        System.out.println("deleteWorkplace---001 " + aLong);

        if (workplaceRepository.findById(aLong).isPresent()) {
            workplaceRepository.deleteById(aLong);
            return true;
        }
        return false;
    }

  public boolean deleteBron(Long aLong) {
        System.out.println("deleteBron---001 " + aLong);

        if (workplaceBronRepository.findById(aLong).isPresent()) {
            System.out.println("deleteBron---005 нашли" );
            workplaceBronRepository.deleteById(aLong);

            return true;
        }
        else {
            System.out.println("deleteBron---010 не нашли" );
        }
        return false;
    }


    public List<User> usergtList(Long idMin) {
        return entityManager.createQuery("SELECT u FROM User u WHERE u.id > :paramId", User.class)
                .setParameter("paramId", idMin).getResultList();
    }
}
