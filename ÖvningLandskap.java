import java.lang.*;
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ÖvningLandskap extends JFrame implements ActionListener
{
	
	private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btn14, btn15, btn16, btn17, btn18, btn19, btn20, btn21, btn22, btn23, btn24, btn25, btnOff, btnStart;
	private JLabel lbl1, lbl2;
	private Vector<Integer> vektorSlump = new Vector<Integer>();
	private	SverigeObjekt landskap;
	private int var;
	private int posvektor = 0;
	
	public ÖvningLandskap()
	{
		
		btn1 = new JButton("1");
		btn2 = new JButton("2");
		btn3 = new JButton("3");
		btn4 = new JButton("4");
		btn5 = new JButton("5");
		btn6 = new JButton("6");
		btn7 = new JButton("7");
		btn8 = new JButton("8");
		btn9 = new JButton("9");
		btn10 = new JButton("10");
		btn11 = new JButton("11");
		btn12 = new JButton("12");
		btn13 = new JButton("13");
		btn14 = new JButton("14");
		btn15 = new JButton("15");
		btn16 = new JButton("16");
		btn17 = new JButton("17");
		btn18 = new JButton("18");
		btn19 = new JButton("19");
		btn20 = new JButton("20");
		btn21 = new JButton("21");
		btn22 = new JButton("22");
		btn23 = new JButton("23");
		btn24 = new JButton("24");
		btn25 = new JButton("25");
		btnOff = new JButton("avsluta");
		btnStart = new JButton("starta");
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);
		btn7.addActionListener(this);
		btn8.addActionListener(this);
		btn9.addActionListener(this);
		btn10.addActionListener(this);
		btn11.addActionListener(this);
		btn12.addActionListener(this);
		btn13.addActionListener(this);
		btn14.addActionListener(this);
		btn15.addActionListener(this);
		btn16.addActionListener(this);
		btn17.addActionListener(this);
		btn18.addActionListener(this);
		btn19.addActionListener(this);
		btn20.addActionListener(this);
		btn21.addActionListener(this);
		btn22.addActionListener(this);
		btn23.addActionListener(this);
		btn24.addActionListener(this);
		btn25.addActionListener(this);
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
		c.add(btn1);
		c.add(btn2);
		c.add(btn3);
		c.add(btn4);
		c.add(btn5);
		c.add(btn6);
		c.add(btn7);
		c.add(btn8);
		c.add(btn9);
		c.add(btn10);
		c.add(btn11);
		c.add(btn12);
		c.add(btn13);
		c.add(btn14);
		c.add(btn15);
		c.add(btn16);
		c.add(btn17);
		c.add(btn18);
		c.add(btn19);
		c.add(btn20);
		c.add(btn21);
		c.add(btn22);
		c.add(btn23);
		c.add(btn24);
		c.add(btn25);
		
		
		setTitle("test");
		setResizable(false);
		setSize(400,400);
		//pack();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	
	public void landskap()
	{
	
	try
	{
				
	Scanner infil = new Scanner(new File("Sverige.txt"));
							
		while (infil.hasNext())
		{
			landskap = new SverigeObjekt(infil);
				
				if (vektorSlump.get(posvektor) == (landskap.getNummer()))
				{
					
						lbl1.setText("Tryck på " + landskap.getNamn());
						
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
			landskap();
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
		
			vektorSlump.clear();

	
			while (vektorSlump.size()<25)
			{
			
				int slump = (int)(1 + Math.random() * 25);
			
				if (!vektorSlump.contains(slump))
				{
					vektorSlump.add(slump);
				}
			}	
			landskap();
		}
		
		if(e.getSource() == btn1)
		{
			var = 1;
			check();
							
		}
		else if(e.getSource() == btn2)
		{
			var = 2;
			check();
		}
		else if(e.getSource() == btn3)
		{
			var = 3;
			check();
		}
		else if(e.getSource() == btn4)
		{
			var = 4;
			check();
		}
		else if(e.getSource() == btn5)
		{
			var = 5;
			check();
		}
		else if(e.getSource() == btn6)
		{
			var = 6;
			check();
		}
		else if(e.getSource() == btn7)
		{
			var = 7;
			check();
		}
		else if(e.getSource() == btn8)
		{
			var = 8;
			check();
		}
		else if(e.getSource() == btn9)
		{
			var = 10;
			check();
		}
		else if(e.getSource() == btn11)
		{
			var = 11;
			check();
		}
		else if(e.getSource() == btn12)
		{
			var = 12;
			check();
		}
		else if(e.getSource() == btn13)
		{
			var = 13;
			check();
		}
		else if(e.getSource() == btn14)
		{
			var = 14;
			check();
		}
		else if(e.getSource() == btn15)
		{
			var = 15;
			check();
		}
		else if(e.getSource() == btn16)
		{
			var = 16;
			check();
		}
		else if(e.getSource() == btn17)
		{
			var = 17;
			check();
		}
		else if(e.getSource() == btn18)
		{
			var = 18;
			check();
		}
		else if(e.getSource() == btn19)
		{
			var = 19;
			check();
		}
		else if(e.getSource() == btn20)
		{
			var = 20;
			check();
		}
		else if(e.getSource() == btn21)
		{
				var = 21;
				check();
		}
		else if(e.getSource() == btn22)
		{
			var = 22;
			check();
		}
		else if(e.getSource() == btn23)
		{
			var = 23;
			check();
		}
		else if(e.getSource() == btn24)
		{
			var = 24;
			check();
		}
		else if(e.getSource() == btn25)
		{
			var = 25;
			check();
		}
		}
			
		public static void main (String[] arg)
		{
			ÖvningLandskap e = new ÖvningLandskap();
		}
}