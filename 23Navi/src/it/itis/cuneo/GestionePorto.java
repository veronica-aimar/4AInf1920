package it.itis.cuneo;/* classe gestione con main e leggi men�
 * classe porto con porto pieno exception su addNave
 * array di navi con cntNavi, MAX_NAVI, vettoreNavi
 * gerarchia di navi, set e get nel padre, creaNave() e costruttori dei figli e caricaNave chiamano i rispettivi del padre
 * Generare la toString
 * Riguardare la add(), find(), remove(), sort()
 * InputOutputUtility
 * SimpleDateFormate().parse() .format()
 */

public class GestionePorto {
	
	static InputOutputUtility t = new InputOutputUtility();
	
	public static void main (String[] args) {
		
		Porto porto = new Porto(0);
		int cntNavi = 0;
		int scelta = 0; 
		
		do
		{
			scelta = GestionePorto.scriviMenu();
			
			switch (scelta) {
				case 1:
					try {
						porto.addNave();
					} catch (PortoPienoException e) {
						e.printStackTrace();
						System.out.println(e.getDescrizione());
					}

					cntNavi++;
				case 2:
					System.out.println("La situazione al porto oggi: ");
					System.out.println(porto.toString());
					break;
				case 3: 
					System.out.println("La situazione al porto oggi ordinata per data di arrivo delle navi: ");
					System.out.println(porto.orderToString(porto));
				case 4:
					System.out.println("Inserisci data partenza: ");
					porto.findNaveInPortoByDataPartenza((java.sql.Date) t.leggiData());
					break;
				case 5:
					System.out.println("Inserisci lunghezza (###.##): ");
					porto.findNaveInPortoByLunghezza(t.leggiNumeroFloat());
					break;
				case 6:
					System.out.println("Inserisci l'attracco: ");
					int attracco = t.leggiNumero();
					int posNave = porto.findNaveInPortoByAttracco(attracco);
					porto.rimuoviNaveFromPorto(posNave);
					break;
				case 9:
					System.out.println("Caricamento dati di test.");
					porto.initPortoTest();
					break;
				case 0: 
					System.out.println("Grazie e arrivederci.");
					break;				
				default:
					System.out.println("Errore nell'inserimento. Riprovare.");
			}
		}
		while (scelta != 0);
	}
	
	public static int scriviMenu() {
		int scelta;
		
		System.out.println("Opzione 0: esci.");
		System.out.println("Menu");
		System.out.println("Opzione 1: aggiungi una nave al porto.");
		System.out.println("Opzione 2: visualizza dati di tutte le navi.");
		System.out.println("Opzione 3: visualizza dati di tutte le navi ordinate per la data di arrivo.");
		System.out.println("Opzione 4: cerca le nave che partono in una determinata data.");
		System.out.println("Opzione 5: cerca le nave che hanno una certa lunghezza.");
		System.out.println("Opzione 6: rimuovi la nave per una posizione di attracco.");
		
		System.out.println("Opzione 9: precarica dati di test.");
		System.out.println("Immettere l'opzione desiderata: ");
		scelta = t.leggiNumero();
		
		return scelta;
	}
}