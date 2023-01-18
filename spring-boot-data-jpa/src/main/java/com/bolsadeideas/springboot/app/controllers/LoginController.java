package com.bolsadeideas.springboot.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error, @RequestParam(value = "logout", required = false) String logout, Model model, Principal principal, RedirectAttributes flash){
        if(principal!=null) {
            flash.addFlashAttribute("info", "Ya ha iniciado sesion");
            return "redirect:/";
        }
        if(error!=null){
            model.addAttribute("error","Error al iniciar sesion, usuario o contraseña incorrecta, vuelva a intentar");
        }
        if(logout!=null){
            model.addAttribute("success","Sesion cerrada con exito");
        }
        return "login";
    }

}
