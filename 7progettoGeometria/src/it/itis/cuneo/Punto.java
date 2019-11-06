package it.itis.cuneo;

/**
 * Created by inf.aimarv1906 on 07/10/2019.
 */
public class Punto {
    //attributi
    private int x;
    private int y;

    //metodi
    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }
    //costruttore di copia
    public Punto(Punto p) {
        x = p.getX();
        y = p.getY();
    }
    public Punto() {
        super();
    }

    public void setX(int x) {
        this.x = x;
    }
    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }
    public int getY() {
        return y;
    }

    public String toString() {
        return "Punto{\" x\": " + x + ", " + "\"y\": " + y + "}";
    }

    public boolean equals(Punto punto) {
        boolean equals = false;
        if(this.x == punto.getX() && (this.y == punto.getY()))
        {
            equals = true;
        }
        return equals;
    }

    public static void main(String[] args) {
        Punto puntoA = new Punto(4, 6);
        //puntoA e puntoB referenziano due aree di memoria diverse
        //puntoB è una copia di A per il suo stato, ma fisicamente sono in due aree di memoria diverse
        Punto puntoB = new Punto(puntoA);

        //puntoA e puntoC come handler referenziano la stessa area di memoria
        Punto puntoC = puntoA;
        Punto puntoD = new Punto();
        Punto puntoE = null;
        //se il richiamo al costruttore non viene svolto ho un null pointer
        puntoE = new Punto();

        System.out.println(puntoA.toString());
        System.out.println(puntoE.toString());
    }
}
