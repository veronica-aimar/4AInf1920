package it.itis.cuneo;

/**
 * Created by inf.aimarv1906 on 20/11/2019.
 */
public class Appartamento extends Abitazione{
    //ATTRIBUTI
    private int piano;
    private boolean ascensore;
    private int nBalconi;

    //COSTRUTTORI
    public Appartamento(int piano, boolean ascensore, int nBalconi) {
        this.piano = piano;
        this.ascensore = ascensore;
        this.nBalconi = nBalconi;
    }
    public Appartamento(int nStanze, double superficie, String indirizzo, String citta, int piano, boolean ascensore, int nBalconi) {
        super(nStanze, superficie, indirizzo, citta);
        this.piano = piano;
        this.ascensore = ascensore;
        this.nBalconi = nBalconi;
    }
    public Appartamento(Abitazione a, int piano, boolean ascensore, int nBalconi) {
        super(a);
        this.piano = piano;
        this.ascensore = ascensore;
        this.nBalconi = nBalconi;
    }

    //SET E GET
    public int getPiano() {
        return piano;
    }
    public void setPiano(int piano) {
        this.piano = piano;
    }
    public boolean isAscensore() {
        return ascensore;
    }
    public void setAscensore(boolean ascensore) {
        this.ascensore = ascensore;
    }
    public int getnBalconi() {
        return nBalconi;
    }
    public void setnBalconi(int nBalconi) {
        this.nBalconi = nBalconi;
    }

    //TOSTRING
    @Override
    public String toString() {
        return "Appartamento{" + super.toString() +
                "piano=" + piano +
                ", ascensore=" + ascensore +
                ", nBalconi=" + nBalconi +
                '}';
    }

    //EQUALS
    @Override
    public boolean equals(Object o) {
        boolean ret = true;
        if (this != o) {
            ret = false;
        }
        if (o == null || getClass() != o.getClass()) {
            ret = false;
        }
        if (!super.equals(o)) {
            ret = false;
        }

        Appartamento that = (Appartamento) o;

        if(ret) {
        if (piano != that.piano) {
            ret = false;
        }
        if (ascensore != that.ascensore)
        {
            ret = false;
        }
            if (nBalconi != that.nBalconi) {
                ret = false;
            }
        }
        return ret;
    }
}
