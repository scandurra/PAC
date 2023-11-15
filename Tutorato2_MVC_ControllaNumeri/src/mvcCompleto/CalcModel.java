package mvcCompleto;

import java.util.ArrayList;
import java.util.Observable;

/*
 *  Definiamo il modello come "Observable". Una classe model che estende
 *  "Observable" può essere gestita in modo molto più sempice, in quanto ogni
 *  modifica fatta al suo contenuto, genera in automatico una notifica
 *  per gli observer
 */
public class CalcModel extends Observable{
	// La "memoria" vera e propria del modello  
	private String result;
	private ArrayList<Integer> numbersList;

	// Costruttore: chiama il reset per (re)impostare il valore inizale
	CalcModel() {
		reset();
	}

	// Reset del valore iniziale
	public void reset() {
		System.out.println("[MODEL] reset ");
		result = "";
		numbersList = new ArrayList<>();
		// Comunica un cambio dello stato
		setChanged();
		// Notifica gli observer (la view)
		notifyObservers();
		System.out.println("[MODEL] Observers notified (reset)");
	}


	// Moltiplica per il valore passato come stringa 
	// Attenzione: non dalla GUI ma dal controller
	public void checkNumber(String newNumber) {
		// Controllo se il numero esiste nella lista
		if (numbersList.contains(Integer.parseInt(newNumber))) {
			result = "Numero già esistente";
		} else {
			result = "Numero nuovo";
			numbersList.add(Integer.parseInt(newNumber));
		}		
		
		System.out.println("[MODEL] Checked "+ newNumber);
		// Comunica un cambio dello stato
		setChanged();
		// Notifica gli observer (la view)
		notifyObservers();
		System.out.println("[MODEL] Observers notified (mult)");
	}

	// Ritorna il valore della "memoria"
	public String getResult() {
		return result;
	}
}
