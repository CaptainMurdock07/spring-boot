package test1.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.EmployeDao;

/**
 * Servlet implementation class Employes
 */
@WebServlet("/Employes")
public class Employes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeDao employeDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Employes() {
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
		request.setAttribute("employes", this.employeDao.lister());
		this.getServletContext().getRequestDispatcher("/WEB-INF/employes.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/employes.jsp").forward(request, response);
	}

}
