package it.itis.cuneo;

/**
 * Created by inf.aimarv1906 on 31/10/2019.
 */
public class ContenitorePienoException extends Throwable {
    private int codice;
    private String descrizione;

    public ContenitorePienoException(int codice, String descrizione) {
        this.codice = codice;
        this.descrizione = descrizione;
    }

    @Override
    public String toString() {
        return "ContenitorePienoException {\"codice\": " + codice + ", \"descrizione\": '" + descrizione + '}';
    }
}
