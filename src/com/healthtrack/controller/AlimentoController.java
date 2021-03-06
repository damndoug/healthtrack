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

import com.healthtrack.Alimento;
import com.healthtrack.Peso;
import com.healthtrack.dao.impl.AlimentoDAO;
import com.healthtrack.util.DateUtils;

/**
 * Servlet implementation class AlimentoController
 */
@WebServlet("/alimentos")
public class AlimentoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private AlimentoDAO dao;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		dao = new AlimentoDAO();
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlimentoController() {
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
				ArrayList<Alimento> alimentos = dao.listar(userId);
				request.setAttribute("alimentos", alimentos);
				request.getRequestDispatcher("pages/alimentos.jsp").forward(request, response);
				break;
			case "remover":
				int alimentoId = Integer.parseInt(request.getParameter("id"));
				dao.remover(alimentoId, userId);
				
				ArrayList<Alimento> alimentosAtualizados = dao.listar(userId);
				
				request.setAttribute("alimentos", alimentosAtualizados);
				request.setAttribute("msg", "Peso removido");
				request.getRequestDispatcher("pages/alimentos.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			HttpSession session = request.getSession(false);
			
			String desc_alimento = request.getParameter("desc_alimento");
			int calorias = Integer.parseInt(request.getParameter("calorias"));
			Date dataCadastro = DateUtils.ConverterParaData(request.getParameter("data"));
			int usuario = Integer.parseInt(session.getAttribute("userId").toString());
			String comentario = request.getParameter("comentarios");
					
			Alimento alimento = new Alimento();

			alimento.setDescAlimento(desc_alimento);
			alimento.setComentarios(comentario);
			alimento.setCalorias(calorias);
			alimento.setDataCadastro(dataCadastro);
			
			dao.cadastrar(alimento, usuario);
			
			ArrayList<Alimento> alimentos = dao.listar(usuario);
			
			request.setAttribute("alimentos", alimentos);
			request.setAttribute("msg", "Alimento cadastrado");
		} catch (Exception e) {
			request.setAttribute("erro", "Houve um erro no cadastro, por gentileza tente novamente");
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("./pages/alimentos.jsp").forward(request, response);
	}

}
