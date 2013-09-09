/*****************************************************
TNM040 - GUI project
Group 1:
Dag Hansson
Mathias Bergqvist
Henrik Gunnarsson
*****************************************************/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class tidtest extends JFrame  implements ActionListener{
	
	private JButton knapp;
	private javax.swing.Timer timer;
	//Timer t;
	private JLabel bild;
	private ImageIcon var, var2;

	tidtest(){
		
		knapp = new JButton("tryck!");
		knapp.addActionListener(this);
		timer = new javax.swing.Timer(2000,this);
			
		timer.addActionListener(this);
		//t = new Timer();
		var = new ImageIcon("Bilder/rättknapp.png");
		var2 = new ImageIcon("Bilder/tomknapp");
		bild = new JLabel(); 
			

		//Container
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.setBackground(Color.white);
		c.add(knapp);
			
		c.add(bild);
		
			
		setTitle("timer");
		setSize(200,200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void setBild()
	{
			while (timer.isRunning() == true)
			{
				
		bild.setIcon(var);
				//bild.setIcon(var2);
					
			}
		
		
	}
	
	
	public void actionPerformed(ActionEvent e) 
	{
		
		if (e.getSource() == knapp) 
		{
			
			
			
			timer.setRepeats(false);
			timer.start();	
			//setBild();
			//bild.setIcon(var);
			bild.setIcon(var);
	
		}
		else if (e.getSource() == timer)
		{
			bild.setIcon(var2);
		}
	
	}

	
	
	public static void main(String[] args) {
		tidtest blabla = new tidtest();
	}
}
