package utils;

import dao.ItensPedidoDao;
import dao.ProdutoDao;
import model.Cliente;
import model.ItensPedido;
import model.Produto;

import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

public class ItensPedidoIO {

    //Campo INPUT id cliente pedidos.
    public static int readIdOfItem(Scanner scanner) {
        out.println("Informe o ID item: ");
        return scanner.nextInt();
    }

    // pesquisa dados do pedidos por id.
    public void printItem(List<ItensPedido> itens) {

        out.println("---------------------------------");
        for (var pedidox : itens) {
            out.println(
                    "Id: " + pedidox.getIdItem() +
                            "\nNum.Pedido: " + pedidox.getNumpedido() +
                            "\nId Produto: " + pedidox.getIdProduto() +
                            "\nQuantidade: " + pedidox.getQuantidade()

            );
            out.println("---------------------------------");
        }
    }

    // Menu pedido.
    public static void itemPedidoIo(Scanner entrada) {
        ItensPedidoIO itemIo = new ItensPedidoIO();
        Cliente cliente = new Cliente();
        ItensPedidoDao itemdao = new ItensPedidoDao();
        ProdutoDao dao = new ProdutoDao();
        Produto produto = new Produto();
        ProdutoIO produtoIO = new ProdutoIO();

        int op;
        System.out.println("==========Itens Pedido==========");
        System.out.println(
                "1 - Incluir item no Pedido" +
                        "\n2 - Atualizar itens no pedido" +
                        "\n3 - Consultar itens no pedido" +
                        "\n4 - Excluir item"
        );
        op = entrada.nextInt();

        switch (op) {
            case 1:


                ItensPedido pedido = new ItensPedido();
                System.out.println("Num.Pedido: ");
                pedido.setNumpedido(entrada.nextInt());

                //Exibe todos os pacotes disponiveis
                out.println("--------------------Pacotes disponiveis------------------");
                produtoIO.printProduto(dao.findAll());
                out.println("------Escolha o seu pacote pelo ID------");

                out.println("Id Produto: ");
                pedido.setIdProduto(entrada.nextInt());
                out.println("Quantidade: ");
                pedido.setQuantidade(entrada.nextDouble());
                itemdao.create(pedido);


                break;

            case 2:

                ItensPedido itemToUpdate = new ItensPedido();
                out.println("IdItem");
                itemToUpdate.setIdItem(entrada.nextInt());
                out.println("Id Produto");
                itemToUpdate.setIdProduto(entrada.nextInt());
                out.println("Quantidade: ");
                itemToUpdate.setQuantidade(entrada.nextDouble());
                itemdao.update(itemToUpdate);
                break;

            case 3:
                itemIo.printItem(itemdao.findByPk(readIdOfItem(entrada)));

                break;

            case 4:
                System.out.println("Digite o Id do item a ser excluido: ");
                itemdao.removeById(Integer.parseInt(entrada.next()));
                break;


        }

    }
}
