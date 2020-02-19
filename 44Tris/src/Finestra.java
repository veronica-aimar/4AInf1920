import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


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
		// TODO Auto-generated method stub
        Container container = this.getContentPane();
        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(3,3));
        bottone1 = new JButton("");
        bottone2 = new JButton("");
        bottone3 = new JButton("");
        bottone4 = new JButton("");
        bottone5 = new JButton("");
        bottone6 = new JButton("");
        bottone7 = new JButton("");
        bottone8 = new JButton("");
        bottone9 = new JButton("");
        panel.add(bottone1);
        panel.add(bottone2);
        panel.add(bottone3);
        panel.add(bottone4);
        panel.add(bottone5);
        panel.add(bottone6);
        panel.add(bottone7);
        panel.add(bottone8);
        panel.add(bottone9);
        bottone1.addActionListener(this);
        bottone2.addActionListener(this);
        bottone3.addActionListener(this);
        bottone4.addActionListener(this);
        bottone5.addActionListener(this);
        bottone6.addActionListener(this);
        bottone7.addActionListener(this);
        bottone8.addActionListener(this);
        bottone9.addActionListener(this);
        container.add(panel);
	}
	
	//@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if (ae.getSource() == bottone1)
		{
			bottone1.setText(toggle(bottone1.getText()));
		}
        if (ae.getSource() == bottone2)
        {
            bottone2.setText(toggle(bottone1.getText()));
        }
        if (ae.getSource() == bottone3)
        {
            bottone3.setText(toggle(bottone1.getText()));
        }
        if (ae.getSource() == bottone4)
        {
            bottone4.setText(toggle(bottone1.getText()));
        }
        if (ae.getSource() == bottone5)
        {
            bottone5.setText(toggle(bottone1.getText()));
        }
        if (ae.getSource() == bottone6)
        {
            bottone6.setText(toggle(bottone1.getText()));
        }
        if (ae.getSource() == bottone7)
        {
            bottone7.setText(toggle(bottone1.getText()));
        }
        if (ae.getSource() == bottone8)
        {
            bottone8.setText(toggle(bottone1.getText()));
        }
        if (ae.getSource() == bottone9)
        {
            bottone9.setText(toggle(bottone1.getText()));
        }
	}

	public String toggle(String bottone) {
	    String r = "";
	    if(bottone == " ") {
	        r = "X";
        } else if(bottone == "X") {
	        r = "O";
        } else if(bottone == "O") {
            r = "X";
        }
        return r;
    }
	
	public static void main(String[] args)
	{
		Finestra fs = new Finestra();
	}
}
