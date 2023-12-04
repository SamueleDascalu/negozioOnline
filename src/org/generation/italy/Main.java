package org.generation.italy;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		String codice, descrizione, opzione;
		float prezzo, sconto;
		int quantita;

		Scanner scanner = new Scanner(System.in);
		
		//creo una sola istanza della classe negozio
		Negozio negozio = new Negozio();

		do {
			//mostro le opzioni disponibili e chiedo di inserire l'opzione
			System.out.println(
				"\n1=Inserimento prodotto\n2=Elenco prodotti\n3=Applica sconto\n"
				+ "4=Vendita prodotti\n\nInserisci l'opzione: "
			);
			opzione = scanner.nextLine();
			
			//creo una nuova istanza della classe prodotto ad ogni iterazione
			Prodotto prodotto = new Prodotto();
			
			//calcolo le iterazioni di alcuni cicli
			int contatore = 0;
			//uso lo switch per le varie opzioni
			switch (opzione) {
			//Inserimento prodotto
			case "1":
				System.out.println("Inserisci i dati del prodotto:\n");
				// codice
				System.out.print("Codice: ");
				codice = scanner.nextLine();
				/*
				 * Confronto il codice del prodotto preso attraverso il metodo getCodice
				 * della classe negozio con il codice inserito.
				 * Se sono uguali non posso inserire quel codice e devo rinserirne uno
				 * nuovo finche il confronto restituisce false.
				 * */
				while (negozio.getCodice(codice).equals(codice) == true) {
					System.out.print("Codice gia presente, inseriscine uno diverso: ");
					codice = scanner.nextLine();
				}
				//aggiungo il codice al prodotto
				prodotto.setCodice(codice);
				// descrizione
				System.out.print("Descrizione: ");
				descrizione = scanner.nextLine();
				prodotto.setDescrizione(descrizione);
				// prezzo
				System.out.print("Prezzo: ");
				prezzo = Float.parseFloat(scanner.nextLine());
				//il metodo set prezzo restituisce un booleano per capire se il prezzo inserito
				//e valido o meno
				//provo a settare il prezzo e viene restituito subito un booleano
				boolean statoPrezzo = prodotto.setPrezzo(prezzo);
				//si itera sul while solo se il prezzo inserito e falso
				while (statoPrezzo == false) {
					System.out.print("Prezzo: ");
					prezzo = Float.parseFloat(scanner.nextLine());
					statoPrezzo = prodotto.setPrezzo(prezzo);
				}
				// sconto
				System.out.print("Sconto: ");
				sconto = Float.parseFloat(scanner.nextLine());
				//stesso controllo usato per il prezzo
				boolean statoSconto = prodotto.setSconto(sconto);
				while (statoSconto == false) {
					System.out.print("Sconto: ");
					sconto = Float.parseFloat(scanner.nextLine());
					statoSconto = prodotto.setSconto(sconto);
				}
				// quantita
				System.out.print("Quantita disponibile: ");
				quantita = Integer.parseInt(scanner.nextLine());
				prodotto.setQuantitaDisponibile(quantita);
				//stesso controllo usato per il prezzo e lo sconto
				boolean statoQuantita = prodotto.setQuantitaDisponibile(quantita);
				while (statoQuantita == false) {
					System.out.print("Quantita disponibile: ");
					quantita = Integer.parseInt(scanner.nextLine());
					statoQuantita = prodotto.setQuantitaDisponibile(quantita);
				}
				negozio.setProdotti(codice, prodotto);
				System.out.println();
				break;
			//elenco prodotti
			case "2":
				System.out.println("Prodotti disponibili:");
				negozio.visualizzaProdotti();
				break;
			//applica sconto
			case "3":
				System.out.print("Inserisci il codice del prodotto a cui aggiungere lo sconto: ");
				codice = scanner.nextLine();
				String codiceProdottoNegozio = negozio.getCodice(codice);
				contatore=0;
				//finche il codice inserito non e presente tra i codici in negozio chiedo
				//che venga rinserito
				while (codice.equals(codiceProdottoNegozio) == false) {
					//se l'utente inserisce per piu volte un codice inesistente gli chiedo
					//se vuole uscire da questa opzione
					if (contatore > 0) {
						System.out.print("Vuoi uscire da questa opzione del menu? (si/no) ");
						String risposta = scanner.nextLine();
						if (risposta.equals("si")) {
							break; //esco dallo switch
						}
					}
					System.out.print("Codice non trovato, riprova: ");
					//si inserisce un nuovo codice
					codice = scanner.nextLine();
					//provo a prendere il nuovo codice se esiste
					codiceProdottoNegozio = negozio.getCodice(codice);
					contatore++;
				}
				if (codice.equals(codiceProdottoNegozio)) {
					System.out.print("Inserisci lo sconto da applicare: ");
					sconto = Float.parseFloat(scanner.nextLine());
					//stesso controllo fatto nell'opzione 1
					statoSconto = negozio.setSconto(codice, sconto);
					while (statoSconto == false) {
						System.out.print("Inserisci uno sconto valido: ");
						sconto = Float.parseFloat(scanner.nextLine());
						statoSconto = negozio.setSconto(codice, sconto);
					}
					negozio.setSconto(codice, sconto);
					System.out.println("Sconto inserito con successo!");
				}
				break;
			//vendita prodotti
			case "4":
				System.out.print("Inserisci il codice del prodotto che vuoi acquistare: ");
				codice = scanner.nextLine();
				contatore = 0;
				//controllo simile a quello dell'opzione 3 ma con la logica invertita
				while (!negozio.getCodice(codice).equals(codice)) {
					if (contatore > 0) {
						System.out.print("Vuoi uscire da questa opzione del menu? (si/no) ");
						String risposta = scanner.nextLine();
						if (risposta.equals("si")) {
							break;
						}
					}
					System.out.print("Codice non trovato, riprova: ");
					codice = scanner.nextLine();
					contatore++;
				}
				if (negozio.getCodice(codice).equals(codice)) {
					//prendo i dati che mi servono per quello specifico prodotto con appositi
					//metodi e grazie al codice del prodotto
					descrizione = negozio.getProdotto(codice).getDescrizione();
					prezzo = negozio.getProdotto(codice).getPrezzo();
					sconto=negozio.getProdotto(codice).getSconto();
					int quantitaDisponibile=negozio.getQuantita(codice);
					//calcolo il prezzo scontato
					Float prezzoScontato=prezzo - ((prezzo*sconto)/100);
					
					//se il prodotto e esaurito esco dallo switch
					if(quantitaDisponibile==0) {
						System.out.println("Prodotto esaurito.");
						break;
					}
					
					//altrimenti mostro i dati del prodotto che si sta acquistando
					System.out.println();
					System.out.println("Stai acquistando: "+descrizione);
					System.out.println("Prezzo originale: "+prezzo+" €");
					System.out.println("Sconto: "+sconto+"%");
					System.out.println("Prezzo scontato: "+prezzoScontato+" €");
					//chiedo di inserire la quantita
					System.out.print("Inserisci la quantità desiderata: ");
					quantita=Integer.parseInt(scanner.nextLine());
					//finche la quantita inserita e maggiore della quantita disponibile
					//chiedo di inserire una quantita valida
					while(quantitaDisponibile<quantita) {
						System.out.println("Puoi acquistare solo "+quantitaDisponibile+" unita. Riprova: ");
						quantita=Integer.parseInt(scanner.nextLine());
					}
					if(quantitaDisponibile>=quantita) {
						//setto la quantita aggiornata del prodotto nel negozio
						negozio.getProdotto(codice).setQuantitaDopoVendita(quantita);
						//prendo la quantita aggiornata e la mostro
						quantitaDisponibile = negozio.getQuantita(codice);
						System.out.println("Rimangono "+quantitaDisponibile+" unita.");
					}
				}
				break;
			default:
				System.out.println("Opzione non disponibile.");
			}
			System.out.print("Vuoi continuare? (si/no) ");
		} while (scanner.nextLine().equals("si"));

		scanner.close();
	}
}