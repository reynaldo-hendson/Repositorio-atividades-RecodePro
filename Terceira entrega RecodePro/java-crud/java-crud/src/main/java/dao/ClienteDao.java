package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.MySqlConnection;
import model.Cliente;

public class ClienteDao implements CrudCliente{
	
	private static Connection connection = MySqlConnection.createConnection();
	private static String sql;
	
	
	public static void create(Cliente cliente) {
		sql = "INSERT into clientes VALUES(null,?,?,?,?)";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, cliente.getNome());
			preparedStatement.setString(2, cliente.getCpf());
			preparedStatement.setString(3, cliente.getNascimento());
			preparedStatement.setString(4, cliente.getSituacao());
			
			preparedStatement.executeUpdate();
			
			System.out.println("--Correct insert on database");
			
		}catch(SQLException e){
			System.out.println("--Incorrect insert on database" + e.getMessage());
			
		}
		
	}
	
	public static void delete(int ClienteId) {
		sql = "DELETE FROM clientes WHERE id= ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, ClienteId);
			preparedStatement.executeUpdate();
			
			System.out.println("--correct delete on cliente");
			
		}catch(SQLException e){
			
			System.out.println("--incorrect delete on cliente"+ e.getMessage());
			
			
		}
		
		
	}
	
	public static List<Cliente> find(String pesquisa){
		
		sql = String.format("SELECT * FROM clientes WHERE nome LIKE '%s%%' OR cpf LIKE '%s%%' ", pesquisa,pesquisa);
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				Cliente cliente = new Cliente();
				
				cliente.setId(resultSet.getInt("id"));
				cliente.setNome(resultSet.getString("nome"));
				cliente.setCpf(resultSet.getString("cpf"));
				cliente.setNascimento(resultSet.getString("nascimento"));
				cliente.setSituacao(resultSet.getString("situacao"));
				
				clientes.add(cliente);
						
			}
			System.out.println("--Correct find clientes. ");
			return clientes;
			
		}catch(SQLException e){
			System.out.println("--Incorrect fin clientes" + e.getMessage());
			return null;
			
		}
		
		
		
	}
	
	public static Cliente findByPk(int clienteId) {
		sql = String.format("SELECT * FROM clientes WHERE id= %d",clienteId);
				
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			Cliente cliente = new Cliente();
			
			while(resultSet.next()) {
				
				cliente.setId(resultSet.getInt("id"));
				cliente.setNome(resultSet.getString("nome"));
				cliente.setCpf(resultSet.getString("cpf"));
				cliente.setNascimento(resultSet.getString("nascimento"));
				cliente.setSituacao(resultSet.getString("situacao"));
			}
			
			System.out.println("--Correct find by pk clientes. ");
			return cliente;
			
		}catch(SQLException e){
			
			System.out.println("--Incorrect fin clientes" + e.getMessage());
			return null;
			
		}
		
		
		
		
		
	}
	public static void update(Cliente cliente) {
		sql = "UPDATE clientes SET nome=?, cpf=?, nascimento=?, situacao=? WHERE id=?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, cliente.getNome());
			preparedStatement.setString(2, cliente.getCpf());
			preparedStatement.setString(3, cliente.getNascimento());
			preparedStatement.setString(4, cliente.getSituacao());
			preparedStatement.setInt(5, cliente.getId());
			
			preparedStatement.executeUpdate();
			
			System.out.println("--Correct update on database");
			
		}catch(SQLException e){
			System.out.println("--Incorrect update on database" + e.getMessage());
			
		}
		
	}
	
	

}
