package it.itis.cuneo;

public class Programma {
    private String denominazione;
    private String produttore;
    private int versione;
    private String sistemaOperativo;
    private int anno;

    public Programma() {super();}
    public Programma(String denominazione, String produttore, int versione, String  sistemaOperativo, int anno) {
        this.denominazione = denominazione;
        this.produttore = produttore;
        this.versione = versione;
        this.sistemaOperativo = sistemaOperativo;
        this.anno = anno;
    }
    public Programma(Programma p) {
        this.denominazione = p.getDenominazione();
        this.produttore = p.getProduttore();
        this.versione = p.getVersione();
        this.sistemaOperativo = p.getSistemaOperativo();
        this.anno = p.getAnno();
    }

    public void setDenominazione(String denominazione) {
        this.denominazione = denominazione;
    }
    public String getDenominazione() {
        return denominazione;
    }
    public void setProduttore(String produttore) {
        this.produttore = produttore;
    }
    public String getProduttore() {
        return produttore;
    }
    public void setVersione(int versione) {
        this.versione = versione;
    }
    public int getVersione() {
        return versione;
    }
    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }
    public String getSistemaOperativo() {
        return sistemaOperativo;
    }
    public void setAnno(int anno) {
        this.anno = anno;
    }
    public int getAnno() {
        return anno;
    }

    public String toString() {
        return "Programma {\"denominazione\": " + this.denominazione + ", \"produttore\": " + this.produttore + ", \"versione\": " + this.versione
                + ", \"sistema operativo\": " + this.sistemaOperativo + ", \"anno\": " + this.anno + "}";
    }
    public int compareAnno(Programma a) {
        int compare;
        if(this.anno != a.getAnno())
        {
            if (this.anno > a.getAnno())
            {
                compare = this.anno - a.getAnno();
            } else
            {
                compare = a.getAnno() - this.anno;
            }
        }
        else
        {
            compare = 0;
        }
        return compare;
    }

    public static void main(String[] args) {
        Programma programma0 = new Programma("nome", "produzione", 2, "windows", 2005);
        Programma programma1 = new Programma("nome2", "produzione2", 1, "linux", 2008);

        System.out.println("I programmi hanno " + programma0.compareAnno(programma1) + " anni di differenza");

        System.out.println(programma0.toString());
    }
}