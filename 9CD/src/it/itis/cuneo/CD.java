package it.itis.cuneo;
import java.lang.Math;

/**
 * Created by inf.aimarv1906 on 09/10/2019.
 */
public class CD {
    //ATTRIBUTI
    private String titolo;
    private String autore;
    private int numeroBrani;
    private int durata;


    //METODI

    //costruttori
    public CD() {super();}
    public CD(String titolo, String autore, int numeroBrani, int durata) {
        this.titolo = titolo;
        this.autore = autore;
        this.numeroBrani = numeroBrani;
        this.durata = durata;
    }
    public CD(CD cd) {
        this.titolo = cd.titolo;
        this.autore = cd.autore;
        this.numeroBrani = cd.numeroBrani;
        this.durata = cd.durata;
    }

    //set e get
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
    public String getTitolo() {
        return this.titolo;
    }
    public void setAutore(String autore) {
        this.autore = autore;
    }
    public String getAutore() {
        return this.autore;
    }
    public void setNumeroBrani(int numeroBrani) {
        this.numeroBrani = numeroBrani;
    }
    public int getNumeroBrani() {
        return this.numeroBrani;
    }
    public void setDurata(int durata) {
        this.titolo = titolo;
    }
    public int getDurata() {
        return this.durata;
    }

    public String toString() {
        return "CD {\"titolo\": " + this.titolo + ", \"autore\": " + this.autore + ", \"numeroBrani\": " + this.numeroBrani + ", \"durata\": " + this.durata;
    }

    public boolean compareDurata(CD cd) {
        boolean uguale = false;
        if(this.durata == cd.getDurata())
        {
            uguale = true;
        }
        return uguale;
    }

    public static void main(String[] args) {

        CD cd = new CD("titolo", "autore", 10, 106);

        CD cd1 = new CD();

        System.out.println(cd.toString());

        boolean equals;
        equals = cd.compareDurata(cd1);
        if(equals)
        {
            System.out.println("Le durate sono uguali");
        }
        else
        {
            System.out.println("Le durate non sono uguali");
        }
    }
}