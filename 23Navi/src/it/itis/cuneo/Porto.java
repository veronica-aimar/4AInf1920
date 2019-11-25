package it.itis.cuneo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Porto {
	
	public static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static final int NAVE_NON_TROVATA = -1;
	public static final int MAX_NAVI = 50;
	private Nave elencoNavi[];
	private static int cntNavi;
	InputOutputUtility t;
	
	public Porto(int cntNavi) {
		super();
		this.cntNavi = cntNavi;
		
		//l'istanza di un oggetto contenuto in un altro va realizzata all'interno del costruttore della classe contenitore 
		elencoNavi = new Nave[MAX_NAVI];
		t = new InputOutputUtility();
	}
	
	public Porto(Nave[] elencoNavi) {
		super();
		this.elencoNavi = elencoNavi;
	}

	public void addNave() throws PortoPienoException {
		if (cntNavi > MAX_NAVI) {
			throw new PortoPienoException(1, "Porto pieno: nave merci non accettata.");
		}
		
		//elencoNavi[cntNavi] = new NaveMerci();
		Nave.caricaNave(elencoNavi, cntNavi, t);
		this.cntNavi++;
	}
	
	
	public String toString() {
		String s = "";
		
		for(int cntNave = 0; cntNave < this.cntNavi; cntNave++) {
			Nave nave = elencoNavi[cntNave];
			
			if (nave.getTipoNave() == Nave.NAVE_PASSEGGERI) {
				s= s + "cntNave: " +cntNave+ " " + ( (NavePasseggeri) nave ).toString() + "\n";
			}
			else {
				s= s + "cntNave: " +cntNave+ " " + ( (NaveMerci) nave ).toString() + "\n";
			}
		}
		
		return s;
	}
	
	public void findNaveInPortoByLunghezza(float lunghezza) {
		
		String s = "";
		
		for(int cntNave = 0; cntNave < this.cntNavi; cntNave++) {
			Nave nave = elencoNavi[cntNave];
			if(nave.getLunghezza() == lunghezza) {
				if (nave.getTipoNave() == Nave.NAVE_PASSEGGERI) {
					s = "cntNave: " +cntNave+ " " + ( (NavePasseggeri) nave ).toString();
				}
				else {
					s = "cntNave: " +cntNave+ " " + ( (NaveMerci) nave ).toString();
				}
				System.out.println(s);
			}
		}
	}
	
	public int findNaveInPortoByAttracco(int attracco) {
		int posizione = NAVE_NON_TROVATA;
		
		for(int cntNave = 0; cntNave < this.cntNavi; cntNave++) {
			Nave nave = elencoNavi[cntNave];
			if(nave.getNumeroPosizioneAttracco() == attracco) {
				posizione = cntNave;
			}
		}
		
		return posizione;
	}
	
	
	public void rimuoviNaveFromPorto(int posizioneNave) {
		
		for (int cntNave = posizioneNave; cntNave < this.cntNavi; cntNave++) {
			elencoNavi[cntNave] = elencoNavi[cntNave + 1];
		}
		this.cntNavi--;
	}
	
	
	public void findNaveInPortoByDataPartenza(Date dataPartenza) {
		
		String s = "";
		
		for(int cntNave = 0; cntNave < this.cntNavi; cntNave++) {
			Nave nave = elencoNavi[cntNave];
			long dataNavePartenzaLong = nave.getDataArrivo().getTime() + 86400 * 1; //tempoPermanenza;
			if( dataNavePartenzaLong == dataPartenza.getTime()) {
				if (nave.getTipoNave() == Nave.NAVE_PASSEGGERI) {
					s = "cntNave: " +cntNave+ " " + ( (NavePasseggeri) nave ).toString();
				}
				else {
					s = "cntNave: " +cntNave+ " " + ( (NaveMerci) nave ).toString();
				}
				System.out.println(s);
			}
		}
	}
	
	/*public NavePasseggeri(int tipoNave, float lunghezza, float larghezza, Date dataArrivo, int numeroPosizioneAttracco,
			String compagnia, GregorianCalendar tempoDiPermanenza, int Passeggeri) */
	public void initPortoTest() {
		this.cntNavi=5;
		
		try {
			this.elencoNavi[0] = new NavePasseggeri(Nave.NAVE_PASSEGGERI, (float)100.00, (float)15.00, df.parse("2001-03-25 14:13:30"), 1, "MSC", new GregorianCalendar(), 4);

			this.elencoNavi[1] = new NaveMerci(Nave.NAVE_MERCI, (float)96.00, (float)17.00, df.parse("2001-09-07 14:17:30"), 2, "MSC", new GregorianCalendar());
			
			this.elencoNavi[2] = new NavePasseggeri(Nave.NAVE_PASSEGGERI, (float)46.00, (float)15.00, df.parse("2001-03-07 14:00:30"), 3, "MSC", new GregorianCalendar(), 109);
			
			this.elencoNavi[3] = new NaveMerci(Nave.NAVE_MERCI, (float)55.00, (float)13.00, df.parse("2002-03-30 14:12:30"), 4, "MSC", new GregorianCalendar());
			
			this.elencoNavi[4] = new NavePasseggeri(Nave.NAVE_PASSEGGERI, (float)33.00, (float)15.00, df.parse("2001-08-16 20:13:30"), 5, "MSC", new GregorianCalendar(), 54);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public Porto clonaPorto() {
		Porto porto = new Porto(elencoNavi);
		
		return porto;
	}
	
	
	public String orderToString(Porto portoOriginale) {
		String sPorto;
		Porto portoClone =  portoOriginale.clonaPorto();
		portoClone.ordinaNaviPerDataArrivo();
		sPorto = portoClone.toString();
		
		return sPorto;
	}
	
	public void ordinaNaviPerDataArrivo() {
		Nave naveTemp, navePrima, naveDopo;
		
		for (int i = 0; i < this.cntNavi - 1; i++) {
			for (int j = 0; j < cntNavi - i - 1; j++) {
				navePrima = elencoNavi[j];
				naveDopo = elencoNavi[j + 1];
				if ( !( navePrima.getDataArrivo().before(naveDopo.getDataArrivo()) ) ) {
					naveTemp = elencoNavi[j];
					elencoNavi[j] = elencoNavi[j + 1];
					elencoNavi[j + 1] = naveTemp;
				}
			}
		}
	}
}