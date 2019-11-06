package it.itis.cuneo;
import jdk.internal.util.xml.impl.Input;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by inf.aimarv1906 on 04/11/2019.
 */
public class Calendario {
    public static void main(String[] args) {
        //data del giorno corrente
        System.out.println("Oggi1: " + new Date());

        /*
        * sarebbe la stessa cosa fare
        * */
        Date calendario1 = new Date();
        System.out.println("Oggi2:" + calendario1);


        String strData = InputOutputUtility.leggiNome("Inserisci la data: ");
        //strData -> dataTastiera
        //stringa -> Date
        /*Date dataTastiera = InputOutputUtility.convertiDataOraToCalendar(strData, InputOutputUtility.dfDay);*/
        //lancio il metodo parse su una simpleDateFormat
        Date dataTastiera = null;
        try {
            dataTastiera = InputOutputUtility.dfDay.parse(strData);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //stringa -> Calendar
        Calendar calendario2 = InputOutputUtility.convertiDataOraToCalendar(strData, InputOutputUtility.dfDay);
        Calendar cData = Calendar.getInstance();
        cData.setTime(cData.getTime());
    }
}
