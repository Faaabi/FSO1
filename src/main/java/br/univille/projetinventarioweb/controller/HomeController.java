package br.univille.projetinventarioweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller //anotaçãoes, tranforma isso em um controlados
@RequestMapping("/")//a barra do localhost:8080
public class HomeController {
    // @GetMapping //Localhost 
    // //@ResponseBody
    // public ModelAndView index(){
    //     //por equanto vamos escrever a logica aqui
    //     var mensagem = "eu não acredito";
    //    return new ModelAndView("home/index", "apelido", mensagem);//junta "dado" com o HTML, para mostrar na interface
    // }
}
