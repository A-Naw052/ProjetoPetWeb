package br.com.petweb.pertweb.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Integer idPedido;

    @Column(nullable = false, length = 10)
    private LocalDate dataPedido;

    @Column(nullable = false, length = 30)
    private Double totalPedido;

    //Relacionamento com Cliente 
    @ManyToOne 
    @JoinColumn(name = "idCliente_fk")
    private Cliente cliente;

    //Relacionamento com Itens 
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItemDoPedido> itens;

    //Metodo para calcular o total
    public Double calcularTotal(){
        Double total = 0.0;
        if (itens != null) { //se eu coloquei alguma coisa na lista
            for(ItemDoPedido item : itens){ //para cada item na lista do pedido vai pegar o subtoal e vai soma com o valor da conta
                total += item.getSubtotal();
            }
        }
        return total;
    }

    //Metodo para atualizar o total 
    public void atualizarTotal(){
        this.totalPedido = calcularTotal();
    }
}
