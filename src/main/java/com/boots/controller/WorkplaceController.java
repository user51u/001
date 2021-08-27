package com.boots.controller;
//qqqqq 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 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

import com.boots.entity.Workplace;
import com.boots.entity.WorkplaceBron;
import com.boots.entity.WorkplaceStatus;
import com.boots.repository.WorkplaceBronRepository;
import com.boots.repository.WorkplaceRepository;
import com.boots.service.WorkplaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.validation.Valid;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Controller
public class WorkplaceController {

    @PersistenceUnit
    private EntityManagerFactory emf; //qqqqqqqqqqqqqqqqqqqqqqqqqq


    @Autowired
    private WorkplaceService workplaceService;

    @Autowired
    private WorkplaceBronRepository workplaceBronRepository;

    @Autowired
    private WorkplaceRepository workplaceRepository;
    private List<Integer> checkWorkplaceList = new ArrayList<>();

    @GetMapping("/workplace")
    public String workplaceList(Model model) {
        System.out.println("workplaceList---001 ");
        model.addAttribute("allWorkplace", workplaceService.allWorkplace());
        return "workplace";
    }

    @PostMapping("/workplace")
    public String deleteWorkplace(@RequestParam(required = true, defaultValue = "") Long workplaceId,
                                  @RequestParam(required = true, defaultValue = "") String action,
                                  Model model) {

        System.out.println("deleteWorkplace---001 workplaceId=" + workplaceId);
        System.out.println("deleteWorkplace---005 action=" + action);

        if (action.equals("delete")) {
            workplaceService.deleteWorkplace(workplaceId);
        }
        return "redirect:/workplace";
    }


//    @GetMapping("/film")
//    public ResponseEntity<List<Film>> getAllTutorials(@RequestParam(required = false) String title) {
//        try {
//
//            EntityManager em = emf.createEntityManager();
//            List<Film> films = em
//                    .createQuery("SELECT f.id, f.title, p.title, g.title FROM Film f, Produsser p, Genre g WHERE f.id_genre =g.id and f.id_produsser =p.id")
//                    .getResultList();
//
//
//            return new ResponseEntity<>(films, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @GetMapping("/workplacebron")
    public String workplaceListBron(@RequestParam(required = true, defaultValue = "") int workplaceId, Model model) {
        System.out.println("workplaceListBron---001 " + model + " " + workplaceId);

        List<WorkplaceBron> workplaceBronList = workplaceBronRepository.getWorkplaceById(workplaceId);
        model.addAttribute("allWorkplaceBron", workplaceBronList);


        // model.addAttribute("allWorkplaceBron", workplaceService.allWorkplaceBronById(workplaceId));
        return "workplacebron";
    }

    @PostMapping("/workplacebron")
    public String bronWorkplace2(

            @RequestParam(required = true, defaultValue = "") Long bronId,
            @RequestParam(required = true, defaultValue = "") Long workplaceId,

            @RequestParam(required = true, defaultValue = "") String action,
            Model model) {

        System.out.println("bronWorkplace2---001 bronId=" + bronId);
        System.out.println("bronWorkplace2---004 workplaceId=" + workplaceId);
        System.out.println("bronWorkplace2---005 action=" + action);


        if (action.equals("delete")) {
            workplaceService.deleteBron(bronId);
        }

        return "redirect:/workplacebron?workplaceId=" + workplaceId;
    }


    @GetMapping("/bron")

    //   public ResponseEntity<List<Film>> getAllTutorials(@RequestParam(required = false) String title) {

