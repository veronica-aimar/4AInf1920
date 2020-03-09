package it.itis.cuneo;

import sun.util.resources.CalendarData;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;


public class FormPrenotazione extends  JFrame implements ActionListener {
    JButton bottoneOk;
    JButton bottoneDelete;
    JButton bottoneSalva;
    JButton bottoneStampa;
    JButton bottoneAvanti;
    JButton bottoneIndietro;

    JTextField cNome;
    JTextField cCognome;
    JTextField cTelefono;
    JTextField cPartenza;
    JTextField cDestinazione;
    JTextField cData;

    JLabel tNome;
    JLabel tCognome;
    JLabel tTelefono;
    JLabel tPartenza;
    JLabel tDestinazione;
    JLabel tData;

    private List<Prenotazione> prenotazioni;
    private int i;

    public static final String PATH_NAME = "H:\\triennio\\quarta_ainf\\informatica\\intelliJ\\48Prenotazione\\src\\it\\itis\\cuneo\\prenotazione.csv";
    public static final String SEPARATOR = ",";


    public void setPrenotazioni(List<Prenotazione> prenotazioni) {
        this.prenotazioni = prenotazioni;
        this.i = 0;
    }
    public List<Prenotazione> getPrenotazioni() {
        return prenotazioni;
    }

    public FormPrenotazione()
    {
        super();
        this.prenotazioni = new ArrayList<Prenotazione>();
        i = 0;
        setSize(600,200);
        setTitle("Prenota il tuo biglietto!");
        initComponets();
        //pack();
        setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }


    private void initComponets() {
        Container container = this.getContentPane();

        //dichiarazione dei pannelli
        JPanel pannelloBasso = new JPanel();
        JPanel pannelloDati = new JPanel();

        //dichiarazione del tipo di layout che si vuole utilizzare
        pannelloDati.setLayout(new GridLayout(6, 2));
        pannelloBasso.setLayout(new FlowLayout());

        //richiesta inserimento nome
        tNome = new JLabel("Nome: ");
        cNome = new JTextField(20);
        pannelloDati.add(tNome);
        pannelloDati.add(cNome);
        //richiesta inserimento cognome
        tCognome = new JLabel("Cognome: ");
        cCognome = new JTextField(20);
        pannelloDati.add(tCognome);
        pannelloDati.add(cCognome);
        //richiesta inserimento telefono
        tTelefono = new JLabel("Telefono: ");
        cTelefono = new JTextField(20);
        pannelloDati.add(tTelefono);
        pannelloDati.add(cTelefono);
        //richiesta inserimento città di partenza
        tPartenza = new JLabel("Città di partenza: ");
        cPartenza = new JTextField(20);
        pannelloDati.add(tPartenza);
        pannelloDati.add(cPartenza);
        //richiesta inserimento città di destinazione
        tDestinazione = new JLabel("Città di destinazione: ");
        cDestinazione = new JTextField(20);
        pannelloDati.add(tDestinazione);
        pannelloDati.add(cDestinazione);
        //richiesta inserimento data
        tData = new JLabel("Data: ");
        cData = new JTextField(20);
        pannelloDati.add(tData);
        pannelloDati.add(cData);

        //dichiaraione dei bottoni
        bottoneOk = new JButton("Conferma");
        bottoneDelete = new JButton("Annulla");
        bottoneStampa = new JButton("Stampa");
        bottoneSalva = new JButton("Salva");
        bottoneIndietro = new JButton("Indietro");
        bottoneAvanti = new JButton("Avanti");
        pannelloBasso.add(bottoneOk);
        pannelloBasso.add(bottoneDelete);
        pannelloBasso.add(bottoneStampa);
        pannelloBasso.add(bottoneSalva);
        pannelloBasso.add(bottoneIndietro);
        pannelloBasso.add(bottoneAvanti);

        container.add(pannelloDati, BorderLayout.CENTER);
        container.add(pannelloBasso, BorderLayout.SOUTH);

        bottoneOk.addActionListener(this);
        bottoneDelete.addActionListener(this);
        bottoneStampa.addActionListener(this);
        bottoneSalva.addActionListener(this);
        bottoneAvanti.addActionListener(this);
        bottoneIndietro.addActionListener(this);
    }


    public void actionPerformed(ActionEvent ae) {
        //CREAZIONE PRENOTAZIONE
        if (ae.getSource() == bottoneOk) {
            richiestaPrenotazione();
            JOptionPane.showMessageDialog(null, "La prenotazione si è conclusa con successo");
            azzeramentoCampiTesto();
        }
        //ANNULLAMENTO PRENOTAZIONE
        if (ae.getSource() == bottoneDelete) {
            azzeramentoCampiTesto();
            JOptionPane.showMessageDialog(null, "Annullamento della prenotazione avvenuto con successo");
        }
        //SALVATAGGIO SU CSV PRENOTAZIONE
        if (ae.getSource() == bottoneSalva) {
            richiestaPrenotazione();
            scriviCSV();
            JOptionPane.showMessageDialog(null, "Salvataggio avvenuto con successo");
            azzeramentoCampiTesto();
        }
        //VISUALIZZAZIONE PRENOTAZIONE
        if (ae.getSource() == bottoneStampa) {
            //finestra di dialogo per stampare la prenotazione
            Prenotazione prenotazione = new Prenotazione(cNome.getText(), cCognome.getText(), cTelefono.getText(), cPartenza.getText(), cDestinazione.getText(), cData.getText());
            JOptionPane.showMessageDialog(null, prenotazione.stampaPrenotazione());
            azzeramentoCampiTesto();
        }
        if(ae.getSource() == bottoneAvanti) {
            mostraElemento(1);
        }
        if(ae.getSource() == bottoneIndietro) {
            mostraElemento(-1);
        }
    }

    public void richiestaPrenotazione() {
        Prenotazione prenotazione = new Prenotazione(cNome.getText(), cCognome.getText(), cTelefono.getText(), cPartenza.getText(), cDestinazione.getText(), cData.getText());
        prenotazioni.add(prenotazione);
        i++;
    }

    public void azzeramentoCampiTesto() {
        cNome.setText("");
        cCognome.setText("");
        cTelefono.setText("");
        cPartenza.setText("");
        cDestinazione.setText("");
        cData.setText("");
    }

    public void mostraElemento(int spiazzamento) {
        i += spiazzamento;

        if(i == prenotazioni.size()) {
            azzeramentoCampiTesto();
        }
        else if(i > -1 && i < prenotazioni.size()) {
            cNome.setText(prenotazioni.get(i).getNome());
            cCognome.setText(prenotazioni.get(i).getCognome());
            cTelefono.setText(prenotazioni.get(i).getTelefono());
            cPartenza.setText(prenotazioni.get(i).getPartenza());
            cDestinazione.setText(prenotazioni.get(i).getDestinazione());
            cData.setText(prenotazioni.get(i).getData());
        } else {
            JOptionPane.showMessageDialog(null, "Non sono stati inserite altre prenotazioni");
        }
    }

    public void scriviCSV() {
        BufferedWriter bw = null;
        String csv = "";
        try {
            bw = new BufferedWriter(new FileWriter(PATH_NAME));
            for (Prenotazione prenotazione : prenotazioni) {
                csv += prenotazione.toRowCSV();
            }
            bw.write(csv);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args)
    {
        FormPrenotazione fp = new FormPrenotazione();
    }
}
