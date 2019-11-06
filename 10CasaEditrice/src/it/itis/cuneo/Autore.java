package it.itis.cuneo;

/**
 * Created by inf.aimarv1906 on 17/10/2019.
 */
public class Autore {
    //ATTRIBUTI
    private String nome;
    private String cognome;
    private int annoNascita;

    //METODI
    //costruttore
    public Autore() {
        super();
    }
    public Autore(String nome, String cognome, int annoNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.annoNascita = annoNascita;
    }
    public Autore(Autore a) {
        this.nome = a.getNome();
        this.cognome = a.getCognome();
        this.annoNascita = a.getAnnoNascita();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public String getCognome() {
        return cognome;
    }
    public void setAnnoNascita(int annoNascita) {
        this.annoNascita = annoNascita;
    }
    public int getAnnoNascita() {
        return annoNascita;
    }
}
