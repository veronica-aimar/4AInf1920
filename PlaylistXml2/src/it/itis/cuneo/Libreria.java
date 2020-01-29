package it.itis.cuneo;

import javax.swing.table.DefaultTableModel;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.*;
import java.util.Collections;
import java.util.List;

@XmlRootElement
public class Libreria {
    public static final String FILE_NAME = "F:\\triennio\\quarta_ainf\\informatica\\intelliJ\\PreventivoCsv\\preventivo.csv";
    public static final String SEPARATOR = ",";

    private List<Album> aAlbum;
    public static final int IVA= 22;

    public Libreria() {
        super();
    }
    public Libreria(List<Album> aAlbum) {
        this.aAlbum = aAlbum;
    }

    public void aggiungiAlbum(Brani album) {
        this.aAlbum.add(album);
    }

    public List<Album> getaAlbum() {
        return aAlbum;
    }
    public void setaCliente(List<Album> aCliente) {
        this.aAlbum = aAlbum;
    }

    public void simula() {
        Album c= new Album("2315", "album");
        Brani a= new Brani("26516", 2.30, "artista", "nome");
        Brani b= new Brani("487417", 1.50, "artista2", "nome2");
        c.aggiungiBrano(a);
        c.aggiungiBrano(b);
        this.aggiungiAlbum(c);

        Album c2= new Album("256232", "album2");
        Brani a2= new Brani("4145", 1.33, "artista3", "nome3");
        Brani b2= new Brani("52563", 3.55, "artista4", "nome4");
        c2.aggiungiBrano(a2);
        c2.aggiungiBrano(b2);
        this.aggiungiAlbum(c2);
    }

    public void caricaAlbum(Libreria libreria) {
        int numeroClienti=InputOutputUtility.leggiNumero("Inserisci il numero di album: ");

        Album c= new Album();
        for(int cntClienti=0;cntClienti<numeroClienti;cntClienti++) {
            c.caricaAlbum(libreria);
        }
    }

    @Override
    public String toString() {
        return "Libreria{" +
                "aAlbum=" + aAlbum +
                '}';
    }

    public void stampa() {
        System.out.println( this.toString() );
    }

    public void stampConFor() {
        float numLibreria=0;
        for(int cntAlbum = 0; cntAlbum<this.aAlbum.size(); cntAlbum++) {
            Album album = this.getaAlbum().get(cntAlbum);
            System.out.println("Album: " + album.toString());
            double totaleDurata = album.calcolaDurataTotale();
            System.out.println("Durata totale: " + totaleDurata);

            numLibreria += totaleDurata;
        }
        System.out.println("Totale durata: " + numLibreria);

    }

    public void ordinaLibreriaoByNomeAlbum() {
        Collections.sort( this.aAlbum );
    }

    public Album ricercaAlbumById(String idAlbum) {
        Album album = null;
        boolean foundAlbum = false;

        for(int cntAlbum = 0; cntAlbum<this.aAlbum.size() && !foundAlbum; cntAlbum++) {
            album = this.aAlbum.get(cntAlbum);
            if(album.getIdAlbum().equalsIgnoreCase(idAlbum)){
                foundAlbum = true;
            }
            else {
                album = null;
            }
        }

        return album;
    }

    public void salvaCSV() {
        String str ="";
        BufferedWriter bw;
        try {
            bw= new BufferedWriter(new FileWriter(FILE_NAME));

            for(int cntAlbum=0; cntAlbum<this.aAlbum.size(); cntAlbum++)
            {
                Album album = this.aAlbum.get(cntAlbum);
                bw.write(album.toRowCSV());

                for(int cntBrano=0; cntBrano<album.getaBrani().size(); cntBrano++) {
                    Brani brani = album.getaBrani().get(cntBrano);
                    bw.write(brani.toRowCsv());
                }
            }

            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void apriCSV() {
        BufferedReader br;
        String rowLine;
        Album album1 = null;

        try {
            br = new BufferedReader(new FileReader(FILE_NAME));

            while((rowLine = br.readLine()) != null) {
                String[] campi = rowLine.split(Libreria.SEPARATOR);
                if(campi[0].equalsIgnoreCase("Album")) {
                    Album album = new Album(campi[1], campi[2]);
                    this.aggiungiAlbum(album);
                }
                if(campi[0].equalsIgnoreCase("Brano")) {
                    //public Articolo(String codice, String descrizione, double importoSenzaIVA, int scontoPercentuale, int quantita)
                    Brani brano = new Brani(campi[1], Double.parseDouble(campi[2]) , campi[3], campi[4]);
                    album1.aggiungiBrano(brano);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[]args) {
        //metodo simula()
        Libreria p= new Libreria();
        p.simula();

        System.out.println("\n\n\n*********<stampa libreria...");
        p.stampa();

        System.out.println("\n\n\n*********stampa libreria con for..");
        p.stampConFor();

        System.out.println("\n\n\n*********stampa libreria ordinata..");
        p.ordinaLibreriaoByNomeAlbum();
        p.stampa();

        System.out.println("\n\n\n*********stampa preventivo dopo rimuovi..");
        Album album = p.ricercaAlbumById("nome");
        if(album != null) {
            album.eliminaBrano("A1");
        }
        p.stampa();

        p.salvaCSV();

        Libreria libreria = new Libreria();
        libreria.apriCSV();
        System.out.println("\n\n\n*********stampa libreria dopo caricamento da CSV..");
        libreria.stampa();
    }

    public void scriviXml() {
        BufferedWriter bw = null;
        try {
            simulaPercorso();
            bw = new BufferedWriter(new FileWriter(FILE_NAME));
            bw.write(this.toXml());
            System.out.println(this.toXml());
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void marshallingXml(){
        try {
            //bisogna specificare il nome del file
            File file = new File(Libreria.FILE_NAME);

            JAXBContext jaxbContext = JAXBContext.newInstance(Libreria.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(this, file);
            jaxbMarshaller.marshal(this, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public void unmarshallingXml() {
        try {
            File file = new File(Libreria.FILE_NAME);
            JAXBContext jaxbContext = JAXBContext.newInstance(Libreria.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Libreria libreria = (Libreria) jaxbUnmarshaller.unmarshal(file);
            System.out.println(libreria);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

    private void simulaLibreria() {
        //Percorso percorso = new Percorso();
        Brani brano1 = new Brani("b1", 2.00, "artista", "nome");
        this.aggiungiAlbum(brano1);
        Brani brano2 = new Brani("b2", 3.15, "artista2", "nome");
        this.aggiungiAlbum(brano2);
        Brani brano3 = new Brani("b3", 2.56, "artista3", "nome");
        this.aggiungiAlbum(brano3);
    }

    public void caricaTabella(DefaultTableModel tableModelPunti) {
        for(Brani brano: this.libreria) {
            tableModelPunti.addRow(new Object[] {brano.getIdBrano(), brano.getDurataBrano(), brano.getArtista(), brano.getNomeBrano() });
        }
    }
}
