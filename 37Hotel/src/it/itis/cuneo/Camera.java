package it.itis.cuneo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Camera {
    private int letto;
    private String bagno;
    private String mare;

    public Camera() {
    }
    public Camera(int letto, String bagno, String mare) {
        this.letto = letto;
        this.bagno = bagno;
        this.mare = mare;
    }

    @XmlElement
    public void setLetto(int letto) {
        this.letto = letto;
    }
    public int getLetto() {
        return letto;
    }
    @XmlElement
    public void setBagno(String bagno) {
        this.bagno = bagno;
    }
    public String getBagno() {
        return bagno;
    }
    @XmlElement
    public void setMare(String mare) {
        this.mare = mare;
    }
    public String getMare() {
        return mare;
    }

    @Override
    public String toString() {
        return "Camera{" +
                "letto=" + letto +
                ", bagno='" + bagno + '\'' +
                ", mare='" + mare + '\'' +
                '}';
    }
}
