package br.com.example.backendAgency.demo.modelo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idProduto;

    @Column(name="descricao")
    private String descricao;

    @Column(name="valor")
    private String valor;

    public Produto() {
    }

    public Produto(long idProduto, String descricao, String valor) {
        this.idProduto = idProduto;
        this.descricao = descricao;
        this.valor = valor;
    }
}
