package org.generation.italy;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		String codice, descrizione, opzione;
		float prezzo, sconto;
		int quantita;
		
		Scanner scanner = new Scanner(System.in);
		
		Negozio negozio = new Negozio();
		
		do {
			System.out.println("\n1=Inserimento prodotto\n2=Elenco prodotti\n3=Applica sconto\n4=Vendita prodotti\n\nInserisci l'opzione: ");
			opzione=scanner.nextLine();
			
			Prodotto prodotto = new Prodotto();
			
			switch(opzione) {
			case "1":
				System.out.println("Inserisci i dati del prodotto:");
				//codice
				System.out.print("Codice: ");
				codice=scanner.nextLine();
				while(negozio.getCodice(codice).equals(codice)==true) {
					System.out.print("Codice gia presente, inseriscine uno diverso: ");
					codice=scanner.nextLine();
				}
				prodotto.setCodice(codice);
				//descrizione
				System.out.print("Descrizione: ");
				descrizione=scanner.nextLine();
				prodotto.setDescrizione(descrizione);
				//prezzo
				System.out.print("Prezzo: ");
				prezzo=Float.parseFloat(scanner.nextLine());
				boolean statoPrezzo=prodotto.setPrezzo(prezzo);
				while(statoPrezzo==false) {
					System.out.print("Prezzo: ");
					prezzo=Float.parseFloat(scanner.nextLine());
					statoPrezzo=prodotto.setPrezzo(prezzo);
				}
				//sconto
				System.out.print("Sconto: ");
				sconto=Float.parseFloat(scanner.nextLine());
				boolean statoSconto=prodotto.setSconto(sconto);
				while(statoSconto==false) {
					System.out.print("Sconto: ");
					sconto=Float.parseFloat(scanner.nextLine());
					statoSconto=prodotto.setSconto(sconto);
				}
				//quantita
				System.out.print("Quantita disponibile: ");
				quantita=Integer.parseInt(scanner.nextLine());
				prodotto.setQuantitaDisponibile(quantita);
				boolean statoQuantita=prodotto.setQuantitaDisponibile(quantita);
				while(statoQuantita==false) {
					System.out.print("Quantita disponibile: ");
					quantita=Integer.parseInt(scanner.nextLine());
					statoQuantita=prodotto.setQuantitaDisponibile(quantita);
				}
				negozio.setProdotti(codice, prodotto);
				System.out.println();
				break;
			case "2":
				System.out.println("Prodotti disponibili:");
				negozio.visualizzaProdotti();
				break;
			case "3":
				System.out.print("Inserisci il codice del prodotto a cui aggiungere lo sconto: ");
				codice=scanner.nextLine();
				String codiceProdottoNegozio=negozio.getCodice(codice);
				int contatore=0;
				while(codice.equals(codiceProdottoNegozio)==false) {
					if(contatore>0) {
						System.out.print("Vuoi uscire da questa opzione del menu? (si/no) ");
						String risposta=scanner.nextLine();
						if(risposta.equals("si")) {
							break;
						}
					}
					System.out.print("Codice non trovato, riprova: ");
					codice=scanner.nextLine();
					codiceProdottoNegozio=negozio.getCodice(codice);
					contatore++;
				}
				if(codice.equals(codiceProdottoNegozio)){
					System.out.print("Inserisci lo sconto da applicare: ");
					sconto=Float.parseFloat(scanner.nextLine());
					statoSconto=negozio.setSconto(codice, sconto);
					while(statoSconto==false) {
						System.out.print("Inserisci uno sconto valido: ");
						sconto=Float.parseFloat(scanner.nextLine());
						statoSconto=negozio.setSconto(codice, sconto);
					}
					negozio.setSconto(codice, sconto);
					System.out.println("Sconto inserito con successo!");
				}
				break;
			case "4":
				System.out.println("Inserisci il codice del prodotto che vuoi acquistare");
				codice=scanner.nextLine();
				break;
			default:
				System.out.println("Opzione non disponibile.");
			}
			System.out.print("Vuoi continuare? (si/no) ");
		}while(scanner.nextLine().equals("si"));
		
		scanner.close();
	}
}
