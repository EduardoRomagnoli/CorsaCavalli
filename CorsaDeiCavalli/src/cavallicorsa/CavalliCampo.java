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

	public CavalliCampo(Cavallo cav, CorsaCavalli cors, int num, int num2) 
	{
		this.cavalli = cav;
		this.ippodromo = cors;
		this.num = num;
		t = new Thread(this);
		t.setName("Cavallo - " + (num2+1));
		t.start();
	}
	
	public int getPos()
	{
		return pos;
	}
	
	@Override
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