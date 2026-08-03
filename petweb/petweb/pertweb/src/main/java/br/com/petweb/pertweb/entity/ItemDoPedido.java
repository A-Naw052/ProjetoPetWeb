package br.com.petweb.pertweb.entity;

import java.time.LocalDate;

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

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ItemDoPedido {
    
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Integer IdItem;

    @Column(nullable = false, length = 10)
    private Integer quantidade;

    @Column(nullable = false, length = 25)
    private Double preco;

    @Column(nullable = false, length = 25)
    private Double subtotal;

    //Metodo calcular subtotal
    public Double calcularSubtotal(){
        return quantidade * preco;
    }

    //Metodo para atualizar subtotal
    public void atualizarSubtotal() {
        this.subtotal = calcularSubtotal();
        
    }
    
    //Relacionamento com Pedido
    @ManyToOne
    @JoinColumn(name = "IdPedido_fk")
    private Pedido pedido;

    //Relacionamento com Produto
    @ManyToOne
    @JoinColumn(name = "IdProduto_fk")
    private Produto produto;


}
    
