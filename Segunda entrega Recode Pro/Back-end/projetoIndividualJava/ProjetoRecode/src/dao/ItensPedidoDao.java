package dao;

import connectionFactory.ConnectionFactory;
import model.ItensPedido;
import model.Pedido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ItensPedidoDao {

    private Connection connection;

    public ItensPedidoDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    // Criar (insert).
    public void create (ItensPedido itemPedido) {
        String sql = "INSERT INTO itensPedido VALUES(null,?,?,?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            //Numero representa a coluna.
            stmt.setInt(1, itemPedido.getNumpedido());
            stmt.setInt(2, itemPedido.getIdProduto());
            stmt.setDouble(3, itemPedido.getQuantidade());
            stmt.execute();

            System.out.println("Itens adicionados.");
            stmt.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // Update nos dados.
    public void update (ItensPedido itemPedido) {
        String sql = "UPDATE itensPedido SET idProduto = ?, quantidade = ? WHERE IdItem = ?";

        try {
            PreparedStatement utmt = connection.prepareStatement(sql);
            utmt.setInt(1,itemPedido.getIdItem());
            utmt.setDouble(2, itemPedido.getQuantidade());
            utmt.setInt(3, itemPedido.getIdItem());
            utmt.execute();

            System.out.println("Itens atualizados.");
            connection.close();

        }
        catch(Exception e){
            e.printStackTrace();

        }
    }
    // Delete itenPedido por id.
    public void removeById(int IdItem) {
        String sql = "DELETE FROM ItensPedido WHERE IdItem = ?";
        try {
            PreparedStatement dtmt = connection.prepareStatement(sql);
            dtmt.setInt(1, IdItem);
            dtmt.execute();

            System.out.println("Item excluido");
            connection.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    // lista pedidos do cliente especifico pelo ID.
    public List<ItensPedido> findByPk(int IdItem) {
        //voltar para IdCliente
        String sql = "SELECT * FROM itensPedido WHERE IdItem = ?";

        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setInt(1, IdItem);
            var result = preparedStatement.executeQuery();
            List<ItensPedido> pedidos = new ArrayList<>();

            while (result.next()) {
                ItensPedido client = new ItensPedido();
                Pedido pedidoItem = new Pedido();

                client.setIdItem(IdItem);
                client.setIdItem(result.getInt("IdItem"));
                client.setNumpedido(result.getInt("NumPedido"));
                client.setIdProduto(result.getInt("idProduto"));
                client.setQuantidade(result.getInt("quantidade"));
                pedidos.add(client);
            }

            System.out.println("[LOG] Query item in database.");
            return pedidos;

        } catch (SQLException e) {
            System.out.printf("[ERROR] Cant query item in database. Message:\n%s", e.getMessage());
            return null;
        }
    }

    public List<ItensPedido> findAll() {
        String sql = "SELECT IdItem, NumPedido, IdProduto, Quantidade from ItensPedido";

        try {
            Statement statement = this.connection.createStatement();
            var result = statement.executeQuery(sql);
            List<ItensPedido> produts = new ArrayList<>();

            while (result.next()) {
                ItensPedido client = new ItensPedido();

                client.setIdItem(result.getInt("IdItem"));
                client.setNumpedido(result.getInt("NumPedido"));
                client.setIdProduto(result.getInt("IdProduto"));
                client.setQuantidade(result.getDouble("Quantidade"));
                produts.add(client);
            }
            System.out.println("[LOG] Query all Items in database.");
            return produts;

        } catch (SQLException e) {
            System.out.printf("[ERROR] Cant query all Items in database. Message:\n%s", e.getMessage());
            return null;
        }
    }
}








