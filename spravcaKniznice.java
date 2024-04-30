package projekt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class spravcaKniznice {
	private List<kniha> knihy;
	
	public spravcaKniznice() {
		this.knihy = new ArrayList<>();
	}
	
	/*public void pridatKnihu(kniha kniha) {
		knihy.add(kniha);
	}*/
	
	public void pridatNovuKnihu(kniha kniha) {
        knihy.add(kniha);
    }
	
	public void upravitKnihu(String nazov, String novyAutor, int novyRokVydania, boolean novaDostupnost) {
		for (kniha kniha : knihy) {
			if (kniha.getNazov().equals(nazov)) {
			kniha.getAutori().clear();
			kniha.getAutori().add(novyAutor);
			kniha.setRokVydania(novyRokVydania);
			kniha.setJeDostupna(novaDostupnost);
			System.out.println("Kniha bola uspesne upravena.");
			return;
			}
		} 
		System.out.println("Kniha s tymto nazvom nebola najdena.");
	}
	
	public void vymazatKnihu(String nazov) {
		for (int i = 0; i < knihy.size(); i++) {
			kniha kniha = knihy.get(i);
			if (kniha.getNazov().equals(nazov)) {
				knihy.remove(i);
				System.out.println("Kniha bola uspesne zmazana.");
				return;
			}
		}
		System.out.println("Kniha s tymto nazvom neexistuje.");
	}
	
	public void oznacitKnihuAkoVypozicanu(String nazov) {
		for (kniha kniha : knihy) {
			if (kniha.getNazov().equals(nazov)) {
				kniha.setJeDostupna(false);
				System.out.println("Kniha bola oznacena ako vypozicana.");
				return;
			}
		}
		System.out.println("Kniha s tymto nazvom neexistuje.");
	}
	
	public void oznacitKnihuAkoVratenu(String nazov) {
		for (kniha kniha : knihy) {
			if (kniha.getNazov().equals(nazov)) {
				kniha.setJeDostupna(true);
				System.out.println("Kniha bola oznacena ako vratena.");
				return;
			}
		}
		System.out.println("Kniha s tymto nazvom neexistuje.");
	}
	
	public void vypisatVsetkyKnihy() {
		for (kniha kniha : knihy) {
			System.out.println(kniha.getInfo());
		}
	}
	
	public void vyhladatKnihu(String nazov) {
		for (kniha kniha : knihy) {
			if (kniha.getNazov().equals(nazov)) {
				System.out.println(kniha.getInfo());
				return;
			}
		}
		System.out.println("Kniha s tymto nazvom neexistuje.");
	}
	
	public void vypisatKnihyPodlaAutora(String autor) {
		boolean najdena = false;
		for (kniha kniha : knihy) {
			if (kniha.getAutori().contains(autor)) {
				System.out.println(kniha.getInfo());
				najdena = true;
			}
		}
		if (!najdena) {
			System.out.println("Kniha tohoto autora nebola najdena.");
		}
	}
	
	public void vypisatKnihyPodlaZanru(String zaner) {
		boolean najdena = false;
		for (kniha kniha : knihy) {
			if (kniha.getZaner().equals(zaner)) {
				System.out.println(kniha.getInfo());
				najdena = true;
			}
		}
		if (!najdena) {
			System.out.println("Kniha tohoto zanru nebola najdena.");
		}
	}
	
	public void vypisatVypozicaneKnihyPodlaTypu() {
		for (kniha kniha : knihy) {
			if (!kniha.isJeDostupna()) {
				System.out.println(kniha.getInfo() + (kniha instanceof ucebnica ? " (Ucebnica)" : " (Roman)"));
			}
		}
	}

}
