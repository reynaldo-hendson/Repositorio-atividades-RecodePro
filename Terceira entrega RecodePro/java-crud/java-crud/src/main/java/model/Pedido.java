package model;

public class Pedido {
	private int id;
	private int idCliente;
	private String quantidade;
	private String idProduto;
	private String dataPedido;
	private String dataViagem;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}
	public String getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
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
		return "Pedido [id=" + id + ", idCliente=" + idCliente + ", quantidade=" + quantidade + ", idProduto="
				+ idProduto + ", dataPedido=" + dataPedido + ", dataViagem=" + dataViagem + "]";
	}

	
}