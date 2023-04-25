package com.construction.Construction.controller;

import com.construction.Construction.models.User;
import com.construction.Construction.respository.ConstractorsOrderRepository;
import com.construction.Construction.respository.SupplierOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {
    @Autowired
    private SupplierOrderRepository supplierOrderRepository;
    @Autowired
    private ConstractorsOrderRepository constractorsOrderRepository;

    @GetMapping("/order")
    public String orderPage(@AuthenticationPrincipal User user, Model model){
        model.addAttribute("supUser", supplierOrderRepository.findByUserId(user.getId()));
        model.addAttribute("conPrice", constractorsOrderRepository.findByUserId(user.getId()));
        return "order";
    }
}
