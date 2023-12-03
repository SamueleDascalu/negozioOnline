package org.generation.italy;

import java.util.HashMap;

public class Negozio {
	//hashmap dove vengono inseriti i prodotti (uno alla volta)
	private HashMap<String, Prodotto> prodotti = new HashMap<String, Prodotto>();
	
	//getters e setters
	//setter per l'inserimento di un prodotto alla volta nell'hashmap
	public void setProdotti(String codice, Prodotto prodotto) {
		prodotti.put(codice, prodotto);
	}
	
	//questo metodo restituisce lo stato dell'operazione attraverso il metodo setSconto
	//della classe Prodotto
	public boolean setSconto(String codice, float sconto) {
		return prodotti.get(codice).setSconto(sconto);
	}
	
	public Prodotto getProdotto(String codice) {
		return prodotti.get(codice);
	}
	
	public String getCodice(String codice) {
		String codiceProdotto="";
		if(prodotti.containsKey(codice)) {
			codiceProdotto=prodotti.get(codice).getCodice();
		}
		return codiceProdotto;
	}
	
	public int getQuantita(String codice){
		return prodotti.get(codice).getQuantitaDisponibile();
	}
	
	public void visualizzaProdotti() {
		for(Prodotto prodotto:prodotti.values()) {
			prodotto.visualizzaDati(); 
		}
	}
}