package br.com.petweb.pertweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.petweb.pertweb.repository.ConsultaRepository;
import br.com.petweb.pertweb.entity.Consulta;


@Service
public class ConsultaService {

    //injeção de dependência do repositorio
    @Autowired
    private ConsultaRepository consultaRepository;

    //Metodo para salvar
    public Consulta save(Consulta consulta){
        return consultaRepository.save(consulta);
    }

    //Metodo para listar
    public List<Consulta> findAll(){
        return consultaRepository.findAll();
    }

    //Método para excluir
    public void deleteById(Integer id){
        consultaRepository.deleteById(id);
    }

    //Método para encontar
    public Consulta findById(Integer id){
        return consultaRepository.findById(id).orElse(null);
    }
}
