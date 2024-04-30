package projekt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class aplikaciaKniznice {

	public static void main(String[] args) {
		spravcaKniznice kniznica = new spravcaKniznice();
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.println("Vyberte akciu:");
			System.out.println("1. Pridat novu knihu");
			System.out.println("2. Upravit knihu");
			System.out.println("3. Zmazat knihu");
			System.out.println("4. Oznacit knihu ako vypozicanu");
			System.out.println("5. Oznacit knihu ako vratenu");
			System.out.println("6. Vypisat vsetky knihy");
			System.out.println("7. Vyhladat knihu");
			System.out.println("8. Vypisat knihy daneho autora");
			System.out.println("9. Vypisat knihy daneho zanru");
			System.out.println("10. Vypisat vypozicane knihy s informaciou o type");
			System.out.println("0. Ukoncit program");
			
			int volba = scanner.nextInt();
			scanner.nextLine();
			
			switch (volba) {
				case 0:
					System.out.println("Program ukonceny.");
					return;
				case 1:
					System.out.println("Zvolte typ knihy:");
				    System.out.println("1. Roman");
				    System.out.println("2. Ucebnica");
				    int typKnihy = scanner.nextInt();
				    scanner.nextLine(); // absorb newline
				    
				    if (typKnihy == 1) {
				        System.out.println("Zadajte nazov romanu:");
				        String nazovRomanu = scanner.nextLine();
				        
				        System.out.println("Zadajte autorov romanu (oddelene ciarkou):");
				        String[] autoriInput = scanner.nextLine().split(",");
				        List<String> autori = new ArrayList<>();
				        for (String autor : autoriInput) {
				            autori.add(autor.trim());
				        }
				        
				        System.out.println("Zadajte rok vydania romanu:");
				        int rokVydania = scanner.nextInt();
				        scanner.nextLine(); // absorb newline
				        
				        System.out.println("Zadajte zaner romanu:");
				        String zanerRomanu = scanner.nextLine();
				        
				        roman novyRoman = new roman(nazovRomanu, autori, rokVydania, zanerRomanu);
				        kniznica.pridatNovuKnihu(novyRoman);
				    } else if (typKnihy == 2) {
				        System.out.println("Zadajte nazov ucebnice:");
				        String nazovUcebnice = scanner.nextLine();
				        
				        System.out.println("Zadajte autorov ucebnice (oddelene ciarkou):");
				        String[] autoriInput = scanner.nextLine().split(",");
				        List<String> autori = new ArrayList<>();
				        for (String autor : autoriInput) {
				            autori.add(autor.trim());
				        }
				        
				        System.out.println("Zadajte rok vydania ucebnice:");
				        int rokVydani = scanner.nextInt();
				        scanner.nextLine(); // absorb newline
				        
				        System.out.println("Zadajte rocnik, pre ktory je ucebnica urcena:");
				        int rocnik = scanner.nextInt();
				        scanner.nextLine(); // absorb newline
				        
				        ucebnica novaUcebnice = new ucebnica(nazovUcebnice, autori, rokVydani, rocnik);
				        kniznica.pridatNovuKnihu(novaUcebnice);
				    } else {
				        System.out.println("Neplatna volba.");
				    }
				    break;
				case 2:
					System.out.println("Zadajte nazov knihy, ktoru chcete upravit:");
					String upravitNazov = scanner.nextLine();
					System.out.println("Zadajte noveho autora knihy:");
					String novyAutor = scanner.nextLine();
					System.out.println("Zadajte novy rok vydania:");
					int novyRokVydania = scanner.nextInt();
					scanner.nextLine();
					System.out.println("Zadajte novy stav dostupnosti (true/false):");
					boolean movaDostupnost = scanner.nextBoolean();
					scanner.nextLine();
					kniznica.upravitKnihu(upravitNazov, novyAutor, novyRokVydania, movaDostupnost);
					break;
				case 3:
					System.out.println("Zadajte nazov knihy, ktoru chcete zmazat:");
					String zmazatNazov = scanner.nextLine();
					kniznica.vymazatKnihu(zmazatNazov);
					break;
				case 4:
					System.out.println("Zadajte nazov knihy, ktoru chcete oznacit ako vypozicanu:");
					String vypozicatNazov = scanner.nextLine();
					kniznica.oznacitKnihuAkoVypozicanu(vypozicatNazov);
					break;
				case 5:
					System.out.println("Zadajte nazov knihy, ktoru chcete oznacit ako vratenu:");
					String vratitNazov = scanner.nextLine();
					kniznica.oznacitKnihuAkoVratenu(vratitNazov);
					break;
				case 6:
					kniznica.vypisatVsetkyKnihy();
					break;
				case 7:
					System.out.println("Zadajte nazov knihy, ktoru chcete vyhladat:");
					String vyhladatNazov = scanner.nextLine();
					kniznica.vyhladatKnihu(vyhladatNazov);
					break;
				case 8:
					System.out.println("Zadajte meno autora, ktoreho knihy chcete vypisat:");
					String menoAutora = scanner.nextLine();
					kniznica.vypisatKnihyPodlaAutora(menoAutora);
					break;
				case 9:
					System.out.println("Zadajte zaner knih, ktore chcete vypisat:");
					String zaner = scanner.nextLine();
					kniznica.vypisatKnihyPodlaZanru(zaner);
					break;
				case 10:
					System.out.println("Vypozicane knihy s informaciou o type:");
					kniznica.vypisatVypozicaneKnihyPodlaTypu();
					break;
				default:
					System.out.println("Neplatna volba. Skuste to znova.");
				
			}



		}

	}

}
