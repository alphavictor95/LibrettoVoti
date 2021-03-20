package it.polito.tdp.librettovoti.model;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Libretto {

	private List<Voto> voti;
	private Map<String, Voto> votiMap; // identity map nei database 
	                                   //nome esame-> oggetto voto
	
	public Libretto() {
		this.voti = new ArrayList<>(); //per ricordarmi che è una variabile dichiaarata a livello di istanza e non è locale
		                               // solo qui so di che tipo ho dichiarato il tipo di lista
		this.votiMap=new HashMap<>();
	}

	public void add(Voto v) {
	
		this.voti.add(v);
		this.votiMap.put(v.getNome(), v);
	}
	
	/*public String votiUguali(int punteggio) {
		//calcola una stringa che contiene i voti 
		//sara poi il chiamante a stampare
	}	*/
	public List<Voto> listaVotiUguali(int punteggio){
		//restituisce solo i voti uguali al criterio
		//difetto: espone la struttura dati all esterno
		List<Voto> risultato = new ArrayList<>();
		for(Voto v : voti) {
			if(v.getVoto()==punteggio) {
				risultato.add(v);
			}
		}
		return risultato;
	}
	
	public Libretto votiUguali (int punteggio) {
		// libretto che contiene soltato gli esami con il voto passato come criterio
		Libretto risultatoLibretto = new Libretto();
		for(Voto v : voti) {
			if(v.getVoto()==punteggio) {
				risultatoLibretto.add(v);
				
			}
		}
		return risultatoLibretto;
	}
	
	/**
	 * Ricerca un voto al corso passato come parametro
	 * @param nomeCorso
	 * @return
	 */
	
	public Voto ricercaCorso(String nomeCorso) {
		/*Voto risultato = null;
		for(Voto v : voti) {
			if(v.getNome().equals(nomeCorso)) {
				risultato=v;
			}
		}
		return risultato;*/
		return this.votiMap.get(nomeCorso);
	}
	
	private boolean esisteDuplicato(Voto v) {
		/*boolean trovato= false;
		for(Voto voto: this.voti) {
			if(voto.getNome().equals(v.getNome()) && voto.getVoto()==v.getVoto()) {
				trovato=true;
				break;
			}
		}*/
		Voto trovato = this.votiMap.get(v.getNome());
		if(trovato==null)
			return false;
		if(trovato.getVoto()==v.getVoto())
		    return true;
		else {
			return false;
		}
	}
	private boolean esisteConflitto(Voto v) {
		/*boolean trovato= false;
		for(Voto voto: this.voti) {
			if(voto.getNome().equals(v.getNome()) && voto.getVoto()!=v.getVoto()) {
				trovato=true;
				break;
			}
		}return trovato;
	*/
		Voto trovato = this.votiMap.get(v.getNome());
		if(trovato==null)
			return false;
		if(trovato.getVoto()!=v.getVoto())
		    return true;
		else {
			return false;
		}
	}
	public String toString() {
		String s = "";
		for (Voto v : this.voti) {
			s = s + v.toString() + "\n";
		}
		return s;
	}
}
