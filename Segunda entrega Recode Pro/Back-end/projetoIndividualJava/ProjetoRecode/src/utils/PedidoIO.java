package utils;

import dao.ItensPedidoDao;
import dao.PedidoDao;
import model.Cliente;
import model.Pedido;

import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;


public class PedidoIO {

    //Campo INPUT id cliente pedidos.
    public static int readIdOfPedido(Scanner scanner) {
        out.println("Informe o seu ID: ");
        return scanner.nextInt();
    }
    // pesquisa dados do pedidos por id.
    public void printPedidos(List<Pedido> pedidos) {

        out.println("---------------------------------");
        for (var pedidox : pedidos) {
            out.println(
                    "Id: " + pedidox.getNumPedido() +
                            "\nID CLiente: " + pedidox.getIdCLiente() +
                            "\nData Pedido: " + pedidox.getDataPedido() +
                            "\nData Viagem: " + pedidox.getDataViagem()

            );
            out.println("---------------------------------");
        }
    }

    // Menu pedido.
    public static void pedidoIo(Scanner entrada) {
        PedidoDao dao = new PedidoDao();
        PedidoIO pedidoIO = new PedidoIO();
        Cliente cliente = new Cliente();
        ItensPedidoDao itemdao = new ItensPedidoDao();


        int op;
        System.out.println("==========PEDIDOS==========");
        System.out.println(
                "1 - Realizar Pedido" +
                        "\n2 - Atualizar meus pedido" +
                        "\n3 - Consultar meus pedido" +
                        "\n4 - Excluir pedido"
        );
        op = entrada.nextInt();

        switch(op) {
            case 1 :

                Pedido pedido = new Pedido();
                System.out.println("Id Cliente: ");
                pedido.setIdCLiente(entrada.nextInt());
                out.println("Data pedido: ");
                pedido.setDataPedido(entrada.next());
                out.println("Data viagem: ");
                pedido.setDataViagem(entrada.next());
                dao.create(pedido);


                break;

            case 2:

                Pedido pedidoToUpdate = new Pedido();
                out.println("Id pedido: ");
                pedidoToUpdate.setNumPedido(entrada.nextInt());
                out.println("Atualize a data do pedido");
                pedidoToUpdate.setDataPedido(entrada.next());
                out.println("Informe nova data para viagem: ");
                pedidoToUpdate.setDataViagem(entrada.next());
                dao.update(pedidoToUpdate);
                break;

            case 3:
                pedidoIO.printPedidos(dao.findByPk(readIdOfPedido(entrada)));

                break;

            case 4:
                System.out.println("Digite o Id do Pedido a ser excluido: ");
                dao.removeById(Integer.parseInt(entrada.next()));
                break;

        }

    }
}
