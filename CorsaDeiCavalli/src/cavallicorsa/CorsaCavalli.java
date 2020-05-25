//Eduardo Romagnoli 4B-IA
package cavallicorsa;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CorsaCavalli extends JFrame 
{
	public int pos;
	public Cavallo[] cavalli;
	public CavalliCampo[] thCavalliCorsa;
	public Campo pista;
	Graphics offscreen;
	Image buffer_virtuale;
	
	public static void main(String[] n) 
	{
		CorsaCavalli camp = new CorsaCavalli();
	}
	
	public CorsaCavalli() 
	{
		setSize(1000, 900);
		setLocation(10, 40);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pista = new Campo();
		cavalli = new Cavallo[8];
		thCavalliCorsa = new CavalliCampo[8];
		pos = 1;
		int partenza = 15;
		for (int i=0; i<8; i++) 
		{
			cavalli[i] = new Cavallo(partenza,  i+1);
			thCavalliCorsa[i] = new CavalliCampo(cavalli[i], this);
			partenza = partenza+100;			
		}
		this.add(pista);
		setVisible(true);
	}
	
	public synchronized int getPos() 
	{
		return pos++;
	}
	
	public synchronized void Arrivi() 
	{
		boolean arrivato=true;
		for (int i=0; i<8; i++) {
			if (thCavalliCorsa[i].pos == 0) 
			{
				arrivato=false;
			}
		}
		if(arrivato == true) 
		{
			Classifica();
		}
	}
	
	public void Classifica() 
	{
		JLabel[] arrivi;
		arrivi = new JLabel[8];
		JFrame classifica = new JFrame("Classifica Finale della Corsa");
		classifica.setSize(600, 400);
		classifica.setLocation(280, 130);
		classifica.setBackground(Color.white);
		classifica.setDefaultCloseOperation(EXIT_ON_CLOSE);
		classifica.getContentPane().setLayout(new GridLayout(8,1 ));
		
		for(int i=1; i<9; i++) {
			for (int i2=0; i2<8; i2++) {
				if (thCavalliCorsa[i2].pos == i)
				{
					arrivi[i2] = new JLabel(i+"° Classificato nella corsia numero: " + (i2+1));
					arrivi[i2].setFont(new Font("Currier New", Font.ITALIC, 20));
					arrivi[i2].setForeground(Color.black);
					classifica.getContentPane().add(arrivi[i2]);
				}
			}
		}
		classifica.setVisible(true);
	}
	
	public void update(Graphics grafica) 
	{
		paint(grafica);
	}
	
	public void paint(Graphics grafica) 
	{
		if (cavalli != null) 
		{
			Graphics2D screen = (Graphics2D) grafica;
			buffer_virtuale= createImage(1000, 900);
			offscreen = buffer_virtuale.getGraphics();
			Dimension d = getSize();
			pista.paint(offscreen);
			for (int i=0; i<8; i++) 
			{
				cavalli[i].paint(offscreen);
			}
			screen.drawImage(buffer_virtuale, 0, 30, this);
			offscreen.dispose();
		}
	}
}