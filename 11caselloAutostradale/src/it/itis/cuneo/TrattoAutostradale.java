package it.itis.cuneo;
import java.util.Calendar;

/**
 * Created by inf.aimarv1906 on 21/10/2019.
 */
public class TrattoAutostradale {
    //ATTRIBUTI
    private Casello caselloIngresso;
    private Casello caselloUscita;

    //METODI
    //costruttori
    public TrattoAutostradale() {
        this.caselloIngresso = new Casello();
        this.caselloUscita = new Casello();
    }
    public TrattoAutostradale(Casello caselloIngresso, Casello caselloUscita) {
        this.caselloIngresso = new Casello(caselloIngresso);
        this.caselloUscita = new Casello(caselloUscita);
    }
    public TrattoAutostradale(TrattoAutostradale t) {
        this.caselloIngresso = new Casello(t.caselloIngresso);
        this.caselloUscita  =new Casello(t.caselloUscita);
    }

    public void setCaselloIngresso(Casello caselloIngresso) {
        this.caselloIngresso = caselloIngresso;
    }
    public Casello getCaselloIngresso() {
        return caselloIngresso;
    }
    public void setCaselloUscita(Casello caselloUscita) {
        this.caselloUscita = caselloUscita;
    }
    public Casello getCaselloUscita() {
        return caselloUscita;
    }

    public static void main(String[] args) {

    }
}
