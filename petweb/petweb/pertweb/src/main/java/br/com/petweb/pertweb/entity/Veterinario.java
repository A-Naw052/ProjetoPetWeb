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
@Table(name = "veterinario") //muda o nome da tabela q vai ser criada la no banco
public class Veterinario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//gera numeros aleatorios
    private Integer idVeterinario;

    @Column(nullable = false, length = 40)
    private String nomeVeterinario;

    @Column(nullable = false, length = 14)
    private String cpfVeterinario;

    @Column(nullable = false, length = 15)
    private String telefoneVeterinario;

    @Column(nullable = false)
    private String crmvVeterinario;

    @Column(nullable = false, length = 20)
    private String especialidadeVeterinario;
}
