package br.com.petweb.pertweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

import br.com.petweb.pertweb.entity.Produto;
import br.com.petweb.pertweb.service.ProdutoService;


@Controller
@RequestMapping("/produtos")
public class ProdutoController {
    

    //Injeção de dependência da service de produtos 
    @Autowired
    private ProdutoService produtoService;

    //Método paa listar todos os produtos
    @GetMapping("/listar")
    public String listar(Model model){
        List<Produto> produtos = produtoService.findAll();
        model.addAttribute("produto", produtos);
        return "produto/listarProduto";
    }

    //Método para exibir o formulário de criação de produto
    @GetMapping("/criar")
    public String criarForm(Model model){
        model.addAttribute("produto", new Produto());
        return "produto/formularioProduto";
    }

    //Método para salvar produto
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Produto produto){
        produtoService.save(produto);
        return "redirect:/produtos/listar";
    }

    //Método para excluir um produto
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Integer id) {
        produtoService.deleteById(id);
        return "redirect:/produtos/listar";
    }
    
    // Método para exibir o formulário de edição do produtos
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        Produto produto = produtoService.findById(id);
        model.addAttribute("produto", produto);
        return "produto/formularioProduto";
    }

    @PutMapping("/atualizar/{id}")
    public String atualizar(@PathVariable Integer id, @ModelAttribute Produto produto){
        produto.setIdProduto(id);
        produtoService.save(produto);
        return "redirect:/produtos/listar";
    }
    

}
