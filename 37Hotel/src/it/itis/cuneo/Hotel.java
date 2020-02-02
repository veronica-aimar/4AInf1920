package it.itis.cuneo;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.lang.management.GarbageCollectorMXBean;
import java.util.ArrayList;

@XmlRootElement (name = "alto")
public class Hotel {
    private static final String PATH_NAME = "H:\\triennio\\quarta_ainf\\informatica\\intelliJ\\Hotel\\xml\\hotel.xml";
    private ArrayList<Camera> lCamere;

    public Hotel() {
        super();
        this.lCamere = new ArrayList<Camera>();
    }

    public void setlCamere(ArrayList<Camera> lCamere) {
        this.lCamere = lCamere;
    }
    public ArrayList<Camera> getlCamere() {
        return lCamere;
    }

    public void addCamera(Camera camera) {
        this.lCamere.add(camera);
    }

    public void unMarhsallXml() {
        File file = new File(PATH_NAME);
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Hotel.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Hotel classeScuola = (Hotel) jaxbUnmarshaller.unmarshal(file);
            System.out.println(classeScuola.toString());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public void marshallXml() {
        File file = new File(PATH_NAME);
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Hotel.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            //this perchè gli sto passando la classe, puntatore
            jaxbMarshaller.marshal(this,file);
            jaxbMarshaller.marshal(this,System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "lCamere=" + lCamere +
                '}';
    }

    public void simula() {
        Camera camera1 = new Camera(2, "si", "mare");
        Camera camera2 = new Camera(1, "si", "mare");
        Camera camera3 = new Camera(3, "no", "città");

        this.addCamera(camera1);
        this.addCamera(camera2);
        this.addCamera(camera3);
    }

    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        hotel.simula();
        hotel.marshallXml();
    }
}
