package org.generation.italy;

import java.util.HashMap;
import java.util.Iterator;

public class Negozio {
	//hashmap dove vengono inseriti i prodotti (uno alla volta)
	private HashMap<String, Prodotto> prodotti = new HashMap<String, Prodotto>();
	
	//getters e setters
	//setter per l'inserimento di un prodotto alla volta nell'hashmap
	public void setProdotti(String codice, Prodotto prodotto) {
		//controllo che il codice della chiave sia uguale a quello del prodotto
		if(codice.equals(prodotto.getCodice())){
			prodotti.put(codice, prodotto);
		} else {
			System.out.println("I codici sono diversi.");
		}
	}
	
	//si usa un iterable per poter accedere in sola lettura all'hashmap prodotti da altre classi
	public Iterable<Prodotto> getElencoProdotti(){
		return new Iterable<Prodotto>() {
			@Override
			public Iterator<Prodotto> iterator() {
				return prodotti.values().iterator();
			}
		};
	}
	
	//questo metodo restituisce lo stato dell'operazione attraverso il metodo setSconto
	//della classe Prodotto
	public boolean setSconto(String codice, float sconto) {
		return prodotti.get(codice).setSconto(sconto);
	}
	
	//restituisco il codice del prodotto preso grazie al codice passato come parametro
	public String getCodice(String codice) {
		String codiceProdotto="";
		//se l'hashmap prodotti contiene la chiave inserita come parametro la restituisco
		if(prodotti.containsKey(codice)) {
			codiceProdotto=prodotti.get(codice).getCodice();
		}
		return codiceProdotto;
	}
	
	//restituisco la quantia del prodotto grazie al codice passato come parametro
	public int getQuantita(String codice){
		return prodotti.get(codice).getQuantitaDisponibile();
	}
	
	public String getDescrizioneNegozio(String codice) {
		return prodotti.get(codice).getDescrizione();
	}
	
	public float getPrezzoNegozio(String codice) {
		return prodotti.get(codice).getPrezzo();
	}
	
	public float getScontoNegozio(String codice) {
		return prodotti.get(codice).getSconto();
	}
	
	public void setQuantitaDopoVenditaNegozio(String codice, int quantitaAcquistata) {
		prodotti.get(codice).setQuantitaDopoVendita(quantitaAcquistata);
	}
}