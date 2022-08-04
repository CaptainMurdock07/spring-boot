package test1.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import test1.forms.LoginForm;
/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String maVariable[] = {"toto", "titi", "tata", "tutu"};
		request.setAttribute("maVariable", maVariable);
		String nom = request.getParameter("nom");
		request.setAttribute("name", nom);
		String prenom = request.getParameter("prenom");
		request.setAttribute("prenom", prenom);
		String civilite = request.getParameter("civilite");
		request.setAttribute("civilite", civilite);
		String[] auteurs = {"Victor Hugo", "Moliere", "Emile Zola", "Racine", "Jules Verne"};
		request.setAttribute("auteurs", auteurs);
		this.getServletContext().getRequestDispatcher("/WEB-INF/bonjour.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String auteur = request.getParameter("auteur");
		request.setAttribute("auteur", auteur);
		String[] auteurs = {"Victor Hugo", "Moliere", "Emile Zola", "Racine", "Jules Verne"};
		request.setAttribute("auteurs", auteurs);
		//int idAuteur = Integer.parseInt(request.getParameter("auteurs"));
		//request.setAttribute("idAuteur", idAuteur);
		
		LoginForm form = new LoginForm();
		form.login(request);
		request.setAttribute("form", form);
		HttpSession session = request.getSession();
		session.setAttribute("noEmploye", form.getLoginId());
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/bonjour.jsp").forward(request, response);
	}

}
