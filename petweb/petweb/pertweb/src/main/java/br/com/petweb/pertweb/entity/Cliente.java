package br.com.petweb.pertweb.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "cliente") //muda o nome da tabela q vai ser criada la no banco
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//gera numeros aleatorios
    private Integer idCliente;

    @Column(nullable = false, length = 40)
    private String nomeCliente;

    @Column(nullable = false, length = 100)
    private String emailCliente;

    @Column(nullable = false, length = 15)
    private String telefoneCliente;

    @Column(nullable = false, length = 50)
    private String enderecoCliente;

    @Column(nullable = false, length = 14)
    private String cpfCliente;
}
