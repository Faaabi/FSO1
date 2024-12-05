package br.univille.projetinventarioweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // Indica que esta classe é um controlador
public class HomeController {

    @GetMapping("/") // Mapeia o endpoint "/" para este método
    public ModelAndView index() {
        // Retorna a view "home/index"
        return new ModelAndView("home/index");
    }
}
