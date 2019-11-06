package it.itis.cuneo;

/**
 * Created by inf.aimarv1906 on 30/09/2019.
 */
public class EseguiConversione {

    //esempio di conversione tra wrapper, partendo da un primitivo
    public static void main(String args[]) {

        //da DOUBLE a FLOAT
        //Float: è una classe wrapper, contiene un primitivo dello setesso tipo ed i metodi che ne permettono l'elaborazione
        //float: è un tipo primitivo, cioè una variabile semplice
        float f;

        /*
        * System.out.println(String s)
        la firma del metodo sopra richiede una stringa  come parametro quindi il float viene convertito in una stringa al momento della chiamata
        * */

        /*
        * System.out.println(float fPrimitivo)
        nel caso della firma sopra passassimo un float wrapper ma il metodo si aspetta un metodo primitivo
        * */
        f = new Float(0.52d);
        System.out.println(f);

        //da STRING a INT
        int n;
        String quanteMele = "8";
        n = Integer.parseInt(quanteMele);
        System.out.println(n);

        //da STRING a INT
        int n2;
        n2 = Integer.parseInt("6");
        System.out.println(n2);

        Float ogF;
        ogF = new Float(n);
        String s2;
        s2 = "" + ogF;
        //  \"\" per non chiudere la stringa
        System.out.println("s2 = \"\" + ogF: " + s2);
        s2 = new String("" + ogF);
        System.out.println("s2 = new String(\"\" + ogF)" + s2);
        s2 = ogF.toString();
        System.out.println("s2 = ogF.toString(): " + s2);

        //da DOUBLE a IINTEGER
        double dN = 6.5d;
        //cast come in C
        int intN = (int) dN;
        //new integer() può contenere solo un intero, quindi bisogna inserire il double in un intero primitivo
        Integer iN = new Integer(intN);
        //permette di trasformare un wrapper in un primitivo dello stesso tipo
        iN = intN;
    }
}
