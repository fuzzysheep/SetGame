package Presentation;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GameForm extends JPanel
{
	
	MenuForm menuForm;
	private ImageIcon backgroundImage;

	public GameForm()
	{
		
		menuForm = new MenuForm();
		backgroundImage = new ImageIcon(this.getClass().getResource("../images/backgroundMenu.png"));
		setSize(800, 600);
		setLayout(null);
		add(menuForm);
		
	}
	
	public void paintComponent(Graphics g)
	{

		//Background plaatje
		g.drawImage(backgroundImage.getImage(), 0, 0, this);

	}
	
}
