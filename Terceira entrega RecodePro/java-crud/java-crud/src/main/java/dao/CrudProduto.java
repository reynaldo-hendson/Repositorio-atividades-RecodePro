package dao;

import java.util.List;

import model.Produto;

public interface CrudProduto {
	
	public static void create(Produto produto){}
	
	public static void delete(int produtoId){}
	
	public static List<Produto> find(String pesquisa){return null;}
	
	public static Produto findByPk(int produtoId) {return null;}
	
	public static void update(Produto produto) {}

}
