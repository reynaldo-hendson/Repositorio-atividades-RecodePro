package model;

public class Pedido {
	private int NumPedido;
	private int IdCLiente;
	private String dataPedido;
	private String dataViagem;

	public Pedido() {

	}

	public Pedido(int numPedido, int idCLiente, String dataPedido, String dataViagem) {
		this.NumPedido = numPedido;
		this.IdCLiente = idCLiente;
		this.dataPedido = dataPedido;
		this.dataViagem = dataViagem;
	}

	public int getNumPedido() {
		return NumPedido;
	}

	public void setNumPedido(int numPedido) {
		NumPedido = numPedido;
	}

	public int getIdCLiente() {
		return IdCLiente;
	}

	public void setIdCLiente(int idCLiente) {
		IdCLiente = idCLiente;
	}

	public String getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(String dataPedido) {
		this.dataPedido = dataPedido;
	}

	public String getDataViagem() {
		return dataViagem;
	}

	public void setDataViagem(String dataViagem) {
		this.dataViagem = dataViagem;
	}

	@Override
	public String toString() {
		return "Pedido{" +
				"NumPedido=" + NumPedido +
				", IdCLiente=" + IdCLiente +
				", dataPedido='" + dataPedido + '\'' +
				", dataViagem='" + dataViagem + '\'' +
				'}';
	}
}