    public String bronList(Model model,
                           @RequestParam(required = false, defaultValue = "") String start,
                           @RequestParam(required = false, defaultValue = "") String stop

    ) {
        System.out.println("bronList---001 " + start + " " + stop);

        List<Workplace> workplaceList = workplaceService.allWorkplace();
        for (int i1 = 0; i1 < checkWorkplaceList.size(); i1++) {
            System.out.println("bronWorkplace1---005 checkWorkplaceList.get(i1)=" + checkWorkplaceList.get(i1));
        }

        for (int i = 0; i < workplaceList.size(); i++) {
            System.out.println("bronWorkplace1---010 workplaceList.get(i)=" + workplaceList.get(i));

            if (start.length() == 0 || stop.length() == 0) {
                workplaceList.get(i).setStatus(0L); //статус неизвестен
            } else {
                workplaceList.get(i).setStatus(2L); //статус свободен
            }

            if (start.length() != 0 && stop.length() != 0) {

                for (int i1 = 0; i1 < checkWorkplaceList.size(); i1++) {
                    System.out.println("bronWorkplace1---015|" + workplaceList.get(i).getNumber() + "|" + checkWorkplaceList.get(i1).longValue() + "|");
                    if (workplaceList.get(i).getId() == checkWorkplaceList.get(i1).longValue()) {
                        workplaceList.get(i).setStatus(1l);
                        System.out.println("bronWorkplace1---020|" + workplaceList.get(i).getNumber() + "|" + checkWorkplaceList.get(i1).longValue() + "|");

                    }
                }
            }
        }
        model.addAttribute("allWorkplace", workplaceList);

        return "bron";
    }

