package it.itis.cuneo;

import java.util.Date;
import java.util.GregorianCalendar;

public class NaveMerci extends Nave {

	public NaveMerci() {
		//super() richiama il costruttore di Nave vuoto, perchè la classe naveMerci è estesa alla classe Nave
		super();
	}
	
	public NaveMerci(int tipoNave, float lunghezza, float larghezza, Date dataArrivo, int numeroPosizioneAttracco, String compagnia, GregorianCalendar tempoDiPermanenza) {
        //super() richiama il costruttore di Nave a cui vengono passati i parametri
		super(tipoNave, lunghezza, larghezza, dataArrivo, numeroPosizioneAttracco, compagnia, tempoDiPermanenza);
		// TODO Auto-generated constructor stub
	}

	public static void creaNave (Nave elencoNavi[], int cntNave, InputOutputUtility t) {
		elencoNavi[cntNave] = new NaveMerci();
		Nave.caricaNave(elencoNavi, cntNave, t);
	}
	
	public String toString() {
        //stampa il contenuto solo di Nave
		String s = new String(super.toString());
		
		return s;
	}
}