package utils;

import dao.ClienteDao;
import model.Cliente;

import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;


public class ClienteIO {

    //Campo INPUT.string
    //readIdOfClient
    public static String readIdOfClientCpf(Scanner scanner) {
        out.println("Informe seu CPF com 11 digitos: ");
        return scanner.next();
    }
    // pesquisa dados por id.
    public void printClients(List<Cliente> clients) {

        out.println("---------------------------------");
        for (var client : clients) {
            out.println(
                    "Id: " + client.getId() +
                            "\nNome: " + client.getNomeCliente() +
                            "\nCidade: " + client.getCidade() +
                            "\nUf: " + client.getUf() +
                            "\nCep: " + client.getCep() +
                            "\nCPF: " + client.getCpf() +
                            "\nLogadouro: " + client.getLogadouro() +
                            "\nTelefone: " + client.getTelefoneCelular() +
                            "\nData de Cadastro: " + client.getDataCadastro()
            );
            out.println("---------------------------------");
        }
    }

    // Menu cliente.
    public static void ClientIo(Scanner entrada) {
        ClienteDao dao = new ClienteDao();
        ClienteIO clienteIO = new ClienteIO();
        int op;
        System.out.println("==========CLIENTE==========");
        System.out.println(
                "1 - Cadastrar Cliente" +
                "\n2 - Atualizar meus dados." +
                "\n3 - Consultar meus dados." +
                "\n4 - Excluir conta" +
                "\n5 - Voltar ao menu principal"
        );
        op = entrada.nextInt();

        switch(op) {
            case 1 :

                Cliente cli1 = new Cliente();
                System.out.println("Nome Completo: ");
                cli1.setNomeCliente(entrada.next());
                System.out.println("Cidade: ");
                cli1.setCidade(entrada.next());
                System.out.println("UF: ");
                cli1.setUf(entrada.next());
                System.out.println("CEP: ");
                cli1.setCep(entrada.next());
                System.out.println("CPF: ");
                cli1.setCpf(entrada.next());
                System.out.println("Logadouro: ");
                cli1.setLogadouro(entrada.next());
                System.out.println("Contato: ");
                cli1.setTelefoneCelular(entrada.next());
                System.out.println("Data Cadastro: ");
                cli1.setDataCadastro(entrada.next());
                dao.create(cli1);

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

                clienteIO.printClients(dao.findByPk(/*clienteIO.*/readIdOfClientCpf(entrada)));

                break;

            case 4:
                System.out.println("Digite o Id do cliente a ser excluido: ");
                dao.removeById(Integer.parseInt(entrada.next()));
                break;

            case 5:
                //iniciar();

                break;
        }

    }
}