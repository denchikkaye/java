package com.construction.Construction.controller;

import com.construction.Construction.models.Role;
import com.construction.Construction.models.User;
import com.construction.Construction.respository.RoleRepository;
import com.construction.Construction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/admin")
    public String userList(@AuthenticationPrincipal User user,
                           Model model) {
        model.addAttribute("allUsers", userService.allUsers());
        model.addAttribute("user",user);
        return "admin";
    }

    @PostMapping("/admin")
    public String  deleteUser(@AuthenticationPrincipal User user,
                              @RequestParam(required = true, defaultValue = "" ) Long userId,
                              @RequestParam(required = true, defaultValue = "" ) String action,
                              Model model) {
        if (action.equals("delete")){
            userService.deleteUser(userId);
        }
        if (action.equals("give_supplier")) {
            User userr = userService.get(userId);
            userr.getRoles().add(new Role(4L, "ROLE_SUPPLIER"));
            userService.saveWith(userr);
        }

        if (action.equals("give_constractors")) {
            User userr = userService.get(userId);
            userr.getRoles().add(new Role(2L, "ROLE_CONTRACTORS"));
            userService.saveWith(userr);
        }

        if (action.equals("delete_role")) {
            User userr = userService.get(userId);
            userr.getRoles().clear();
            userr.getRoles().add(new Role(1L, "ROLE_USER"));
            userService.saveWith(userr);
        }
        model.addAttribute("user",user);
        return "redirect:/admin";
    }

    @PostMapping("/admin_registration")
    public String addUserByAdmin(@ModelAttribute("userForm")@Valid User userForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "admin";
        }
        if (!userForm.getPassword().equals(userForm.getPasswordConfirm())){
            model.addAttribute("passwordError", "Пароли не совпадают");
            return "admin";
        }
        if (!userService.saveUser(userForm)){
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "admin";
        }

        return "redirect:/admin";
    }

    @GetMapping("/admin/gt/{userId}")
    public String gtUser(@AuthenticationPrincipal User user,
                         @PathVariable("userId") Long userId, Model model) {
        model.addAttribute("allUsers", userService.usergtList(userId));
        model.addAttribute("user",user);
        return "admin";
    }
}