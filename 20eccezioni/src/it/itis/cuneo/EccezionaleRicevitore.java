package it.itis.cuneo;

/**
 * Created by inf.aimarv1906 on 24/10/2019.
 */

public class EccezionaleRicevitore {

    public int divisione(int numeratore, int denominatore) throws ArithmeticException{
        int quoto = 0;
        quoto = numeratore / denominatore;
        return quoto;
    }

    public static void main(String[] args) {
        EccezionaleRicevitore eccezionaleRicevitore = new EccezionaleRicevitore();
        try {
            //codice che genera eccezione
            eccezionaleRicevitore.divisione(5, 0);
        }
        catch (ArithmeticException aEx){
            System.out.println("catch (ArithmeticException aEx)");
            //il printStackTrace passa direttamente al finally
            aEx.printStackTrace();
        }
        catch (Exception ex) {
            System.out.println("catch (Exception ex)");
            ex.printStackTrace();
        }
        finally {
            System.out.println("No esco sempre bene!!");
        }
    }
}
