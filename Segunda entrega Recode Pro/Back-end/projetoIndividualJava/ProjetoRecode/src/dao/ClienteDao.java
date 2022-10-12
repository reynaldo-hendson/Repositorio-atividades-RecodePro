package dao;

import connectionFactory.ConnectionFactory;
import model.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao {

	private Connection connection;

	public ClienteDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	// Criar (insert).
	public void create(Cliente cliente) {
		String sql = "INSERT INTO cliente VALUES(null,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			//Numero representa a coluna.
			stmt.setString(1, cliente.getNomeCliente());
			stmt.setString(2, cliente.getCidade());
			stmt.setString(3, cliente.getUf());
			stmt.setString(4, cliente.getCep());
			stmt.setString(5, cliente.getCpf());
			stmt.setString(6, cliente.getLogadouro());
			stmt.setString(7, cliente.getTelefoneCelular());
			stmt.setString(8, cliente.getDataCadastro());
			stmt.execute();

			System.out.println("Cadastro cliente realizado.");
			stmt.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// Update nos dados.
	public void update(Cliente cliente) {
		String sql = "UPDATE cliente SET nomeCliente = ? , cidade = ?,uf = ?, cep = ?, cpf = ?, logadouro = ? , telefoneCelular = ?, dataCadastro = ? WHERE cpf = ?";

		try {
			PreparedStatement utmt = connection.prepareStatement(sql);
			utmt.setString(1, cliente.getNomeCliente());
			utmt.setString(2, cliente.getCidade());
			utmt.setString(3, cliente.getUf());
			utmt.setString(4, cliente.getCep());
			utmt.setString(5, cliente.getCpf());
			utmt.setString(6, cliente.getLogadouro());
			utmt.setString(7, cliente.getTelefoneCelular());
			utmt.setString(8, cliente.getDataCadastro());
			utmt.setString(9, cliente.getCpf());//getID
			utmt.executeUpdate();

			System.out.println("Contato atualizado.");
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	// Delete dados cliente por ID..
	public void removeById(int IdCliente) {
		String sql = "DELETE FROM cliente WHERE IdCliente = ?";
		try {
			PreparedStatement dtmt = connection.prepareStatement(sql);
			dtmt.setInt(1, IdCliente);
			dtmt.execute();

			System.out.println("Cliente deletado.");
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Lista os todos os dados da tabela vai para o menu ADMIN.

	public ResultSet getClientes() throws SQLException {
		String sql = "SELECT * FROM Cliente";
		Statement stmt = null;
		ResultSet resultado = null;
		try {
			stmt = connection.createStatement();
			resultado = stmt.executeQuery(sql);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return resultado;

	}

	//Select por ID.
	// int  IdCliente
	public List<Cliente> findByPk(String cpf) {
		//voltar para IdCliente
		String sql = "SELECT * FROM cliente WHERE cpf = ?";

		try {
			PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
			preparedStatement.setString(1, cpf);//setString IdCliente
			var result = preparedStatement.executeQuery();
			List<Cliente> clients = new ArrayList<>();

			while (result.next()) {
				Cliente client = new Cliente();
				client.setCpf(cpf);//SetInt IdCliente.
				client.setId(result.getInt("IdCliente"));
				client.setNomeCliente(result.getString("NomeCliente"));
				client.setCidade(result.getString("Cidade"));
				client.setUf(result.getString("Uf"));
				client.setCep(result.getString("Cep"));
				client.setCpf(result.getString("Cpf"));
				client.setLogadouro(result.getString("Logadouro"));
				client.setTelefoneCelular(result.getString("TelefoneCelular"));
				client.setDataCadastro(result.getString("DataCadastro"));
				clients.add(client);
			}

			System.out.println("[LOG] Query one Client in database.");
			return clients;

		} catch (SQLException e) {
			System.out.printf("[ERROR] Cant query one Client in database. Message:\n%s", e.getMessage());
			return null;
		}
}



}

