package it.itis.cuneo;

import jdk.internal.org.objectweb.asm.tree.MultiANewArrayInsnNode;
import jdk.internal.util.xml.impl.Input;

import java.text.ParseException;
import java.time.temporal.UnsupportedTemporalTypeException;

/**
 * Created by inf.aimarv1906 on 07/11/2019.
 */
public class PortaCD {
    private static final int MAX_CD = InputOutputUtility.leggiNumero("Inseisci il numero massimo di cd: ");
    private CD[] vPortaCd;
    private int nCd;

    public PortaCD() {
        vPortaCd = new CD[MAX_CD];
        nCd = 0;
    }

    public void addCd(CD cd) throws PortaCDPienoException{
        if(nCd < MAX_CD)
        {
            throw new PortaCDPienoException(1, "Troppi cd");
        }
        vPortaCd[nCd] = cd;
        nCd++;
    }

    public CD getCD(int posizione) {
        if(posizione < 0 || posizione > MAX_CD)
        {
            return null;
        }
        return vPortaCd[posizione];
    }

    public int setCD(int posizione, CD cd) {
        if(posizione < 0 || posizione > MAX_CD)
        {
            return -1;
        }
        vPortaCd[posizione] = cd;
        return 1;
    }

    public int killCD(int posizione) {
        if(posizione < 0 || posizione > MAX_CD)
        {
            return -1;
        }
        vPortaCd[posizione] = null;
        return 1;
    }

    public int getN() {
        int numero = 0;
        for(int i=0; i<MAX_CD; i++)
        {
            if(vPortaCd[i] != null)
            {
                numero++;
            }
        }
        return numero;
    }

    public int cercaCdPerTitolo(CD cd) {
        int posizione = -1;
        for(int i=0; i<MAX_CD; i++)
        {
            if(vPortaCd[i].getTitolo().equals(cd.getTitolo()));
            {
                posizione = i;
            }
        }
        return posizione;
    }

    public String toString() {
        return "PortaCd {\"titolo1\": " + vPortaCd[0] + ", \"titolo2\": " + vPortaCd[1] + ", \"titolo3\": " + vPortaCd[2] + "}";
    }

    public int confrontaCollezione(PortaCD p) {
        int i, c;
        int numero = 0;
        for(i=0; i<MAX_CD; i++)
        {
            for(c=0; c<p.MAX_CD; c++) {
                if (vPortaCd[i].equals(p.getCD(c))) {
                    numero++;
                }
            }
        }
        return numero;
    }

    public static void main(String[] args) {
        CD cd = new CD(InputOutputUtility.leggiNome("Inserisci il titolo: "), InputOutputUtility.leggiNome("Inserisci il nome dell'autore: "), InputOutputUtility.leggiNumero("Inserisci il numero di brani: "), InputOutputUtility.leggiNumero("Inserisci la durata: "));
        PortaCD portacd = new PortaCD();

        int avvenuto = 0;
        do
        {
            avvenuto = portacd.setCD(InputOutputUtility.leggiNumero("Inserisci la posizione: "), cd);
            if(avvenuto == -1)
            {
                System.out.println("La posizione deve essere maggiore di 0 e minore di " + MAX_CD);
            }
        }while(avvenuto != 1);

        try {
            portacd.addCd(cd);
            portacd.addCd(cd);
            portacd.addCd(cd);
            portacd.addCd(cd);
        } catch (PortaCDPienoException e)
        {
            e.printStackTrace();
            System.err.println(e.toString());
        }
        System.err.println(portacd.toString());

        do {
            avvenuto = portacd.killCD(InputOutputUtility.leggiNumero("Inserisci la posizione del cd da eliminare: "));
            if(avvenuto == -1)
            {
                System.out.println("La posizione deve essere maggiore di 0 e minore di " + MAX_CD);
            }
        }while(avvenuto != 1);

        System.out.println("Il numero di cd nel porta cd è" + portacd.getN());

        avvenuto = portacd.cercaCdPerTitolo(new CD());
        if(avvenuto == -1)
        {
            System.out.println("Il cd non è stato trovato");
        }
        else
        {
            System.out.println("IL CD è nella posizione " + avvenuto);
        }

        System.out.println(portacd.toString());

        avvenuto = portacd.confrontaCollezione(new PortaCD());
        if(avvenuto == 0)
        {
            System.out.println("Non sono stati trovati CD in comune");
        }
        else
        {
            System.out.println("Il numero di CD in comune è " + avvenuto);
        }
    }

}
