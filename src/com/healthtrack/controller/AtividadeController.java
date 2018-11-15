package com.healthtrack.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.healthtrack.AtividadeFisica;
import com.healthtrack.dao.impl.AtividadeFisicaDAO;
import com.healthtrack.util.DateUtils;

/**
 * Servlet implementation class AtividadeController
 */
@WebServlet("/pages/atividades")
public class AtividadeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private AtividadeFisicaDAO dao;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		dao = new AtividadeFisicaDAO();
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AtividadeController() {
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

				ArrayList<AtividadeFisica> atividades = dao.listar(userId);
				request.setAttribute("atividades", atividades);
				request.getRequestDispatcher("./atividades.jsp").forward(request, response);
				break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(false);
			
			String descAtividade = request.getParameter("atividade");
			double calorias = Double.parseDouble(request.getParameter("calorias"));
			int qtTempo = Integer.parseInt(request.getParameter("tempo"));
			int usuario = Integer.parseInt(session.getAttribute("userId").toString());
			String comentarios = request.getParameter("comentario");
			Date dataCadastro = DateUtils.ConverterParaData(request.getParameter("data"));
			
			AtividadeFisica atividade = new AtividadeFisica();
			atividade.setDescAtividade(descAtividade);
			atividade.setCalorias(calorias);
			atividade.setComentarios(comentarios);
			atividade.setTempo(qtTempo);
			atividade.setDataCadastro(dataCadastro);
			
			dao.cadastrar(atividade, usuario);
			
			request.setAttribute("msg", "Atividade Física cadastrada");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("./atividades.jsp").forward(request, response);
	}

}
