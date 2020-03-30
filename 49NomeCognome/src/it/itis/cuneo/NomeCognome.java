package it.itis.cuneo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.*;
import javax.swing.border.Border;

public class NomeCognome extends JFrame implements ActionListener, ItemListener {
    //label per la richiesta dell'inserimento del nome e del cognome
    JLabel richiestaNome;
    JLabel richiestaCognome;
    JTextField inserimentoNome;
    JTextField inserimentoCognome;
    JButton conferma;

    JList<String> listaNomi;

    ArrayList<String> arrayNomi;

    DefaultComboBoxModel listNome;
    DefaultListModel modelloNome;

    //COSTRUTTORE
    public NomeCognome()
    {
        setSize(950, 250);
        //inizializzazione degli arrayList
        arrayNomi = new ArrayList<String>();
        this.setTitle("Inserimento Nome e Cognome");
        initComponents();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    //INIZIALIZZAZIONE DEI VALORI
    public void initComponents() {
        //creazione dei pannelli per il corretto posizionamento dei componenti
        JPanel pannelloBasso = new JPanel();
        JPanel pannelloAlto = new JPanel();

        //inserimento del testo nelle label
        richiestaNome = new JLabel("Nome: ");
        richiestaCognome = new JLabel("Cognome: ");
        //inizializzazione del box di testo
        inserimentoNome = new JTextField(20);
        inserimentoCognome = new JTextField(20);

        //aggiunta dei valori al container
        pannelloAlto.add(richiestaNome);
        pannelloAlto.add(inserimentoNome);
        pannelloAlto.add(richiestaCognome);
        pannelloAlto.add(inserimentoCognome);

        //inizializzazione delle JList
        listaNomi = new JList<>();
        pannelloAlto.add(listaNomi);

        //inizializzazione del bottone di conferma
        conferma= new JButton("Conferma");
        pannelloAlto.add(conferma);
        conferma.addActionListener(this);



        //inserimento della scroll list dei nomi
        listNome = new DefaultComboBoxModel();
        JComboBox comboNomi = new JComboBox(listNome);
        comboNomi.setPrototypeDisplayValue("---------------------------------");
        JScrollPane scrollNome = new JScrollPane(comboNomi);
        pannelloBasso.add(scrollNome);

        modelloNome = new DefaultListModel();
        listaNomi = new JList<>(modelloNome);
        listaNomi.setPrototypeCellValue("---------------------------------");
        JScrollPane scrollLista = new JScrollPane(listaNomi);
        pannelloBasso.add(scrollLista);

        this.add(pannelloAlto, BorderLayout.NORTH);
        this.add(pannelloBasso, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        NomeCognome frame = new NomeCognome();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(conferma)) {
            //richiarazione delle stringhe per la memorizzazione dei dati
            String nome;
            String cognome;
            //memorizzazione dei dati inseriti dall'utente
            nome = inserimentoNome.getText();
            cognome = inserimentoCognome.getText();
            listNome.addElement(nome + " " + cognome);
            modelloNome.addElement(nome + " " + cognome);
        }
    }

    public void itemStateChanged(ItemEvent ie) {
        String s = (String)ie.getItem();
        System.out.println(s);
    }
}
