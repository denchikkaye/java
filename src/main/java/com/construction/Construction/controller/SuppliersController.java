package com.construction.Construction.controller;

import com.construction.Construction.models.SupplierOrder;
import com.construction.Construction.models.SuppliersAccept;
import com.construction.Construction.models.User;
import com.construction.Construction.respository.SupplierOrderRepository;
import com.construction.Construction.respository.SuppliersAcceptRepository;
import com.construction.Construction.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SuppliersController {
    @Autowired
    SupplierOrderRepository supplierOrderRepository;
    @Autowired
    SuppliersAcceptRepository suppliersAcceptRepository;
    @Autowired
    SupplierService supplierService;

    @GetMapping("/suppliers")
    public String getSupplier(@AuthenticationPrincipal User user, Model model){
        model.addAttribute("allSupOrder", supplierOrderRepository.findAll());
        return "suppliers";
    }

    @PostMapping("/suppliers")
    public String buttonSupAccept(@AuthenticationPrincipal User user,
                                  @RequestParam(required = true, defaultValue = "") Long supId,
                                  Model model){

        SupplierOrder supplierOrder = supplierService.findById(supId);
        SuppliersAccept suppliersAccept = new SuppliersAccept();
        suppliersAccept.setFirstName(supplierOrder.getFirstName());
        suppliersAccept.setLastName(supplierOrder.getLastName());
        suppliersAccept.setNumber(supplierOrder.getNumber());
        suppliersAccept.setSupplierOrderId(supplierOrder.getId());
        suppliersAccept.setPrice(supplierOrder.getAllPrice());
        suppliersAccept.setUserId(supplierOrder.getUserId());
        suppliersAcceptRepository.save(suppliersAccept);
        return "redirect:/suppliers";
    }
}
