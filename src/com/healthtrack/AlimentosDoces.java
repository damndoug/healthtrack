package com.healthtrack;

public class AlimentosDoces extends Alimento {

	private boolean superCalorico = true;
	
	public AlimentosDoces(String descAlimento, double calorias, String comentario) {
		super(descAlimento, calorias, comentario);
	}

	public boolean isSuperCalorico() {
		return superCalorico;
	}

	public void setSuperCalorico(boolean superCalorico) {
		this.superCalorico = superCalorico;
	}

	
}
