package dao;

import java.util.List;

import model.Pedido;

public interface CrudPedido {
	public static void create(Pedido pedido){}
	
	public static void delete(int PedidoId){}
	
	public static List<Pedido> find(String pesquisa){return null;}
	
	public static Pedido findByPk(int pedidoId) {return null;}
	
	public static void update(Pedido pedido) {}
	
	

}
