package Controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ProdutoDao;

@WebServlet("/ProdutoDestroy")
public class ProdutoDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProdutoDelete() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int produtoId = Integer.parseInt(request.getParameter("produtoId"));
		ProdutoDao.delete(produtoId);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
