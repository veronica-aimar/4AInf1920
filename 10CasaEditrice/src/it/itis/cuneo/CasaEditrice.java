package it.itis.cuneo;

/**
 * Created by inf.aimarv1906 on 17/10/2019.
 */
public class CasaEditrice {
    //ATTRIBUTI
    private String ragioneSociale;
    private String luogo;
    private int annoFondazione;

    //METODI
    //costruttore
    public CasaEditrice() {
        super();
    }
    public CasaEditrice(String ragioneSociale, String luogo, int annoFondazione) {
        this.ragioneSociale = ragioneSociale;
        this.luogo = luogo;
        this.annoFondazione = annoFondazione;
    }
    public CasaEditrice(CasaEditrice c) {
        this.ragioneSociale = c.getRagioneSociale();
        this.luogo = c.getLuogo();
        this.annoFondazione = c.getAnnoFondazione();
    }

    //set e get
    public void setRagioneSociale(String ragioneSociale) {
        this.ragioneSociale = ragioneSociale;
    }
    public String getRagioneSociale() {
        return ragioneSociale;
    }
    public void setLuogo(String luogo) {
        this.luogo = luogo;
    }
    public String getLuogo() {
        return luogo;
    }
    public void setAnnoFondazione(int annoFondazione) {
        this.annoFondazione = annoFondazione;
    }
    public int getAnnoFondazione() {
        return annoFondazione;
    }
}
