package Presentation;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MenuForm extends JPanel
{
	
	private BufferedImage backgroundImage, knopImage;
	private final int MAIN = 0, OPTIES = 1, HANDLEIDING = 2, SPELEN = 3, NIEUW = 4, LADEN = 5;
	private int LOCATIE;
	private ArrayList<Knop> knoppen = new ArrayList<Knop>();
	
	public MenuForm()
	{
	
		setSize(800, 600);
		setOpaque(false);
		setBackground(null);
		setLayout(null);
		backgroundImage = createBufferedImage(new ImageIcon(this.getClass().getResource("../images/backgroundMenuBox.png")).getImage());
		knopImage = createBufferedImage(new ImageIcon(this.getClass().getResource("../images/knop.png")).getImage());
		setMenu(MAIN);
		
	}
	
	private void setMenu(int loc)
	{
		System.out.println(loc);
		LOCATIE = loc;
		knoppen.clear();
		removeAll();
		
		switch(LOCATIE) //Menu knoppen
		{
		case MAIN:
			addKnop("Spelen", SPELEN, 150, 150);
			addKnop("Opties", OPTIES, 150, 250);
			addKnop("Handleiding", HANDLEIDING, 150, 350);
			break;
		case SPELEN:
			addKnop("Nieuw spel", NIEUW, 150, 200);
			addKnop("Spel laden", LADEN, 150, 300);
			break;
		default: //Main menu
			addKnop("Spelen", SPELEN, 150, 150);
			addKnop("Opties", OPTIES, 150, 250);
			addKnop("Handleiding", HANDLEIDING, 150, 350);
			break;
		}
		repaint();
		
	}

	private void addKnop(String naam, int action, int x, int y)
	{
		
		Knop knop = new Knop(this, knopImage, action, naam, x, y);
		knoppen.add(knop);
		add(knop);
		
	}

	private BufferedImage createBufferedImage(Image img)
	{

	    BufferedImage bimage = null;
	    bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
	    Graphics g = bimage.createGraphics();
	    g.drawImage(img, 0, 0, null);
	    g.dispose();
	    return bimage;
	    
	}

	public void paintComponent(Graphics g)
	{
		
		//Background plaatje
		g.drawImage(backgroundImage, 0, 0, this);

	}

	public void doAction(int action)
	{
		
		setMenu(action);
		
	}

}
