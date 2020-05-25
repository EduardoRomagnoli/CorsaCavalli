//Eduardo Romagnoli 4B-IA
package cavallicorsa;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import javax.swing.JPanel;

public class Cavallo extends JPanel 
{
	int cx;
	int cy;
	Image img;

	public Cavallo (int cy2, int cx2) 
	{
		cx = 0;
		cy = cy2;
		setSize(80, 81);
		Toolkit tk = Toolkit.getDefaultToolkit();
		switch (cx2) 
		{
			case 1:
			{
				img = tk.getImage("./src/cavallo1.png");
				break;
			}
			case 2: 
			{
				img = tk.getImage("./src/cavallo2.png");
				break;
			}
			case 3: 
			{
				img = tk.getImage("./src/cavallo3.png");
				break;
			}
			case 4: 
			{
				img = tk.getImage("./src/cavallo4.png");
				break;
			}
			case 5: 
			{
				img = tk.getImage("./src/cavallo5.png");
				break;
			}
			case 6: 
			{
				img = tk.getImage("./src/cavallo6.png");
				break;
			}
			case 7: 
			{
				img = tk.getImage("./src/cavallo7.png");
				break;
			}
			case 8: 
			{
				img = tk.getImage("./src/cavallo8.png");
				break;
			}
		}
		MediaTracker mt = new MediaTracker(this);
		mt.addImage(img, 1);
		try 
		{
			mt.waitForID(1);
		} 
		catch (Exception e) 
		{
		}
	}
	public void setCx(int n) 
	{
		cx = n;
	}
	public int getCx() 
	{
		return cx;
	}	
	public void paint(Graphics grafica) 
	{
		grafica.drawImage(img,  cx,  cy, null);
	}
}