package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.User;

@WebServlet(name = "Usuarios", urlPatterns = { "/UserController" })
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/user.jsp";
	private static String LIST_USER = "/listUser.jsp";
	private static String LIST_TELEFONES = "/listTelefones.jsp";
	private UserDao dao;
	

	public UserController() {
		dao = new UserDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");

		if (action.contentEquals("delete")) {
			int userId = Integer.parseInt(request.getParameter("id"));
			dao.deleteUser(userId);
			forward = LIST_USER;
			request.setAttribute("users", dao.getAllUsers());
		} else if (action.equalsIgnoreCase("edit")) {
			forward = INSERT_OR_EDIT;
			int userId = Integer.parseInt(request.getParameter("id"));
			User user = dao.getUserById(userId);
			request.setAttribute("user", user);

		

		} else if (action.equalsIgnoreCase("listUser")) {
			forward = LIST_USER;
			request.setAttribute("users", dao.getAllUsers());
			
		}else if (action.equalsIgnoreCase("telefones")) {
			forward = LIST_TELEFONES;
			int userId = Integer.parseInt(request.getParameter("id"));
			User user = dao.getUserById(userId);
			request.setAttribute("user", user);
		}
		else {
			forward = INSERT_OR_EDIT;
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase(LIST_USER)) {
			String email = request.getParameter("login");
			String senha = request.getParameter("senha");
			
			if(dao.login(email, senha)) {
				RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
				request.setAttribute("users", dao.getAllUsers());
				view.forward(request, response);
			}
		}
		else {
			
		User user = new User();
		user.setNome(request.getParameter("nome"));
		user.setEmail(request.getParameter("email"));
		user.setSenha(request.getParameter("senha"));
		String userid = request.getParameter("userid");
		if (userid == null || userid.isEmpty()) {
			dao.addUser(user);
		} else {
			user.setUserid(Integer.parseInt(userid));
			dao.updteUser(user);

		}
		RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
		request.setAttribute("users", dao.getAllUsers());
		view.forward(request, response);
		}
		
	}

}
