package it.itis.cuneo;
import java.util.Arrays;

/**
 * Created by inf.aimarv1906 on 30/10/2019.
 */

public class Libreria {
    public static final int MAX_LIBRI = 3;
    private Libro[] vLibri;
    private int cntLibro; //deve essere minore o uguale di MAX_LIBRI

    /*
    * STRUTTURA DA IMPARARE A MEMORIA
    * */
    public Libreria() {
        //se il parametro non è uguale alla classe non serve mettere this
        //costruttore di array
        vLibri = new Libro[MAX_LIBRI];
        cntLibro = 0;
    }

    public void addLibro(Libro libro) throws LibreriaPienaException {
        if(cntLibro+1 > MAX_LIBRI)
            //è possibile perchè la classe LibreriaPienaException estende l'eccezione
            throw new LibreriaPienaException(1, "Troppi libri");
        //dato che viene lanciata l'eccezione, il codice non viene eseguito
        vLibri[cntLibro] = libro;
        cntLibro++;
    }

    @Override
    public String toString() {
        return "Libreria{" + "\"vLibri\": " + Arrays.toString(vLibri) + ", \"cntLibro\": " + cntLibro + '}';
    }

    public static void main(String[] args) {
        Libro libro1 = new Libro(InputOutputUtility.convertiDataOraToCalendar("12/10/2019", InputOutputUtility.dfDay), "Lewis Carrol", "123456789", "Alice");
        Libreria libreria = new Libreria();
        try {
            libreria.addLibro(libro1);
            libreria.addLibro(libro1);
            libreria.addLibro(libro1);
            libreria.addLibro(libro1);
        } catch (LibreriaPienaException e) {
            e.printStackTrace();
            //System.out.println(e.toString());
            System.err.println(e.toString());
        }
        //System.out.println(libreria.toString());
        System.err.println(libreria.toString());

    }
    /*
    * FINO A QUA
    * */
}
