
import java.lang.Math;

public class Vettore {
    //ATTRIBUTI
    private Punto origine;
    private Punto vertice;

    //METODI

    //costruttori
    public Vettore() {
        this.origine = new Punto();
        this.vertice = new Punto();
    }
    public Vettore(Punto origine, Punto vertice) {
        this.origine = new Punto(origine);
        this.vertice = new Punto(vertice);
    }
    //costruttore di copia
    public Vettore(Vettore v) {
        this.origine = new Punto(v.origine);
        this.vertice = new Punto(v.vertice);
    }

    //metodo per controllare se un vettore è uguale ad un altro
    public boolean equals(Vettore v) {
        boolean uguale = false;
        if(this.origine == v.origine && this.vertice == v.vertice)
        {
            uguale = true;
        }
        return uguale;
    }

    //metodo per calcolare la lunghezza del vettore
    public double lenght() {
        double lunghezza;
        lunghezza = Math.sqrt(((this.origine.getX() - this.vertice.getX()) * (this.origine.getX() - this.vertice.getX())
        + (this.origine.getY() - this.vertice.getY()) * (this.origine.getY() - this.vertice.getY())));
        return lunghezza;
    }

    //metodo per dare in output lo stato del vettore
    public String toString() {
        return "Vettore {\"x0\": " + this.origine.getX() + ", \"y0\": " + this.origine.getY() + ", \"x1\": " + this.vertice.getX() + "\"y1\": " + this.vertice.getY() + "}";
    }

    public static void main(String[] args) {
        //allocazione di origine e vertice del primo vettore
        Punto origine0 = new Punto(0, 5);
        Punto vertice0 = new Punto(4, 7);

        //allocazione di origine e vertice del secondo vertice
        Punto origine1 = new Punto(9, 5);
        Punto vertice1 = new Punto(6, 3);

        //allocazione dei due vettori
        Vettore vettore = new Vettore(origine0, vertice0);
        Vettore vettore1 = new Vettore(origine1, vertice1);

        //calcolo degli uguali
        boolean uguali;
        uguali = vettore.equals(vettore1);
        if(uguali)
        {
            System.out.println("I vettori sono uguali");
        }
        else
        {
            System.out.println("I vettori non sono uguali");
        }

        //calcolo della lunghezza del vettore
        double lenght;
        lenght = vettore.lenght();
        System.out.println("La lunghezza del vettore è " + lenght);

        //output dello stato del vettore
        System.out.println(vettore.toString());
    }
}
