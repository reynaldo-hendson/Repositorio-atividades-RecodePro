package modelo;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="itensPedido")
public class ItensPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name ="idPedido")
    private int idPedido;

    @Column(name="quantidade")
    private int quantidade;

    @Column(name="idProduto")
    private int idProduto;

    public ItensPedido() {
    }

    public ItensPedido(int id, int idPedido, int quantidade, int idProduto) {
        this.id = id;
        this.idPedido = idPedido;
        this.quantidade = quantidade;
        this.idProduto = idProduto;
    }
}