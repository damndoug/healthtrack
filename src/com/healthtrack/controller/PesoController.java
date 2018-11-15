package com.healthtrack.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.healthtrack.Peso;
import com.healthtrack.dao.impl.PesoDAO;
import com.healthtrack.util.DateUtils;

/**
 * Servlet implementation class PesoController
 */
@WebServlet("/pages/pesos")
public class PesoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private PesoDAO dao;
	
	@Override
	public void init() throws ServletException {
		super.init();
		dao = new PesoDAO();
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PesoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		
		String acao = request.getParameter("acao");

		switch (acao) {
		
			case "listar":
				
				int userId = Integer.parseInt(session.getAttribute("userId").toString());
			
				ArrayList<Peso> pesos = dao.listar(userId);
				request.setAttribute("pesos", pesos);
				request.getRequestDispatcher("./pesos.jsp").forward(request, response);
				break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(false);
			
			int qtpeso = Integer.parseInt(request.getParameter("peso"));
			String comentarios = request.getParameter("comentarios");
			int usuario = Integer.parseInt(session.getAttribute("userId").toString());
			Date dataCadastro = DateUtils.ConverterParaData(request.getParameter("data"));

			Peso peso = new Peso();
			peso.setPeso(qtpeso);
			peso.setComentario(comentarios);
			peso.setUsuario(usuario);
			peso.setDataCadastro(dataCadastro);
			
			dao.cadastrar(peso, usuario);
			
			request.setAttribute("msg", "Peso cadastrado");

		} catch (Exception e) {
			e.printStackTrace();
			
			request.setAttribute("erro", "Erro ao cadastrar! Tente novamente");

		}

		request.getRequestDispatcher("./pesos.jsp").forward(request, response);
	}

}
