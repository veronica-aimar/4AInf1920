package it.itis.cuneo;
import java.lang.Math;

/**
 * Created by inf.aimarv1906 on 07/10/2019.
 */
public class PianoCartesiano {

    //attributi
    private Rettangolo rettangolo1;
    private Rettangolo rettangolo2;

    //costanti
    //statici sono attributi di classe
    private static int ox = 0;
    private static int oy = 0;

    //con final non è modificabile, scritto maiuscolo
    public final static int MAX_X = 100;
    public final static int MAX_Y = 500;

    public PianoCartesiano(Rettangolo rettangolo1, Rettangolo rettangolo2) {
        this.rettangolo1 = new Rettangolo(Rettangolo rettangolo1)
    }

    public boolean equals(PianoCartesiano pianoCartesiano) {
        boolean equals = false;
        if((this.rettangolo1.equals(pianoCartesiano.rettangolo1)) && (this.rettangolo2.equals(pianoCartesiano.rettangolo2)))
        {
            equals = true;
        }
        return equals;
    }

    public static void setOx(int ox) {
        PianoCartesiano.ox = ox;
    }
    public static int getOx() {
        return ox;
    }
    public static void setOy(int oy) {
        PianoCartesiano.oy = oy;
    }
    public static int getOy() {
        return oy;
    }

    public String toString() {
        String str="";
        str = "PianoCartesiano{\"rettangolo1\": " + rettangolo1 + "" + "\"rettangolo2\": " + rettangolo2 + "}";
        //equivale a "\"rettangolo2\: " + rettangolo2.toString() + "}"
    }

    public static void main(String[] args) {
        //lo static definisce una variabile globale condivisa fra tutte le istanze della classe
        int maxX = PianoCartesiano.MAX_X;
        //alle variabili statiche, tipo ox PianoCartesiano si accede con nome della classe senza utilizzare il costruttore
        //se l'attributo condiviso viene modificato, per tutti gli oggetti
        PianoCartesiano.setOx(10);
        int mYOx = PianoCartesiano.getOx()
    }
}
