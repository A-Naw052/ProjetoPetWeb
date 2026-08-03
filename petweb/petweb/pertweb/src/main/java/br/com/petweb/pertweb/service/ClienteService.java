package br.com.petweb.pertweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.petweb.pertweb.entity.Cliente;
import br.com.petweb.pertweb.repository.ClienteRepository;

@Service
public class ClienteService {
    
    //injeção de dependência do repositorio de clientes 
    @Autowired
    private ClienteRepository clienteRepository;

    //Metodo para salvar um cliente 
    public Cliente save(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    //Metodo para listar os clientes
    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }

    //Método para excluir um cliente por id
    public void deleteById(Integer id){
        clienteRepository.deleteById(id);
    }

    //Método para encontar um cliente por id
    public Cliente findById(Integer id){
        return clienteRepository.findById(id).orElse(null);
    }
}
