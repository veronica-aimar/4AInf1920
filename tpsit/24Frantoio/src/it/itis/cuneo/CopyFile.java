package it.itis.cuneo;

import java.io.*;

/**
 * Created by inf.aimarv1906 on 25/11/2019.
 */
public class CopyFile {
    private static InputStreamReader r = new FileReader(new File("C:\\elenco.txt"));
    private static BufferedReader br = new BufferedReader(r);

    private static InputStreamWriter v = new FileWriter(new File("C:\\elenco.txt"));
    private static BufferedWriter bw = new BufferedWriter(w);

    public static void main(String[] args) {
    }
}
