package it.itis.cuneo;

public class Angolo {
    //attributi
    private int gradi;
    private int primi;
    private int secondi;

    //metodi
    //costruttore
    public Angolo() {
        super();
    }
    public Angolo(int gradi, int primi, int secondi) {
        super();
        this.gradi = gradi;
        this.primi = primi;
        this.secondi = secondi;
    }

    //set e get
    public void setGradi(int gradi) {
        this.gradi = gradi;
    }
    public int getGradi() {
        return this.gradi;
    }

    public void setPrimi(int primi) {
        this.primi = primi;
    }
    public int getPrimi() {
        return this.primi;
    }

    public void setSecondi(int secondi) {
        this.secondi = secondi;
    }
    public int getSecondi() {
        return this.secondi;
    }

    public String visualizzaAngolo() {
        return "L'angolo è: " + this.gradi + " " + this.primi + " " + this.secondi;
    }

    public void aggiungiGradi(int n) {
        this.gradi += n;
        while(this.gradi > 360)
        {
            this.gradi = this.gradi - 360;
        }
    }

    public void aggiungiPrimi(int n) {
        this.primi += n;
        while(this.primi > 60)
        {
            this.primi -= 360;
            this.gradi++;
        }
    }

    public void aggiungiSecondi(int n) {
        this.secondi += n;
        while(this.secondi > 60)
        {
            this.secondi -= 60;
            this.primi++;
        }
    }

    public int angoloSecondi() {
        int sec = 0;
        sec = this.gradi * 3600;
        sec += this.primi * 60;
        sec += this.secondi;
        return sec;
    }

    public void secondiAngolo(int n) {
        if(n >= 3600)
        {
            this.gradi = n / 3600;
            n -= this.gradi * 3600;
        }
        if(n >= 60)
        {
            this.primi = n / 60;
            n -= this.primi * 60;
        }
        this.secondi = n;
    }

    public int differenzaSecondi(Angolo a) {

    }

    public void sommaAngolo(Angolo a) {
        this.secondi += a.secondi;
        while(this.secondi > 60)
        {
            this.secondi -= 60;
            this.primi++;
        }
        this.primi += a.primi;
        while(this.primi > 60)
        {
            this.primi -= 60;
            this.gradi++;
        }
        this.gradi += a.gradi;
    }

    public static void main(String[] args) {
        Angolo angolo = new Angolo(10, 3, 50);
        Angolo a = new Angolo(20, 3, 5);

        System.out.println(angolo.visualizzaAngolo());

        System.out.println(angolo.aggiungiGradi(30));
        System.out.println(angolo.aggiungiPrimi(30));
        System.out.println(angolo.aggiungiSecondi(30));

        System.out.println(angolo.angoloSecondi());
        angolo.secondiAngolo(30);
        System.out.println(angolo);
        System.out.println(angolo.differenzaSecondi(a));
        angolo.sommaAngolo(a);
        System.out.println(angolo);
    }
}
