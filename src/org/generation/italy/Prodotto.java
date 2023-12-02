package org.generation.italy;

public class Prodotto {
	private String codice, descrizione;
	private float prezzo, sconto;
	private int quantitaDisponibile;

	public Prodotto() {
		prezzo=0;
		sconto=0;
		quantitaDisponibile=0;
	}
	
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

	public boolean setPrezzo(float prezzo) {
		boolean stato=false;
		if(prezzo>0) {
			this.prezzo = prezzo;
			stato=true;
		} else {
			System.out.println("Il prezzo deve essere maggiore di 0.");
		}
		return stato;
	}

	public float getSconto() {
		return sconto;
	} 

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

	public void visualizzaDati() {
		System.out.print("\nCodice: "+codice+"\n"+"Descizione: "+descrizione+"\nPrezzo: "+prezzo+"\nSconto: "+sconto+"\nQuantita disponibile: "+quantitaDisponibile+"\n\n");
	}
}
