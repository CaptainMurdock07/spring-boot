package produit.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import meslivres.Livre;

/**
 * Servlet implementation class Produit
 */
@WebServlet("/Produit")
public class Produit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Produit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Modele
		// Liste des livres
		ArrayList<Livre> livres = Livre.getLivres();
		// livre selectionne
		Livre livre = null;
		String id = request.getParameter("id");
		if ( id != null) {
			livre = new Livre(Integer.parseInt(id));
		}
		// Vue
		request.setAttribute("livres", livres);
		if ( livre != null) request.setAttribute("livre", livre);
		this.getServletContext().getRequestDispatcher("/WEB-INF/listesProduits.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/listesProduits.jsp").forward(request, response);
	}

}
