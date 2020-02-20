import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;


public class Finestra extends JFrame implements ActionListener {
	JButton bottone1;
	JButton bottone2;
	JButton bottone3;
	JButton bottone4;
	JButton bottone5;
	JButton bottone6;
	JButton bottone7;
	JButton bottone8;
	JButton bottone9;
    JButton nuovaPartita;
    private int[][] matrice = new int[3][3];
    String ultimoValore = "";

	public Finestra()
	{
		setSize(300,300);
		setTitle("Tris");
		initComponets();
		//pack();
		setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	 }
	
	private void initComponets() {
        String ultimoValore = "";
		//azzeramento della matrice
        inizializzazioneValori();
        Container container = this.getContentPane();
        JPanel panel = new JPanel();
        JPanel pannelloBasso = new JPanel();
        BoxLayout centerPanelLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(new GridLayout(3,3));

        //inizializzazione dei bottoni
        bottone1 = new JButton("");
        bottone2 = new JButton("");
        bottone3 = new JButton("");
        bottone4 = new JButton("");
        bottone5 = new JButton("");
        bottone6 = new JButton("");
        bottone7 = new JButton("");
        bottone8 = new JButton("");
        bottone9 = new JButton("");
        nuovaPartita = new JButton("Nuova partita");
        pannelloBasso.add(nuovaPartita);

        //inserimento dei bottoni nel pannello centrale
        panel.add(bottone1);
        panel.add(bottone2);
        panel.add(bottone3);
        panel.add(bottone4);
        panel.add(bottone5);
        panel.add(bottone6);
        panel.add(bottone7);
        panel.add(bottone8);
        panel.add(bottone9);

        //controllo al click del bottone
        bottone1.addActionListener(this);
        bottone2.addActionListener(this);
        bottone3.addActionListener(this);
        bottone4.addActionListener(this);
        bottone5.addActionListener(this);
        bottone6.addActionListener(this);
        bottone7.addActionListener(this);
        bottone8.addActionListener(this);
        bottone9.addActionListener(this);
        nuovaPartita.addActionListener(this);
        container.add(panel);
        container.add(pannelloBasso, BorderLayout.SOUTH);
	}
	
