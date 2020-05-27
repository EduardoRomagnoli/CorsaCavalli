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
* Classe "CorsaCavalli", questa classe si occupa di gestire il programma, infatti al suo interno è presente il main il quale quando avviato fa la richiesta all'utente di inserire il numero dei cavalli che gareggieranno, dopodichè si occuperà di avviare il programma creando un oggetto.
* 
*/

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
	
	/** 
	* Metodo Costruttore, definisce la classe appena viene iniziata dal main.
	* @param num valore di tipo int il quale viene inserito dall'utente e si usa per definire il numero di cavalli che gareggieranno.
	* @throws Eccezione la quale verrà lanciata quando si presenteranno degli errori relativi alla classe "Cavallo".
	* 
	*/
	
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
			thCavalliCorsa.add(i, new CavalliCampo(cavallic.get(i), this, num));
		}
		this.add(pista);
		this.setVisible(true);
	}
	
	/** 
	* Metodo getPos(), metodo che si occupa di ritornare il valore pos ingrementato, questo serve per definire la posizione di arrivo e di piazzamento del cavallo, inoltre viene sincronizzato in modo da evitare errori di tipo temporale sul thread.
	* 
	*/
	
	public synchronized int getPos() 
	{
		return pos++;
	}

	/** 
	* Metodo Arrivi, metodo che si occupa di controllare ognivolta, se i cavalli sono tutti arrivati al traguardo, in questo caso, richiama il metodo "Classifica()" così da generare la classifica finale della corsa.
	* @param num valore di tipo int la quale viene inserita dall'utente e si usa per definire il numero di cavalli che gareggieranno.
	* 
	*/
	
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
	
	/** 
	* Metodo Classifica, metodo che si occupa di generare la classifica finale della corsa e la finestra che annuncia separatamente il vincitore della corsa.
	* 
	*/
	
	public void Classifica() 
	{
		JFrame classifica = new JFrame("Classifica corsa dei cavalli");
		JLabel[] arrivi = new JLabel[num];
		classifica.setDefaultCloseOperation(EXIT_ON_CLOSE);
		classifica.setLocation(250, 100);
		classifica.setSize(700, 600);
		classifica.setBackground(Color.WHITE);
		classifica.getContentPane().setLayout(new GridLayout(num, 1));
		for(int i = 1; i < num+1; i++) 
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
	
	/** 
	* Metodo update, metodo che si occupa di fare un override del metodo paint in modo da aggiornare la classe paint.
	* @param graf2 oggetto di tipo Graphics il quale viene inserito nel momento in cui viene richiamato il medoto.
	* 
	*/
	
	public void update(Graphics graf2) 
	{
		paint(graf2);
	}

	/** 
	* Metodo paint, metodo che si occupa di disegnare nella nostra finestra definita dalla classe "Campo"
	* @param graf2 oggetto di tipo Graphics il quale viene inserito nel momento in cui viene richiamato il medoto.
	* 
	*/
	
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
	
	/** 
	* Metodo main, il main contiene il codice necessario per chiedere all'utente il numero di cavalli che vuole far correre e la parte relativa alla creazione di un oggetto di tipo CorsaCavalli così tramite il costruttore è possibile definire le funzioni del programma.
	* @param graf2 oggetto di tipo Graphics il quale viene inserito nel momento in cui viene richiamato il medoto.
	* 
	*/
	
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