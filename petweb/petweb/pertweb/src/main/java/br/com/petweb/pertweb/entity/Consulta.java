package br.com.petweb.pertweb.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "consulta")
public class Consulta {
      
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//gera numeros aleatorios
    private Integer idConsulta;

    @Column(nullable = false)
    private LocalDate dataConsulta;

    @Column(nullable = false)
    private LocalTime horaConsulta;

    @Column(nullable = false, length = 30)
    private String obsConsulta;

    @Column(nullable = false)
    private Double valorConsulta;

    @Column(nullable = false, length = 30)
    private String diagnosticoConsulta;

    @Column(nullable = false, length = 30)
    private String tratamentoConsulta;

    @ManyToOne
    @JoinColumn(name = "idVeterinario_fk")
    private Veterinario veterinario;

    @ManyToOne
    @JoinColumn(name = "idAnimal_fk")
    private Animal animal;
}
