package it.itis.cuneo;

/**
 * Created by inf.aimarv1906 on 30/09/2019.
 */
public class Punto {
    //attributi
    private int posX;
    private int posY;

    //metodi

    //costruttori
    public Punto() {
        super();
    }

    public Punto(int posX, int posY) {
        super();
        this.posX = posX;
        this.posY = posY;
    }

    //setter e getter
    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosX() {
        return this.posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getPosY() {
        return this.posY;
    }

    public int numeroQuadrante() {
        int quadrante;
        if(this.posX > 0)
        {
            if(this.posY > 0)
            {
                quadrante = 1;
            }
            else
            {
                quadrante = 4;
            }
        }
        else
        {
            if(this.posY > 0)
            {
                quadrante = 2;
            }
            else
            {
                quadrante = 3;
            }
        }
        return quadrante;
    }

    public float distanzaPunti(Punto punto) {
        float distanza;
        distanza = sqrt(pow(this.posX - punto.getPosX(), 2) + pow(this.posY - punto.getPosY(), 2));
        return distanza;
    }

    public boolean puntiUguali(Punto punto) {
        boolean uguali = false;
        if((this.posX == punto.getPosX()) && (this.posY == punto.getPosY()))
        {
            uguali = true;
        }
        return uguali;
    }

    public String statoOggetto() {
        return "Punto: { PosizioneX: " + this.posX + ", PosizioneY: " + this.posY + "}";
    }

    public static void main(String argS[]) {
        Punto punto1 = new Punto(3, 5);
        Punto punto2 = new Punto();

        int numero;
        numero = punto1.numeroQuadrante();
        System.out.println("Il numero del quadrate è: " + numero);

        float distanza;
        distanza = punto1.distanzaPunti(punto2);
        System.out.println("La distanza tra i due punti è: " + distanza);

        boolean uguali;
        uguali = punto1.puntiUguali(punto2);
        if(uguali)
        {
            System.out.println("I due punti sono uguali");
        }
        else
        {
            System.out.println("I due punti non sono uguali");
        }

        System.out.println(punto1.statoOggetto());

    }
}
