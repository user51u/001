package com.boots.controller;

import com.boots.entity.Workplace;
import com.boots.entity.WorkplaceBron;
import com.boots.service.WorkplaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;
import java.text.SimpleDateFormat;

@Controller
public class WorkplaceController {
    @Autowired
    private WorkplaceService workplaceService;

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


    @GetMapping("/workplacebron")
    public String workplaceListBron(@RequestParam(required = true, defaultValue = "") Long workplaceId, Model model) {
        System.out.println("workplaceListBron---001 " + model + " " + workplaceId);
        model.addAttribute("allWorkplaceBron", workplaceService.allWorkplaceBronById(workplaceId));
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

/*
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }*/

    @GetMapping("/bron")
    public String bronList(Model model) {
        System.out.println("workplaceList---001 ");
        model.addAttribute("allWorkplace", workplaceService.allWorkplace());
        return "bron";
    }

    @PostMapping("/bron")
    public String bronWorkplace1(

            @RequestParam(required = true, defaultValue = "") Long workplaceId,
            @RequestParam(required = false, defaultValue = "") String start,
            @RequestParam(required = false, defaultValue = "") String stop,
            @RequestParam(required = false, defaultValue = "") String startTime,
            @RequestParam(required = false, defaultValue = "") String stopTime,
            @RequestParam(required = true, defaultValue = "") String action,
            Model model) {

        System.out.println("bronWorkplace1---001 start=" + start);
        System.out.println("bronWorkplace1---001 stop=" + stop);
        System.out.println("bronWorkplace1---001 startTime=" + startTime);
        System.out.println("bronWorkplace1---001 stopTime=" + stopTime);
        System.out.println("bronWorkplace1---001 workplaceId=" + workplaceId);
        System.out.println("bronWorkplace1---005 action=|" + action + "|");

        if (action.equals("setZanato")) {
            System.out.println("bronWorkplace1---010 action=" + action);
            workplaceService.bronWorkplace(workplaceId, 1l);
            return "redirect:/bron";
        }
        if (action.equals("setSvobodno")) {
            System.out.println("bronWorkplace1---010 action=" + action);
            workplaceService.bronWorkplace(workplaceId, 2l);
            return "redirect:/bron";
        }
        if (action.equals("setVybrano")) {
            System.out.println("bronWorkplace1---010 action=" + action);
            workplaceService.bronWorkplace(workplaceId, 3l);
            return "redirect:/bron";
        }
        if (action.equals("setNedostupno")) {
            System.out.println("bronWorkplace1---010 action=" + action);
            workplaceService.bronWorkplace(workplaceId, 4l);
            return "redirect:/bron";
        }

        if (action.equals("listBrone")) {
            System.out.println("bronWorkplace1---010 action=" + action);
            workplaceService.bronWorkplace(workplaceId, 4l);
            return "redirect:/workplacebron?workplaceId=" + workplaceId;
        }

        if (action.equals("zabron")) {
            System.out.println("bronWorkplace1---010 action=" + action + " " + start);

            //    model.addAttribute("userForm", new WorkplaceBron());
            workplaceService.bronWorkplaceBron(workplaceId, start,startTime,stopTime);
            return "redirect:/bron";
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
