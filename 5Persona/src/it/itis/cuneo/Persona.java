package it.itis.cuneo;

public class Persona {
    //attributi
    private int eta;
    private String nome;
    private String sesso;
    private String professione;

    //metodi

    //setter e getter
    public void setEta(int eta) {
        this.eta = eta;
    }

    public int getEta() {
        return this.eta;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setSesso(String sesso) {
        this.sesso = sesso;
    }

    public String getSesso() {
        return this.sesso;
    }

    public void setProfessione(String professione) {
        this.professione = professione;
    }

    public String getProfessione() {
        return this.professione;
    }

    //costruttore
    public Persona(int eta, String nome, String sesso, String professione) {
        super();
        this.eta = eta;
        this.nome = nome;
        this.sesso = sesso;
        this.professione = professione;
    }

    public String chiSei() {
        return "Sono una persona di nome: " + this.nome + ", sesso: " + this.sesso + ", età: " + this.eta + ", professione: "
                + this.professione + ".";
    }
    public static void main(String args[]) {
        Persona persona = new Persona(17, "Veronica", "F", "studente");
        System.out.println(persona.chiSei());
    }
}
