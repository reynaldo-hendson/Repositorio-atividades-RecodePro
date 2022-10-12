import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;
import static utils.AdminIO.menuAdminIo;
import static utils.ClienteIO.ClientIo;
import static utils.ItensPedidoIO.itemPedidoIo;
import static utils.PedidoIO.pedidoIo;
public class Main {

	public static void main(String[] args) {
		iniciar();


	}

	public static int iniciar() {
		Scanner entrada = new Scanner(in);

        int op = 0;
		while (op >= 0 && op < 5) {
			entrada = new Scanner(in);

			out.println("------------------------------Menu--------------------------------");
			out.println(
							"1 - Cliente" +
							"\n2 - Pedidos" +
							"\n3 - Incluir item Pedido" +
							"\n4 - Administrador"+
							"\n5 - Encerrar Programa"
			);
			op = entrada.nextInt();

			switch (op) {
				case 1:
					ClientIo(entrada);
					break;

				case 2:
					pedidoIo(entrada);
					break;

				case 3:
					itemPedidoIo(entrada);
					break;

				case 4:
					menuAdminIo(entrada);
					break;

				case 5:
					break;


			}

		}
		return Integer.parseInt(entrada.next());

	}

}






