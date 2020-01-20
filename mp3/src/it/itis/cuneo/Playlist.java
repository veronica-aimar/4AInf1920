package it.itis.cuneo;

import com.sun.security.jgss.InquireSecContextPermission;

import java.util.Random;

public class Playlist {
    private static final int MAX_BRANI = 20;
    private Brano[] vPlaylist;
    private int contatore;

    public Playlist() {
        super();
    }
    public Playlist(Brano[] vPlaylist, int contatore) {
        this.vPlaylist = vPlaylist;
        this.contatore = contatore;
    }

    public void aggiungiBrano(Brano brano) throws PortaPlaylistPienaException{
        if(contatore > MAX_BRANI)
        {
            throw new PortaPlaylistPienaException(1, "Troppi cd");
        }
        vPlaylist[contatore] = brano;
        contatore++;
    }

    public int eliminaBrano(String titolo) {
        int errore = -1;
        for (int i=0; i<contatore; i++) {
            if (vPlaylist[i].titolo.equals(titolo)) {
                vPlaylist[i] = null;
                errore = 0;
            }
        }
        return errore;
    }

    public float durataTotalePlaylist() {
        float durata = 0;
        for (int i=0; i<contatore; i++) {
            durata = durata + vPlaylist[i].durata;
        }
        return durata;
    }

    public int esportazioneBrani(int n) {
        int errore = -1;
        if (n < contatore) {
            errore = 0;
            int cntVettore = 0;
            Playlist vettore = new Playlist();
            for (int i = 0; i < n; i++) {
                vettore[cntVettore] = vPlaylist[i];
                cntVettore++;
            }
        }
        return errore;
    }

    public void esportazionePerTempo(float t) {
        float durata = 0;
        Playlist vettore = new Playlist();
        int i=0;
        while(durata < t && i<contatore) {
            vettore[i] = vPlaylist[i];
        }
    }

    public int spostamentoPosizionePrecedente(int posizione) {
        int errore = -1;
        if (vPlaylist[posizione] != null) {
            errore = 0;
            Brano jolly = vPlaylist[posizione];
            vPlaylist[posizione] = vPlaylist[posizione - 1];
            vPlaylist[posizione - 1] = jolly;
        }
        return errore;
    }

    public int spostamentoPosizioneSuccessiva(int posizione) {
        int errore = -1;
        if (vPlaylist[posizione] != null && vPlaylist[posizione + 1] != null) {
            errore = 0;
            Brano jolly = vPlaylist[posizione];
            vPlaylist[posizione] = vPlaylist[posizione + 1];
            vPlaylist[posizione + 1] = jolly;
        }
        return errore;
    }

    public void ripristinoFile() {
        vPlaylist.toFile();
    }

    public void shuffle() {
        int valoreCasuale = 0;
        for(int i=0; i<contatore; i++) {
            valoreCasuale = nextInt();
            Brano jolly = vPlaylist[i];
            vPlaylist[i] = valoreCasuale[valoreCasuale];
            vPlaylist[valoreCasuale] = jolly;
        }
    }

    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        int cntBrani = 0;
        int scelta = 0;
        do {
            scelta = Playlist.scriviMenu();
            switch (scelta) {
                case 1:
                    try {
                        Brano brano = new Brano(InputOutputUtility.leggiNome("Inserisci il nome del brano: "), InputOutputUtility.leggiNumeroFloat("Inserisci la durata del brano: "));
                        playlist.aggiungiBrano(brano);
                    } catch (PortaPlaylistPienaException e) {
                        e.printStackTrace();
                        System.out.println(e.toString());
                    }
                    cntBrani++;
                case 2:
                    String titolo = InputOutputUtility.leggiNome("Inserisci il nome del brano da eliminare: ");
                    if (playlist.eliminaBrano(titolo) == -1) {
                        System.out.println("Non è stato trovato il brano richiesto");
                    }
                    break;
                case 3:
                    System.out.println("La durata totale dei brani è " + playlist.durataTotalePlaylist());
                case 4:
                    int n = InputOutputUtility.leggiNumero("Inserisci il numero di brani da esportare: ");
                    if (playlist.esportazioneBrani(n) == -1) {
                        System.out.println("Il numero inserito è maggiore del numero di brani contenuti all'interno della playlist");
                        break;
                        case 5:
                            float tempo = InputOutputUtility.leggiNumeroFloat("Inserisci il tempo fino a cui esportare: ");
                            playlist.esportazionePerTempo(tempo);
                            break;
                        case 6:
                            int posizione = InputOutputUtility.leggiNumero("Inserisci la posizione del brano: ");
                            if (playlist.spostamentoPosizionePrecedente(posizione) == -1) {
                                System.out.println("Nella posizione inserita non è presente nessun brano");
                            }
                            break;
                        case 7:
                            int posizione = InputOutputUtility.leggiNumero("Inserisci la posizione del brano: ");
                            if (playlist.spostamentoPosizioneSuccessiva(posizione) == -1) {
                                System.out.println("Nella posizione inserita non è presente nessun brano");
                            }
                            break;
                        case 8:
                            playlist.ripristinoFile();
                            System.out.println("Esportazione avvenuta");
                            break;
                        case 9:
                            playlist.shuffle();
                            System.out.println("Riordino casuale avvenuto");
                            break;
                        case 0:
                            System.out.println("Arrivederci!!!!!");
                            break;
                        default:
                            System.out.println("Errore nell'inserimento. Riprovare.");
                            break;
                    }
            }
        }while (scelta != 0);
    }

    public int scriviMenu() {
        int scelta;
        System.out.println("Menu");
        System.out.println("Opzione 0: esci");
        System.out.println("Opzione 1: aggiungi un brano alla playlist");
        System.out.println("Opzione 2: eliminazione di un brano");
        System.out.println("Opzione 3: determinazione della durata totale dei brani nella playlist");
        System.out.println("Opzione 4: esportazione di n elementi");
        System.out.println("Opzione 5: esportazione dei primi n minuti di brani");
        System.out.println("Opzione 6: spostamento di un brano nella posizione precedente");
        System.out.println("Opzione 7: spostamento di un brano nella posizione successiva");
        System.out.println("Opzione 8: ripristino della playlist");
        System.out.println("Opzione 9: riordinamento casuale dei brani");

        scelta = InputOutputUtility.leggiNumero("Immettere l'opzione desiderata: ");

        return scelta;
    }
}
