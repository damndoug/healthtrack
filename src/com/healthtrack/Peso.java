package com.healthtrack;

import java.sql.Date;

/**
 * A classe representando um peso
 * @author Douglas Pires Vilela da Silva
 *
 */
public class Peso {


	private int Id;
	private double Peso;
	private String Comentario;
	private Date DataCadastro;
	private int Usuario;
	
	
	public Peso () {
		
	}
	/**
	 * Constrói um novo peso
	 * @param peso O peso do susuário
	 */
	public Peso (double peso) {
		this.Peso = peso;
	}
	
	/**
	 * Retorna o peso
	 * @return Retorna o peso
	 */
	public double getPeso () {
		return this.Peso;
	}
	
	public String getComentario () {
		return this.Comentario;
	}
	
	
	/**
	 * Altera um peso
	 * @param peso O novo peso
	 */
	public void setPeso (double peso) {
		this.Peso = peso;
	}
	
	public void setComentario (String comentario) {
		this.Comentario = comentario;
	}
	public Date getDataCadastro() {
		return DataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		DataCadastro = dataCadastro;
	}
	public int getUsuario() {
		return Usuario;
	}
	public void setUsuario(int usuario) {
		Usuario = usuario;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
}
