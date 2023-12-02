package org.generation.italy;

import java.util.HashMap;

public class Negozio {
	private HashMap<String, Prodotto> prodotti = new HashMap<String, Prodotto>();
	
	public void setProdotti(String codice, Prodotto prodotto) {
		prodotti.put(codice, prodotto);
	}
	
	public String getCodice(String codice) {
		String codiceProdotto="";
		if(prodotti.containsKey(codice)) {
			codiceProdotto=prodotti.get(codice).getCodice();
		}
		return codiceProdotto;
	}
	
	public void visualizzaProdotti() {
		for(Prodotto prodotto:prodotti.values()) {
			prodotto.visualizzaDati(); 
		}
	}
	
	public boolean setSconto(String codice, float sconto) {
		return prodotti.get(codice).setSconto(sconto);
	}
}
