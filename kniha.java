package projekt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class kniha {
	private String nazov;
	private List<String> autori;
	private int rokVydania;
	private boolean jeDostupna;
	private ZanerRomanu zaner;

	public kniha(String nazov, List<String> autori, int rokVydania, ZanerRomanu zaner) {
		this.nazov = nazov;
		this.autori = autori;
		this.rokVydania = rokVydania;
		this.jeDostupna = true;
		this.zaner = zaner;
	}

	public String getNazov() {
		return nazov;
	}


	public List<String> getAutori() {
		return autori;
	}

	public void setRokVydania(int rokVydania) {
		this.rokVydania = rokVydania;
	}
	
	public int getRokVydania() {
		return rokVydania;
	}

	

	public boolean isJeDostupna() {
		return jeDostupna;
	}

	public void setJeDostupna(boolean jeDostupna) {
		this.jeDostupna = jeDostupna;
	}
	
	public ZanerRomanu getZaner() {
		return zaner;
	}
	
	public String getInfo() {
		return "Nazov: " + nazov + "\nAutori: " + autori + "\nRok vydania: " + rokVydania + "\nStav dostupnosti: " + (jeDostupna ? "K dispozicii" : "Vypozicane") + "\nZaner: " + zaner;
	}
	
}