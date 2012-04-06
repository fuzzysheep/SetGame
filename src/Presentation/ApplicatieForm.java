package Presentation;

import javax.swing.JFrame;

public class ApplicatieForm extends JFrame
{

	 public ApplicatieForm()
	  {
		
	    setSize(800, 600);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setTitle("Set");
		setLocationRelativeTo(null);
		setResizable(false);
		add(new GameForm());
		setVisible(true);
	    
	  }
	
}
