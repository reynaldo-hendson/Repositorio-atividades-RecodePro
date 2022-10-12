package Controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ProdutoDao;
import model.Produto;


@WebServlet("/ProdutoCreateAndFind")
public class ProdutoCreateAndFind extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProdutoCreateAndFind() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pesquisa = request.getParameter("pesquisa");
		
		if (pesquisa == null) {
			pesquisa="";
		}
		
		List<Produto> produto = ProdutoDao.find(pesquisa);
		
		//Depois do cadastro retorna para pagina desejada no parametro.
		
		request.setAttribute("produto", produto);
		RequestDispatcher resquesDispatcher = request.getRequestDispatcher("listaProduto.jsp");
		resquesDispatcher.forward(request, response);
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*=====Cadastra um Produto=====*/
		Produto produto = new Produto();
		
		produto.setDescricao(request.getParameter("descricao"));
		produto.setValor(Double.parseDouble(request.getParameter("valor")));
		
		ProdutoDao.create(produto);
		doGet(request, response);
		
	}

}
