package projekt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class aplikaciaKniznice {

	public static void main(String[] args) {
		spravcaKniznice kniznica = new spravcaKniznice();
		Scanner scanner = new Scanner(System.in);
		ZanerRomanu zaner = null;
		
		
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
			System.out.println("11. Ulozit knihu do suboru");
			System.out.println("12. Pridat knihu zo suboru");
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
				        
				        System.out.println("Vyberte žáner romanu:");
		                        System.out.println("1. Detektívny");
		                        System.out.println("2. Historický");
		                        System.out.println("3. Psychologický");
		                        System.out.println("4. Romantický");
		                        System.out.println("5. Sci-Fi");
		                        int volbaZanru = scanner.nextInt();
		                        scanner.nextLine();
		                        switch (volbaZanru) {
		                            case 1:
		                                zaner = ZanerRomanu.DETEKTIVNY;
		                                break;
		                            case 2:
		                                zaner = ZanerRomanu.HISTORICKY;
		                                break;
		                            case 3:
		                                zaner = ZanerRomanu.PSYCHOLOGICKY;
		                                break;
		                            case 4:
		                                zaner = ZanerRomanu.ROMANTICKY;
		                                break;
		                            case 5:
		                                zaner = ZanerRomanu.SCI_FI;
		                                break;
		                            default:
		                                System.out.println("Neplatná voľba, nastavujem záner na Detektívny.");
		                                zaner = ZanerRomanu.DETEKTIVNY;
		                        }
				        
				        roman novyRoman = new roman(nazovRomanu, autori, rokVydania, zaner);
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
				    System.out.println("1. Detektívny");
				    System.out.println("2. Historický");
				    System.out.println("3. Psychologický");
				    System.out.println("4. Romantický");
				    System.out.println("5. Sci-Fi");
				    int volbaZanru = scanner.nextInt();
				    scanner.nextLine(); 
				    switch (volbaZanru) {
				        case 1:
				            zaner = ZanerRomanu.DETEKTIVNY;
				            break;
				        case 2:
				            zaner = ZanerRomanu.HISTORICKY;
				            break;
				        case 3:
				            zaner = ZanerRomanu.PSYCHOLOGICKY;
				            break;
				        case 4:
				            zaner = ZanerRomanu.ROMANTICKY;
				            break;
				        case 5:
				            zaner = ZanerRomanu.SCI_FI;
				            break;
				        default:
				            System.out.println("Neplatná voľba, vypisujem všetky knihy.");
				            kniznica.vypisatVsetkyKnihy();
				            break;
				    }
				    if (volbaZanru >= 1 && volbaZanru <= 5) {
				        kniznica.vypisatKnihyPodlaZanru(zaner);
				    }
				    break;
				case 10:
					System.out.println("Vypozicane knihy s informaciou o type:");
					kniznica.vypisatVypozicaneKnihyPodlaTypu();
					break;
				case 11:
				    System.out.println("Zadajte nazov suboru, do ktoreho chcete ulozit knihu:");
				    String nazovSuboru = scanner.nextLine();
				    System.out.println("Zadajte nazov knihy, ktoru chcete ulozit do suboru:");
				    String nazovKnihy = scanner.nextLine();
				    boolean ulozena = kniznica.ulozDoSuboru(nazovSuboru, nazovKnihy);
				    if (ulozena) {
				        System.out.println("Kniha uspesne ulozena do suboru " + nazovSuboru + ".");
				    } else {
				        System.out.println("Kniha nebola ulozena do suboru.");
				    }
				    break;
				case 12:
				    System.out.println("Zadajte nazov suboru, z ktoreho chcete nacitat knihu:");
				    String nazovSuboru1 = scanner.nextLine();
				    boolean pridanaKniha = kniznica.pridatNovuKnihuZoSuboru(nazovSuboru1);
				    if (pridanaKniha) {
				        System.out.println("Kniha uspesne pridana zo suboru " + nazovSuboru1 + ".");
				    } else {
				        System.out.println("Kniha nebola pridana zo suboru.");
				    }
				    break;

				/* case 13:
					vlozKnihu2();
					break;
				default:
					System.out.println("Neplatna volba. Skuste to znova.");
				
			} */



		}

	}
	//SQL SQL SQL SQL SQL SQL SQL SQL
	
	/*private static void vlozKnihu(Connection conn, String nazov, List<String> autori, int rokVydania, boolean jeDostupna, ZanerRomanu zaner) throws SQLException {
		String autoritxt; autoritxt = String.join(", ", autori);
		System.out.println(autoritxt);
		String insertSQL = "INSERT INTO Knihy(nazov, autori, rokVydania,jeDostupna, zaner) VALUES(?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(insertSQL);
    	   pstmt.setString(1, nazov);
    	   pstmt.setString(2, autoritxt);
    	   pstmt.setInt(3, rokVydania);
    	   pstmt.setBoolean(4, jeDostupna);
    	   pstmt.setInt(5, zaner.ordinal());
    	   pstmt.executeUpdate();
       }
	 
	
	private static void vlozKnihu2()
	{
		Connection conn = null;
		try {
			//Class.forName("org.sqlite.JDBC");
				//String url = "jdbc:sqlite:\\sqlite-jdbc-3.45.3.0.jar";
            String url = "jdbc:sqlite:books.db";
				//conn = DriverManager.getConnection("jdbc:sqlite:sqlite-jdbc-3.45.3.0.jar");
				conn = DriverManager.getConnection(url);
				//conn = DriverManager.getConnection("jdbc:sqlite:kniznica.db");
				System.out.println("Databaza otvorena!");
				//deleteTable(conn); //table musi existovat
				String insertSQL = "INSERT INTO Knihy(nazov, autori, rokVydania,jeDostupna, zaner) VALUES('Test nazov','adam','1.1.2024',1,1)";
				PreparedStatement pstmt = conn.prepareStatement(insertSQL);

				conn = DriverManager.getConnection("jdbc:sqlite:kniznica.db");
				System.out.println("Databaza otvorena!");
				String autoritxt; autoritxt = String.join(", ", autori);
				System.out.println(autoritxt);
				String insertSQL = "INSERT INTO Knihy(nazov, autori, rokVydania,jeDostupna, zaner) VALUES(?,?,?,?,?)";
				PreparedStatement pstmt = conn.prepareStatement(insertSQL);
		    	   pstmt.setString(1, nazov);
		    	   pstmt.setString(2, autoritxt );
		    	   pstmt.setInt(3, rokVydania );
		    	   pstmt.setBoolean(4, jeDostupna );
		    	   pstmt.setInt(5, zaner.ordinal() );
		    	   pstmt.executeUpdate();
			
				pstmt.executeUpdate();
		}
		catch (Exception ignored) {
			System.out.println(ignored.getLocalizedMessage());
			//nic to neurobi
		}
		//createTable(conn);
		finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println(e.getMessage());
				}
			}
		}
	}
	
	public static void createTable(Connection conn) throws SQLException {
		// String createTablesq = " " +
	} */
}
}