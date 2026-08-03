package br.com.petweb.pertweb.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//gera numeros aleatorios
    private Integer idAnimal;

    @Column(nullable = false, length = 40)
    private String nomeAnimal;

    @Column(nullable = false, length = 40)
    private String racaAnimal;

    @Column(nullable = false, length = 20)
    private String porteAnimal;

    @Column(nullable = false, length = 50)
    private Double pesoAnimal;

    @ManyToOne
    @JoinColumn(name= "idCliente_fk")
    private Cliente cliente;
    
}
