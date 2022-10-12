package Controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProdutoDao;
import model.Produto;


@WebServlet("/ProdutoUpdate")
public class ProdutoFindAndUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ProdutoFindAndUpdate() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*===== Search for a customer by id. ======*/
		int produtoId = Integer.parseInt(request.getParameter("produtoId"));
		Produto produto = ProdutoDao.findByPk(produtoId);
		
		request.setAttribute("produto", produto);
		RequestDispatcher resquesDispatcher = request.getRequestDispatcher("formUpdateProduto.jsp");
		resquesDispatcher.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*====== Update product data =====*/
		Produto produto = new Produto();
		
		produto.setId(Integer.parseInt(request.getParameter("id")));
		produto.setDescricao(request.getParameter("descricao"));
		produto.setValor(Double.parseDouble(request.getParameter("valor")));
				
		ProdutoDao.update(produto);
		ProdutoCreateAndFind produtoCreateAndFind = new ProdutoCreateAndFind();
		produtoCreateAndFind.doGet(request, response);
	}

}
