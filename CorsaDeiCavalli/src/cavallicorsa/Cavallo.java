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

public class Cavallo extends JPanel 
{
	private int cx2 = 75;
	private int cy2 = 75;
	private int cx;
	private int cy;
	private Image img;
	
	public Cavallo(int cy, int num) throws Exception 
	{
		this.setSize(cx2, cy2);
		this.cx = 0;
		this.cy = cy;
		MediaTracker mt = new MediaTracker(this);
		Toolkit tk = Toolkit.getDefaultToolkit();
		if (!(num < 1 || num > 11)) 
		{
			img = tk.getImage("./src/cavallo" + num + ".png");
		} 
		else 
		{
			throw new Exception("errore numero cavalli");
		}
		mt.addImage(img, 0);
		try 
		{
			mt.waitForID(0);
		} 
		catch (Exception e) 
		{
			throw new Exception("errore immagine");
		}
	}
	
	public void setCx(int n) 
	{
		this.cx = n;
	}
	
	public int getCx() 
	{
		return cx;
	}
	
	public void paint(Graphics graf) 
	{
		graf.drawImage(img, cx, cy, null);
	}
	

}