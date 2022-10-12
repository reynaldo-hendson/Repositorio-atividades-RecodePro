package dao;

import java.util.List;

import model.Cliente;

public interface CrudCliente {
	public static void create(Cliente cliente){}
	
	public static void delete(int ClienteId){}
	
	public static List<Cliente> find(String pesquisa){return null;}
	
	public static Cliente findByPk(int clienteId) {return null;}
	
	public static void update(Cliente cliente) {}
}
