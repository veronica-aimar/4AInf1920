package it.itis.cuneo;

/**
 * Created by inf.aimarv1906 on 31/10/2019.
 */
public class Bottiglia {
    private int bottiglia;
    private int tappo;

    //COSTRUTTORI
    public Bottiglia() {super();}
    public Bottiglia(int bottiglia, int tappo) {
        this.bottiglia = bottiglia;
        this.tappo = tappo;
    }
    public Bottiglia(Bottiglia b) {
        this.bottiglia = b.getBottiglia();
        this.tappo = b.getTappo();
    }

    //SET E GET

    public void setBottiglia(int bottiglia) {
        this.bottiglia = bottiglia;
    }
    public int getBottiglia() {
        return bottiglia;
    }
    public void setTappo(int tappo) {
        this.tappo = tappo;
    }
    public int getTappo() {
        return tappo;
    }
}
