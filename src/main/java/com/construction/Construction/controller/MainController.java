package com.construction.Construction.controller;

import com.construction.Construction.models.*;
import com.construction.Construction.respository.*;
import com.construction.Construction.service.HomeService;
import com.construction.Construction.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    HomeService homeService;
    @Autowired
    SupplierService supplierService;
    @Autowired
    private ConstractorsRepository constractorsRepository;
    @Autowired
    private SupplierOrderRepository supplierOrderRepository;
    @Autowired
    private ConstractorsOrderRepository constractorsOrderRepository;

    @GetMapping("/")
    public String addOrder(@AuthenticationPrincipal User user,
                           Model model) {
        model.addAttribute("allHome", homeService.allHomes());
        return "homePage";
    }

    @PostMapping("/")
    public String payHome(@AuthenticationPrincipal User user,
                          @RequestParam(required = true, defaultValue = "" ) Long homeId,
                          Model model){
        Long supId = 1L;
        Home home = homeService.findHomeById(homeId);
        Suppliers suppliers = supplierService.findSupplierById(supId);
        //Занесение заказа на материал у поставщиков
        SupplierOrder supplierOrder = new SupplierOrder();
        supplierOrder.setFirstName(user.getFirst_name());
        supplierOrder.setLastName(user.getLast_name());
        supplierOrder.setNumber(user.getNumber());
        supplierOrder.setDoor(home.getDoor());
        supplierOrder.setInsulation(home.getInsulation());
        supplierOrder.setPaint(home.getPaint());
        supplierOrder.setPlank(home.getPlank());
        supplierOrder.setRoof(home.getRoof());
        supplierOrder.setTimber(home.getTimber());
        supplierOrder.setVaporBarrier(home.getVaporBarrier());
        supplierOrder.setWindows(home.getWindows());
        supplierOrder.setAllPrice(home.getDoor() * suppliers.getDoor() +
                home.getInsulation() * suppliers.getInsulation() +
                home.getPaint() * suppliers.getPaint() +
                home.getPlank() * suppliers.getPlank() +
                home.getRoof() * suppliers.getRoof() +
                home.getTimber() * suppliers.getTimber() +
                home.getVaporBarrier() * suppliers.getVaporBarrier() +
                home.getWindows() * suppliers.getWindows());
        supplierOrder.setUserId(user.getId());
        supplierOrderRepository.save(supplierOrder);
        //Занесение заказа пользователя в заказ подрядчка
        ConstractorsOrder constractorsOrder = new ConstractorsOrder();
        constractorsOrder.setHomeId(homeId);
        constractorsOrder.setUserId(user.getId());
        constractorsOrder.setFirstName(user.getFirst_name());
        constractorsOrder.setLastName(user.getLast_name());
        constractorsOrder.setNumber(user.getNumber());
        constractorsOrder.setPrice(constractorsRepository.findPriceByHomeId(homeId).getPrice());
        constractorsOrderRepository.save(constractorsOrder);
        return "redirect:/";
    }
}
