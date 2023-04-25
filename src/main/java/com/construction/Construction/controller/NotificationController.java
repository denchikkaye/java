package com.construction.Construction.controller;

import com.construction.Construction.models.ConstractorsAccept;
import com.construction.Construction.models.User;
import com.construction.Construction.respository.ConstractorsAcceptRepository;
import com.construction.Construction.respository.ConstractorsOrderRepository;
import com.construction.Construction.respository.SuppliersAcceptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NotificationController {
    @Autowired
    ConstractorsAcceptRepository constractorsAcceptRepository;
    @Autowired
    SuppliersAcceptRepository suppliersAcceptRepository;

    @GetMapping("/notification")
    public String getNotification(@AuthenticationPrincipal User user, Model model){
        model.addAttribute("userCon", constractorsAcceptRepository.findByUserId(user.getId()));
        model.addAttribute("userSup", suppliersAcceptRepository.findByUserId(user.getId()));
        return "notification";
    }
}
