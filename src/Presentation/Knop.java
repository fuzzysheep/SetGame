package Presentation;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JPanel;

public class Knop extends JPanel implements MouseListener
{

	private String naam;
	private BufferedImage img;
	private Font font;
	private MenuForm menuForm;
	private int action;

	public Knop(MenuForm menuForm, BufferedImage img, int action, String naam, int x, int y)
	{

		setOpaque(false);
		setSize(img.getWidth(), img.getHeight());
		setLocation(x, y);
		addMouseListener(this);
		this.menuForm = menuForm;
		this.naam = naam;
		this.img = img;
		this.action = action;
		try
		{
			font = Font.createFont(Font.TRUETYPE_FONT, this.getClass().getResource("../images/Harabara.ttf").openStream());
			font = font.deriveFont(Font.BOLD, 24);
		} catch (FontFormatException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}

	}

	public void paintComponent(Graphics g)
	{
		
		//Knop
		g.drawImage(img, 0, 0, this);
		g.setFont(font);
		g.setColor(Color.BLACK);
		g.drawString(naam.toUpperCase(), (250-((naam.length()*12)/2)), 33);

	}

	public void mouseClicked(MouseEvent e)
	{
		
		menuForm.doAction(action);
		
	}
	
	public void mouseExited(MouseEvent e)	{}
	public void mouseEntered(MouseEvent e)	{}
	public void mousePressed(MouseEvent e)	{}
	public void mouseReleased(MouseEvent e)	{}

}
