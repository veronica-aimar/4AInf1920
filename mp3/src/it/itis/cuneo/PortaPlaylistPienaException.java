package it.itis.cuneo;

public class PortaPlaylistPienaException extends Exception{
    private int codice;
    private String descrizione;

    public PortaPlaylistPienaException(int codice, String descrizione) {
        this.codice = codice;
        this.descrizione = descrizione;
    }

    public String toString() {
        return "PortaPlaylistPienaException {\"codice\": " + codice + ", \"descrizione\": " + descrizione;
    }
}
