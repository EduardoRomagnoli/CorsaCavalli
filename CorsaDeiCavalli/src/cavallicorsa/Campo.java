//Eduardo Romagnoli 4B-IA
package cavallicorsa;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class Campo extends JPanel 
{
	public void paint(Graphics grafica) 
	{
		grafica.setColor(Color.green);
		grafica.fillRect(0, 0, 1000, 800);
		grafica.setColor(Color.white);
		grafica.fillRect(0, 0, 1000, 10);
		grafica.fillRect(0, 100, 1000, 10);
		grafica.fillRect(0, 200, 1000, 10);
		grafica.fillRect(0, 300, 1000, 10);
		grafica.fillRect(0, 400, 1000, 10);
		grafica.fillRect(0, 500, 1000, 10);
		grafica.fillRect(0, 600, 1000, 10);
		grafica.fillRect(0, 700, 1000, 10);
		grafica.fillRect(310, 820, 380, 100);
		grafica.fillRect(35, 0, 5, 800);
		grafica.fillRect(25, 0, 5, 800);
		grafica.fillRect(15, 0, 5, 800);
		grafica.setColor(Color.red);
		grafica.fillRect(960, 0, 5, 800);
		grafica.fillRect(30, 0, 5, 800);
		grafica.fillRect(20, 0, 5, 800);
		grafica.fillRect(10, 0, 5, 800);
		grafica.setColor(Color.orange);
		grafica.fillRect(0, 850, 1000, 20);
		grafica.fillRect(300, 810, 400, 100);
		grafica.setColor(Color.black);
		grafica.fillRect(40, 0, 5, 800);
		grafica.fillRect(10, 0, 5, 800);
	}
}