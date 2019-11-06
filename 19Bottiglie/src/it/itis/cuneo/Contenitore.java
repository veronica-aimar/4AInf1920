package it.itis.cuneo;
import java.util.Arrays;
import javax.naming.ContextNotEmptyException;
import java.lang.Throwable;

/**
 * Created by inf.aimarv1906 on 31/10/2019.
 */
public class Contenitore {
    public static final int MAX_BOTTIGLIE = 6;
    private Bottiglia[] vBottiglie;
    private int cntBottiglie;

    //COSTRUTTORI

    public Contenitore() {
        this.vBottiglie = new Bottiglia[MAX_BOTTIGLIE];
        cntBottiglie = 0;
    }
    public void addBottiglia(Bottiglia b) throws ContenitorePienoException {
        if(cntBottiglie+1 >= MAX_BOTTIGLIE)
        {
            throw new ContenitorePienoException(1, "Troppe bottiglie");
        }
            vBottiglie[cntBottiglie] = b;
            cntBottiglie++;
    }
}
