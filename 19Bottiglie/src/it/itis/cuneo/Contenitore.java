import java.util.Arrays;
import javax.naming.ContextNotEmptyException;
import java.lang.Throwable;

/**
 * Created by inf.aimarv1906 on 31/10/2019.
 */
public class Contenitore {
    public static final int MAX_BOTTIGLIE = InputOutputUtility.leggiNumero("Inserisci il numero massimo di bottiglie per contenitore: ");
    private Bottiglia[] vBottiglie;
    private int cntBottiglie;
    private int length;

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

    public int setContenitore(Bottiglia bottiglia, int posizione) {
        if(posizione < 0 || posizione > MAX_BOTTIGLIE)
        {
            return -1;
        }
        if(vBottiglie[posizione] != null)
        {
            return -2;
        }
        vBottiglie[posizione] = bottiglia;
        return 1;
    }
    public Bottiglia getContenitore(int posizione) {
        if(vBottiglie[posizione] == null || posizione < 0 || posizione > MAX_BOTTIGLIE)
        {
            return null;
        }
        return vBottiglie[posizione];
    }

    public int killProgramma(int posizione) {
        if(posizione < 0 || posizione > MAX_BOTTIGLIE)
        {
            return -1;
        }
        if(vBottiglie[posizione] == null)
        {
            return -2;
        }
        vBottiglie[posizione] = null;
        return 1;
    }

    public int getN() {
        int i, contatore = 0;
        for(i=0; i<this.length; i++) {
        if(vBottiglie[i] != null)
            {
                contatore++;
            }
        }
        return contatore;
    }

    public Bottiglia cercaBottiglia(int posizione) {
        if(posizione < 0 || posizione > MAX_BOTTIGLIE || vBottiglie[posizione] == null)
        {
            return null;
        }
        return vBottiglie[posizione];
    }
}
