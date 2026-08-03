package br.com.petweb.pertweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.petweb.pertweb.entity.Produto;

public interface ProdutoRepository extends JpaRepository <Produto, Integer> {
    
}
