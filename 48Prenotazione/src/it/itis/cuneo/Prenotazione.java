package it.itis.cuneo;

public class Prenotazione {
    private String nome;
    private String cognome;
    private String telefono;
    private String partenza;
    private String destinazione;
    private String data;

    //COSTRUTTORE
    public Prenotazione() {super();}
    public Prenotazione(String nome, String cognome, String telefono, String partenza, String destinazione, String data) {
        this.nome = nome;
        this.cognome = cognome;
        this.telefono = telefono;
        this.partenza = partenza;
        this.destinazione = destinazione;
        this.data = data;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public String getCognome() {
        return cognome;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setPartenza(String partenza) {
        this.partenza = partenza;
    }
    public String getPartenza() {
        return partenza;
    }
    public void setDestinazione(String destinazione) {
        this.destinazione = destinazione;
    }
    public String getDestinazione() {
        return destinazione;
    }
    public void setData(String data) {
        this.data = data;
    }
    public String getData() {
        return data;
    }

    public String stampaPrenotazione() {
        return "nome: " + nome + '\n' +
                "cognome: " + cognome + '\n' +
                "telefono: " + telefono + '\n' +
                "partenza: " + partenza + '\n' +
                "destinazione: " + destinazione + '\n' +
                "data: " + data + '\n';
    }

    public String toRowCSV() {
        return nome + FormPrenotazione.SEPARATOR + cognome
                + FormPrenotazione.SEPARATOR + telefono
                + FormPrenotazione.SEPARATOR
                + partenza + FormPrenotazione.SEPARATOR
                + destinazione + FormPrenotazione.SEPARATOR
                + data + "\n";
    }
}
