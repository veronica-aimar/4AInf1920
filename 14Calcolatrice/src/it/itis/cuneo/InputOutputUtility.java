package it.itis.cuneo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class InputOutputUtility {
    //inputStreamReader prende dalla tastiera
    private static InputStreamReader r = new InputStreamReader(System.in);
    /*
    inserisco i dati della tastiera nel buffer
    non posso leggere i dati dalla tastiera ma dal buffer, perchè la presona può scrivere troppo veloce
    il buffer è una memoria della memoria centrale che contiene i dati contenuti in reader, che prende i dati letti dalla tastiera
    */
    private static BufferedReader br = new BufferedReader(r);


    //il parametro che passiamo è la richiesta dell'input
    public static String input(String richiesta){
        String a = null;

        System.out.print(richiesta);
        try {
            //sc = sequenza di caratteri
            //la sequenza di caratteri è letta scrivendo all'utente un messaggio
            //inserimento da tastiera (readLine)
            a=br.readLine();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            //eccezione nel caso la tastiera sia rotta...
            e.printStackTrace();
        }
        return a;
    }

    public static void main(String[] args) {
        double a, b;
        a = Double.parseDouble(input("Inserisci il primo numero: "));
        b = Double.parseDouble(input("Inserisci il secondo numero: "));

        try {
            double c = a/b;
        }
        catch(ArithmeticException ex) {
            System.out.println("Non puoi inserire 0");
            b = Double.parseDouble(input("Inserire il secondo numero. Il valore deve essere diverso da 0: "));
        }
        finally {
            System.out.println("Valori adatti");
        }
        System.out.println("La somma vale " + (a+b));
        System.out.println("La differenza vale " + (a-b));
        System.out.println("La moltiplicazione vale " + (a*b));
        System.out.println("La divisione vale " + (a/b));
    }
}