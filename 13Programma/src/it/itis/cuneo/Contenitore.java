package it.itis.cuneo;

public class Contenitore {
    private Programma programma1;
    private Programma programma2;
    private Programma programma3;

    public Contenitore() {
        this.programma1 = new Programma();
        this.programma2 = new Programma();
        this.programma3 = new Programma();
    }
    public Contenitore(Programma programma1, Programma programma2, Programma programma3) {
        this.programma1 = new Programma(programma1);
        this.programma2 = new Programma(programma2);
        this.programma3 = new Programma(programma3);
    }
    public Contenitore(Contenitore c) {
        this.programma1 = new Programma(c.programma1);
        this.programma2 = new Programma(c.programma2);
        this.programma3 = new Programma(c.programma3);
    }

    public void setProgramma(int posizione, Programma programma2) throws Exception{
        switch(posizione) {
            case 1:
                this.programma1 = new Programma(programma1);
            case 2:
                this.programma2 = new Programma(programma2);
            case 3:
                this.programma3 = new Programma(programma3);
        }
    }
    public Programma getProgramma(int posizione) throws Exception {
        switch(posizione) {
            case 1:
                return new Programma(this.programma1);
            case 2:
                return new Programma(this.programma2);
            case 3:
                return new Programma(this.programma3);
            default:
                throw new Exception("-1");
        }
    }
    public void killProgramma(int posizione) {
        switch (posizione) {
            case 1:
                this.programma1 = null;
            case 2:
                this.programma2 = null;
            case 3:
                this.programma3 = null;
        }
    }
    public int getN() {
        int n = 3;
        return n;
    }
    public int cercaProgrammaPerDenominazione(String nomeProgramma) throws Exception{
        if(programma1 == nomeProgramma)
    }
    public String toString() {
        return "Contenitore { \"programma1\": " + this.programma1 + ", \"programma2\": " + this.programma2 + ", \"programma3\": " + this.programma3 + "}";
    }
    public int confrontaContenitore(Contenitore c) {
        int n = 0;
        if(this.programma1 == c.programma1) {
            n++;
        }
        if(this.programma2 == c.programma2) {
            n++;
        }
        if(this.programma3 == c.programma3) {
            n++;
        }
        return n;
    }
}
