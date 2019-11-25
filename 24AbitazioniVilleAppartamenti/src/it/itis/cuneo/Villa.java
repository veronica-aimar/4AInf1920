package it.itis.cuneo;

/**
 * Created by inf.aimarv1906 on 20/11/2019.
 */
public class Villa extends Abitazione{
    private int nPiani;
    private double superficieGiardino;
    private boolean piscina;

    public Villa() {
        super();
    }
    public Villa(int nPiani, double superficieGiardino, boolean piscina) {
        this.nPiani = nPiani;
        this.superficieGiardino = superficieGiardino;
        this.piscina = piscina;
    }
    public Villa(int nStanze, double superficie, String indirizzo, String citta, int nPiani, double superficieGiardino, boolean piscina) {
        super(nStanze, superficie, indirizzo, citta);
        this.nPiani = nPiani;
        this.superficieGiardino = superficieGiardino;
        this.piscina = piscina;
    }
    public Villa(Abitazione a, int nPiani, double superficieGiardino, boolean piscina) {
        super(a);
        this.nPiani = nPiani;
        this.superficieGiardino = superficieGiardino;
        this.piscina = piscina;
    }

    public int getnPiani() {
        return nPiani;
    }
    public void setnPiani(int nPiani) {
        this.nPiani = nPiani;
    }
    public double getSuperficieGiardino() {
        return superficieGiardino;
    }
    public void setSuperficieGiardino(double superficieGiardino) {
        this.superficieGiardino = superficieGiardino;
    }
    public boolean isPiscina() {
        return piscina;
    }
    public void setPiscina(boolean piscina) {
        this.piscina = piscina;
    }

    //TOSTRING
    @Override
    public String toString() {
        return "Villa{" + super.toString() +
                ", nPiani=" + nPiani +
                ", superficieGiardino=" + superficieGiardino +
                ", piscina=" + piscina +
                '}';
    }

    //EQUALS
    @Override
    public boolean equals(Object o) {
        boolean ret = true;
        if(this != o)
        {
            ret = false;
        }
        if (o == null || getClass() != o.getClass()) {
            ret = false; }
        if (!super.equals(o)) {
            ret = false; }

        Villa villa = (Villa) o;
        if(ret) {
            if (nPiani != villa.nPiani)
                ret = false;
            if (Double.compare(villa.superficieGiardino, superficieGiardino) != 0)
                ret = false;
            if(piscina != villa.piscina)
            {
                ret = false;
            }
        }
        return ret;
    }
}
