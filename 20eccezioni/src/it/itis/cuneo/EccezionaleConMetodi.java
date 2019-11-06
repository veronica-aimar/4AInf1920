package it.itis.cuneo;

/**
 * Created by inf.aimarv1906 on 24/10/2019.
 */
public class EccezionaleConMetodi {
    public void metodo1() throws Exception{
        //se in questo programma faccio la run, mi viene che l'ultimo errore (quello più in alto) è questo.
        //Quindi se commento metodo2(), il programma non si inchioda più
        //metodo2();
    }

    //metodo che rilancia l'eccezione
    public void metodo2() throws Exception{
        throw new Exception("Eccezione dal metodo2");
    }

    public static void main(String[] args) throws Exception{
        EccezionaleConMetodi eccezionaleConMetodi = new EccezionaleConMetodi();
        eccezionaleConMetodi.metodo1();
    }
}
