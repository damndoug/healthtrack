package com.healthtrack.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.healthtrack.dao.impl.UsuarioDAO;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	private UsuarioDAO dao;
	
	@Override
	public void init() throws ServletException {
		super.init();
		dao = new UsuarioDAO();
	}

	
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("./pages/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			
			if (dao.validarUsuario(email, senha)) {
				int userId = dao.getUserId(email, senha);

				HttpSession session = request.getSession();
				session.setAttribute("user", email);
				session.setAttribute("userId", userId);

				response.sendRedirect("dashboard");
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("erro", "Usuario ou senha inválidos");
		request.getRequestDispatcher("pages/login.jsp").forward(request, response);
	}

}
