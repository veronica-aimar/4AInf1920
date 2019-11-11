package it.itis.cuneo;

/**
 * Created by inf.aimarv1906 on 07/11/2019.
 */
public class PortaCDPienoException  extends Exception{
    private int codice;
    private String descrizione;

    public PortaCDPienoException(int codice, String descrizione) {
        this.codice = codice;
        this.descrizione = descrizione;
    }

    public String toString() {
        return "PortaCdPienoException {\"codice\": " + codice + ", \"descrizione\": " + descrizione;
    }
}
