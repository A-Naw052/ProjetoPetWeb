package br.com.petweb.pertweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.petweb.pertweb.entity.ItemDoPedido;

public interface ItemDoPedidoRepository extends JpaRepository <ItemDoPedido, Integer> {
    
}
