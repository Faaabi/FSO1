
package br.univille.projetinventarioweb.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.projetinventarioweb.entity.Comp;
import br.univille.projetinventarioweb.entity.Produto;
import br.univille.projetinventarioweb.service.CompService;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/componente")
public class CompController {
    @Autowired
    private CompService service;

    @GetMapping
    public ModelAndView index(){
        var listaComp = service.getAll();
        return new ModelAndView("comp/index","listaComp", listaComp);
    
    }

    @GetMapping("/novo")
        public ModelAndView novo(){
            var comp = new Comp();
            HashMap<String,Object> dados= new HashMap<>();
                dados.put("comp" , comp);
                return new ModelAndView("comp/form",dados);
    }

    @PostMapping
    public ModelAndView save(Comp comp){
        service.save(comp);
        return new ModelAndView("redirect:/componente");// a parte do form
    }
    
    @GetMapping("/alterar/{id}")
    public ModelAndView alterar (@PathVariable("id") long id){
        var umComp = service.getById(id);

        HashMap<String,Object> dados =new HashMap<>();
        dados.put("comp", umComp);
        return new ModelAndView("comp/form", dados);

    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete (@PathVariable("id") long id){
        var umComp = service.getById(id);
        if(umComp!= null){
            service.delete(id);
        }
        return new ModelAndView("redirect:/componente");
    }
 
}