import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Finestra extends  JFrame implements ActionListener {
	
	JLabel lNumero1;
	JLabel lNumero2;
	JTextField tNumero1;
	JTextField tNumero2;
	JButton bSomma;
	JButton bDifferenza;
	JButton bMoltiplicazione;
	JButton bDivisione;
	JLabel lRisultato;
	
	public Finestra()
	{
		setSize(800,600);
		setLocation(200, 200);
		setTitle("MyFirstFrame");
		initComponets();
		//pack();
		JPanel myPanel = new JPanel();
		myPanel.setBackground(Color.BLUE);
		Container container = this.getContentPane();
		container.add(myPanel);
		setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	 }
	
	private void initComponets() {
		// TODO Auto-generated method stub
		this.setLayout(new FlowLayout());
		lNumero1 = new JLabel("Numero1: ");
		this.add(lNumero1);
		tNumero1 = new JTextField(20);
		this.add(tNumero1);
		lNumero2 = new JLabel("Numero2: ");
		this.add(lNumero2);
		tNumero2= new JTextField(20);
		this.add(tNumero2);
		bSomma= new JButton("+");
		bDifferenza= new JButton("-");
		bMoltiplicazione= new JButton("*");
		bDivisione= new JButton("/");
		this.add(bSomma);
		this.add(bDifferenza);
		this.add(bMoltiplicazione);
		this.add(bDivisione);
		lRisultato = new JLabel("Risultato: ");
		this.add(lRisultato);
		bSomma.addActionListener(this);
		bDifferenza.addActionListener(this);
		bMoltiplicazione.addActionListener(this);
		bDivisione.addActionListener(this);
	}
	
	//@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if (ae.getSource() == bSomma)
		{
			int risultato = Integer.parseInt(tNumero1.getText()) + Integer.parseInt(tNumero2.getText());
			lRisultato.setText(Integer.toString(risultato));
		}
		if (ae.getSource() == bDifferenza)
		{
			int risultato = Integer.parseInt(tNumero1.getText()) - Integer.parseInt(tNumero2.getText());
			lRisultato.setText(Integer.toString(risultato));
		}
		if (ae.getSource() == bMoltiplicazione)
		{
			int risultato = Integer.parseInt(tNumero1.getText()) * Integer.parseInt(tNumero2.getText());
			lRisultato.setText(Integer.toString(risultato));
		}
		if (ae.getSource() == bDivisione)
		{
			int risultato = Integer.parseInt(tNumero1.getText()) / Integer.parseInt(tNumero2.getText());
			lRisultato.setText(Integer.toString(risultato));
		}
	}
	
	public static void main(String[] args)
	{
		Finestra fs = new Finestra();
	}
}
