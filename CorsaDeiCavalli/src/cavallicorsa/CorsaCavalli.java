//Eduardo Romagnoli 4B-IA
package cavallicorsa;

/** 
* 
* @author Eduardo Romagnoli 4B-IA
*/

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.swing.*;

public class CorsaCavalli extends JFrame 
{
	private int pos = 1;
	private int num = -1;
	private int i, i2;
	private int c = 15;
	private Graphics graf;
	private Image image;
	private ArrayList<Cavallo> cavallic;
	private ArrayList<CavalliCampo> thCavalliCorsa;	
	private Campo pista;

	public CorsaCavalli(int num) throws Exception 
	{
		this.num = num;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocation(0, 0);
		this.setSize(1000, (105 * num));
		if (num == 2)
		{
			this.setSize(1000, 220);
		}
		pista = new Campo();
		cavallic = new ArrayList<Cavallo>(num);
		thCavalliCorsa = new ArrayList<CavalliCampo>(num);		
		for (i = 0; i < num; c += 100, i++) 
		{
			cavallic.add(i, new Cavallo(c, (i + 1)));
			thCavalliCorsa.add(i, new CavalliCampo(cavallic.get(i), this, num, i));
		}
		this.add(pista);
		this.setVisible(true);
	}
	
	public synchronized int getPos() 
	{
		return pos++;
	}

	public synchronized void Arrivi(int inum) 
	{
		boolean traguardo = true;
		for (i = 0; i < inum; i++) 
		{
			if (thCavalliCorsa.get(i).getPos() == 0) 
			{
				traguardo = false;
			}
		}
		if (traguardo == true)
		{
			Classifica();
		}
	}
	
	public void Classifica() 
	{
		JFrame classifica = new JFrame("Classifica corsa dei cavalli");
		JLabel[] arrivi = new JLabel[num];
		classifica.setSize(700, 600);
		classifica.setLocation(250, 100);
		classifica.setBackground(Color.WHITE);
		classifica.setDefaultCloseOperation(EXIT_ON_CLOSE);
		classifica.getContentPane().setLayout(new GridLayout(num, 1));
		for(int i = 1; i < (num+1); i++) 
		{
			for (int i2 = 0; i2 < num; i2++) 
			{
				if (thCavalliCorsa.get(i2).getPos() == i)
				{
					if(thCavalliCorsa.get(i2).getPos() == 1)
					{
						JFrame vincitore = new JFrame("Vincitore - Corsa dei Cavalli");
						vincitore.setLocation(250, 17);
						vincitore.setSize(700, 100);
						vincitore.setDefaultCloseOperation(EXIT_ON_CLOSE);
						arrivi[i2] = new JLabel("Ha vinto il cavallo che gareggiava nella linea numero: " + (i2 + 1));
						arrivi[i2].setForeground(Color.BLACK);
						arrivi[i2].setFont(new Font("CurrierNew", Font.BOLD, 20));
						vincitore.getContentPane().add(arrivi[i2]);
						vincitore.setVisible(true);
					}
					arrivi[i2] = new JLabel(i + "° Classificato è sulla linea numero " + (i2 + 1) + " Cavallo numero: " + (i2 + 1));
					arrivi[i2].setForeground(Color.BLACK);
					arrivi[i2].setFont(new Font("CurrierNew", Font.ITALIC, 20));
					classifica.getContentPane().add(arrivi[i2]);
				}
			}
		}
		classifica.setVisible(true);
	} 
	
	public void update(Graphics graf2) 
	{
		paint(graf2);
	}

	public void paint(Graphics graf2) 
	{
		Graphics2D graphics2d = (Graphics2D) graf2;
		image = createImage (1000, (110 * num));
		graf = image.getGraphics();
		pista.paint(graf, num);
		for (i = 0; i < num; i++) 
		{
			cavallic.get(i).paint(graf);
		}
		graphics2d.drawImage(image, 0, 30, this);
		graf.dispose();
	}
	
	public static void main(String[] args) throws Exception 
	{
		int num;
		do {
			try 
			{
				String number = JOptionPane.showInputDialog("Inserisci numero dei cavalli che vuoi far gareggiare:");
				num = Integer.parseInt(number);
			} catch (Exception e) 
			{
				num = -1;
			}
		} while (!(num > 1 && num < 11));
		CorsaCavalli programma = new CorsaCavalli(num);
	}
}