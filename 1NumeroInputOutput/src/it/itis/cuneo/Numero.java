package it.itis.cuneo;

/**
 * Created by inf.aimarv1906 on 21/09/2019.
 */
public class Numero
{
    //Attributi
    private int valore;

    /*
    Metodi
    * */
    //costruttore
    public Numero(int valore)
    {
        this.valore = valore;
    }

    //setter
    public void setValore(int valore)
    {
        this.valore = valore;
    }

    //getter
    public int getValore()
    {
        return this.valore;
    }

    //tutti i metodi che hanno "static" è come se fossero esterni
    public static void main(String args[])
    {
        //dichiarazione della variabile per prendere il numero
        int x;
        //dentro al metodo non si mettono i modificatori di visibilità
        //creazione di un oggetto con il costruttore
        Numero numero = new Numero(5);
        //prendo il valore e lo inserisco nella variabile che ho creato
        x = numero.getValore();
        //richiamo dell'oggetto per l'output del valore con alla fine "a capo"
        System.out.println("Il numero inserito vale " + x);
    }
}
