package it.itis.cuneo;

import java.util.Date;
import java.util.GregorianCalendar;

public class Nave {
	public static final int NAVE_PASSEGGERI = 0;
	public static final int NAVE_MERCI = 1;
	
	private int tipoNave;
	private float lunghezza;
	private float larghezza;
	private Date dataArrivo;
	private int numeroPosizioneAttracco; 
	private String compagnia;
	private GregorianCalendar tempoDiPermanenza; 
	
	public Nave() {
	}
	
	public Nave(int tipoNave, float lunghezza, float larghezza, Date dataArrivo, int numeroPosizioneAttracco,
			String compagnia, GregorianCalendar tempoDiPermanenza) {
		super();
		this.tipoNave = tipoNave;
		this.lunghezza = lunghezza;
		this.larghezza = larghezza;
		this.dataArrivo = dataArrivo;
		this.numeroPosizioneAttracco = numeroPosizioneAttracco;
		this.compagnia = compagnia;
		this.tempoDiPermanenza = tempoDiPermanenza;
	}
	
	public int getTipoNave() {
		return tipoNave;
	}
	public void setTipoNave(int tipoNave) {
		this.tipoNave = tipoNave;
	}
	public float getLunghezza() {
		return lunghezza;
	}
	public void setLunghezza(float lunghezza) {
		this.lunghezza = lunghezza;
	}
	public float getLarghezza() {
		return larghezza;
	}
	public void setLarghezza(float larghezza) {
		this.larghezza = larghezza;
	}
	public Date getDataArrivo() {
		return dataArrivo;
	}
	public void setDataArrivo(Date dataArrivo) {
		this.dataArrivo = dataArrivo;
	}
	public int getNumeroPosizioneAttracco() {
		return numeroPosizioneAttracco;
	}
	public void setNumeroPosizioneAttracco(int numeroPosizioneAttracco) {
		this.numeroPosizioneAttracco = numeroPosizioneAttracco;
	}
	public String getCompagnia() {
		return compagnia;
	}
	public void setCompagnia(String compagnia) {
		this.compagnia = compagnia;
	}
	public GregorianCalendar getTempoDiPermanenza() {
		return tempoDiPermanenza;
	}
	public void setTempoDiPermanenza(GregorianCalendar tempoDiPermanenza) {
		this.tempoDiPermanenza = tempoDiPermanenza;
	}
		
	public static void caricaNave (Nave elencoNavi[], int cntNave, InputOutputUtility t) {
		int tipoNave;
		System.out.println("\nDati nave: ");
		do {
			System.out.println("Tipo nave (0 : passeggeri / 1 : merci) :");
			tipoNave = t.leggiNumero();
		} 
		while ((tipoNave < 0) || (tipoNave > 1));
		
		if (tipoNave == Nave.NAVE_PASSEGGERI) {
			elencoNavi[cntNave] = new NavePasseggeri();
			System.out.println("Numero passeggeri: ");
			( (NavePasseggeri)elencoNavi[cntNave] ).setNumPasseggeri(t.leggiNumero());
		}
		else {
			elencoNavi[cntNave] = new NaveMerci();
		}
		elencoNavi[cntNave].setTipoNave(tipoNave);
		System.out.println("Lunghezza: ");
		elencoNavi[cntNave].setLunghezza(t.leggiNumeroFloat());
		System.out.println("Larghezza: ");
		elencoNavi[cntNave].setLarghezza(t.leggiNumeroFloat());
		System.out.println("Data arrivo (yyyy-mm-dd): ");
		elencoNavi[cntNave].setDataArrivo(t.leggiData());
		System.out.println("Attracco numero: ");
		elencoNavi[cntNave].setNumeroPosizioneAttracco(t.leggiNumero());
		System.out.println("Compagnia:");
		elencoNavi[cntNave].setCompagnia(t.leggiNome());
	}
	
	public String toString() {
		String descTipoNave = this.tipoNave==Nave.NAVE_PASSEGGERI ? "PASSEGGERI" : "MERCI";
		String s = new String("Tipo Nave: "+descTipoNave+" Lunghezza: " +lunghezza+ " Larghezza: " +larghezza+ " Data arrivo: " +
				Porto.df.format(dataArrivo)+ " Attracco numero: " +numeroPosizioneAttracco+ " Compagnia: " +compagnia);
		
		return s;
	}
}