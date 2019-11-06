package it.itis.cuneo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by inf.aimarv1906 on 21/10/2019.
 */
public class Casello {
    //ATTRIBUTI
    //Calendar serve per inserire una data che ha anche ore, minuti, secondi
    private String identifier;
    private Calendar dataEntrata;
    private Calendar dataUscita;

    //METODI
    //costruttori
    public Casello() {super();}
    public Casello(Calendar dataEntrata, Calendar dataUscita, String identifier) {
        this.identifier = identifier;
        this.dataEntrata = dataEntrata;
        this.dataUscita = dataUscita;
    }
    public Casello(Casello c) {
        //tutti i tipi non elementari devono chiamare il costruttore, altrimenti ho due oggetti che puntano alla stessa cella di memoria
        this.identifier = new String (c.getIdentifier());
        this.dataUscita = c.getDataUscita();
        //essendo vuoto corrisponde all' 01/01/1970
        //method factory. è un metodo che produce un'istanza che punta al 01/01/1970
        //si usa la getIstance() perchè in base a dove ci si trova, va a richiamare i costruttori per determinati calendari
        Calendar cDataIngresso = Calendar.getInstance();
        //permette di settare la data
        cDataIngresso.setTime(c.getDataEntrata().getTime());
        //Calendar cData = new Calendar() non esiste. è protected
        this.dataEntrata = cDataIngresso;

        Calendar cDataUscita = Calendar.getInstance();
        cDataUscita.setTime(c.getDataUscita().getTime());
        this.dataUscita = cDataUscita;
    }

    //set e get
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
    public String getIdentifier() {
        return identifier;
    }
    public void setDataEntrata(Calendar dataEntrata) {
        this.dataEntrata = dataEntrata;
    }
    public Calendar getDataEntrata() {
        return dataEntrata;
    }
    public void setDataUscita(Calendar dataUscita) {
        this.dataUscita = dataUscita;
    }
    public Calendar getDataUscita() {
        return dataUscita;
    }

    public static void main(String[] args) {
        //creazione della data
        //stringa -> data
        /*
        si usa la simpleDateFormat che usa un pattern che rappresenta come io voglio andare a tradurre quello che devo ottenere dalla
        stringa
        pattern: formato della data rappresentato da una stringa
        es.       23/10/2019 09:25:43      pattern: dd/MM/yyyy HH:mi:ss
        Se l'utente sbaglia ad inserire da tastiera il pattern, non viene presa. Quindi all'utente bisogna sempre dare il formato della data
        */
        //c'è "final" perchè il pattern è costante
        final String FORMATO_DD_HMS = "dd/MM/yyyy HH:mi:ss";
        String strDataPartenza = "29/08/2002 13:30:40";
        Calendar cDataEntrata = Calendar.getInstance();
        //inserimento all'interno di setTime di una stringa con la data
        SimpleDateFormat sdfHH = new SimpleDateFormat(FORMATO_DD_HMS);
        //prende una stringa e tira fuori una data. Fa un'operazione di parsificazione
        //parsificare una stringa secondo un formato permette di ottenere una variabile di altro tipo
       //l'eccezione è un'anomalia software che si verifica quando il codice genera un errore in tempo di esecuzione
        //in questo caso la parseException sta a rappresentare che la stringa non rispetta il formato
        Date dataPartenza=null;
        try {
            dataPartenza = sdfHH.parse(strDataPartenza);
        } catch (ParseException e) {
            //parseException è l'errore del formato della stringa, che quindi non può essere convertita
            //viene stampato una StackTrace che è una traccia delo stack. è l'elenco delle chiamate ai metodi
            e.printStackTrace();
        }
        //la setTime sono il numero di secondi
        //Calendar mantiene il numero di secondi dal 01/01/1970, quindi se stampo questo valore a video trovo un numero long
        cDataEntrata.setTime(dataPartenza);
        System.out.println("cDataEntrata: " + cDataEntrata);

        //simpleDateFormat.format()
        String strData = sdfHH.format(dataPartenza);
        System.out.println("\n\nsdfHH.format(dataPartenza): " + sdfHH.format(cDataEntrata));
    }
}


