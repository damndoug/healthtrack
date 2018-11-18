	package com.healthtrack;

import java.sql.Date;

import com.healthtrack.util.CriptografiaUtils;

/**
 * A classe representando um usuário
 * @author Douglas Pires Vilela da Silva
 *
 */
public class Usuario {

	private int Id;
	private String Nome;
	private Date DtNasc;
	private String Email;
	private String Senha;
	private int Sexo;
	private Date DataCadastro;

	public Usuario () {
		
	}
	
	/**
	 * Constrói um usuário
	 * @param nome O nome do cliente
	 * @param email O email do cliente
	 * @param senha A senha do cliente
	 */
	public Usuario (String nome, String email, String senha) {
		this.Nome = nome;
		this.Email = email;
		this.Senha = senha;
	}
	
	
	/**
	 * Constrói um usuário
	 * @param nome O nome do cliente
	 * @param dtNasc A data de nascimento do cliente
	 * @param telefone O telefone do cliente
	 * @param email O e-mail do cliente
	 * @param senha A senha do cliente
	 */
	public Usuario (String nome, Date dtNasc, String email, String senha) {
		this.Nome = nome;
		this.DtNasc = dtNasc;
		this.Email = email;
		this.Senha = senha;
	}
	
	
	/**
	 * Retorna o nome do usuário
	 * @return retorna o nome do usuário
	 */
	public String getNome () {
		return this.Nome;
	}

	/**
	 * Retorna a data de nascimento
	 * @return Retorna a data de nascimento
	 */
	public Date getDtNasc () {
		return this.DtNasc;
	}
	
	/**
	 * Retorna o e-mail
	 * @return Retorna o e-mail
	 */
	public String getEmail() {
		return this.Email;
	}
	
	/**
	 * Retorna a senha
	 * @return Retorna a senha
	 */
	public String getSenha () {
		return this.Senha;
	}
	
	
	public int getSexo() {
		return this.Sexo;
	}
	
	/**
	 * Altera o nome do usuário
	 * @param nome Altera o nome do usuário
	 */
	public void setNome (String nome) {
		this.Nome = nome;	
	}
	
	/**
	 * Altera a data de nascimento do usuário
	 * @param dtNasc Altera a data de nascimento do usuário
	 */
	public void setDtNasc(Date dtNasc) {
		this.DtNasc = dtNasc;
	}

	/**
	 * Altera o email do usuário
	 * @param email Altera o email do usuário
	 */
	public void setEmail (String email) {
		this.Email = email;
	}
	
	/**
	 * Altera a senha de um usuário
	 * @param senha Altera a senha de um usuário
	 * @throws Exception 
	 */
	public void setSenha (String senha) throws Exception {
		this.Senha = CriptografiaUtils.criptografar(senha);
	}

	
	public void setSexo(int sexo) {
		this.Sexo = sexo;
		
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
