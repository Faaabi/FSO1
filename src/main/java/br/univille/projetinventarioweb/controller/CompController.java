
package br.univille.projetinventarioweb.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.projetinventarioweb.entity.Comp;
import br.univille.projetinventarioweb.service.CompService;

@Controller
@RequestMapping("/compressor")
public class CompController {
    @Autowired
    private CompService service;

    @GetMapping
    public ModelAndView index(){
        var listaComp = service.getAll();
        return new ModelAndView("comp/index","listaComp", listaComp);
    
    }
}