package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TelefoneDao;
import dao.UserDao;
import model.Telefone;
import model.User;

@WebServlet(name = "Telefones", urlPatterns = { "/TelefoneController" })
public class TelefoneController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String LIST_TELEFONES = "/listTelefones.jsp";
	private TelefoneDao dao;
	

	public TelefoneController() {
		dao = new TelefoneDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forward = "";
		String id = request.getParameter("id");
		String name = request.getParameter("name");
			forward = LIST_TELEFONES;
			List<Telefone> telefones = dao.getPhone(Integer.parseInt(id));
			System.out.println(telefones);

			request.setAttribute("telefones", telefones);
			request.setAttribute("name", name);
			request.setAttribute("id", id);
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Telefone telefone = new Telefone();
		telefone.setDDD(Integer.parseInt(request.getParameter("ddd")));
		telefone.setNumero(request.getParameter("numero"));
		telefone.setTipo(request.getParameter("tipo"));
		Integer userid = Integer.parseInt(request.getParameter("userid"));
		String name = (request.getParameter("name"));
		telefone.setUserId(userid);
		
		dao.addTelefone(telefone);
		
		RequestDispatcher view = request.getRequestDispatcher(LIST_TELEFONES);
		request.setAttribute("telefones", dao.getPhone(userid));
		request.setAttribute("name", (name));
		view.forward(request, response);
		
	}

}
