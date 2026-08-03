package br.com.petweb.pertweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.petweb.pertweb.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
    
}
