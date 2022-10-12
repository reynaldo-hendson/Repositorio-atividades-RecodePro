package Controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PedidoDao;
import model.Pedido;


@WebServlet("/PedidoUpdate")
public class PedidoFindAndUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public PedidoFindAndUpdate() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*Search for request by id*/
		int pedidoId = Integer.parseInt(request.getParameter("pedidoId"));
		Pedido pedido = PedidoDao.findByPk(pedidoId);
		
		request.setAttribute("pedido", pedido);
		RequestDispatcher resquesDispatcher = request.getRequestDispatcher("formUpdatePedido.jsp");
		resquesDispatcher.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*====== Update pedido data =====*/
		Pedido pedido = new Pedido();
		
		pedido.setId(Integer.parseInt(request.getParameter("id")));
		pedido.setIdCliente(Integer.parseInt(request.getParameter("idCliente")));
		pedido.setQuantidade(request.getParameter("quantidade"));
		pedido.setIdProduto(request.getParameter("idProduto"));
		pedido.setDataPedido(request.getParameter("dataPedido"));
		pedido.setDataViagem(request.getParameter("dataViagem"));
		
		PedidoDao.update(pedido);
		PedidoCreateAndFind pedidoCreateAndFind = new PedidoCreateAndFind();
		pedidoCreateAndFind.doGet(request, response);
	}

}
