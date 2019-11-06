package it.itis.cuneo;

/**
 * Created by inf.aimarv1906 on 07/10/2019.
 */
public class Rettangolo {

    //attributi
    private Segmento segmentoAlto;
    private Segmento segmentoDestro;
    private Segmento segmentoBasso;
    private Segmento segmentoSinistro;

    public Rettangolo(Segmento segmentoAlto, Segmento segmentoDestro, Segmento segmentoBasso, Segmento segmentoSinistro) {
        this.segmentoAlto = new Segmento(segmentoAlto);
        this.segmentoBasso = new Segmento(segmentoBasso);
        this.segmentoDestro = new Segmento(segmentoDestro);
        this.segmentoSinistro = new Segmento(segmentoSinistro);
    }

    public Rettangolo(Rettangolo rettangolo) {
        this.segmentoSinistro = new Segmento(rettangolo.getSegmentoSinistro());
        segmentoDestro = new Segmento(rettangolo.getSegmentoDestro());
        segmentoAlto = new Segmento(rettangolo.getSegmentoAlto());
        segmentoBasso = new Segmento(rettangolo.getSegmentoBasso());
    }

    public void setSegmentoAlto(Segmento segmentoAlto) {
        this.segmentoAlto = segmentoAlto;
    }
    public Segmento getSegmentoAlto() {
        return segmentoAlto;
    }

    public void setSegmentoBasso(Segmento segmentoBasso) {
        this.segmentoBasso = segmentoBasso;
    }
    public Segmento getSegmentoBasso() {
        return segmentoBasso;
    }

    public void setSegmentoDestro(Segmento segmentoDestro) {
        this.segmentoDestro = segmentoDestro;
    }
    public Segmento getSegmentoDestro() {
        return segmentoDestro;
    }

    public void setSegmentoSinistro(Segmento segmentoSinistro) {
        this.segmentoSinistro = segmentoSinistro;
    }
    public Segmento getSegmentoSinistro() {
        return segmentoSinistro;
    }

    public String toString() {
        return "Segmento alto --> \"segmento Alto\"" + segmentoAlto + ", \"segmento destro\": " + segmentoDestro + ", \"segmento sinistro\": " + segmentoSinistro +
                ", \"segmento basso\": " + segmentoBasso;
    }

    public boolean equals(Rettangolo rettangolo) {
        boolean equals = false;
        if(this.segmentoAlto.equals(rettangolo.getSegmentoAlto())
            && this.segmentoBasso.equals(rettangolo.getSegmentoBasso()) &&
                this.segmentoDestro.equals(rettangolo.getSegmentoDestro()) &&
                this.segmentoSinistro.equals(rettangolo.getSegmentoSinistro()))
        {
            equals = true;
        }
        return equals;
    }
}
