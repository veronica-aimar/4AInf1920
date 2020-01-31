package it.itis.cuneo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Ruote {
    private String ruota;
    private String ruota2;

    public Ruote() {}
    public Ruote (String ruota, String ruota2) {
        this.ruota = ruota;
        this.ruota2 = ruota2;
    }

    @XmlElement(name = "anteriore")
    public void setRuota(String ruota) {
        this.ruota = ruota;
    }
    public String getRuota() {
        return ruota;
    }

    @XmlElement(name = "posteriore")
    public void setRuota2(String ruota2) {
        this.ruota2 = ruota2;
    }
    public String getRuota2() {
        return ruota2;
    }

    @Override
    public String toString() {
        return "Ruote{" +
                "ruota='" + ruota + '\'' +
                ", ruota2='" + ruota2 + '\'' +
                '}';
    }

    public String toXml() {
        return  "\t<ruote nome=\""+ ruota + "\">\n" +
                "\t\t<anteriore>" + ruota + "</anteriore>\n" +
                "\t\t<posteriore>" + ruota2 + "</posteriore>\n"+
                "\t</ruote>\n";
    }
}
