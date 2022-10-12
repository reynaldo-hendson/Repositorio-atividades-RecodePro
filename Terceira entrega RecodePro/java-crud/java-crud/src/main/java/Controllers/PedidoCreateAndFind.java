package Controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PedidoDao;
import model.Pedido;


@WebServlet("/PedidoCreateAndFind")
public class PedidoCreateAndFind extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public PedidoCreateAndFind() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pesquisa = request.getParameter("pesquisa");
		
		if(pesquisa == null) {
			pesquisa ="";
		}
		
		List<Pedido> pedido = PedidoDao.find(pesquisa);
		
		request.setAttribute("pedido", pedido);
		RequestDispatcher resquesDispatcher = request.getRequestDispatcher("listaPedido.jsp");
		resquesDispatcher.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Pedido pedido = new Pedido();
		
		pedido.setIdCliente(Integer.parseInt(request.getParameter("idCliente")));
		pedido.setQuantidade(request.getParameter("quantidade"));
		pedido.setIdProduto(request.getParameter("idProduto"));
		pedido.setDataPedido(request.getParameter("dataPedido"));
		pedido.setDataViagem(request.getParameter("dataViagem"));
		
		PedidoDao.create(pedido);				
		doGet(request, response);
	}

}
