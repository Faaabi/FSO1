package br.univille.projetinventarioweb.controller;
import java.io.ObjectInputFilter.Status;
import java.nio.file.AccessDeniedException;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.projetinventarioweb.entity.ItemProduto;
import br.univille.projetinventarioweb.entity.Produto;
import br.univille.projetinventarioweb.repository.ProdutoRepository;
import br.univille.projetinventarioweb.service.CompService;
import br.univille.projetinventarioweb.service.LocalizacaoService;
import br.univille.projetinventarioweb.service.ProdutoService;
import br.univille.projetinventarioweb.service.StatusService;
import br.univille.projetinventarioweb.service.TcompService;
import br.univille.projetinventarioweb.service.TecService;
import br.univille.projetinventarioweb.service.TensaoService;
import br.univille.projetinventarioweb.service.TipoService;

import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/produto")
public class ProdutoController {
    
    @Autowired
    private ProdutoService service;
    @Autowired
    private LocalizacaoService localizacaoService;
    @Autowired
    private TecService tecService;
    @Autowired
    private StatusService statusService;
    @Autowired
    private TipoService tipoService;
    @Autowired
    private CompService compService;
    @Autowired
    private TensaoService tensaoService;
    @Autowired
    private TcompService tcompService;
   
    
    @GetMapping
    @PreAuthorize("hasAuthority('APPROLE_Read') or hasAuthority('APPROLE_Admin')")
    public ModelAndView index(){
        //chamar o banco de dados e dar um select *from tabela -> na vida real é feito paginação
        var listaProduto = service.getAll();        //montar a tela com os dados do banco

        return new ModelAndView("produto/index", "listaProduto", listaProduto);
    }
    
    @GetMapping("/novo")
    @PreAuthorize("hasAuthority('APPROLE_Admin')")    
    public ModelAndView novo(){
        var produto = new Produto();
        var listaLocalizacao = localizacaoService.getAll();
        var listaTec = tecService.getAll();
        var listaStatus = statusService.getAll();
        var listaTipo = tipoService.getAll();
        var listaComp = compService.getAll();
        var listaTensao = tensaoService.getAll();
        var listaTComp = tcompService.getAll();
        HashMap<String,Object> dados=
            new HashMap<>();
            dados.put("produto" ,produto);
            dados.put("listaLocalizacao", listaLocalizacao);
            dados.put("listaTec", listaTec);
            dados.put("listaStatus", listaStatus);
            dados.put("listaTipo", listaTipo);
            dados.put("listaComp", listaComp);
            dados.put("listaTensao", listaTensao);
            dados.put("listaTComp", listaTComp);
            dados.put("novoItem", new ItemProduto());
            return new ModelAndView("produto/form", dados);
        
    }
    
    @PostMapping
    @PreAuthorize("hasAuthority('APPROLE_Admin')")   
    public ModelAndView save(Produto produto){
        service.save(produto);
        return new ModelAndView("redirect:/produto");// a parte do form
    }
    
    @GetMapping("/alterar/{id}")
    @PreAuthorize("hasAuthority('APPROLE_Admin')")
    public ModelAndView alterar (@PathVariable("id") long id){
        var umProduto = service.getById(id);
        var listaLocalizacao = localizacaoService.getAll();
        var listaTec = tecService.getAll();
        var listaStatus = statusService.getAll();
        var listaTipo = tipoService.getAll();
        var listaComp = compService.getAll();
        var listaTensao = tensaoService.getAll();
        var listaTComp = tcompService.getAll();
        HashMap<String,Object> dados =new HashMap<>();
        dados.put("produto", umProduto);
        dados.put("listaLocalizacao", listaLocalizacao);
        dados.put("listaTec", listaTec);
        dados.put("listaStatus", listaStatus);
        dados.put("listaTipo", listaTipo);
        dados.put("listaComp", listaComp);
        dados.put("listaTensao", listaTensao);
        dados.put("listaTComp", listaTComp);
        dados.put("novoItem", new ItemProduto());
        return new ModelAndView("produto/form", dados);

    }
    @GetMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('APPROLE_Admin')")
    public ModelAndView delete (@PathVariable("id") long id){
        var umProduto = service.getById(id);
        if(umProduto!= null){
            service.delete(id);
        }
        return new ModelAndView("redirect:/produto");
    }

    @GetMapping("/detalhe/{id}")
    @PreAuthorize("hasAuthority('APPROLE_Admin')")
    public ModelAndView detalhe (@PathVariable("id") long id){
        var umProduto = service.getById(id);
        var listaLocalizacao = localizacaoService.getAll();
        var listaTec = tecService.getAll();
        var listaStatus = statusService.getAll();
        var listaTipo = tipoService.getAll();
        var listaComp = compService.getAll();
        var listaTensao = tensaoService.getAll();
        var listaTComp = tcompService.getAll();
        HashMap<String,Object> dados =new HashMap<>();
        dados.put("produto", umProduto);
        dados.put("listaLocalizacao", listaLocalizacao);
        dados.put("listaTec", listaTec);
        dados.put("listaStatus", listaStatus);
        dados.put("listaTipo", listaTipo);
        dados.put("listaComp", listaComp);
        dados.put("listaTensao", listaTensao);
        dados.put("listaTComp", listaTComp);
        dados.put("novoItem", new ItemProduto());
        return new ModelAndView("produto/detalhe", dados);

    }
    

    @ExceptionHandler(AccessDeniedException.class)
    public ModelAndView handle404Exception(AccessDeniedException ex) {
        return new ModelAndView("erro/400");
    }

    @PostMapping(params = "incitem")
    public ModelAndView incluirItem(Produto produto, 
                ItemProduto novoItem){
        produto.getItens().add(novoItem);

        var listaComp = compService.getAll();
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("produto", produto);
        dados.put("novoItem", new ItemProduto());
        dados.put("listaComp", listaComp);

        return new ModelAndView("produto/form",dados);
    }

    @PostMapping(params = "removeitem")
    public ModelAndView removerItem(@RequestParam("removeitem") int index, 
                                Produto produto){
        produto.getItens().remove(index);

        var listaComp = compService.getAll();

        HashMap<String,Object> dados = 
            new HashMap<>();
        dados.put("produto",produto);
        dados.put("novoItem", new ItemProduto());
        dados.put("listaComp",listaComp);

        return new ModelAndView("produto/form",dados);
    }

}
