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

public class Campo extends JPanel 
{
	private int i;
	
	public void paint(Graphics graf, int num) 
	{
		graf.setColor(Color.green);
		graf.fillRect(0, 0, 1000, (103*num)); 
		graf.setColor(Color.red); 
		for (i = 0; i <= (num); i++) 
		{
			graf.fillRect(0, (i*100), 1000, 10);
		}
		graf.fillRect(960, 0, 5, (100*(num)));
	}
}