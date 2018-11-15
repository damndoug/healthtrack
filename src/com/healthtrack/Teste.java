package com.healthtrack;

import java.util.ArrayList;

import com.healthtrack.dao.impl.AlimentoDAO;
import com.healthtrack.dao.impl.AtividadeFisicaDAO;

public class Teste {

	public static void main(String[] args) {
		// Para fins de leitura do output, comentar ou descomentar o método que deseja visualizar
		
		//setAlimento();
		//getAlimentos();
		
		//setAtividadeFisica();
		//getAtividadesFisicas();
	}
	
	private static void getAtividadesFisicas() {
		AtividadeFisicaDAO dao = new AtividadeFisicaDAO();
		AtividadeFisica atividade = new AtividadeFisica("corrida", 199, 60);
		dao.cadastrar(atividade, 7);
	}

	private static void setAtividadeFisica() {
		AtividadeFisicaDAO dao = new AtividadeFisicaDAO();
		ArrayList<AtividadeFisica> atividades = dao.listar(7);
		for (AtividadeFisica atividade : atividades) {
			System.out.println(atividade.getDescAtividade());
			System.out.println(atividade.getCalorias());
			System.out.println(atividade.getTempo());
		}
	}

	public static void setAlimento() {
		AlimentoDAO dao = new AlimentoDAO();
		Alimento alimento = new Alimento("pera", 91, "E uma pera, bicho!");
		dao.cadastrar(alimento, 7);
	}
	
	public static void getAlimentos() {
		AlimentoDAO dao = new AlimentoDAO();
		ArrayList<Alimento> alimentos = dao.listar(7);


		for (Alimento alimento : alimentos) {
			System.out.println(alimento.getDescAlimento());
			System.out.println(alimento.getCalorias());
			System.out.println(alimento.getComentarios());
		}
	}
}
