package guy.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.EmployeDao;
import dao.EmployeDaoImpl;
import forms.EmployeForm;

/**
 * Servlet implementation class Guy
 */
@WebServlet("/Guy")
public class Guy extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeDao employeDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Guy() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() {
    	DaoFactory daoFactory = DaoFactory.getInstance();
    	this.employeDao = daoFactory.getEmployeDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//EmployeDaoImpl newguy = new EmployeDaoImpl();
		request.setAttribute("employes", this.employeDao.lister());
		this.getServletContext().getRequestDispatcher("/WEB-INF/employe.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//EmployeDaoImpl newguy = new EmployeDaoImpl();
		//request.setAttribute("employes", this.employeDao.ajouter(null));
		EmployeForm employeForm = new EmployeForm();
		employeForm.ajouterEmploye(request, this.employeDao);
		request.setAttribute("employeform", employeForm);
		request.setAttribute("employes", this.employeDao.lister());
		this.getServletContext().getRequestDispatcher("/WEB-INF/employe.jsp").forward(request, response);
	}

}
