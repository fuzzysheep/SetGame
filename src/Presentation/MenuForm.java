package Presentation;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MenuForm extends JPanel
{
	
	private BufferedImage backgroundImage, knopImage, smallKnopImage;
	private final int MAIN = 0, OPTIES = 1, HANDLEIDING = 2, SPELEN = 3, NIEUW = 4, LADEN = 5;
	private int LOCATIE;
	private ArrayList<Knop> knoppen = new ArrayList<Knop>();
	private String Handleiding = "";
	
	public MenuForm()
	{
	
		setSize(800, 600);
		setOpaque(false);
		setBackground(null);
		setLayout(null);
		backgroundImage = createBufferedImage(new ImageIcon(this.getClass().getResource("../images/backgroundMenuBox.png")).getImage());
		knopImage = createBufferedImage(new ImageIcon(this.getClass().getResource("../images/knop.png")).getImage());
		smallKnopImage = createBufferedImage(new ImageIcon(this.getClass().getResource("../images/smallKnop.png")).getImage());
		InputStream in = this.getClass().getResourceAsStream("../res/handleiding.txt");
		BufferedReader br;
		try
		{
			br = new BufferedReader(new InputStreamReader(in, "UTF-8"));
			String buffer;
			while ((buffer = br.readLine()) != null) {
				Handleiding = Handleiding + buffer;
			}
		} catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
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
			addKnop("Spelen", SPELEN, 150, 150, knopImage);
			addKnop("Opties", OPTIES, 150, 250, knopImage);
			addKnop("Handleiding", HANDLEIDING, 150, 350, knopImage);
			break;
		case SPELEN:
			addKnop("Nieuw spel", NIEUW, 150, 200, knopImage);
			addKnop("Spel laden", LADEN, 150, 300, knopImage);
			addKnop("Terug", MAIN, 100, 450, smallKnopImage);
			break;
		case OPTIES:
			addKnop("Terug", MAIN, 100, 450, smallKnopImage);
			break;
		case HANDLEIDING:
			JTextArea handleiding = new JTextArea();
			handleiding.setEditable(false);
			handleiding.setText(this.getClass().getResourceAsStream("../res/handleiding.txt").toString());
			handleiding.setBounds(150, 150, 475, 250);
			handleiding.setText(Handleiding);
			handleiding.setWrapStyleWord(true);
			handleiding.setLineWrap(true);
			JScrollPane scrollPane = new JScrollPane(handleiding, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			add(handleiding);
			addKnop("Terug", MAIN, 100, 450, smallKnopImage);
			break;
		default: //Main menu
			addKnop("Spelen", SPELEN, 150, 150, knopImage);
			addKnop("Opties", OPTIES, 150, 250, knopImage);
			addKnop("Handleiding", HANDLEIDING, 150, 350, knopImage);
			break;
		}
		repaint();
		
	}

	private void addKnop(String naam, int action, int x, int y, BufferedImage img)
	{
		
		Knop knop = new Knop(this, img, action, naam, x, y);
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
