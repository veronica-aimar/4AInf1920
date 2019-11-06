package it.itis.cuneo;

/**
 * Created by inf.aimarv1906 on 30/09/2019.
 */
public class Frazione
{
    //Attributi
    private int numeratore;
    private int denominatore;

    //Metodi
    public Frazione()
    {
        //si mette nei costuttori e istruisce la macchina virtuale su come istanziare gli oggetti (come riservare lo spazio in memoria)
        //serve per istanziare
        super();
    }

    public Frazione(int numeratore, int denominatore)
    {
        this.numeratore = numeratore;
        this.denominatore = denominatore;
    }

    public void setNumeratore(int numeratore)
    {
        this.numeratore = numeratore;
    }

    public int getNumeratore()
    {
        return numeratore;
    }

    public void setDenominatore(int numeratore)
    {
        this.denominatore = denominatore;
    }

    public int getDenominatore()
    {
        return denominatore;
    }

    //controllo se due frazioni sono uguali
    public boolean equals(Frazione frazione)
    {
        boolean sonoUguali = false;
        /*
        * thjs == frazione
        * controlla se gli oggetti sono contenuti nella stessa area di memoria
        * */
        if( (this.numeratore == frazione.getNumeratore()) && (this.denominatore == frazione.getDenominatore()) )
        {
            sonoUguali = true;
        }
        return sonoUguali;
    }

    //restituisce una stringa con lo stato dell'oggetto
    public String toString()
    {
        return "Frazione {numeratore: " + numeratore + ", denominatore: " + denominatore + "}";
    }

    //semplificazione
    public Frazione getSemplificazione()
    {
        //dichiarazione del numero che divide i valori
        int numero = 2;
        boolean basta = false;
        while(!basta)
        {
            if(this.numeratore % numero == 0 && this.denominatore % numero == 0)
            {
                this.numeratore /= numero;
                this.denominatore /= numero;
                numero = 2;
            }
            else
            {
                if(numero > this.numeratore || numero > this.denominatore)
                {
                    basta = true;
                }
                numero++;
            }
        }
        return this;
    }

    //calcolo della somma
    public Frazione getSomma(Frazione frazione2)
    {
        Frazione risultato = new Frazione( (this.numeratore * frazione2.getDenominatore()) + (frazione2.getNumeratore() * this.denominatore), this.denominatore * frazione2.getDenominatore() );
        return risultato.getSemplificazione();
    }

    //calcolo della differenza
    public Frazione getDifferenza(Frazione frazione2)
    {
        Frazione risultato = new Frazione( (this.numeratore * frazione2.getDenominatore()) - (frazione2.getNumeratore() * this.denominatore), this.denominatore * frazione2.getDenominatore() );
        return risultato.getSemplificazione();
    }

    //calcolo della moltiplicazione
    public Frazione getMoltiplicazione(Frazione frazione2)
    {
        Frazione risultato = new Frazione( this.numeratore * frazione2.getNumeratore(), this.denominatore * frazione2.getDenominatore() );
        return risultato.getSemplificazione();
    }

    //calcolo della divisione
    public Frazione getDivisione(Frazione frazione2)
    {
        Frazione risultato = new Frazione( this.numeratore * frazione2.getDenominatore(), this.denominatore * frazione2.getNumeratore() );
        return risultato.getSemplificazione();
    }

    public static void main(String args[])
    {
        Frazione frazioneUnknownState = new Frazione(1, 4);
        System.out.println( frazioneUnknownState.toString() );

        Frazione frazione1 = new Frazione(2, 5);
        //stampo la frazione conosciuta
        System.out.println( frazione1.toString() );

        //confronto la frazione e la frazione sconosciuta
        boolean confrontoUguali = frazione1.equals(frazioneUnknownState);
        System.out.println("Sono uguali? " + confrontoUguali);

        //calcolo della somma
        Frazione somma = new Frazione();
        somma = frazione1.getSomma(frazioneUnknownState);

        //calcolo della differenza
        Frazione differenza = new Frazione();
        differenza = frazione1.getSomma(frazioneUnknownState);

        //calcolo della moltiplicazione
        Frazione moltiplicazione = new Frazione();
        moltiplicazione = frazione1.getSomma(frazioneUnknownState);

        //calcolo della divisione
        Frazione divisione = new Frazione();
        divisione = frazione1.getSomma(frazioneUnknownState);

        System.out.println("La somma vale " + somma.toString());
        System.out.println("La differenza vale " + differenza.toString());
        System.out.println("La moltiplicazione vale " + moltiplicazione.toString());
        System.out.println("La divisione vale " + divisione.toString());
    }
}