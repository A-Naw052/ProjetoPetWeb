package br.com.petweb.pertweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.petweb.pertweb.repository.ProdutoRepository;
import br.com.petweb.pertweb.entity.Produto;

@Service
public class ProdutoService {

    //injeção de dependência do repositorio
    @Autowired
    private ProdutoRepository produtoRepository;

    //Metodo para salvar um produto
    public Produto save(Produto produto){
        return produtoRepository.save(produto);
    }

    //Metodo para listar os produtos
    public List<Produto> findAll(){
        return produtoRepository.findAll();
    }
    
    //Método para encontar um produto
    public Produto findById(Integer id){
        return produtoRepository.findById(id).orElse(null);
    }

    //Método para excluir um produto
    public void deleteById(Integer id){
        produtoRepository.deleteById(id);
    }

}
