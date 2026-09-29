package br.com.petweb.pertweb.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.petweb.pertweb.entity.Cliente;
import br.com.petweb.pertweb.entity.ItemDoPedido;
import br.com.petweb.pertweb.entity.Pedido;
import br.com.petweb.pertweb.entity.Produto;
import br.com.petweb.pertweb.repository.ClienteRepository;
import br.com.petweb.pertweb.repository.PedidoRepository;
import br.com.petweb.pertweb.repository.ProdutoRepository;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    public void deleteById(Integer id) {
        pedidoRepository.deleteById(id);
    }

    @Transactional
    public Pedido salvarPedido(Pedido pedido) {
        pedido.setDataPedido(LocalDate.now());

        // Busca o cliente completo no banco
        if (pedido.getCliente() != null && pedido.getCliente().getIdCliente() != null) {
            Cliente cliente = clienteRepository.findById(pedido.getCliente().getIdCliente())
                    .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
            pedido.setCliente(cliente);
        }

        // Processa os itens do pedido
        if (pedido.getItens() != null) {
            for (ItemDoPedido item : pedido.getItens()) {
                Produto produto = produtoRepository.findById(item.getProduto().getIdProduto())
                        .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

                item.setProduto(produto);
                item.setPreco(produto.getValorProduto());
                item.atualizarSubtotal();
                item.setPedido(pedido);
            }
        }

        pedido.atualizarTotal();
        return pedidoRepository.save(pedido);
    }
}