import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Finestra extends  JFrame implements ActionListener {
	
	public Finestra()
	{
		setSize(200,200);
		setTitle("Finestra");
		initComponets();
		//pack();
		setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	 }
	
	private void initComponets() {
		Container container = this.getContentPane();
		JPanel centerPanel = new JPanel();
		BoxLayout centerPanelLayout = new BoxLayout(centerPanel, BoxLayout.Y_AXIS);
		centerPanel.setLayout(centerPanelLayout);
		JButton button = new JButton("button");
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		JButton shortButton = new JButton("short");
		shortButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		JButton IongButton = new JButton("long-long - long button");
		IongButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		centerPanel.add(button);
		centerPanel.add(shortButton);
		centerPanel.add(IongButton);
		JPanel pannelloBasso = new JPanel();
		JButton bottoneOk = new JButton("OK");
		JButton bottoneDelete = new JButton("Delete");
		pannelloBasso.add(bottoneOk);
		pannelloBasso.add(bottoneDelete);
		container.add(pannelloBasso, BorderLayout.SOUTH);
		container.add(centerPanel);
	}
	
	//@Override
	public void actionPerformed(ActionEvent ae) {
	}
	
	public static void main(String[] args)
	{
		Finestra fs = new Finestra();
	}
}
