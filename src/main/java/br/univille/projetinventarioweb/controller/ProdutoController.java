package br.univille.projetinventarioweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.projetinventarioweb.repository.ProdutoRepository;

@Controller
@RequestMapping("/produto")
public class ProdutoController {
    
    @Autowired//injeta as coisas no banco
    private ProdutoRepository repository;
    
    @GetMapping
    public ModelAndView index(){
        //chamar o banco de dados e dar um select *from tabela -> na vida real é feito paginação
        var listaProduto =repository.findAll();
        //montar a tela com os dados do banco

        return new ModelAndView("produto/index", "listaProduto", listaProduto);
    }
}
