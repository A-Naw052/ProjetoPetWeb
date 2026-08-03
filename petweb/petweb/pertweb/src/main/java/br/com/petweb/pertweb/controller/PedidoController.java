package br.com.petweb.pertweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.petweb.pertweb.entity.Cliente;
import br.com.petweb.pertweb.entity.Pedido;
import br.com.petweb.pertweb.entity.Produto;
import br.com.petweb.pertweb.service.ClienteService;
import br.com.petweb.pertweb.service.PedidoService;
import br.com.petweb.pertweb.service.ProdutoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("/pedidos")
public class PedidoController {
    
    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProdutoService produtoService;

    //Endpoit para salvar o pedido(JSON - pelo fatch)
    @PostMapping
    @ResponseBody
    public Pedido salvarPedido(@RequestBody Pedido pedido){
        return pedidoService.salvarPedido(pedido);
    }

    //Abrir a tela de cadastro de pedido
    @GetMapping("path")
    public String criarForm(Model model) {
        model.addAttribute("pedido", new Pedido());

        List<Cliente> clientes =  clienteService.findAll();
        model.addAttribute("clientes", clientes);

        List<Produto> produtos = produtoService.findAll();
        model.addAttribute("produtos", produtos);

        return "pedido/formularioPedido";
    }
    

}
