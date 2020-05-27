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

/** 
* Classe "Cavallo", si occupa di disegnare e aggiornare la posizione dei cavalli nel campo 
*/

public class Cavallo extends JPanel 
{
	private int cx2 = 75;
	private int cy2 = 75;
	private int cx;
	private int cy;
	private Image img;
	
	/** 
	* Costruttore della Classe "Cavallo": richiede in input la posizione y del cavallo e il "num" che equivale al numero dei cavalli che l'utente vuole far gareggiare.
	* @throws Questa eccezione viene inviata solamente quando si presentano degli errori relativi ai cavalli e all'inserimento delle immagini.
	*/
	
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
	
	/** 
	* Metodo che serve per settare la posizione x del cavallo.
	* @param n variabile di tipo intero da settare.
	* 
	*/
	
	public void setCx(int n) 
	{
		this.cx = n;
	}
	
	/** 
	* Metodo per ottenere la posizione x del cavallo.
	* 
	*/
	
	public int getCx() 
	{
		return cx;
	}
	
	/** 
	* Metodo che disegna l'immagine man mano che si sposta nella pista.
	* @param graf è l'oggetto di tipo Graphics che si occuperò di disegnare i nostri cavalli nel campo
	* 
	*/
	
	public void paint(Graphics graf) 
	{
		graf.drawImage(img, cx, cy, null);
	}
	

}