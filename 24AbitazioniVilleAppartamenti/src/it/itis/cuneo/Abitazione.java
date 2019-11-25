package it.itis.cuneo;

/**
 * Created by inf.aimarv1906 on 20/11/2019.
 */
public class Abitazione {
    //ATTRIBUTI
    private int nStanze;
    private double superficie;
    private String indirizzo;
    private String citta;

    //COSTRUTTORI
    public Abitazione() {
    }
    public Abitazione(int nStanze, double superficie, String indirizzo, String citta) {
        this.nStanze = nStanze;
        this.superficie = superficie;
        this.indirizzo = indirizzo;
        this.citta = citta;
    }
    public Abitazione(Abitazione a) {
        this.nStanze = a.getnStanze();
        this.superficie = a.getSuperficie();
        this.indirizzo = a.getIndirizzo();
        this.citta = a.getCitta();
    }

    //SET E GET
    public int getnStanze() {
        return nStanze;
    }
    public void setnStanze(int nStanze) {
        this.nStanze = nStanze;
    }
    public double getSuperficie() {
        return superficie;
    }
    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }
    public String getIndirizzo() {
        return indirizzo;
    }
    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }
    public String getCitta() {
        return citta;
    }
    public void setCitta(String citta) {
        this.citta = citta;
    }

    //TO STRING
    @Override
    public String toString() {
        return "nStanze=" + nStanze +
                ", superficie=" + superficie +
                ", indirizzo='" + indirizzo + '\'' +
                ", citta='" + citta;
    }

    //EQUALS
    @Override
    public boolean equals(Object o) {
        boolean ret = true;
        if(this != o)
        {
            ret = false;
        }
        if (o == null || getClass() != o.getClass())
        {
            ret = false;
        }

        Abitazione that = (Abitazione) o;

        if(ret) {
        if (nStanze != that.nStanze) {
            ret = false;
        }
        if (Double.compare(that.superficie, superficie) != 0) {
            ret = false;
        }
        if (indirizzo != null ? !indirizzo.equals(that.indirizzo) : that.indirizzo != null) {
            ret = false;
        }
            if (citta != null ? citta.equals(that.citta) : that.citta == null) {
                ret = false;
            }
        }
        return ret;
    }
}
