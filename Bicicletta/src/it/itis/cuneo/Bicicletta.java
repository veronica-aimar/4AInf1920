package it.itis.cuneo;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

@XmlRootElement
public class Bicicletta {
    private String telaio;
    private String freno;
    private String cambio;
    private ArrayList<Ruote> ruote;
    public static final String PATH_NAME = "H:\\triennio\\quarta_ainf\\informatica\\intelliJ\\Bicicletta\\xml\\bicicletta.xml";

    public Bicicletta() {
    }

    @XmlAttribute
    public void setTelaio(String telaio) {
        this.telaio = telaio;
    }
    public String getTelaio() {
        return telaio;
    }

    @XmlAttribute
    public void setFreno(String freno) {
        this.freno = freno;
    }
    public String getFreno() {
        return freno;
    }

    @XmlAttribute
    public void setCambio(String cambio) {
        this.cambio = cambio;
    }
    public String getCambio() {
        return cambio;
    }

    @XmlAttribute
    public void setRuote(ArrayList<Ruote> ruote) {
        this.ruote = ruote;
    }
    public ArrayList<Ruote> getRuote() {
        return ruote;
    }

    public void unMarshallXml() {
        File file = new File(PATH_NAME);
        try {
            JAXBContext JaxbContext = JAXBContext.newInstance(Bicicletta.class);
            Unmarshaller jaxbUmarshaller = JaxbContext.createUnmarshaller();
            //bisogna castare jaxbUmarshaller.unmarshal(file)
            Bicicletta bicicletta = (Bicicletta) jaxbUmarshaller.unmarshal(file);
            System.out.println(bicicletta.toString());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Bicicletta{" +
                "telaio='" + telaio + '\'' +
                ", freno='" + freno + '\'' +
                ", cambio='" + cambio + '\'' +
                ", ruote=" + ruote +
                '}';
    }

    public String toXml() {
        String xml="";
        for(Ruote ruota : this.bicicletta){
            xml += punto.toXml();
        }
        xml = "<bicicletta>\n" + xml + "</percorso>";
        return xml;
    }

    public void scriviXml(){
        BufferedWriter bw = null;
        try {
            simulaPercorso();
            bw = new BufferedWriter(new FileWriter(PATH_NAME));
            bw.write(this.toXml());
            System.out.println(this.toXml());
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void marshallingXml(){
        try {
            File file = new File(Bicicletta.PATH_NAME);
            JAXBContext jaxbContext = JAXBContext.newInstance(Bicicletta.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(this, file);
            jaxbMarshaller.marshal(this, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private void simulaPercorso() {
        //Percorso percorso = new Percorso();
        Ruote ruote1 = new Ruote("nome", "nome");
        this.addRuota(ruote1);
        Ruote ruote2 = new Ruote("nome", "nome");
        this.addRuota(ruote2);
    }

    public void addRuota(Ruote ruote){
        bicicletta.add(ruote);
    }
}
