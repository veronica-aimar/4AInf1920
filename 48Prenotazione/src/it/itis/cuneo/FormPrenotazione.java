package it.itis.cuneo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import javax.swing.border.Border;


public class FormPrenotazione extends  JFrame implements ActionListener {

    JButton bottoneOk;
    JButton bottoneDelete;
    JButton bottoneSalva;
    JButton bottoneStampa;

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

    private Prenotazione[] aPrenotazoni;
    private int i;

    public static final String PATH_NAME = "H:\\triennio\\quarta_ainf\\informatica\\intelliJ\\48Prenotazione\\src\\it\\itis\\cuneo\\prenotazione.csv";
    public static final String SEPARATOR = ",";


    public void setPrenotazioni(Prenotazione[] aPrenotazoni) {
        this.aPrenotazoni = aPrenotazoni;
    }
    public void setIndice(int indice) {
        this.i = indice;
    }
    public int getIndice() {
        return this.i;
    }


    public FormPrenotazione()
    {
        super();
        setSize(400,300);
        setTitle("Prenota il tuo biglietto!");
        initComponets();
        //pack();
        setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        aPrenotazoni = new Prenotazione[10];
        i = 0;
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
        pannelloBasso.add(bottoneOk);
        pannelloBasso.add(bottoneDelete);
        pannelloBasso.add(bottoneStampa);
        pannelloBasso.add(bottoneSalva);

        container.add(pannelloDati, BorderLayout.CENTER);
        container.add(pannelloBasso, BorderLayout.SOUTH);

        bottoneOk.addActionListener(this);
        bottoneDelete.addActionListener(this);
        bottoneStampa.addActionListener(this);
        bottoneSalva.addActionListener(this);
    }


    public void actionPerformed(ActionEvent ae) {
        //CREAZIONE PRENOTAZIONE
        if (ae.getSource() == bottoneOk) {
            richiestaPrenotazione();
            JOptionPane.showMessageDialog(null, "La prenotazione si è conclusa con successo");
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
        }
        //VISUALIZZAZIONE PRENOTAZIONE
        if (ae.getSource() == bottoneStampa) {
            //finestra di dialogo per stampare la prenotazione
            Prenotazione prenotazione = new Prenotazione(cNome.getText(), cCognome.getText(), cTelefono.getText(), cPartenza.getText(), cDestinazione.getText(), cData.getText());
            JOptionPane.showMessageDialog(null, prenotazione.stampaPrenotazione());
        }
    }

    public void richiestaPrenotazione() {
        Prenotazione prenotazione = new Prenotazione(cNome.getText(), cCognome.getText(), cTelefono.getText(), cPartenza.getText(), cDestinazione.getText(), cData.getText());
        aPrenotazoni[i] = prenotazione;
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

    public void scriviCSV() {
        File file = new File(PATH_NAME);
        BufferedWriter bw = null;
            try {
                bw = new BufferedWriter(new FileWriter(PATH_NAME));
                bw.write(aPrenotazoni[i-1].toRowCSV());
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
