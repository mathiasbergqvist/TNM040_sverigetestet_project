import java.lang.*;
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class test extends JFrame implements ActionListener
{
	
	private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btn14, btn15, btn16, btn17, btn18, btn19, btn20, btn21, btn22, btn23, btn24, btn25, btnOff, btnStart,
					btn26, btn27, btn28, btn29, btn30, btn31, btn32, btn33, btn34, btn35, btn36, btn37, btn38, btn39, btn40, btn41, btn42, btn43, btn44, btn45, btn46, btn47, btn48, btn49, btn50;
	private JLabel lbl1, lbl2;
	private Vector<Integer> vektorStäder = new Vector<Integer>();
	private	SverigeObjekt stad;
	private int var;
	private int posvektor = 0;
	
	public test()
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
	
	public void stad()
	{
	
	try
	{
				
	Scanner infil = new Scanner(new File("Sverige.txt"));
							
		while (infil.hasNext())
		{
			stad = new SverigeObjekt(infil);
				
				if (vektorStäder.get(posvektor) == (stad.getNummer()))
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
		if(vektorStäder.get(posvektor) == var)
		{
			lbl2.setText("Rätt!");
			posvektor++;
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
		
			vektorStäder.clear();

	
			while (vektorStäder.size()<25)
			{
			
				int slump = (int)(1 + Math.random() * 50);
			
				if (!vektorStäder.contains(slump))
				{
					vektorStäder.add(slump);
				}
			}	
			stad();
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
			var = 9;
			check();
		}
		else if(e.getSource() == btn10)
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
		else if(e.getSource() == btn26)
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
			test e = new test();
		}
}