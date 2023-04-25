package com.construction.Construction.controller;

import com.construction.Construction.models.ConstractorsAccept;
import com.construction.Construction.models.ConstractorsOrder;
import com.construction.Construction.models.User;
import com.construction.Construction.respository.ConstractorsAcceptRepository;
import com.construction.Construction.respository.ConstractorsOrderRepository;
import com.construction.Construction.service.ConstractorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConstractorsController {

    @Autowired
    ConstractorsService constractorsService;
    @Autowired
    ConstractorsAcceptRepository constractorsAcceptRepository;

    @GetMapping("/constractors")
    public String getConstractors(@AuthenticationPrincipal User user, Model model){
        model.addAttribute("allConOrder", constractorsService.allConOrder());
        return "constractors";
    }

    @PostMapping("/constractors")
    public String buttonAccept(@AuthenticationPrincipal User user,
                               @RequestParam(required = true, defaultValue = "" ) Long conId){

        ConstractorsAccept constractorsAccept = new ConstractorsAccept();
        ConstractorsOrder constractorsOrder = constractorsService.findById(conId);
        constractorsAccept.setConstractorsOrder(conId);
        constractorsAccept.setFirstName(constractorsOrder.getFirstName());
        constractorsAccept.setLastName(constractorsOrder.getLastName());
        constractorsAccept.setHomeId(constractorsOrder.getHomeId());
        constractorsAccept.setNumber(constractorsOrder.getNumber());
        constractorsAccept.setPrice(constractorsOrder.getPrice());
        constractorsAccept.setUserId(constractorsOrder.getUserId());
        constractorsAcceptRepository.save(constractorsAccept);
        return "redirect:/constractors";
    }
}
