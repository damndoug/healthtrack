package com.healthtrack;

import java.sql.Date;

/**
 * A classe representando a pressão arterial
 * @author Douglas Pires Vilela da Silva
 *
 */
public class PressaoArterial {

	private String pressaoArterial;
	private Date DataCadastro;
	
	public PressaoArterial () {
		
	}
	
	/**
	 * Constrói uma nova pressão arterial
	 * @param pressaoArterial A pressão arterial do usuário
	 */
	public PressaoArterial (String pressaoArterial) {
		this.pressaoArterial = pressaoArterial;
	}
	
	/**
	 * Retorna a pressão arterial
	 * @return Retorna a pressão arterial
	 */
	public String getPressaoArterial () {
		return this.pressaoArterial;
	}
	
	/**
	 * Altera a pressão arterial
	 * @param pressaoArterial A nova pressão arterial
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
