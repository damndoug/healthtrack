package com.healthtrack;

import java.sql.Date;

/**
 * A classe representando um alimento
 * @author Douglas Pires Vilela da Silva
 *
 */
public class Alimento {

	private int Id;
	private String DescAlimento;
	private double Calorias;
	private String Comentarios;
	private Date DataCadastro;
	
	
	/**
	 * Constrói um novo alimento
	 * @param descAlimento O nome do alimento
	 * @param calorias As calorias do alimento
	 */
	public Alimento () {
		
	}
	
	public Alimento (String descAlimento, double calorias, String comentarios) {
		this.DescAlimento = descAlimento;
		this.Calorias = calorias;
		this.Comentarios = comentarios;
	}
	
	/**
	 * Retorna o nome de um alimento
	 * @return Retorna o nome de um alimento
	 */
	public String getDescAlimento () {
		return this.DescAlimento;
	}

	/**
	 * Retorna as calorias de um alimento
	 * @return Retorna as calorias de um alimento
	 */
	public double getCalorias () {
		return this.Calorias;
	}
	

	/**
	 * Retorna os comentarios de um alimento
	 * @return Retorna os comentarios de um alimento
	 */
	public String getComentarios () {
		return this.Comentarios;
	}
	
	/**
	 * Altera o nome de um alimento 
	 * @param alimento O novo nome do alimento
	 */
	public void setDescAlimento (String alimento) {
		this.DescAlimento = alimento;
	}
	
	/**
	 * Altera a quantidade de calorias de um alimento
	 * @param calorias A nova quantidade de calorias do alimento
	 */
	public void setCalorias (double calorias) {
		this.Calorias = calorias;
	}
	/**
	 * Altera a quantidade de calorias de um alimento
	 * @param comentario O novo comentário do alimento
	 */
	public void setComentarios (String comentario) {
		this.Comentarios = comentario;
	}

	public Date getDataCadastro() {
		return DataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		DataCadastro = dataCadastro;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}
}

