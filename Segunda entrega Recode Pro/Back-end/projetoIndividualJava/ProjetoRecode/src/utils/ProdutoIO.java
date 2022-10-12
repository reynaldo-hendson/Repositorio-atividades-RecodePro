package utils;

import dao.ProdutoDao;
import model.Produto;

import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

public class ProdutoIO {


    //Campo INPUT id .
    public static int readIdOfProduto(Scanner scanner) {
        out.println("Informe o ID do Produto: ");
        return scanner.nextInt();
    }

    // pesquisa dados do pedidos por id.
    public void printProduto(List<Produto> produto) {

        out.println("---------------------------------");
        for (var pedidox : produto) {
            out.println(
                    " | IdProduto: " + pedidox.getIdProduto() +
                            " - Descricao: " + pedidox.getDescricao() +
                            " - Valor Unit.: " + pedidox.getValorUnit()

            );
            out.println("---------------------------------");
        }
    }


    // Menu produto.
    public static void produtoIo(Scanner entrada) {
        ProdutoDao dao = new ProdutoDao();
        Produto produto = new Produto();
        ProdutoIO produtoIO = new ProdutoIO();

        Scanner in = new Scanner(System.in);
        System.out.println("login> ");
        String login = in.nextLine();
        System.out.println("senha> ");
        String senha = in.nextLine();

        if (login.equals("admin") && senha.equals("admin")) {
            System.out.printf("Usuário %s logado com sucesso.", login);

            int op;
            System.out.println("==========Produtos==========");
            System.out.println(
                    "1 - Incluir Produto" +
                            "\n2 - Atualizar Produto" +
                            "\n3 - Consultar Produtos" +
                            "\n4 - Excluir Produto" +
                            "\n5 - Voltar"
            );
            op = entrada.nextInt();

            switch (op) {
                case 1:

                    //Produto produto = new Produto();
                    System.out.println("Descricao: ");
                    produto.setDescricao(entrada.next());
                    out.println("Valor Unit: ");
                    produto.setValorUnit(entrada.nextDouble());
                    dao.create(produto);

                    break;

                case 2:

                    Produto produtoToUpdate = new Produto();
                    out.println("Id Produto");
                    produtoToUpdate.setIdProduto(entrada.nextInt());
                    out.println("Descricao: ");
                    produtoToUpdate.setDescricao(entrada.next());
                    out.println("Valor:  ");
                    produtoToUpdate.setValorUnit(entrada.nextDouble());
                    dao.update(produtoToUpdate);
                    break;

                case 3:
                    //produtoIO.printPedidos(dao.findByPk(readIdOfProduto(entrada)));
                    produtoIO.printProduto(dao.findAll());
                    break;

                case 4:
                    System.out.println("Digite o Id do Produto a ser excluido: ");
                    dao.removeById(Integer.parseInt(entrada.next()));
                    break;

                case 5:
                    break;

            }


        } else {
            System.out.println("Login ou senha inválidos!");
        }

    }
}
