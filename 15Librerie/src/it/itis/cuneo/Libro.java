package it.itis.cuneo;
import java.util.Calendar;

/**
 * Created by inf.aimarv1906 on 30/10/2019.
 */
public class Libro {
    private String titolo;
    private String autore;
    private String isbn;
    private Calendar dataPubblicazione;

    public Libro() {
    }

    //COSTRUTTORI
    public Libro(Calendar dataPubblicazione, String isbn, String autore, String titolo) {
        this.titolo = titolo;
        this.autore = autore;
        this.isbn = isbn;
        this.dataPubblicazione = dataPubblicazione;
    }
    public Libro(Libro libro) {
        this.titolo = libro.getTitolo();
        this.autore = libro.getAutore();
        this.isbn = libro.getIsbn();
        this.dataPubblicazione = libro.getDataPubblicazione();
    }
    //SET E GET
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
    public String getTitolo() {
        return titolo;
    }
    public void setDataPubblicazione(Calendar dataPubblicazione) {
        this.dataPubblicazione = dataPubblicazione;
    }
    public Calendar getDataPubblicazione() {
        return dataPubblicazione;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setAutore(String autore) {
        this.autore = autore;
    }
    public String getAutore() {
        return autore;
    }

    public boolean equals(Libro libro) {
        boolean equals = false;
        //controllo anche che gli handler non puntino a null
        if(titolo != null && titolo.equals(libro.getTitolo()) && autore != null && autore.equals(libro.getAutore()) && isbn != null && isbn.equals(libro.getIsbn()) && dataPubblicazione != null && dataPubblicazione.equals(libro.getDataPubblicazione()))
        {
            equals = true;
        }
        return equals;
    }
}
