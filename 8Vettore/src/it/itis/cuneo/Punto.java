
import java.lang.Math;

public class Punto {

    //ATTRIBUTI
    private double x;
    private double y;


    //METODI

    //costruttore
    public Punto() {super();}
    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }
    //costruttore di copia
    public Punto(Punto p) {
        this.x = p.getX();
        this.y = p.getY();
    }

    //set e get
    public void setX(double x) {
        this.x = x;
    }
    public double getX() {
        return this.x;
    }
    public void setY(double y) {
        this.y = y;
    }
    public double getY() {
        return this.y;
    }
}
