package br.com.petweb.pertweb.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.petweb.pertweb.repository.PedidoRepository;
import br.com.petweb.pertweb.repository.ProdutoRepository;
import br.com.petweb.pertweb.entity.ItemDoPedido;
import br.com.petweb.pertweb.entity.Pedido;
import br.com.petweb.pertweb.entity.Produto;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    //Metodo para salvar um pedido
    public Pedido salvarPedido(Pedido pedido){
        pedido.setDataPedido(LocalDate.now());

        for(ItemDoPedido item : pedido.getItens()){
            Produto produto = produtoRepository.findById(item.getProduto().getIdProduto()).
            orElseThrow(() -> new RuntimeException("Produto nâo encontrado"));
            
            item.setProduto(produto);
            item.setPreco(produto.getValorProduto());
            item.atualizarSubtotal();
            item.setPedido(pedido);
        }

        pedido.atualizarTotal();
        return pedidoRepository.save(pedido);
    }


}
