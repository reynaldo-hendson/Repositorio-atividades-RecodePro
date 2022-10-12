package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.MySqlConnection;
import model.Produto;

public class ProdutoDao implements CrudProduto{

	private static Connection connection = MySqlConnection.createConnection();
	private static String sql;
	
	
	public static void create(Produto  produto) {
		sql = "INSERT into produto VALUES(null,?,?)";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, produto.getDescricao());
			preparedStatement.setDouble(2, produto.getValor());
			
			preparedStatement.executeUpdate();
			
			System.out.println("--Correct insert on database");
			
		}catch(SQLException e){
			System.out.println("--Incorrect insert on database" + e.getMessage());
			
		}
		
	}
	
	public static void delete(int ProdutoId) {
		sql = "DELETE FROM clientes WHERE id= ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, ProdutoId);
			preparedStatement.executeUpdate();
			
			System.out.println("--correct delete on product");
			
		}catch(SQLException e){
			
			System.out.println("--incorrect delete on product"+ e.getMessage());
			
			
		}
		
		
	}
	
	public static List<Produto> find(String pesquisa){
		
		sql = String.format("SELECT * FROM produto WHERE descricao LIKE '%s%%' ", pesquisa);
		List<Produto> produto = new ArrayList<Produto>();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				
				Produto produtos = new Produto();
				
				produtos.setId(resultSet.getInt("id"));
				produtos.setDescricao(resultSet.getString("descricao"));
				produtos.setValor(resultSet.getDouble("valor"));
						
				produto.add(produtos);
						
			}
			System.out.println("--Correct find destiny. ");
			return produto;
			
		}catch(SQLException e){
			System.out.println("--Incorrect find destiny" + e.getMessage());
			return null;
			
		}
		
		
		
	}
	
	public static Produto findByPk(int produtoId) {
		sql = String.format("SELECT * FROM produto WHERE id= %d",produtoId);
				
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			Produto produto = new Produto();
			
			while(resultSet.next()) {
				
				produto.setId(resultSet.getInt("id"));
				produto.setDescricao(resultSet.getString("descricao"));
				produto.setValor(resultSet.getDouble("valor"));
						
			}
			
			System.out.println("--Correct find by pk destiny. ");
			return produto;
			
		}catch(SQLException e){
			
			System.out.println("--Incorrect find destiny" + e.getMessage());
			return null;
			
		}	
		
	}
	
	public static void update(Produto produto) {
		sql = "UPDATE produto SET descricao=?, valor=? WHERE id=?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, produto.getDescricao());
			preparedStatement.setDouble(2, produto.getValor());
			preparedStatement.setInt(3, produto.getId());
			
			preparedStatement.executeUpdate();
			
			System.out.println("--Correct update on database");
			
		}catch(SQLException e){
			System.out.println("--Incorrect update on database" + e.getMessage());
			
		}
		
	}
	
	

}
