package br.com.petweb.pertweb.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteAnimalDTO {
    
    private String nomeCliente;
    private String telefoneCliente;
    private String nomeAnimal;
}
