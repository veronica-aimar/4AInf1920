package it.itis.cuneo;

/**
 * Created by inf.aimarv1906 on 07/11/2019.
 */
public class ContenitoreException extends Exception {
    private int codice;
    private String descrizione;

    public ContenitoreException(int codice, String descrizione) {
        this.codice = codice;
        this.descrizione = descrizione;
    }

    public String toString() {
        return "ProgrammaException {\"codice\": " + codice + ", \"descrizione\"; " + descrizione;
    }
}
