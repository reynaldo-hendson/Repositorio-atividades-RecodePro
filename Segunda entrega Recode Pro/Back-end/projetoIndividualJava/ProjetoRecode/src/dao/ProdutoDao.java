package dao;

import connectionFactory.ConnectionFactory;
import model.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDao {

    private Connection connection;

    public ProdutoDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    // Criar (insert).
    public void create(Produto produto) {
        String sql = "INSERT INTO produto VALUES(null,?,?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            //Numero representa a coluna.
            stmt.setString(1, produto.getDescricao());
            stmt.setDouble(2, produto.getValorUnit());
            stmt.execute();

            System.out.println("Cadastro produto realizado.");
            stmt.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // Update nos dados.
    public void update(Produto produto) {
        String sql = "UPDATE produto SET Descricao = ?, valorUnit = ? WHERE IdProduto = ?";

        try {
            PreparedStatement utmt = connection.prepareStatement(sql);
            utmt.setString(1, produto.getDescricao());
            utmt.setDouble(2,produto.getValorUnit());
            utmt.setInt(3, produto.getIdProduto());//getID
            utmt.executeUpdate();

            System.out.println("Atualizacao realizada com sucesso.");
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    // Delete dados cliente por ID..
    public void removeById(int IdProduto) {
        String sql = "DELETE FROM produto WHERE IdProduto = ?";
        try {
            PreparedStatement dtmt = connection.prepareStatement(sql);
            dtmt.setInt(1, IdProduto);
            dtmt.execute();

            System.out.println("Produto deletado.");
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   // Mostra todos os pacotes
    public List<Produto> findAll() {
        String sql = "SELECT IdProduto, descricao , ValorUnit from produto";

        try {
            Statement statement = this.connection.createStatement();
            var result = statement.executeQuery(sql);
            List<Produto> produts = new ArrayList<>();

            while (result.next()) {
                Produto client = new Produto();

                client.setIdProduto(result.getInt("IdProduto"));
                client.setDescricao(result.getString("descricao"));
                client.setValorUnit(result.getDouble("ValorUnit"));
                produts.add(client);
            }
            System.out.println("[LOG] Query all Product in database.");
            return produts;

        } catch (SQLException e) {
            System.out.printf("[ERROR] Cant query all Product in database. Message:\n%s", e.getMessage());
            return null;
        }
    }


}
