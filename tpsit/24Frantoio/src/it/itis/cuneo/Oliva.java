package it.itis.cuneo;
import java.util.Calendar;

/**
 * Created by inf.aimarv1906 on 23/11/2019.
 */
public class Oliva {
    //si riferisce alla enum, quindi può assumere diversi valori costanti che io stessa definisco
    private String codiceOliva;
    private Calendar dataRaccolta;
    private ColoreOliva coloreOliva;
    private MaturazioneOliva maturazioneOliva;

    public Oliva() {super();}
    public Oliva(String codiceOliva, Calendar dataRaccolta, ColoreOliva coloreOliva, MaturazioneOliva maturazioneOliva) {
        this.codiceOliva = codiceOliva;
        this.dataRaccolta = dataRaccolta;
        this.coloreOliva = coloreOliva;
        this.maturazioneOliva = maturazioneOliva;
    }

    public void setCodiceOliva(String codiceOliva) {
        this.codiceOliva = codiceOliva;
    }
    public String getCodiceOliva() {
        return codiceOliva;
    }
    public Calendar getDataRaccolta() {
        return dataRaccolta;
    }
    public ColoreOliva getColoreOliva() {
        return coloreOliva;
    }
    public void setColoreOliva(ColoreOliva coloreOliva) {
        this.coloreOliva = coloreOliva;
    }
    public void setDataRaccolta(Calendar dataRaccolta) {
        this.dataRaccolta = dataRaccolta;
    }
    public void setMaturazioneOliva(MaturazioneOliva maturazioneOliva) {
        this.maturazioneOliva = maturazioneOliva;
    }
    public MaturazioneOliva getMaturazioneOliva() {
        return maturazioneOliva;
    }

    @Override
    public String toString() {
        return "Oliva{" +
                "codiceOliva='" + codiceOliva + '\'' +
                ", dataRaccolta=" + dataRaccolta +
                ", coloreOliva=" + coloreOliva +
                ", maturazioneOliva=" + maturazioneOliva +
                '}';
    }
}
