import java.lang.*;
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ÖvningStäder extends JFrame implements ActionListener
{
	
	private JButton btn26, btn27, btn28, btn29, btn30, btn31, btn32, btn33, btn34, btn35, btn36, btn37, btn38, btn39, btn40, btn41, btn42, btn43, btn44, btn45, btn46, btn47, btn48, btn49, btn50, btnOff, btnStart;
	private JLabel lbl1, lbl2;
	private Vector<Integer> vektorSlump = new Vector<Integer>();
	private	SverigeObjekt stad;
	private int var;
	private int posvektor = 0;
	
	public ÖvningStäder()
	{
		
		btn26 = new JButton("26");
		btn27 = new JButton("27");
		btn28 = new JButton("28");
		btn29 = new JButton("29");
		btn30 = new JButton("30");
		btn31 = new JButton("31");
		btn32 = new JButton("32");
		btn33 = new JButton("33");
		btn34 = new JButton("34");
		btn35 = new JButton("35");
		btn36 = new JButton("36");
		btn37 = new JButton("37");
		btn38 = new JButton("38");
		btn39 = new JButton("39");
		btn40 = new JButton("40");
		btn41 = new JButton("41");
		btn42 = new JButton("42");
		btn43 = new JButton("43");
		btn44 = new JButton("44");
		btn45 = new JButton("45");
		btn46 = new JButton("46");
		btn47 = new JButton("47");
		btn48 = new JButton("48");
		btn49 = new JButton("49");
		btn50 = new JButton("50");
		btnOff = new JButton("avsluta");
		btnStart = new JButton("starta");
		
		btn26.addActionListener(this);
		btn27.addActionListener(this);
		btn28.addActionListener(this);
		btn29.addActionListener(this);
		btn30.addActionListener(this);
		btn31.addActionListener(this);
		btn32.addActionListener(this);
		btn33.addActionListener(this);
		btn34.addActionListener(this);
		btn35.addActionListener(this);
		btn36.addActionListener(this);
		btn37.addActionListener(this);
		btn38.addActionListener(this);
		btn39.addActionListener(this);
		btn40.addActionListener(this);
		btn41.addActionListener(this);
		btn42.addActionListener(this);
		btn43.addActionListener(this);
		btn44.addActionListener(this);
		btn45.addActionListener(this);
		btn46.addActionListener(this);
		btn47.addActionListener(this);
		btn48.addActionListener(this);
		btn49.addActionListener(this);
		btn50.addActionListener(this);
		btnOff.addActionListener(this);
		btnStart.addActionListener(this);
		
		lbl1 = new JLabel("Tryck på Starta");
		lbl2 = new JLabel("");
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.setBackground(Color.white);
		
		c.add(btnOff);
		c.add(btnStart);
		c.add(lbl1);
		c.add(lbl2);	
		c.add(btn26);
		c.add(btn27);
		c.add(btn28);
		c.add(btn29);
		c.add(btn30);
		c.add(btn31);
		c.add(btn32);
		c.add(btn33);
		c.add(btn34);
		c.add(btn35);
		c.add(btn36);
		c.add(btn37);
		c.add(btn38);
		c.add(btn39);
		c.add(btn40);
		c.add(btn41);
		c.add(btn42);
		c.add(btn43);
		c.add(btn44);
		c.add(btn45);
		c.add(btn46);
		c.add(btn47);
		c.add(btn48);
		c.add(btn49);
		c.add(btn50);
		
		
		setTitle("test");
		setResizable(false);
		setSize(400,400);
		//pack();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	
	public void slumpaVektor()
	{
		vektorSlump.clear();

		while (vektorSlump.size()<25)
			{
			
				int slump = (int)(26 + Math.random() * 25);
			
				if (!vektorSlump.contains(slump))
				{
					vektorSlump.add(slump);
				}
			}
	}
	
	public void stad()
	{
	
	try
	{
				
	Scanner infil = new Scanner(new File("Sverige.txt"));
							
		while (infil.hasNext())
		{
			stad = new SverigeObjekt(infil);
				
				if (vektorSlump.get(posvektor) == (stad.getNummer()))
				{
					
						lbl1.setText("Tryck på " + stad.getNamn());
						
				}
								
		}
		
		infil.close();
	}
	
	catch (FileNotFoundException a)
	{
				System.out.println("Hittade ej filen");
	}	
				
	}
	
	public void check()
	{
		if(vektorSlump.get(posvektor) == var)
		{
			lbl2.setText("Rätt!");
			posvektor++;
			if(posvektor == 24)
			{
				posvektor = 0;
				slumpaVektor();
				stad();	
			}
			else
			stad();
		}
		else
		{
			lbl2.setText("Fel. testa igen.");
		}
	}
	
	public void actionPerformed(ActionEvent e) 
		{
	
		if(e.getSource() == btnOff)
		{
			System.exit(0);
		}
		
		else if (e.getSource() == btnStart)
		{	
			slumpaVektor();
			stad();
		}
		
		if(e.getSource() == btn26)
		{
			var = 26;
			check();
							
		}
		else if(e.getSource() == btn27)
		{
			var = 27;
			check();
		}
		else if(e.getSource() == btn28)
		{
			var = 28;
			check();
		}
		else if(e.getSource() == btn29)
		{
			var = 29;
			check();
		}
		else if(e.getSource() == btn30)
		{
			var = 30;
			check();
		}
		else if(e.getSource() == btn31)
		{
			var = 31;
			check();
		}
		else if(e.getSource() == btn32)
		{
			var = 32;
			check();
		}
		else if(e.getSource() == btn33)
		{
			var = 33;
			check();
		}
		else if(e.getSource() == btn34)
		{
			var = 34;
			check();
		}
		else if(e.getSource() == btn35)
		{
			var = 35;
			check();
		}
		else if(e.getSource() == btn36)
		{
			var = 36;
			check();
		}
		else if(e.getSource() == btn37)
		{
			var = 37;
			check();
		}
		else if(e.getSource() == btn38)
		{
			var = 38;
			check();
		}
		else if(e.getSource() == btn39)
		{
			var = 39;
			check();
		}
		else if(e.getSource() == btn40)
		{
			var = 40;
			check();
		}
		else if(e.getSource() == btn41)
		{
			var = 41;
			check();
		}
		else if(e.getSource() == btn42)
		{
			var = 42;
			check();
		}
		else if(e.getSource() == btn43)
		{
			var = 43;
			check();
		}
		else if(e.getSource() == btn44)
		{
			var = 44;
			check();
		}
		else if(e.getSource() == btn45)
		{
			var = 45;
			check();
		}
		else if(e.getSource() == btn46)
		{
				var = 46;
				check();
		}
		else if(e.getSource() == btn47)
		{
			var = 47;
			check();
		}
		else if(e.getSource() == btn48)
		{
			var = 48;
			check();
		}
		else if(e.getSource() == btn49)
		{
			var = 49;
			check();
		}
		else if(e.getSource() == btn50)
		{
			var = 50;
			check();
		}
		}
			
		public static void main (String[] arg)
		{
			ÖvningStäder e = new ÖvningStäder();
		}
}