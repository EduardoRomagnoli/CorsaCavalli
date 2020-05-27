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
* Classe CavalliCampo, classe che serve per avviare i thread.
* 
*/

public class CavalliCampo implements Runnable 
{
	private Thread t;
	private CorsaCavalli ippodromo;
	private Cavallo cavalli;
	private int pos = 0;
	private int num;
	private int dim1 = 80;
	private int dim2 = 1000;
	private int velocità = 1;
	private int conta = 0;

	/** 
	* Metodo CavalliCampo, costruttore che si ocupa di preparare i thread
	* @param cav oggetto di tipo Cavallo, questo oggetto contiene il cavallo registratto su questo thread.
	* @param cors oggetto di tipo CorsaCavalli, questo oggetto si occupa di creare un'istanza nella quale girerà il nostro programma.
	* @param num variabile di tipo int, questa rappresenta il numero dei cavalli presenti alla gara.
	* 
	*/
	
	public CavalliCampo(Cavallo cav, CorsaCavalli cors, int num) 
	{
		this.cavalli = cav;
		this.ippodromo = cors;
		this.num = num;
		t = new Thread(this);
		t.start();
	}
	
	/** 
	* Metodo getPos, metodo che si occupa di ritornare la posizione del thread
	* 
	*/
	
	public int getPos()
	{
		return pos;
	}
	
	@Override
	
	/** 
	* Metodo run, il metodo run è un override che serve per definire il funzionamento dei thread, viene eseguito finchè tutti i cavalli non arrivano al traguardo.
	*
	*/
	
	public void run()
	{
		while((cavalli.getCx()+dim1)<dim2) 
		{
			if (conta%15 == 0) 
			{
				velocità=(int)(Math.random()*3+1);
			}
			cavalli.setCx (cavalli.getCx()+velocità);
			conta++;
			try 
			{
				Thread.sleep(10);
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			ippodromo.repaint();
		}
		pos = ippodromo.getPos();
		ippodromo.Arrivi(num);
	}
	
}