    @PostMapping("/bron")
    public String bronWorkplace1(

            @RequestParam(required = true, defaultValue = "") Long workplaceId,
            @RequestParam(required = true, defaultValue = "") Long number,
            @RequestParam(required = true, defaultValue = "") String action,
            @RequestParam(required = false, defaultValue = "") String start,
            @RequestParam(required = false, defaultValue = "") String stop,
            @RequestParam(required = false, defaultValue = "") String param,
            @RequestParam(required = false, defaultValue = "") String login,
            Model model) {

        System.out.println("bronWorkplace1---001 number=|" + number + "| workplaceId=|" + workplaceId + "|");
        System.out.println("bronWorkplace1---005 " + start + " " + stop + " param=|" + param + "|");
        System.out.println("bronWorkplace1---010 action=" + action);

        if (action.equals("bron1")) {
            System.out.println("bronWorkplace1---010 action=" + action);
            workplaceService.bronWorkplace(workplaceId, 1l);
            return "redirect:/bron";
        }
        if (action.equals("bron2")) {
            System.out.println("bronWorkplace1---010 action=" + action);
            workplaceService.bronWorkplace(workplaceId, 2l);
            return "redirect:/bron";
        }
        if (action.equals("bron3")) {
            System.out.println("bronWorkplace1---010 action=" + action);
            workplaceService.bronWorkplace(workplaceId, 3l);
            return "redirect:/bron";
        }
        if (action.equals("bron4")) {
            System.out.println("bronWorkplace1---010 action=" + action);
            workplaceService.bronWorkplace(workplaceId, 4l);
            return "redirect:/bron";
        }
        if (action.equals("bron5")) {
            System.out.println("bronWorkplace1---010 action=" + action);
            //qqqqq    workplaceService.bronWorkplace(workplaceId, 4l);
            return "redirect:/workplacebron?workplaceId=" + workplaceId;
        }

        if (action.equals("bron6")) {
            System.out.println("bronWorkplace1---030 action=" + action);

            //    model.addAttribute("userForm", new WorkplaceBron());
            workplaceService.bronWorkplaceBron(workplaceId, start, stop, 4l, login, number);
            return "redirect:/bron?start=" + start + "&stop=" + stop + "&param=needCheck";
        }


        if (action.equals("bronCheckDate")) {
            System.out.println("bronCheckDate---050 action=" + action);

            //    model.addAttribute("userForm", new WorkplaceBron());

            // checkWorkplaceList = workplaceRepository.getWorkplaceBusy(start+"", stop+"");


            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH:mm");
            Date convertedCurrentDateStart = null;
            Date convertedCurrentDateStop = null;
            try {
                convertedCurrentDateStart = simpleDateFormat.parse(start.replaceAll("T", "-"));
                convertedCurrentDateStop = simpleDateFormat.parse(stop.replaceAll("T", "-"));

                //Date convertedCurrentDate = simpleDateFormat.parse("2013-09-18");
                //  String date=simpleDateFormat.format(convertedCurrentDate );


                Timestamp timestampStart = new Timestamp(convertedCurrentDateStart.getTime());
                Timestamp timestampStop = new Timestamp(convertedCurrentDateStop.getTime());


                checkWorkplaceList = workplaceRepository.getWorkplaceBusy(timestampStart, timestampStop);


//            try {
//
//                EntityManager entityManager = emf.createEntityManager();
//                String sql = "SELECT number FROM public.t_workplace_bron where date_start2 > '"
//                        +
//                        start.replaceAll("T"," ")
//                        + "' and date_start2 < '" +
//                        stop.replaceAll("T"," ")
//                        + "' or date_stop > '" +
//                        start.replaceAll("T"," ")
//                        + "' and date_stop < '" +
//                        stop.replaceAll("T"," ")
//                        +"'";
//                System.out.println("bronCheckDate---003: |"+sql+"|");
//                checkWorkplaceList = entityManager
//                        .createQuery(sql)
//                        .getResultList();
//
//                System.out.println("bronCheckDate---004: films.size()=" +  checkWorkplaceList);


//           List<Film> films = new ArrayList<Film>();
//            if (title == null)
//                tutorialRepository.findAll().forEach(films::add);
//            else
//                tutorialRepository.findByTitleContaining(title).forEach(films::add);
//
//            if (films.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }

                //  return new ResponseEntity<>(films, HttpStatus.OK);
//            } catch (Exception e) {
//                System.out.println("bronCheckDate---020: ERROR "+e);
//              //   return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//            }


                System.out.println("bronWorkplace1---052 workplaceList.size()=" + checkWorkplaceList.size());

                for (int i = 0; i < checkWorkplaceList.size(); i++) {
                    System.out.println("bronWorkplace1---055 " + checkWorkplaceList.get(i));
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }

//            model.addAttribute("allWorkplaceBron", workplaceBronList);
//
//            workplaceService.checkWorkplaceBron(workplaceId, start, stop, 4l);
            return "redirect:/bron?start=" + start + "&stop=" + stop + "&param=" + param;
        }


        return "redirect:/bron";
    }

    @GetMapping("/workplace/gt/{userId}")
    public String gtWorkplace(@PathVariable("userId") Long userId, Model model) {
        model.addAttribute("allworkplace", workplaceService.usergtList(userId));
        return "workplace";
    }


    @GetMapping("/regwor")
    public String workplace(Model model) {
        model.addAttribute("userForm", new Workplace());
        return "regwor";
    }


    @PostMapping("/regwor")
    public String addWorkplace(@ModelAttribute("userForm") @Valid Workplace workplace, BindingResult bindingResult, Model model) {

        System.out.println("addWorkplace---001 " + workplace);
        if (bindingResult.hasErrors()) {
            System.out.println("addWorkplace---005 ERROR");
            return "regwor";
        }

        if (!workplaceService.saveWorkplace(workplace)) {
            System.out.println("addWorkplace---010 ERROR");
            return "regwor";
        }
        System.out.println("addWorkplace---010 ВРОДЕ ДОБАВИЛИ");
        return "redirect:/";
    }

//    @PostMapping("/bron")
//    public String bronWorkplace(@ModelAttribute("userForm") @Valid Workplace workplace, BindingResult bindingResult, Model model) {
//
//        System.out.println("bronWorkplace---001 " + workplace);
//        if (bindingResult.hasErrors()) {
//            System.out.println("bronWorkplace---005 ERROR");
//            return "bron";
//        }
//
//        if (!workplaceService.saveWorkplace(workplace)) {
//            System.out.println("bronWorkplace---010 ERROR");
//            return "bron";
//        }
//
//        if (action.equals("bron")) {
//            workplaceService.bronWorkplace(workplaceId);
//        }
//
//
//
//        System.out.println("bronWorkplace---010 ВРОДЕ ДОБАВИЛИ");
//        return "redirect:/bron";
//    }


}
