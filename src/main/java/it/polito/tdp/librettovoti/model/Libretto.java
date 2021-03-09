package it.polito.tdp.librettovoti.model;


import java.util.ArrayList;
import java.util.List;

public class Libretto {

	private List<Voto> voti;
	
	public Libretto() {
		this.voti = new ArrayList<>(); //per ricordarmi che è una variabile dichiaarata a livello di istanza e non è locale
		                               // solo qui so di che tipo ho dichiarato il tipo di lista
	}

	public void add(Voto v) {
	
		this.voti.add(v);
	}
	public String toString() {
		String s = "";
		for (Voto v : this.voti) {
			s = s + v.toString() + "\n";
		}
		return s;
	}
}
