package it.itis.cuneo;

import java.util.ArrayList;
import java.util.List;

public class Album implements Comparable {

    private  String idAlbum;
    private  String nomeAlbum;
    private  List<Brani> aBrani;

    public Album(String idAlbum, String nomeAlbum) {
        this.idAlbum = idAlbum;
        this.nomeAlbum = nomeAlbum;
        this.aBrani = aBrani;
        aBrani= new ArrayList<Brani>();
    }
    public Album() {
        super();
    }

    public void aggiungiBrano(Brani brano) {
        this.aBrani.add(brano);
    }

    public void caricaAlbum(Libreria libreria) {

        idAlbum = InputOutputUtility.leggiNome("Inserire l'id dell'album: ");
        nomeAlbum = InputOutputUtility.leggiNome("Inserire il nome dell'album: ");
        Album album = new Album(idAlbum, nomeAlbum);
        libreria.aggiungiAlbum(album);

        int numeroBrani = InputOutputUtility.leggiNumero("inserisci il numero di brani: ");
        for(int cntBrani = 0; cntBrani<numeroBrani; cntBrani++) {
            Brani brano = new Brani();
            brano = brano.caricaBrano();
            album.aggiungiBrano(brano);
        }
    }

    public String getIdAlbum() {
        return idAlbum;
    }
    public void setIdAlbum(String idAlbum) {
        this.idAlbum = idAlbum;
    }
    public String getNomeAlbum() {
        return nomeAlbum;
    }
    public void setNomeAlbum(String nomeAlbum) {
        this.nomeAlbum = nomeAlbum;
    }
    public List<Brani> getaBrani() {
        return aBrani;
    }
    public void setaBrani(List<Brani> aBrani) {
        this.aBrani = aBrani;
    }

    @Override
    public String toString() {
        return "Album{" +
                "idAlbum='" + idAlbum + '\'' +
                ", nomeAlbum='" + nomeAlbum + '\'' +
                ", aBrani=" + aBrani +
                '}';
    }

    public String toRowCSV() {
        return "Album" + Libreria.SEPARATOR + idAlbum + Libreria.SEPARATOR + nomeAlbum + "\n";
    }


    public double calcolaDurataTotale() {
        double durataTotale = 0;
        double durata;

        for(int cntAlbum=0; cntAlbum<this.aBrani.size(); cntAlbum++) {
            Brani brani = this.aBrani().get(cntAlbum);
            durata = this.aBrani.get(cntAlbum).getDurataBrano();
            durataTotale = durataTotale + durata;
        }
        return durataTotale;
    }

    public void eliminaBrano(String idBrano) {

        int numAlbum = this.aBrani.size();
        for(int cntBrani=0; cntBrani<numAlbum; cntBrani++) {

            if( ( this.aBrani.get(cntBrani).getIdBrano() ).equalsIgnoreCase( idBrano ) ) {
                this.aBrani.remove(cntBrani);
            }
        }

    }

    @Override
    public int compareTo(Object arg0) {
        Album album = (Album) arg0;

        if(this.idAlbum.equalsIgnoreCase( album.nomeAlbum))
            return 1; //true
        else
            return 0;
    }

}
