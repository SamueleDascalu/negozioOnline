package org.generation.italy;

public class Prodotto {
	private String codice, descrizione;
	private float prezzo, sconto;
	private int quantitaDisponibile;
	
	//costruttore
	public Prodotto() {
		prezzo=0;
		sconto=0;
		quantitaDisponibile=0;
	}
	
	//setters e getters
	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public float getPrezzo() {
		return prezzo;
	}
	
	//questo setter restituisce lo stato dell'operazione attraverso un booleano
	public boolean setPrezzo(float prezzo) {
		//inizializzo lo stato a falso
		boolean stato=false;
		if(prezzo>0) {
			this.prezzo = prezzo;
			//se il prezzo inserito dall'utente é maggiore di 0 lo stato diventa vero
			stato=true;
		} else {
			System.out.println("Il prezzo deve essere maggiore di 0.");
		}
		return stato;
	}

	public float getSconto() {
		return sconto;
	} 
	
	//questo setter restituisce lo stato dell'operazione attraverso un booleano
	public boolean setSconto(float sconto) {
		boolean stato=false;
		if(sconto>=0&&sconto<=100) {
			this.sconto = sconto;
			stato=true;
		} else {
			System.out.println("Lo sconto deve essere compreso tra 0 e 100.");
		}
		return stato;
	}

	public int getQuantitaDisponibile() {
		return quantitaDisponibile;
	}
	
	//questo setter restituisce lo stato dell'operazione attraverso un booleano
	public boolean setQuantitaDisponibile(int quantitaDisponibile) {
		boolean stato=false;
		if(quantitaDisponibile>0) {
			this.quantitaDisponibile = quantitaDisponibile;
			stato=true;
		} else {
			System.out.println("La quantità deve essere maggiore di 0.");
		}
		return stato;
	}
	
	public void setQuantitaDopoVendita(int quantitaAcquistata) {
		if(quantitaDisponibile>0) {
			quantitaDisponibile-=quantitaAcquistata;
		}
	}
	
	//metodo per la visualizzazione dei dati del prodotto
	public void visualizzaDati() {
		System.out.print("\nCodice: "+codice+"\n"+"Descizione: "+descrizione+"\nPrezzo: "+prezzo+"\nSconto: "+sconto+"\nQuantita disponibile: "+quantitaDisponibile+"\n\n");
	}
}
