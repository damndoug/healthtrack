package com.healthtrack;

import java.sql.Date;

/**
 * A classe representando uma atividade f�sica
 * @author Douglas Pires Vilela da Silva
 *
 */
public class AtividadeFisica {

	private String DescAtividade;
	private double Calorias;
	private int Tempo;
	private Date DataCadastro;
	private String Comentarios;
	
	/**
	 * Constr�i uma nova atividade f�sica
	 * @param descAtividade O nome da atividade f�sica
	 * @param calorias A quantidade de calorias gasta na atividade
	 */
	
	public AtividadeFisica () {
		
	}
	
	public AtividadeFisica (String descAtividade, double calorias, int tempo) {
		this.DescAtividade = descAtividade;
		this.Calorias = calorias;
		this.Tempo = tempo;
	}
	
	/**
	 * Retorna o nome de uma atividade
	 * @return Retorna o nome de uma atividade
	 */
	public String getDescAtividade () {
		return this.DescAtividade;
	}
	
	/**
	 * Retorna a quantidade de calorias da atividade 
	 * @return Retorna a quantidade de calorias da atividade
	 */
	public double getCalorias () {
		return this.Calorias;
	}
	
	public int getTempo () {
		return this.Tempo;
	}
	
	/**
	 * Altera o nome de uma atividade f�sica
	 * @param descAtividade Altera o nome de uma atividade f�sica 
	 */
	public void setDescAtividade (String descAtividade) {
		this.DescAtividade = descAtividade;
	}
	
	/**
	 * Altera a quantidade de calorias de uma atividade f�sica
	 * @param calorias Altera a quantidade de calorias de uma atividade f�sica
	 */
	public void setCalorias (double calorias) {
		this.Calorias = calorias;
	}

	public void setTempo (int tempo) {
		this.Tempo = tempo;
	}

	public Date getDataCadastro() {
		return DataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		DataCadastro = dataCadastro;
	}

	public String getComentarios() {
		return Comentarios;
	}

	public void setComentarios(String comentarios) {
		Comentarios = comentarios;
	}
}


