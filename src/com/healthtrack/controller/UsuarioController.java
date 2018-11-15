package com.healthtrack.controller;

import java.io.IOException;
import java.util.Calendar;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.healthtrack.Usuario;
import com.healthtrack.dao.impl.UsuarioDAO;


@WebServlet("/pages/usuario")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private UsuarioDAO dao;
	
	@Override
	public void init() throws ServletException {
		super.init();
		dao = new UsuarioDAO();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			String sexo = request.getParameter("sexo");
			Date dataCadastro = new Date(Calendar.getInstance().getTime().getTime());
			
			int sexoEscolhido = 1;
			
			if (sexo == "Masculino") {
				sexoEscolhido = 1;
			} else {
				sexoEscolhido = 2;
			}
			
			Usuario usuario = new Usuario();
			
			usuario.setNome(nome);
			usuario.setEmail(email);
			usuario.setSenha(senha);
			usuario.setSexo(sexoEscolhido);
			usuario.setDataCadastro(dataCadastro);
			
			dao.cadastrar(usuario, 0);
			
			request.setAttribute("msg", "Usuário cadastrado, por gentileza clique em login");
		} catch (Exception e) {
			request.setAttribute("erro", "Houve um erro no cadastro, por gentileza tente novamente");
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("cadastrar.jsp").forward(request, response);
	}

}
