package modelo;

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
	private int id;

	@Column(name="idCliente")
	private int idCliente;

	@Column(name="dataPedido")
	private String dataPedido;

	@Column(name="dataViagem")
	private String dataViagem;

	public Pedido() {
	}

	public Pedido(int id, int idCliente, String dataPedido, String dataViagem) {
		this.id = id;
		this.idCliente = idCliente;
		this.dataPedido = dataPedido;
		this.dataViagem = dataViagem;
	}
}

