package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TelefoneDao;
import model.Telefone;

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
		List<Telefone> telefones = new ArrayList<>();

		String name = request.getParameter("name");
		String action = request.getParameter("action");
		RequestDispatcher view = null;
		switch(action) {
		case "delete":
			Integer phoneId = Integer.parseInt(request.getParameter("id"));
			Integer userId = Integer.parseInt(request.getParameter("userid"));
			dao.deletePhone(phoneId);
			telefones = dao.getPhone(userId);
			request.setAttribute("telefones", telefones);
			request.setAttribute("name", name);
			request.setAttribute("id", userId);
			request.setAttribute("btnFormTelefone", "Cadastrar");
			request.setAttribute("btnFormAction", "save");
			view = request.getRequestDispatcher(LIST_TELEFONES);
			view.forward(request, response);
			break;
		case "edit":
			Integer phoneIdEdit = Integer.parseInt(request.getParameter("id"));
			Integer userIdEdit = Integer.parseInt(request.getParameter("userid"));
			Telefone fone = dao.getPhoneById(phoneIdEdit);
			telefones = dao.getPhone(userIdEdit);
			request.setAttribute("btnFormTelefone", "Atualizar");
			request.setAttribute("fone", fone);
			request.setAttribute("telefones", telefones);
			request.setAttribute("name", name);
			request.setAttribute("id", userIdEdit);
			request.setAttribute("btnFormAction", "update");
			view = request.getRequestDispatcher(LIST_TELEFONES);
			view.forward(request, response);
			break;
		
		default:
			String id = request.getParameter("id");
			String forward = "";
			forward = LIST_TELEFONES;
			telefones = dao.getPhone(Integer.parseInt(id));
			request.setAttribute("btnFormTelefone", "Cadastrar");
			request.setAttribute("btnFormAction", "save");
			request.setAttribute("telefones", telefones);
			request.setAttribute("name", name);
			request.setAttribute("id", id);
			view = request.getRequestDispatcher(forward);
			view.forward(request, response);
			break;
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		switch(action) {
		case "save":
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
			request.setAttribute("btnFormTelefone", "Cadastrar");
			request.setAttribute("btnFormAction", "save");
			request.setAttribute("name", (name));
			request.setAttribute("id", (userid));
			view.forward(request, response);
			break;
		case "update":
			Integer phoneIdUpdate = Integer.parseInt(request.getParameter("foneId"));
			Integer userIdUpdate = Integer.parseInt(request.getParameter("userid"));
			Integer dddUpdate = Integer.parseInt(request.getParameter("ddd"));
			String numeroUpdate = (request.getParameter("numero"));
			String tipoUpdate = request.getParameter("tipo");
			String nameUpdate = request.getParameter("name");
			Telefone foneUpdate = new Telefone(phoneIdUpdate, dddUpdate,numeroUpdate,tipoUpdate,userIdUpdate);
			dao.updtePhone(foneUpdate);
			List<Telefone> telefones = dao.getPhone(userIdUpdate);
			request.setAttribute("btnFormTelefone", "Cadastrar");
			request.setAttribute("fone", null);
			request.setAttribute("telefones", telefones);
			request.setAttribute("name", nameUpdate);
			request.setAttribute("id", userIdUpdate);
			request.setAttribute("btnFormAction", "save");
			view = request.getRequestDispatcher(LIST_TELEFONES);
			view.forward(request, response);
			break;
		}
		
	}
	
	
	
	

}
