package it.itis.cuneo;

/**
 * Created by inf.aimarv1906 on 30/10/2019.
 */

//eccezione della famiglia eccezioni
//extends permette di utilizzare la classe come eccezione
public class LibreriaPienaException extends Exception{
    private int codice;
    private String descrizione;

    public LibreriaPienaException(int codice, String descrizione) {
        this.codice = codice;
        this.descrizione = descrizione;
    }

    public String toString() {
        return "LibreriaPienaException {" + "\"codice\": " + codice + ", \"descrizione\": " + descrizione + '}';
    }
}
