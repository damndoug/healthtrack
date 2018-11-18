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

import com.healthtrack.Alimento;
import com.healthtrack.PressaoArterial;
import com.healthtrack.dao.impl.PressaoArterialDAO;
import com.healthtrack.util.DateUtils;

/**
 * Servlet implementation class PressaoArterialController
 */
@WebServlet("/pressoes")
public class PressaoArterialController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private PressaoArterialDAO dao;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		dao = new PressaoArterialDAO();
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PressaoArterialController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		if (session.getAttribute("userId") == null) {	
			request.getRequestDispatcher("/").forward(request, response);
			return;
		}
		
		int userId = Integer.parseInt(session.getAttribute("userId").toString());
		String acao = request.getParameter("acao");

		switch (acao) {
		
			case "listar":
				

				ArrayList<PressaoArterial> pressoes = dao.listar(userId);
				request.setAttribute("pressoes", pressoes);
				request.getRequestDispatcher("pages/pressao_arterial.jsp").forward(request, response);
				break;
			case "remover":
				int pressaoId = Integer.parseInt(request.getParameter("id"));
				dao.remover(pressaoId, userId);
				
				ArrayList<PressaoArterial> pressoesAtualizados = dao.listar(userId);
				
				request.setAttribute("pressoes", pressoesAtualizados );
				request.setAttribute("msg", "Pressão removida");
				request.getRequestDispatcher("pages/pressao_arterial.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(false);
			
			String pressao = request.getParameter("pressao_arterial");
			Date dataCadastro = DateUtils.ConverterParaData(request.getParameter("data"));
			
			PressaoArterial pressaoArterial = new PressaoArterial();
			pressaoArterial.setPressaoArterial(pressao);
			pressaoArterial.setDataCadastro(dataCadastro);
			int usuario = Integer.parseInt(session.getAttribute("userId").toString());
			
			dao.cadastrar(pressaoArterial, usuario);
			ArrayList<PressaoArterial> pressoes = dao.listar(usuario);
			
			request.setAttribute("pressoes", pressoes);
			request.setAttribute("msg", "Pressão arterial cadastrada");
			
		} catch (Exception e) {
			request.setAttribute("erro", "Houve um erro no cadastro, por gentileza tente novamente");
			e.printStackTrace();
		}
		request.getRequestDispatcher("pages/pressao_arterial.jsp").forward(request, response);
	}

}
