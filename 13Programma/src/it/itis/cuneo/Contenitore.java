package it.itis.cuneo;
import jdk.internal.util.xml.impl.Input;
import sun.plugin.util.ProgressMonitorAdapter;

import javax.naming.ContextNotEmptyException;
import javax.naming.Name;
import javax.naming.NameParser;

public class Contenitore {
    private static final int MAX_PROGRAMMI = InputOutputUtility.leggiNumero("Inserisci il numero massimo di programmi per contenitore: ");
    private Programma[] vProgrammi;
    private int nProgrammi;

    public Contenitore() {
        vProgrammi = new Programma[MAX_PROGRAMMI];
        nProgrammi = 0;
    }

    public void addProgramma(Programma programma) throws ContenitoreException {
        if(nProgrammi > MAX_PROGRAMMI)
        {
            throw new ContenitoreException(1, "Troppi programmi");
        }
        vProgrammi[nProgrammi] = programma;
        nProgrammi++;
    }

    public String toString() {
        return "Contenitore {\"vProgrammi\": " + vProgrammi[0] + ", " + vProgrammi[1] + ", " + vProgrammi[2] + "}";
    }

    public Programma getProgramma(int posizione) {
        if(posizione < 0 || posizione > MAX_PROGRAMMI)
        {
            return null;
        }
        return vProgrammi[posizione];
    }

    public int setProgramma(Programma programma, int posizione) {
        if(posizione < 0 || posizione > MAX_PROGRAMMI)
        {
            return -1;
        }
        vProgrammi[posizione] = programma;
        return 1;
    }

    public int killProgramma(int posizione) {
        if(posizione < 0 || posizione > MAX_PROGRAMMI)
        {
            return -1;
        }
        vProgrammi[posizione] = null;
        return 1;
    }

    public int getN() {
        int numero = 0, i;
        for(i=0; i<MAX_PROGRAMMI; i++)
        {
            if(vProgrammi[i] != null)
            {
                numero++;
            }
        }
        return numero;
    }

    public int cercaProgrammaPerDenominazione(Programma programma) {
        int posizione = -1;
        for(int i=0; i<MAX_PROGRAMMI; i++)
        {
            if(vProgrammi[i].getDenominazione().equals(programma.getDenominazione()))
            {
                posizione = i;
            }
        }
        return posizione;
    }

    public int confrontaContenitore(Contenitore c) {
        int numeroComuni = 0;
        int i, z;
        for(i=0; i<MAX_PROGRAMMI; i++)
        {
            for(z=0; z<MAX_PROGRAMMI; z++) {
                if (this.vProgrammi[i].equals(c.getProgramma(z))) {
                    numeroComuni++;
                }
            }
        }
        return numeroComuni;
    }

    public static void main(String[] args) {
        Programma programma1 = new Programma();
        Contenitore contenitore = new Contenitore();
        try {
            contenitore.addProgramma(programma1);
            contenitore.addProgramma(programma1);
            contenitore.addProgramma(programma1);
        } catch (ContenitoreException e){
            e.printStackTrace();
            System.out.println(e.toString());
        }
        System.err.println(contenitore.toString());

        int avvenuto = 0;

        do {
            avvenuto = contenitore.killProgramma(InputOutputUtility.leggiNumero("Inserisci la posizione del programma da elimianre: "));
            if (avvenuto == -1) {
                System.out.println("La posizione deve essere maggiore di 0 e minore di " + MAX_PROGRAMMI);
            }
        }while(avvenuto != 1);

        System.out.println("Ci sono " + contenitore.getN() + " programmi nel contenitore");

        avvenuto = contenitore.cercaProgrammaPerDenominazione(new Programma(InputOutputUtility.leggiNome("Inserisci la denominazione: "), InputOutputUtility.leggiNome("Inserici il nome del produttore: "), InputOutputUtility.leggiNumero("Inserisci la versione: "), InputOutputUtility.leggiNome("Inserisci il sistema operativo: "), InputOutputUtility.leggiNumero("Inserisci l'anon di uscita: ")));
        if(avvenuto == 0)
            {
                System.out.println("Non è stato trovato un programma con la stessa denominazione");
            }
        else
            {
                System.out.println("Sono stati trovati " + avvenuto + "programmi con la stessa denominazione");
            }

        System.out.println(contenitore.toString());

        avvenuto = contenitore.confrontaContenitore(new Contenitore());
        if(avvenuto == 0)
        {
            System.out.println("Non sono stati trovati programmi in comune");
        }
        else
        {
            System.out.println("Sono stati trovati" + avvenuto + "programmi in comune");
        }

    }
}
