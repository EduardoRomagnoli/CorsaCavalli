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
* Classe "Campo", si occupa della componente grafica del programma	 
*/

public class Campo extends JPanel 
{
	/** 
	* @param Oggetto per disegnare il campo
	*/
	
	public void paint(Graphics graf, int num) 
	{
		graf.setColor(Color.green);
		graf.fillRect(0, 0, 1000, (103*num)); 
		graf.setColor(Color.red); 
		for (int i = 0; i <= (num); i++) 
		{
			graf.fillRect(0, (i*100), 1000, 5);
		}
		graf.fillRect(950, 0, 15, (100*(num)));
		graf.setColor(Color.blue);
		graf.fillRect(30, 0, 5, 800);
		graf.fillRect(20, 0, 5, 800);
		graf.fillRect(10, 0, 5, 800);
		graf.setColor(Color.white);
		graf.fillRect(955, 0, 5, 800);
	}
}	