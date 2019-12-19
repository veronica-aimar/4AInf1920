package it.itis.cuneo;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by inf.aimarv1906 on 23/11/2019.
 */
public class Frantoio {
    //creazione di una lista di olive
    //list è un'interfaccia di arrayList
    //ArrayList<E> implementa List<E>
    private List<Oliva> listaOliva;

    public Frantoio() {super();}
    public Frantoio(List<Oliva> listaOliva) {
        this.listaOliva= new ArrayList<Oliva>();
    }

}
