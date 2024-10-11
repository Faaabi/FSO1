package br.univille.projetinventarioweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.projetinventarioweb.entity.Produto;
import br.univille.projetinventarioweb.repository.ProdutoRepository;
import br.univille.projetinventarioweb.service.ProdutoService;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/produto")
public class ProdutoController {
    
    @Autowired
    private ProdutoService service;
    
    @GetMapping
    public ModelAndView index(){
        //chamar o banco de dados e dar um select *from tabela -> na vida real é feito paginação
        var listaProduto = service.getAll();        //montar a tela com os dados do banco

        return new ModelAndView("produto/index", "listaProduto", listaProduto);
    }

    @GetMapping("/novo")    
    public ModelAndView novo(){
        var produto = new Produto();
        return new ModelAndView("produto/form", "produto" ,produto);
        
    }
    @PostMapping
    public ModelAndView save(Produto produto){
        service.save(produto);
        return new ModelAndView("redirect:/produto");// a parte do form
    }
    @GetMapping("/alterar/{id}")
    public ModelAndView alterar (@PathVariable("id") long id){
        var umProduto = service.getById(id);
        return new ModelAndView("produto/form", "produto" ,umProduto);
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete (@PathVariable("id") long id){
        var umProduto = service.getById(id);
        if(umProduto!= null){
            service.delete(id);
        }
        return new ModelAndView("redirect:/produto");
    }

}
