package it.itis.cuneo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.Objects;

public class Brani {

    private String idBrano;
    private double durataBrano;
    private String artista;
    private String nomeBrano;

    public Brani () {
        super();
    }
    public Brani(String idBrano, double durataBrano, String artista, String nomeBrano) {
        this.idBrano = idBrano;
        this.durataBrano = durataBrano;
        this.artista = artista;
        this.nomeBrano = nomeBrano;
    }
    @XmlAttribute
    public String getIdBrano() {
        return idBrano;
    }
    public void setIdBrano(String idBrano) {
        this.idBrano = idBrano;
    }
    @XmlElement
    public double getDurataBrano() {
        return durataBrano;
    }
    public void setDurataBrano(double durataBrano) {
        this.durataBrano = durataBrano;
    }
    @XmlElement
    public String getArtista() {
        return artista;
    }
    public void setArtista(String artista) {
        this.artista = artista;
    }
    @XmlElement
    public String getNomeBrano() {
        return nomeBrano;
    }
    public void setNomeBrano(String nomeBrano) {
        this.nomeBrano = nomeBrano;
    }

    public String toRowCSV() {
        return "Brano" + Libreria.SEPARATOR + idBrano + Libreria.SEPARATOR + durataBrano + Libreria.SEPARATOR + artista + Libreria.SEPARATOR + nomeBrano + "\n";
    }

    @Override
    public String toString() {
        return "Brani{" +
                "idBrano='" + idBrano + '\'' +
                ", durataBrano=" + durataBrano +
                ", artista='" + artista + '\'' +
                ", nomeBrano='" + nomeBrano + '\'' +
                '}';
    }

    public String toRowCsv() {
        return "Brano"+ Libreria.SEPARATOR +idBrano + Libreria.SEPARATOR  + durataBrano + Libreria.SEPARATOR  + artista
                + Libreria.SEPARATOR  + nomeBrano + "\n";
    }

    public Brani caricaBrano() {
        idBrano = InputOutputUtility.leggiNome("inserire l'id del brano: ");
        durataBrano = InputOutputUtility.leggiNumeroDouble("inserire la durata del brano: ");
        artista = InputOutputUtility.leggiNome("inserire il nome dell'artista: ");
        nomeBrano = InputOutputUtility.leggiNome("inserire il nome del brano: ") ;
        Brani brano = new Brani(idBrano, durataBrano, artista, nomeBrano);
        return brano;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Brani brani = (Brani) o;
        return Double.compare(brani.durataBrano, durataBrano) == 0 &&
                Objects.equals(idBrano, brani.idBrano) &&
                Objects.equals(artista, brani.artista) &&
                Objects.equals(nomeBrano, brani.nomeBrano);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBrano, durataBrano, artista, nomeBrano);
    }

    @Override
    public String toXml(){
        return "\t<brani nome=\">" + idBrano + "\">\n" + "\t\t<durataBrano>" +
                durataBrano + "</durataBrano>\n" + "\t\t<artista>" + artista +
                "</artista>\n" + "\t\t<nomeBrano>" + nomeBrano + "</nomeBrano>" +
                "\t</brani>\n";
    }

}
