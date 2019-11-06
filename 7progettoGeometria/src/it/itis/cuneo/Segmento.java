package it.itis.cuneo;

/**
 * Created by inf.aimarv1906 on 07/10/2019.
 */
public class Segmento {
    private Punto punto1;
    private Punto punto2;

    //metodi
    public Segmento(Punto punto1, Punto punto2) {
        this.punto1 = punto1;
        this.punto2 = punto2;
    }
    //questo costruttore è uguale a quello sotto
    public Segmento(Punto punto1, Punto punto2) {
        this.punto1 = new Punto(punto1.getX(), punto1.getY());
        this.punto2 = new Punto(punto2.getX(), punto2.getY());
    }
    //questo costruttore è uguale a quello sopra
    public Segmento(Punto punto1, Punto punto2) {
        this.punto1 = new Punto(punto1);
        this.punto2 = new Punto(punto2);
    }

    //il costruttore di copia serve quando uno degli attributi è un wrapper
    public Segmento(Segmento segmento) {
        this.punto1 = new Punto(segmento.getPunto1());
        this.punto2 = new Punto(segmento.getPunto2());
    }

    public void setPunto1(Punto punto1) {
        this.punto1 = new Punto(punto1);
        //this.punto1 = punto1;
        //non è così perchè passo un oggetto che viene creato fuori. Se qualcuno lo cancella non mi rimane niente, quindi per sicurezza ne creo uno nuovo
        //se deferenzio il parametro perdo il contenuto, quindi anche l'attributo. Quindi ne creo uno mio
    }
    public Punto getPunto1() {
        return this.punto1;
    }
    public void setPunto2(Punto punto2) {
        this.punto2 = new Punto(punto2);
        /*
        this.punto2 = new Punto(punto2.getX(), punto2.getY())*/
    }
    public Punto getPunto2() {
        return this.punto2;
    }

    public boolean equals(Segmento segmento) {
        boolean equals = false;


        //if((this.punto1 == segmento.getPunto1()) --> errato perchè controlla gli handler e quindi gli indirizzi
        if(this.punto1.equals(getPunto1()) && this.punto2.equals(getPunto2()))
        {
            equals = true;
        }
            return equals;
    }
}
