package dao;

import connectionFactory.ConnectionFactory;
import model.Pedido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PedidoDao {
		
	private Connection connection;
		
		public PedidoDao() {
			this.connection = new ConnectionFactory().getConnection();
		}
		
		// Criar (insert).
		public void create (Pedido pedido) {
			String sql = "INSERT INTO pedido VALUES(null,?,?,?)";
			
			try {
				PreparedStatement stmt = connection.prepareStatement(sql);
				
				//Numero representa a coluna.
				stmt.setInt(1, pedido.getIdCLiente());
				stmt.setString(2, pedido.getDataPedido());
				stmt.setString(3, pedido.getDataViagem());
				stmt.execute();
				
				System.out.println("Pedido realizado.");
				stmt.close(); 
				connection.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		}
		
		// Update nos dados.
		public void update (Pedido pedido) {
			String sql = "UPDATE pedido SET dataPedido = ?, dataViagem = ? WHERE NumPedido = ?";
			
			try {
				PreparedStatement utmt = connection.prepareStatement(sql);
				utmt.setString(1, pedido.getDataPedido());
				utmt.setString(2, pedido.getDataViagem());
				utmt.setInt(3, pedido.getNumPedido());
				utmt.executeUpdate();
				
				System.out.println("Dados atualizados.");
				connection.close();
				
			}
			catch(Exception e){
				e.printStackTrace();
				
			}
		}
		// Delete pedido por id.
		public void removeById(int NumPedido) {
			String sql = "DELETE FROM pedido WHERE NumPedido = ?";
			try {
				PreparedStatement dtmt = connection.prepareStatement(sql);
				dtmt.setInt(1, NumPedido);
				dtmt.execute();
				
				System.out.println("Pedido excluido");
				connection.close();
			}
			catch (Exception e){
				e.printStackTrace();
			}
		}
		// lista pedidos do cliente especifico pelo ID.
		public List<Pedido> findByPk(int IdCliente) {
			//voltar para IdCliente
			String sql = "SELECT * FROM pedido WHERE IdCliente = ?";

			try {
				PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
				preparedStatement.setInt(1, IdCliente);//setString IdCliente
				var result = preparedStatement.executeQuery();
				List<Pedido> pedidos = new ArrayList<>();

				while (result.next()) {
					Pedido client = new Pedido();
					client.setIdCLiente(IdCliente);//SetInt IdCliente.
					client.setNumPedido(result.getInt("NumPedido"));
					client.setDataPedido(result.getString("dataPedido"));
					client.setDataViagem(result.getString("dataViagem"));
					pedidos.add(client);
				}

				System.out.println("[LOG] Query pedido in database.");
				return pedidos;

			} catch (SQLException e) {
				System.out.printf("[ERROR] Cant query pedido in database. Message:\n%s", e.getMessage());
				return null;
			}
		}

	public List<Pedido> findAll() {
		String sql = "SELECT NumPedido, IdCliente , dataPedido, dataViagem from pedido";

		try {
			Statement statement = this.connection.createStatement();
			var result = statement.executeQuery(sql);
			List<Pedido> produts = new ArrayList<>();

			while (result.next()) {
				Pedido client = new Pedido();

				client.setNumPedido(result.getInt("NumPedido"));
				client.setIdCLiente(result.getInt("IdCliente"));
				client.setDataPedido(result.getString("DataPedido"));
				client.setDataViagem(result.getString("DataViagem"));
				produts.add(client);
			}
			System.out.println("[LOG] Query all request in database.");
			return produts;

		} catch (SQLException e) {
			System.out.printf("[ERROR] Cant query all resquest in database. Message:\n%s", e.getMessage());
			return null;
		}
	}
}
