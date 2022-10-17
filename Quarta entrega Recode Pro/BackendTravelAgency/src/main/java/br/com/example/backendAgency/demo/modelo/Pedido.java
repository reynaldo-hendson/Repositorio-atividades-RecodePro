package br.com.example.backendAgency.demo.modelo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@Table(name="pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name="idCliente")
	private long idCliente;

	@Column(name="dataPedido")
	private String dataPedido;

	@Column(name="dataViagem")
	private String dataViagem;

	public Pedido() {
	}

	public Pedido(long id, long idCliente, String dataPedido, String dataViagem) {
		this.id = id;
		this.idCliente = idCliente;
		this.dataPedido = dataPedido;
		this.dataViagem = dataViagem;
	}
}

