package utils;

import dao.ClienteDao;
import dao.ItensPedidoDao;
import dao.PedidoDao;
import dao.ProdutoDao;
import model.Cliente;
import model.ItensPedido;
import model.Pedido;
import model.Produto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static java.lang.System.out;

public class AdminIO {

    public static void menuAdminIo(Scanner entrada) {
        ClienteDao dao = new ClienteDao();
        PedidoDao pdao = new PedidoDao();
        PedidoIO pedidoIO = new PedidoIO();
        ItensPedidoDao itemdao = new ItensPedidoDao();
        ItensPedidoIO itemIo = new ItensPedidoIO();
        ProdutoDao prodao = new ProdutoDao();
        ProdutoIO produtoIO = new ProdutoIO();
        Produto produto = new Produto();

        System.out.println("==========Administrador==========");
        Scanner in = new Scanner(System.in);
        System.out.println("login> ");
        String login = in.nextLine();
        System.out.println("senha> ");
        String senha = in.nextLine();

        if (login.equals("admin") && senha.equals("admin")) {
            System.out.printf("Usuário %s logado com sucesso.", login);

            int op = 0;
            while (op >= 0 && op < 5) {
                entrada = new Scanner(System.in);

                out.println("\n------------------------------Menu Administrador--------------------------------");
                out.println(
                        "1 - Cliente" +
                                "\n2 - Pedidos" +
                                "\n3 - Item Pedido" +
                                "\n4 - Produto" +
                                "\n5 - Menu principal"
                );
                op = entrada.nextInt();
                if (op == 1) {

                    System.out.println("==========CLIENTE==========");
                    System.out.println(
                            "1 - Consultar lista de Clientes" +
                                    "\n2 - Atualizar dados Cliente" +
                                    "\n3 - Excluir conta de cliente"
                    );
                    op = entrada.nextInt();
                    switch (op) {
                        case 1:
                            try {
                                ResultSet resultado = dao.getClientes();
                                while (resultado.next()) {
                                    System.out.println(
                                            "ID Cliente: " + resultado.getInt(1) +
                                                    "\nNome Cliente:  " + resultado.getString(2) +
                                                    "\nCidade: " + resultado.getString(3) +
                                                    "\nUf: " + resultado.getString(4) +
                                                    "\nCep: " + resultado.getString(5) +
                                                    "\nCPF: " + resultado.getString(6) +
                                                    "\nLogadouro: " + resultado.getString(7) +
                                                    "\nTelefone: " + resultado.getString(8) +
                                                    "\nData de Cadastro: " + resultado.getString(9)
                                    );
                                    System.out.println("-------------------------------------------------------------");
                                }
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            break;

                        case 2:
                            Cliente clientToUpdate = new Cliente();
                            out.println("cpf: ");
                            String upCpf = entrada.next();
                            clientToUpdate.setCpf(upCpf);
                            out.println("Informe o nome Cliente: ");
                            clientToUpdate.setNomeCliente(entrada.next());
                            out.println("CPF: ");
                            clientToUpdate.setCpf(entrada.next());
                            out.println("Rua / Avenida / Traavessa:");
                            clientToUpdate.setLogadouro(entrada.next());
                            out.println("Cidade: ");
                            clientToUpdate.setCidade(entrada.next());
                            out.println("UF: ");
                            clientToUpdate.setUf(entrada.next());
                            out.println("Cep: ");
                            clientToUpdate.setCep(entrada.next());
                            out.println("Telefone: ");
                            clientToUpdate.setTelefoneCelular(entrada.next());
                            System.out.println("Data Cadastro: ");
                            clientToUpdate.setDataCadastro(entrada.next());
                            dao.update(clientToUpdate);

                            break;

                        case 3:
                            System.out.println("Digite o Id do cliente a ser excluido: ");
                            dao.removeById(Integer.parseInt(entrada.next()));
                            break;

                    }
                }
                if (op == 2) {
                    System.out.println("==========PEDIDOS==========");
                    System.out.println(
                            "1 - Consultar pedidos" +
                                    "\n2 - Atualizar pedidos" +
                                    "\n3 - Excluir pedido"
                    );
                    op = entrada.nextInt();

                    switch (op) {
                        case 1:
                            pedidoIO.printPedidos(pdao.findAll());
                            break;

                        case 2:
                            Pedido pedidoToUpdate = new Pedido();
                            out.println("Id pedido: ");
                            pedidoToUpdate.setNumPedido(entrada.nextInt());
                            out.println("Atualize a data do pedido");
                            pedidoToUpdate.setDataPedido(entrada.next());
                            out.println("Informe nova data para viagem: ");
                            pedidoToUpdate.setDataViagem(entrada.next());
                            pdao.update(pedidoToUpdate);
                            break;

                        case 3:
                            System.out.println("Digite o Id do Pedido a ser excluido: ");
                            dao.removeById(Integer.parseInt(entrada.next()));
                            break;

                    }
                }
                if (op == 3) {
                    System.out.println("==========Itens Pedido==========");
                    System.out.println(
                            "1 - Consulta Itens" +
                                    "\n2 - Atualizar itens no pedido" +
                                    "\n3 - Excluir item"
                    );
                    op = entrada.nextInt();

                    switch (op) {
                        case 1:
                            itemIo.printItem(itemdao.findAll());
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
                            System.out.println("Digite o Id do item a ser excluido: ");
                            itemdao.removeById(Integer.parseInt(entrada.next()));
                            break;
                    }
                }
                if (op == 4) {
                    System.out.println("==========Produtos==========");
                    System.out.println(
                            "1 - Incluir Produto" +
                                    "\n2 - Atualizar Produto" +
                                    "\n3 - Consultar Produtos" +
                                    "\n4 - Excluir Produto"
                    );
                    op = entrada.nextInt();

                    switch (op) {
                        case 1:

                            //Produto produto = new Produto();
                            System.out.println("Descricao: ");
                            produto.setDescricao(entrada.next());
                            out.println("Valor Unit: ");
                            produto.setValorUnit(entrada.nextDouble());
                            prodao.create(produto);

                            break;

                        case 2:

                            Produto produtoToUpdate = new Produto();
                            out.println("Id Produto");
                            produtoToUpdate.setIdProduto(entrada.nextInt());
                            out.println("Descricao: ");
                            produtoToUpdate.setDescricao(entrada.next());
                            out.println("Valor:  ");
                            produtoToUpdate.setValorUnit(entrada.nextDouble());
                            prodao.update(produtoToUpdate);
                            break;

                        case 3:
                            produtoIO.printProduto(prodao.findAll());
                            break;

                        case 4:
                            System.out.println("Digite o Id do Produto a ser excluido: ");
                            dao.removeById(Integer.parseInt(entrada.next()));
                            break;

                    }
                }if (op == 5){
                    break;
                }
            }
        } else {
            System.out.println("Login ou senha inválidos!");
        }
    }
}