	//@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if (ae.getSource() == bottone1)
		{
            //disabilitazione del bottone
            bottone1.setEnabled(false);
            //inserimento del valore opposto all'ultimo inserito
            ultimoValore = toggle(ultimoValore);
			bottone1.setText(ultimoValore);
            //mappatura del valore nella matrice
            matrice[0][0] = inserimentoValoreMatrice();
            //controllo di un possibile vincitore
            controllaVincitore();
		}
        if (ae.getSource() == bottone2)
        {
            bottone2.setEnabled(false);
            ultimoValore = toggle(ultimoValore);
            bottone2.setText(ultimoValore);
            matrice[0][1] = inserimentoValoreMatrice();
            controllaVincitore();
        }
        if (ae.getSource() == bottone3)
        {
            bottone3.setEnabled(false);
            ultimoValore = toggle(ultimoValore);
            bottone3.setText(ultimoValore);
            matrice[0][2] = inserimentoValoreMatrice();
            controllaVincitore();
        }
        if (ae.getSource() == bottone4)
        {
            bottone4.setEnabled(false);
            ultimoValore = toggle(ultimoValore);
            bottone4.setText(ultimoValore);
            matrice[1][0] = inserimentoValoreMatrice();
            controllaVincitore();
        }
        if (ae.getSource() == bottone5)
        {
            bottone5.setEnabled(false);
            ultimoValore = toggle(ultimoValore);
            bottone5.setText(ultimoValore);
            matrice[1][1] = inserimentoValoreMatrice();
            controllaVincitore();
        }
        if (ae.getSource() == bottone6)
        {
            bottone6.setEnabled(false);
            ultimoValore = toggle(ultimoValore);
            bottone6.setText(ultimoValore);
            matrice[1][2] = inserimentoValoreMatrice();
            controllaVincitore();
        }
        if (ae.getSource() == bottone7)
        {
            bottone7.setEnabled(false);
            ultimoValore = toggle(ultimoValore);
            bottone7.setText(ultimoValore);
            matrice[2][0] = inserimentoValoreMatrice();
            controllaVincitore();
        }
        if (ae.getSource() == bottone8)
        {
            bottone8.setEnabled(false);
            ultimoValore = toggle(ultimoValore);
            bottone8.setText(ultimoValore);
            matrice[2][1] = inserimentoValoreMatrice();
            controllaVincitore();
        }
        if (ae.getSource() == bottone9)
        {
            bottone9.setEnabled(false);
            ultimoValore = toggle(ultimoValore);
            bottone9.setText(ultimoValore);
            matrice[2][2] = inserimentoValoreMatrice();
            controllaVincitore();
        }
        if (ae.getSource() == nuovaPartita)
        {
            //azzeramento matrice
            inizializzazioneValori();
            //abilitazione del click del bottone
            bottone1.setEnabled(true);
            bottone2.setEnabled(true);
            bottone3.setEnabled(true);
            bottone4.setEnabled(true);
            bottone5.setEnabled(true);
            bottone6.setEnabled(true);
            bottone7.setEnabled(true);
            bottone8.setEnabled(true);
            bottone9.setEnabled(true);

            //inserimento del testo all'interno del bottone
            bottone1.setText("");
            bottone2.setText("");
            bottone3.setText("");
            bottone4.setText("");
            bottone5.setText("");
            bottone6.setText("");
            bottone7.setText("");
            bottone8.setText("");
            bottone9.setText("");
        }
	}

    public void inizializzazioneValori() {
        //inserimento di -1 in tutte le celle della matrice
        for(int r=0; r<3; r++) {
            for (int c=0; c<3; c++) {
                matrice[r][c] = -1;
            }
        }
    }

	public String toggle(String valore) {
        //inserimento del valore opposto a quello appena inserito
	    if(valore == "X") {
	        valore = "O";
        } else if(valore == "O") {
            valore = "X";
        } else{
            valore = "X";
        }
        return valore;
    }

    public int inserimentoValoreMatrice() {
        //inserimento del valore all'interno della matrice
        int numero = -1;
        if(ultimoValore == "O") {
            numero = 0;
        }else {
            numero = 1;
        }
        return numero;
    }

    public void controllaVincitore() {
        int vincitore = -1;
        boolean pieno = true;
        //controllo di un possibile TRIS
        if((matrice[0][0] == matrice[1][0]) && (matrice[0][0] == matrice[2][0]) && (matrice[0][0] != -1)) {
            vincitore = matrice[0][0];
        }
        else if((matrice[0][1] == matrice[1][1]) && (matrice[0][1] == matrice[2][1]) && (matrice[0][1] != -1)) {
            vincitore = matrice[0][1];
        }
        else if((matrice[0][2] == matrice[1][2]) && (matrice[0][2] == matrice[2][2]) && (matrice[0][2] != -1)) {
            vincitore = matrice[0][2];
        }
        else if((matrice[0][0] == matrice[0][1]) && (matrice[0][0] == matrice[0][2]) && (matrice[0][0] != -1)) {
            vincitore = matrice[0][0];
        }
        else if((matrice[1][0] == matrice[1][1]) && (matrice[1][0] == matrice[0][2]) && (matrice[1][0] != -1)) {
            vincitore = matrice[1][0];
        }
        else if((matrice[2][0] == matrice[2][1]) && (matrice[2][0] == matrice[0][2]) && (matrice[2][0] != -1)) {
            vincitore = matrice[2][0];
        }
        else if((matrice[0][0] == matrice[1][1]) && (matrice[0][0] == matrice[2][2]) && (matrice[0][0] != -1)) {
            vincitore = matrice[0][0];
        }
        if((matrice[0][2] == matrice[1][1]) && (matrice[0][0] == matrice[2][0]) && (matrice[0][2] != -1)) {
            vincitore = matrice[0][2];
        }
        for (int r=0; r<3; r++) {
            for (int c=0; c<3; c++) {
                if(matrice[r][c] == -1) {
                    pieno = false;
                }
            }
        }

        //caso con il giocatore 2 come vincitore
        if(vincitore == 0) {
            System.out.println("Il vincitore è il giocatore 2");
        }

        //caso con il giocatore 1 come vincitore
        else if(vincitore == 1) {
            System.out.println("Il vincitore è il giocatore 1");
        }
        else if(pieno) {
            System.out.println("Non c'è nessun vincitore");
        }
        if (vincitore == 0 || vincitore == 1 || pieno) {
            inizializzazioneValori();

            //abilitazione del click del bottone
            bottone1.setEnabled(true);
            bottone2.setEnabled(true);
            bottone3.setEnabled(true);
            bottone4.setEnabled(true);
            bottone5.setEnabled(true);
            bottone6.setEnabled(true);
            bottone7.setEnabled(true);
            bottone8.setEnabled(true);
            bottone9.setEnabled(true);

            //inserimento del testo all'interno del bottone
            bottone1.setText("");
            bottone2.setText("");
            bottone3.setText("");
            bottone4.setText("");
            bottone5.setText("");
            bottone6.setText("");
            bottone7.setText("");
            bottone8.setText("");
            bottone9.setText("");
        }
    }

	
	public static void main(String[] args)
	{
		Finestra fs = new Finestra();
	}
}
