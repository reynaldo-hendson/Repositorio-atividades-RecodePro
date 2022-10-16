package modelo;

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
    private int idProduto;

    @Column(name="descricao")
    private String descricao;

    @Column(name="valor")
    private String valor;

    public Produto() {
    }

    public Produto(int idProduto, String descricao, String valor) {
        this.idProduto = idProduto;
        this.descricao = descricao;
        this.valor = valor;
    }
}
