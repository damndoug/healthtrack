package com.healthtrack;

import java.sql.Date;

/**
 * A classe representando a press�o arterial
 * @author Douglas Pires Vilela da Silva
 *
 */
public class PressaoArterial {

	private String pressaoArterial;
	private Date DataCadastro;
	
	public PressaoArterial () {
		
	}
	
	/**
	 * Constr�i uma nova press�o arterial
	 * @param pressaoArterial A press�o arterial do usu�rio
	 */
	public PressaoArterial (String pressaoArterial) {
		this.pressaoArterial = pressaoArterial;
	}
	
	/**
	 * Retorna a press�o arterial
	 * @return Retorna a press�o arterial
	 */
	public String getPressaoArterial () {
		return this.pressaoArterial;
	}
	
	/**
	 * Altera a press�o arterial
	 * @param pressaoArterial A nova press�o arterial
	 */
	public void setPressaoArterial (String pressaoArterial) {
		this.pressaoArterial = pressaoArterial;
	}

	public Date getDataCadastro() {
		return DataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		DataCadastro = dataCadastro;
	}
}
