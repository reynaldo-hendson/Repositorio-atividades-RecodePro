package model;


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
    private long id;

    @Column(name ="idPedido")
    private long idPedido;

    @Column(name="quantidade")
    private long quantidade;

    @Column(name="idProduto")
    private long idProduto;

    public ItensPedido() {
    }

    public ItensPedido(long id, long idPedido, long quantidade, long idProduto) {
        this.id = id;
        this.idPedido = idPedido;
        this.quantidade = quantidade;
        this.idProduto = idProduto;
    }
}