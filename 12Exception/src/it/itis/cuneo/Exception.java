package it.itis.cuneo;

public class Exception {
    public float divisione(int numeratore, int denominatore) throws ArithmeticException {
        float divisione;
        divisione = numeratore / denominatore;
        return divisione;
    }
    public static void main(char[] args) {
        Exception eccezione = new Exception();
        int i = 0;
        while (i < 5) {
            try {
                eccezione.divisione(4, 0);
            } catch (ArithmeticException aEx) {
                i++;
            } finally {
                System.out.println("Un giro in più!");
            }
        }
        System.out.println("Finito");
    }
}
