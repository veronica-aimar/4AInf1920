package it.itis.cuneo;

/**
 * Created by inf.aimarv1906 on 17/10/2019.
 */
public class Libro {
    //Attributi
    private String titolo;
    private Autore autore;
    private CasaEditrice casaEditrice;
    private int giorno;
    private int mese;
    private int anno;

    //Metodi
    //costruttori
    public Libro() {
        super();
        this.autore = new Autore();
        this.casaEditrice = new CasaEditrice();
    }
    public Libro(String titolo, Autore autore, CasaEditrice casaEditrice, int giorno, int mese, int anno) {
        this.titolo = titolo;
        this.autore = new Autore(autore);
        this.casaEditrice = new CasaEditrice(casaEditrice);
        this.giorno = giorno;
        this.mese = mese;
        this.anno = anno;
    }
    public Libro(Libro l) {
        this.titolo = l.getTitolo();
        this.autore = new Autore(l.autore);
        this.casaEditrice = new CasaEditrice(l.casaEditrice);
        this.giorno = l.getGiorno();
        this.mese = l.getMese();
        this.anno = l.getAnno();
    }

    //set e get
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
    public String getTitolo() {
        return this.titolo;
    }
    public void setGiorno(int giorno) {
        this.giorno = giorno;
    }
    public int getGiorno() {
        return this.giorno;
    }
    public void setMese(int mese) {
        this.mese = mese;
    }
    public int getMese() {
        return this.mese;
    }
    public void setAutore(int anno) {
        this.anno = anno;
    }
    public int getAnno() {
        return this.anno;
    }

    public String toString() {
        return "Libro {\"titolo\": " + this.titolo + ", \"autore\": " + this.autore + ", \"casaEditrice\": " + this.casaEditrice + ", \"giorno\": " + this.giorno + ", \"mese\": " + this.mese + ", \"anno\": "
                + this.anno + "}";
    }

    public static void main(String[] args) {
        Autore autore0 = new Autore("Veronica", "Aimar", 2002);
        CasaEditrice casaEditrice0 = new CasaEditrice("Mondadori", "Cuneo", 1999);

        Libro libro0 = new Libro("Titolo", autore0, casaEditrice0, 12, 02, 2019);

        System.out.println(libro0.toString());
    }
}
