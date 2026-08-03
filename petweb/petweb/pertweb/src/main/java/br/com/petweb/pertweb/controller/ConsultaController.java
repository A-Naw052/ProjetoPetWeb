package br.com.petweb.pertweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.petweb.pertweb.entity.Consulta;
import br.com.petweb.pertweb.service.ConsultaService;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/consultas")
public class ConsultaController {
    

    //Injeção de dependência da service de consultas 
    @Autowired
    private ConsultaService consultaService;

    //Método para salvar consulta
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Consulta consulta){
        consultaService.save(consulta);
        return "redirect:/consultas/listar";
    }

    //Método paa listar todos os consultas
    @GetMapping("/listar")
    public String listar(Model model){
        List<Consulta> consultas = consultaService.findAll();
        model.addAttribute("consulta", consultas);
        return "consulta/listarConsulta";
    }

    //Método para exibir o formulário de cadastro de consulta
    @GetMapping("/criar")
    public String criar(Model model){
        model.addAttribute("consulta", new Consulta());
        return "consulta/formularioConsulta";
    }

    //Método para excluir um Consulta
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Integer id) {
        consultaService.deleteById(id);
        return "redirect:/consultas/listar";
    }
    
    // Método para exibir o formulário de edição do consultas
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        Consulta consulta = consultaService.findById(id);
        model.addAttribute("consulta", consulta);
        return "consulta/formularioConsulta";
    }
    

}
