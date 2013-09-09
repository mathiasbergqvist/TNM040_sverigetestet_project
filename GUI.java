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
import java.io.*;
import java.net.*;
import javax.swing.border.LineBorder;
import java.lang.*;
import java.util.*;

public class GUI extends JFrame implements ActionListener {
  
  	private JTextArea txtHighScore;
	private JLabel lblStarttext ,lblText, lbl�va, lblLogo, lblKarta, lblFr�ga, lblr�ttSvar, lblfelSvar, lblKlickade, lblBeskrivning, lbl�vaSt�der, lbl�vaLandskap, lblMaskot, lblMaskotLiten, lblPratbubblaStart, lblPratbubblaTest, lblPratbubbla�vning, lblPratbubblaTips;
	private JLabel lblVapen, lblBak,lblBak�t, lblAvsluta, lblfr�gaNummer, lblTipsText;
	private JTextArea lblTips;
	private JRadioButton radSt�der, radLandskap;
	private ImageIcon imgLogo, img�va, imgTest, imgBak, imgAvsluta, img�vaSt�der, img�vaLandskap, imgStart, imgKarta, imgStad, imgLandskap, imgR�tt,
					  imgFel, imgStartaTest, imgBeskrivning, imgTomBild, imgMaskot, imgPratbubblaStart, imgPratbubblaTest, imgPratbubbla�vning, imgMaskotLiten, imgPratbubblaTips;
	private ImageIcon bakBl�, bakR�d, bakGul, bakGr�n, bakRosa, bakTr�, imgTopp;
	private ImageIcon vapenBlekinge, vapenBohusl�n, vapenDalarna, vapenDalsland, vapenGotland, vapenG�strikland, vapenHalland, vapenH�lsingland,
					  vapenH�rjedalen, vapenJ�mtland, vapenLappland, vapenMedelpad, vapenNorrbotten, vapenN�rke, vapenSk�ne, vapenSm�land, vapenS�dermanland,
					  vapenUppland, vapenV�rmland, vapenV�sterbotten, vapenV�sterg�tland, vapenV�stmanland, vapen�ngermanland, vapen�land, vapen�sterg�tland;
	private JButton btn�va, btnTest, btn�vaSt�der, btn�vaLandskap, btnBak, btnAvsluta, btnStart, btnStartaTest, btnHighscore;
	private JButton btnStockholm, btnG�teborg, btnMalm�, btnUppsala, btnV�ster�s, btn�rebro, btnLink�ping, btnHelsingborg, btnJ�nk�ping,
					btnNorrk�ping, btnLund, btnUme�, btnG�vle, btnBor�s, btnKalmar, btnEskilstuna, btnKarlstad, btnHalmstad, btnV�xj�, btnSundsvall,
					btnKiruna, btnVisby, btnFalun, btnLule�, btn�stersund;
	
	private JButton btnLappland, btnNorrbotten, btnV�sterbotten, btnJ�mtland, btn�ngermanland,btnMedelpad, btnH�rjedalen, btnH�lsingland, btnDalarna,
					btnG�strikland,btnUppland, btnV�stmanland, btnV�rmland, btnS�dermanland, btnN�rke, btnDalsland, btn�sterg�tland, btnV�sterg�tland, 
					btnBohusl�n, btnSm�land, btnHalland, btnBlekinge, btnSk�ne, btnGotland, btn�land;
	
	private ImageIcon bak;
	private JMenuBar menuBar;
	private JMenu f�rgMeny;
	private JMenuItem r�dF�rg, bl�F�rg, gr�nF�rg, gulF�rg, rosaF�rg, tr�F�rg;
	
	private Vector<Integer> vektorSlump = new Vector<Integer>();
	private	SverigeObjekt obj;
	private Highscore highscore;
	private javax.swing.Timer timer;
	private int var, antalPo�ng=0, fr�gaNummer=1, antalFel=0;
	private int posvektor = 0, startPos = 0;
	private Boolean klickbara = true;
	private String aktuellSida, aktuellStad;
	private JOptionPane topplista;
	private JDialog d1;
	
	//--------------------------------------------------------------------------------------------------------------------------------------------
	public GUI() {
		
		//S�tter layout manager till null s� att man kan s�tta ut komponenter var man vill	
		Container c = getContentPane();
		c.setLayout(null);
		
		//--------------------------------------------------------------------------------------------		
		//Objekt sorterade i den ordning de visas p� de olika sidorna
		//Menyraden
		
		bakBl� = new ImageIcon("Bilder/bakgrund_ver2.png");
		bakR�d = new ImageIcon("Bilder/r�d_bak.png");
		bakGul = new ImageIcon("Bilder/gul_bak.png");
		bakGr�n = new ImageIcon("Bilder/gr�n_bak.png");
		bakRosa = new ImageIcon("Bilder/rosa_bak.png");
		bakTr� = new ImageIcon("Bilder/bakgrund_tr�.png");
		
		lblBak = new JLabel();
		lblBak.setBounds(0,0,800,600);
		lblBak.setIcon(bakBl�);
		
		menuBar = new JMenuBar();
		f�rgMeny = new JMenu("Bakgrundsf�rg");
		r�dF�rg = new JMenuItem("R�d");
		bl�F�rg = new JMenuItem("Orginal");
		gr�nF�rg = new JMenuItem("Gr�n");
		gulF�rg = new JMenuItem("Gul");
		rosaF�rg = new JMenuItem("Rosa");
		tr�F�rg = new JMenuItem("Tr�f�rgad");
		
		f�rgMeny.add(bl�F�rg);
		f�rgMeny.add(r�dF�rg);
		f�rgMeny.add(gr�nF�rg);
		f�rgMeny.add(gulF�rg);
		f�rgMeny.add(rosaF�rg);
		f�rgMeny.add(tr�F�rg);
		
		menuBar.add(f�rgMeny);
		
		setJMenuBar(menuBar);
		
		//Startsidan......................................................
		imgLogo = new ImageIcon("images/logo.png");
		img�va = new ImageIcon("images/ova.png");
		imgTest = new ImageIcon("Bilder/knapp_test.png");
		imgMaskot = new ImageIcon("Bilder/maskot kopiera.png");
		imgPratbubblaStart = new ImageIcon("Bilder/Start_bubbla.png");
		
		lblMaskot = new JLabel();
		lblPratbubblaStart = new JLabel();
		lblVapen = new JLabel();
		lblLogo = new JLabel();
		btn�va = new JButton();
		btnTest = new JButton();
		
		lblMaskot.setIcon(imgMaskot);
		lblPratbubblaStart.setIcon(imgPratbubblaStart);
		lblLogo.setIcon(imgLogo);
		btn�va.setIcon(img�va);
		btnTest.setIcon(imgTest);
		
		lblStarttext = new JLabel("V�lj ett av alternativen f�r att g� vidare:");
		lblStarttext.setFont(new Font("SanSerif", Font.PLAIN, 22));
		
		lblMaskot.setBounds(430,340,400,250);
		lblPratbubblaStart.setBounds(130,65,580,363);

		lblLogo.setBounds(180,10,420,90);
		btn�va.setBounds(20,150,200,100);
		btnTest.setBounds(20,280,200,100);
		
		aktuellSida = "start";
		
		//Objekt som visas p� flera sidor..............................
		imgBak = new ImageIcon("Bilder/bak.png");
		imgAvsluta = new ImageIcon("Bilder/avsluta kopiera.png");
		imgTomBild = new ImageIcon("images/tombild.png");
		
		lblBak�t = new JLabel("Bak�t");
		lblAvsluta = new JLabel("Avsluta");
		lblTips = new JTextArea();
		lblTipsText = new JLabel("Tips!");
		lblText = new JLabel();
		btnBak = new JButton();
		btnAvsluta = new JButton();
		
		btnBak.setContentAreaFilled(false);
		btnAvsluta.setContentAreaFilled(false);
		
		lblText.setFont(new Font("SanSerif", Font.PLAIN, 18));
		lblTipsText.setFont(new Font("SanSarif", Font.PLAIN, 22));
		
		btnBak.setIcon(imgBak);
		btnAvsluta.setIcon(imgAvsluta);
		
		lblBak�t.setBounds(45,500,80,40);
		lblAvsluta.setBounds(160,500,80,40);
		btnBak.setBounds(20,530,80,40);
		btnAvsluta.setBounds(140,530,80,40);
		lblText.setBounds(20,20,400,20);
		lblTips.setBounds(150,375,220,40);
		lblTipsText.setBounds(80,360,60,40);
		
		timer = new javax.swing.Timer(2300,this);
			
		//�vasidan....................................................................
		img�vaSt�der = new ImageIcon("images/stad.png");
		img�vaLandskap = new ImageIcon("images/landskap.png");
		imgStart = new ImageIcon("images/start.png");
		imgR�tt = new ImageIcon("images/r�ttknapp.png");
		imgFel = new ImageIcon("images/felknapp.png");
		imgBeskrivning = new ImageIcon("images/beskrivning.png");
		imgMaskotLiten = new ImageIcon("Bilder/maskotLiten.png");
		imgPratbubblaTips = new ImageIcon("Bilder/bubblaTipset.png");
		imgPratbubbla�vning = new ImageIcon("Bilder/�va_bubbla.png");
		
		lblr�ttSvar = new JLabel();
		lblfelSvar = new JLabel();
		lblFr�ga = new JLabel("");
		lblKlickade = new JLabel();
		lblMaskotLiten = new JLabel();
		lblPratbubblaTips = new JLabel();
		lblPratbubbla�vning = new JLabel();
		lblBeskrivning = new JLabel();
		btn�vaSt�der = new JButton();
		btn�vaLandskap = new JButton();
		btnStart = new JButton();
		radSt�der = new JRadioButton();
		radLandskap = new JRadioButton();
		lbl�vaSt�der = new JLabel("�va p� st�der.");
		lbl�vaLandskap = new JLabel("�va p� landskap.");
		
		lblMaskotLiten.setIcon(imgMaskotLiten);
		lblPratbubblaTips.setIcon(imgPratbubblaTips);
		lblPratbubbla�vning.setIcon(imgPratbubbla�vning);
		lblBeskrivning.setIcon(imgBeskrivning);
		btn�vaSt�der.setIcon(img�vaSt�der);
		btn�vaLandskap.setIcon(img�vaLandskap);
		btnStart.setIcon(imgStart);
		lblr�ttSvar.setIcon(imgR�tt);
		lblfelSvar.setIcon(imgFel);
		
		lblBeskrivning.setBounds(498,10,120,50);
		btn�vaSt�der.setBounds(20,100,100,100);
		btn�vaLandskap.setBounds(20,270,100,100);
		btnStart.setBounds(245,420,120,50);
		lblPratbubbla�vning.setBounds(130,65,580,363);
		lblPratbubblaTips.setBounds(40,320,388,176);
		lblMaskotLiten.setBounds(250,430,250,156);
		radSt�der.setBounds(140,140,20,20);
		radLandskap.setBounds(140,310,20,20);
		lbl�vaSt�der.setBounds(20,80,100,20);
		lbl�vaLandskap.setBounds(20,250,100,20);
		lblVapen.setBounds(300,60,120,146);
		lblr�ttSvar.setBounds(10,120,170,130);
		lblfelSvar.setBounds(1,120,170,130);
		lblFr�ga.setBounds(20,60,220,20);
		lblKlickade.setBounds(20,100,250,20);
				
		ButtonGroup gruppen = new ButtonGroup();
		gruppen.add(radSt�der);
		gruppen.add(radLandskap);
	
		lblFr�ga.setFont(new Font("SanSerif", Font.PLAIN, 18));
		lblKlickade.setFont(new Font("SanSerif", Font.PLAIN, 18));
			
		lblFr�ga.setOpaque(true);
		lblFr�ga.setBackground(Color.white);
		lblFr�ga.setBorder(new LineBorder(Color.black));
		
		//Landskapsvapnen.........................................................
		vapenBlekinge = new ImageIcon("vapen/Blekinge_vapen.png");
		vapenBohusl�n = new ImageIcon("vapen/Bohusl�n_vapen.png");
		vapenDalarna = new ImageIcon("vapen/Dalarna_vapen.png");
		vapenDalsland = new ImageIcon("vapen/Dalsland_vapen.png");
		vapenGotland = new ImageIcon("vapen/Gotland_vapen.png");
		vapenG�strikland = new ImageIcon("vapen/G�strikland_vapen.png");
		vapenHalland = new ImageIcon("vapen/Halland_vapen.png");
		vapenH�lsingland = new ImageIcon("vapen/H�lsingland_vapen.png");
		vapenH�rjedalen = new ImageIcon("vapen/H�rjedalen_vapen.png");
		vapenJ�mtland = new ImageIcon("vapen/J�mtland_vapen.png");
		vapenLappland = new ImageIcon("vapen/Lappland_vapen.png");
		vapenMedelpad = new ImageIcon("vapen/Medelpad_vapen.png");
		vapenNorrbotten = new ImageIcon("vapen/Norrbotten_vapen.png");
		vapenN�rke = new ImageIcon("vapen/N�rke_vapen.png");
		vapenSk�ne = new ImageIcon("vapen/Sk�ne_vapen.png");
		vapenSm�land = new ImageIcon("vapen/Sm�land_vapen.png");
		vapenS�dermanland = new ImageIcon("vapen/S�dermanland_vapen.png");
		vapenUppland = new ImageIcon("vapen/Uppland_vapen.png");
		vapenV�rmland = new ImageIcon("vapen/V�rmland_vapen.png");
		vapenV�sterbotten = new ImageIcon("vapen/V�sterbotten_vapen.png");
		vapenV�sterg�tland = new ImageIcon("vapen/V�sterg�tland_vapen.png");
		vapenV�stmanland = new ImageIcon("vapen/V�stmanland_vapen.png");
		vapen�ngermanland = new ImageIcon("vapen/�ngermanland_vapen.png");
		vapen�land = new ImageIcon("vapen/�land_vapen.png");
		vapen�sterg�tland = new ImageIcon("vapen/�sterg�tland_vapen.png");
		
		//St�derna................................................................		
		imgStad = new ImageIcon("Bilder/kartknapp2.2.png");
		imgKarta = new ImageIcon("images/karta2.png");

		btnStockholm = new JButton();
		btnG�teborg  = new JButton();
		btnMalm� = new JButton();
		btnUppsala = new JButton();
		btnV�ster�s = new JButton();
		btn�rebro = new JButton();
		btnLink�ping = new JButton();
		btnHelsingborg = new JButton();
		btnJ�nk�ping = new JButton();	
		btnNorrk�ping = new JButton();
		btnLund = new JButton();
		btnUme� = new JButton();
		btnG�vle = new JButton();
		btnBor�s = new JButton();
		btnKalmar = new JButton(); 
		btnEskilstuna = new JButton();
		btnKarlstad = new JButton();
		btnHalmstad = new JButton();
		btnV�xj� = new JButton();
		btnSundsvall = new JButton();
		btnKiruna = new JButton();
		btnVisby = new JButton();
		btnFalun = new JButton();
		btnLule� = new JButton();
		btn�stersund = new JButton();
		lblKarta = new JLabel();
	
		btnStockholm.setIcon(imgStad); btnG�teborg.setIcon(imgStad); btnMalm�.setIcon(imgStad); btnUppsala.setIcon(imgStad); 
		btnV�ster�s.setIcon(imgStad); btn�rebro.setIcon(imgStad); btnLink�ping.setIcon(imgStad); btnHelsingborg.setIcon(imgStad); 
		btnJ�nk�ping.setIcon(imgStad); btnNorrk�ping.setIcon(imgStad); btnLund.setIcon(imgStad); btnUme�.setIcon(imgStad); 
		btnG�vle.setIcon(imgStad); btnBor�s.setIcon(imgStad); btnKalmar.setIcon(imgStad); btnEskilstuna.setIcon(imgStad); 
		btnKarlstad.setIcon(imgStad); btnHalmstad.setIcon(imgStad); btnV�xj�.setIcon(imgStad); btnSundsvall.setIcon(imgStad); 
		btnKiruna.setIcon(imgStad); btnVisby.setIcon(imgStad); btnFalun.setIcon(imgStad); btnLule�.setIcon(imgStad); 
		btn�stersund.setIcon(imgStad);
		lblKarta.setIcon(imgKarta);
				
		btnStockholm.setBounds(654,398,14,14);
		btnG�teborg.setBounds(515,472,14,14);		
		btnMalm�.setBounds(533,565,14,14);
		btnUppsala.setBounds(640,386,14,14);
		btnV�ster�s.setBounds(615,391,14,14);
		btn�rebro.setBounds(585,415,14,14);
		btnLink�ping.setBounds(594,449,14,14);
		btnJ�nk�ping.setBounds(565,476,14,14);	
		btnNorrk�ping.setBounds(610,442,14,14);
		btnHelsingborg.setBounds(530,546,14,14);
		btnLund.setBounds(546,556,14,14);
		btnUme�.setBounds(690,220,14,14);
		btnG�vle.setBounds(625,350,14,14);
		btnBor�s.setBounds(536,478,14,14);
		btnKalmar.setBounds(604,513,14,14);
		btnEskilstuna.setBounds(616,409,14,14);
		btnKarlstad.setBounds(549,402,14,14);
		btnHalmstad.setBounds(530,516,14,14);
		btnV�xj�.setBounds(586,501,14,14);
		btnSundsvall.setBounds(632,280,14,14);
		btnKiruna.setBounds(675,70,14,14);
		btnFalun.setBounds(597,355,14,14);
		btnLule�.setBounds(743,133,14,14);
		btn�stersund.setBounds(570,250,14,14);
		btnVisby.setBounds(664,481,14,14);
		lblKarta.setBounds(495,5,292,578);
		
		btnStockholm.setContentAreaFilled(false);
		btnG�teborg.setContentAreaFilled(false);
		btnMalm�.setContentAreaFilled(false);	
		btnUppsala.setContentAreaFilled(false);
		btnV�ster�s.setContentAreaFilled(false);
		btn�rebro.setContentAreaFilled(false);
		btnLink�ping.setContentAreaFilled(false);
		btnHelsingborg.setContentAreaFilled(false);
		btnJ�nk�ping.setContentAreaFilled(false);
		btnNorrk�ping.setContentAreaFilled(false);
		btnLund.setContentAreaFilled(false);
		btnUme�.setContentAreaFilled(false);
		btnG�vle.setContentAreaFilled(false);
		btnBor�s.setContentAreaFilled(false);
		btnKalmar.setContentAreaFilled(false);
		btnEskilstuna.setContentAreaFilled(false);
		btnKarlstad.setContentAreaFilled(false);
		btnHalmstad.setContentAreaFilled(false);
		btnV�xj�.setContentAreaFilled(false);
		btnSundsvall.setContentAreaFilled(false);
		btnKiruna.setContentAreaFilled(false);
		btnVisby.setContentAreaFilled(false);
		btnFalun.setContentAreaFilled(false);
		btnLule�.setContentAreaFilled(false);
		btn�stersund.setContentAreaFilled(false);
		btnVisby.setContentAreaFilled(false);
		
		lblKarta.setBorder(new LineBorder(Color.black));
		
		//Landkapen............................................................
		imgLandskap = new ImageIcon("Bilder/gulknapp2.png");

		btnLappland = new JButton();
		btnNorrbotten  = new JButton();
		btnV�sterbotten = new JButton();
		btnJ�mtland = new JButton();
		btn�ngermanland = new JButton();
		btnMedelpad = new JButton();
		btnH�rjedalen = new JButton();
		btnH�lsingland = new JButton();
		btnDalarna = new JButton();	
		btnG�strikland = new JButton();
		btnUppland = new JButton();
		btnV�stmanland = new JButton();
		btnV�rmland = new JButton();
		btnS�dermanland = new JButton();
		btnN�rke = new JButton(); 
		btnDalsland = new JButton();
		btn�sterg�tland = new JButton();
		btnV�sterg�tland = new JButton();
		btnBohusl�n = new JButton();
		btnSm�land = new JButton();
		btnHalland = new JButton();
		btnBlekinge = new JButton();
		btnSk�ne = new JButton();
		btnGotland = new JButton();
		btn�land = new JButton();		
		
		btnLappland.setIcon(imgLandskap);
		btnNorrbotten.setIcon(imgLandskap);
		btnV�sterbotten.setIcon(imgLandskap);	
		btnJ�mtland.setIcon(imgLandskap);	
		btn�ngermanland.setIcon(imgLandskap);
		btnMedelpad.setIcon(imgLandskap);
		btnH�rjedalen.setIcon(imgLandskap);
		btnH�lsingland.setIcon(imgLandskap);
		btnDalarna.setIcon(imgLandskap);
		btnG�strikland.setIcon(imgLandskap); 
		btnUppland.setIcon(imgLandskap);	
		btnV�stmanland.setIcon(imgLandskap);	
		btnV�rmland.setIcon(imgLandskap);	
		btnS�dermanland.setIcon(imgLandskap);
		btnN�rke.setIcon(imgLandskap);
		btnDalsland.setIcon(imgLandskap);
		btn�sterg�tland.setIcon(imgLandskap);
		btnV�sterg�tland.setIcon(imgLandskap);	
		btnBohusl�n.setIcon(imgLandskap);	
		btnSm�land.setIcon(imgLandskap);	
		btnHalland.setIcon(imgLandskap);	
		btnBlekinge.setIcon(imgLandskap);	
		btnSk�ne.setIcon(imgLandskap);	
		btnGotland.setIcon(imgLandskap);	
		btn�land.setIcon(imgLandskap);
			
		btnAvsluta.setContentAreaFilled(false);
		btnNorrbotten.setContentAreaFilled(false);
		btnV�sterbotten.setContentAreaFilled(false);
		btnJ�mtland.setContentAreaFilled(false);
		btn�ngermanland.setContentAreaFilled(false);
		btnMedelpad.setContentAreaFilled(false); 
		btnH�rjedalen.setContentAreaFilled(false);
		btnH�lsingland.setContentAreaFilled(false); 
		btnDalarna.setContentAreaFilled(false);
		btnG�strikland.setContentAreaFilled(false);
		btnUppland.setContentAreaFilled(false);
		btnV�stmanland.setContentAreaFilled(false);
		btnV�rmland.setContentAreaFilled(false);
		btnS�dermanland.setContentAreaFilled(false);
		btnN�rke.setContentAreaFilled(false);
		btnDalsland.setContentAreaFilled(false);
		btn�sterg�tland.setContentAreaFilled(false);
		btnV�sterg�tland.setContentAreaFilled(false);
		btnBohusl�n.setContentAreaFilled(false);
		btnSm�land.setContentAreaFilled(false);
		btnHalland.setContentAreaFilled(false);
		btnBlekinge.setContentAreaFilled(false);
		btnSk�ne.setContentAreaFilled(false);
		btnGotland.setContentAreaFilled(false);
		btn�land.setContentAreaFilled(false);
		
		btnLappland.setBounds(645,130,14,14);
		btnNorrbotten.setBounds(731,123,14,14);
		btnV�sterbotten.setBounds(695,200,14,14);
		btnJ�mtland.setBounds(570,230,14,14);
		btn�ngermanland.setBounds(640,235,14,14);
		btnMedelpad.setBounds(622,275,14,14);
		btnH�rjedalen.setBounds(560,290,14,14);
		btnH�lsingland.setBounds(612,310,14,14);
		btnDalarna.setBounds(577,345,14,14);
		btnG�strikland.setBounds(620,355,14,14);
		btnUppland.setBounds(647,383,14,14);
		btnV�stmanland.setBounds(600,390,14,14);
		btnV�rmland.setBounds(545,389,14,14);
		btnS�dermanland.setBounds(620,412,14,14);
		btnN�rke.setBounds(585,415,14,14);
		btnDalsland.setBounds(517,422,14,14);
		btn�sterg�tland.setBounds(593,442,14,14);
		btnV�sterg�tland.setBounds(536,458,14,14);
		btnBohusl�n.setBounds(500,442,14,14);
		btnSm�land.setBounds(586,501,14,14);
		btnHalland.setBounds(528,503,14,14);
		btnBlekinge.setBounds(586,531,14,14);
		btnSk�ne.setBounds(545,545,14,14);
		btnGotland.setBounds(660,483,14,14);
		btn�land.setBounds(616,520,14,14);	
			
		//Testsidan........................................................
		imgPratbubblaTest = new ImageIcon("Bilder/Test_bubbla.png");
		imgTopp = new ImageIcon("Bilder/toplista.png");
		imgStartaTest = new ImageIcon("images/start.png");
		
		lblfr�gaNummer = new JLabel();
		lblPratbubblaTest = new JLabel();
		btnHighscore = new JButton();	
		btnStartaTest = new JButton();
		txtHighScore = new JTextArea();
		highscore = new Highscore();			
		
		btnStartaTest.setIcon(imgStartaTest);
		btnHighscore.setIcon(imgTopp);
		lblPratbubblaTest.setIcon(imgPratbubblaTest);
		
		txtHighScore.setBorder(new LineBorder(Color.black));
		txtHighScore.setBackground(Color.white);
		txtHighScore.setEditable(false);

		lblfr�gaNummer.setBounds(22,25,250,50);
		lblPratbubblaTest.setBounds(130,65,580,363);
		btnStartaTest.setBounds(20,130,120,50);
		btnHighscore.setBounds(20,200,120,50);

		//---------------------------------------------------------------------------
		
		
		//Actionlistners
		//---------------------------------------------------------------------------
		btnHighscore.addActionListener(this);
		btn�va.addActionListener(this);
		btnTest.addActionListener(this);
		btnBak.addActionListener(this);
		btnAvsluta.addActionListener(this);
		btn�vaSt�der.addActionListener(this);
		btn�vaLandskap.addActionListener(this);
		btnStart.addActionListener(this);
		radSt�der.addActionListener(this);
		radLandskap.addActionListener(this);
		btnStartaTest.addActionListener(this);
		//st�der......................................
		btnStockholm.addActionListener(this);
		btnG�teborg.addActionListener(this);
		btnMalm�.addActionListener(this);
		btnUppsala.addActionListener(this);
		btnV�ster�s.addActionListener(this);
		btn�rebro.addActionListener(this);
		btnLink�ping.addActionListener(this);
		btnHelsingborg.addActionListener(this);
		btnJ�nk�ping.addActionListener(this);	
		btnNorrk�ping.addActionListener(this);
		btnLund.addActionListener(this);
		btnUme�.addActionListener(this);
		btnG�vle.addActionListener(this);
		btnBor�s.addActionListener(this);
		btnKalmar.addActionListener(this);
		btnEskilstuna.addActionListener(this);
		btnKarlstad.addActionListener(this);
		btnHalmstad.addActionListener(this);
		btnV�xj�.addActionListener(this);
		btnSundsvall.addActionListener(this);
		btnKiruna.addActionListener(this);
		btnVisby.addActionListener(this);
		btnFalun.addActionListener(this);
		btnLule�.addActionListener(this);
		btn�stersund.addActionListener(this);
		//landskap...................................
		btnLappland.addActionListener(this);
		btnNorrbotten.addActionListener(this);
		btnV�sterbotten.addActionListener(this);
		btnJ�mtland.addActionListener(this);
		btn�ngermanland.addActionListener(this);
		btnMedelpad.addActionListener(this);
		btnH�rjedalen.addActionListener(this);
		btnH�lsingland.addActionListener(this);
		btnDalarna.addActionListener(this);	
		btnG�strikland.addActionListener(this);
		btnUppland.addActionListener(this);
		btnV�stmanland.addActionListener(this);
		btnV�rmland.addActionListener(this);
		btnS�dermanland.addActionListener(this);
		btnN�rke.addActionListener(this);
		btnDalsland.addActionListener(this);
		btn�sterg�tland.addActionListener(this);
		btnV�sterg�tland.addActionListener(this);
		btnBohusl�n.addActionListener(this);
		btnSm�land.addActionListener(this);
		btnHalland.addActionListener(this);
		btnBlekinge.addActionListener(this);
		btnSk�ne.addActionListener(this);
		btnGotland.addActionListener(this);
		btn�land.addActionListener(this);
		//bakgrundsf�rger
		r�dF�rg.addActionListener(this);
		bl�F�rg.addActionListener(this);
		gr�nF�rg.addActionListener(this);
		gulF�rg.addActionListener(this);
		rosaF�rg.addActionListener(this);
		tr�F�rg.addActionListener(this);
		//---------------------------------------------------------------------------
		
		//S�tter in objekten i containern som fyller hela rutan.
		//---------------------------------------------------------------------------
		c.add(lblfr�gaNummer);
		c.add(lblTips);
		c.add(lblTipsText);
		c.add(lblLogo);
		c.add(lblMaskot);
		c.add(lblMaskotLiten);
		c.add(lblPratbubblaTips);
		c.add(lblPratbubblaStart);
		c.add(lblPratbubblaTest);
		c.add(lblPratbubbla�vning);
		c.add(btn�va);
		c.add(btnHighscore);
		c.add(btnTest);
		c.add(lblText);
		c.add(btn�vaLandskap);
		c.add(btn�vaSt�der);
		c.add(lbl�vaSt�der);
		c.add(lbl�vaLandskap);
		c.add(lblAvsluta);
		c.add(lblBak�t);
		c.add(btnBak);
		c.add(btnAvsluta);
		c.add(btnStart);
		c.add(radSt�der);
		c.add(radLandskap);
		c.add(lblStarttext);
		c.add(lblFr�ga);
		c.add(lblr�ttSvar);
		c.add(lblfelSvar);
		c.add(btnStartaTest);
		c.add(lblBeskrivning);
		c.add(txtHighScore);
		c.add(lblKlickade);
		c.add(lblVapen);
		//st�der...................
		c.add(btnStockholm);
		c.add(btnG�teborg);
		c.add(btnMalm�);
		c.add(btnUppsala);
		c.add(btnV�ster�s);
		c.add(btn�rebro);
		c.add(btnLink�ping);
		c.add(btnHelsingborg);
		c.add(btnJ�nk�ping);
		c.add(btnNorrk�ping);
		c.add(btnLund);
		c.add(btnUme�);
		c.add(btnG�vle);
		c.add(btnBor�s);
		c.add(btnKalmar);
		c.add(btnEskilstuna);
		c.add(btnKarlstad);
		c.add(btnHalmstad);
		c.add(btnV�xj�);
		c.add(btnSundsvall);
		c.add(btnKiruna);
		c.add(btnVisby);
		c.add(btnFalun);
		c.add(btnLule�);
		c.add(btn�stersund);
		//Landskap.................
		c.add(btnLappland);
		c.add(btnNorrbotten);
		c.add(btnV�sterbotten);
		c.add(btnJ�mtland);
		c.add(btn�ngermanland);
		c.add(btnMedelpad);
		c.add(btnH�rjedalen);
		c.add(btnH�lsingland);
		c.add(btnDalarna);
		c.add(btnG�strikland);
		c.add(btnUppland);
		c.add(btnV�stmanland);
		c.add(btnV�rmland);
		c.add(btnS�dermanland);
		c.add(btnN�rke);
		c.add(btn�sterg�tland);
		c.add(btnV�sterg�tland);
		c.add(btnBohusl�n);
		c.add(btnDalsland);
		c.add(btnSm�land);
		c.add(btnHalland);
		c.add(btnBlekinge);
		c.add(btnSk�ne);
		c.add(btnGotland);	
		c.add(btn�land);
		//......................
		c.add(lblKarta);
		c.add(lblBak);
		
		Sidan("start");					
						
		setSize(800,640);
		setResizable(false);
		setTitle("Sverigetestet v2.0");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
		//------------------------------------------------------------------------------------
		
		
	
		//Actionlisteners
		//------------------------------------------------------------------------------------
		public void actionPerformed(ActionEvent e) {
			
			//menyf�rgen..........................................
			if (e.getSource() == bl�F�rg){
				lblBak.setIcon(bakBl�);
			}
			else if (e.getSource() == r�dF�rg){
				lblBak.setIcon(bakR�d);
			}
			else if (e.getSource() == gr�nF�rg){
				lblBak.setIcon(bakGr�n);
			}
			else if (e.getSource() == gulF�rg){
				lblBak.setIcon(bakGul);
			}
			else if (e.getSource() == rosaF�rg){
				lblBak.setIcon(bakRosa);
			}
			else if (e.getSource() == tr�F�rg){
				lblBak.setIcon(bakTr�);	
			}
				
			//knapparna...........................................
			else if (e.getSource() == btn�va) {
				Sidan("�va");
			}
			else if (e.getSource() == btn�vaSt�der) {
				radSt�der.setSelected(true);
			}
			else if (e.getSource() == btn�vaLandskap) {
				radLandskap.setSelected(true);
			}
			else if (e.getSource() == btnStart) {
				if (radSt�der.isSelected() == true) {
						Sidan("�vaSt�der");
						startPos = 26;
						slumpaVektor();		
						nyttObjekt();
				}
				else if (radLandskap.isSelected() == true) {
						Sidan("�vaLandskap");
						startPos = 1;
						slumpaVektor();		
						nyttObjekt();
				}
			}
			else if (e.getSource() == btnTest) {
				Sidan("testsidan");
			}	
			else if (e.getSource() == btnStartaTest){
				Sidan("testet");
				slumpaVektor();		
				nyttObjekt();
				antalPo�ng = 0;
				fr�gaNummer = 1;
			}
			else if (e.getSource() == btnBak) {
				if (aktuellSida == "�va"){
					Sidan("start");
				}
				else if ((aktuellSida == "�vaSt�der") || (aktuellSida == "�vaLandskap")) {
					Sidan("�va");
				}
				else if (aktuellSida == "testsidan"){
					Sidan("start");
				}
			}
			else if ((e.getSource() == btnAvsluta) && (aktuellSida != "testet")) {
				aktuellSida = "start";
				Sidan("start");			
			}
			else if ((e.getSource() == btnAvsluta) && (aktuellSida == "testet")) {
				int i = JOptionPane.showConfirmDialog(this, "Vill du verkligen avsluta testet?", "Avsluta", JOptionPane.YES_NO_OPTION);
				if (i == 0){
					aktuellSida = "start";
					Sidan("start");	
				}
			}
			else if (e.getSource() == btnHighscore){
				highscore.readList();
				topplista = new JOptionPane (highscore.getList(), JOptionPane.INFORMATION_MESSAGE);
				d1 = topplista.createDialog(this, "Topplista");		
				d1.setModal(false);
				d1.setVisible(true);
			}
			//Lanskapen..................................................
			else if	(e.getSource() == btnLappland) {
				lblKlickade.setText("Du klickade p� Lappland");	
				var = 1;
				check();	
			}
			else if	(e.getSource() == btnNorrbotten) {
				lblKlickade.setText("Du klickade p� Norrbotten");
				var = 2;
				check();		
			}
			else if	(e.getSource() == btnV�sterbotten) {
				lblKlickade.setText("Du klickade p� V�sterbotten");	
				var = 3;
				check();	
			}
			else if	(e.getSource() == btnJ�mtland) {
				lblKlickade.setText("Du klickade p� J�mtland");	
				var = 4;
				check();	
			}
			else if	(e.getSource() == btn�ngermanland) {
				lblKlickade.setText("Du klickade p� �ngermanland");	
				var = 5;
				check();	
			}
			else if	(e.getSource() == btnMedelpad) {
				lblKlickade.setText("Du klickade p� Medelpad");	
				var = 6;
				check();	
			}
			else if	(e.getSource() == btnH�rjedalen) {
				lblKlickade.setText("Du klickade p� H�rjedalen");
				var = 7;
				check();		
			}
			else if	(e.getSource() == btnH�lsingland) {
				lblKlickade.setText("Du klickade p� H�lsingland");
				var = 8;
				check();		
			}
			else if	(e.getSource() == btnDalarna) {
				lblKlickade.setText("Du klickade p� Dalarna");	
				var = 9;
				check();	
			}
			
			else if	(e.getSource() == btnG�strikland) {
				lblKlickade.setText("Du klickade p� G�strikland");
				var = 10;
				check();		
			}
			else if	(e.getSource() == btnUppland) {
				lblKlickade.setText("Du klickade p� Uppland");	
				var = 11;
				check();	
			}
			else if	(e.getSource() == btnV�stmanland) {
				lblKlickade.setText("Du klickade p� V�stmanland");
				var = 12;
				check();		
			}
			else if	(e.getSource() == btnV�rmland) {
				lblKlickade.setText("Du klickade p� V�rmland");	
				var = 13;
				check();	
			}
			else if	(e.getSource() == btnS�dermanland) {
				lblKlickade.setText("Du klickade p� S�dermanland");
				var = 14;
				check();		
			}
			else if	(e.getSource() == btnN�rke) {
				lblKlickade.setText("Du klickade p� N�rke");	
				var = 15;
				check();	
			}
			else if	(e.getSource() == btnDalsland) {
				lblKlickade.setText("Du klickade p� Dalsland");
				var = 16;
				check();		
			}
			else if	(e.getSource() == btn�sterg�tland) {
				lblKlickade.setText("Du klickade p� �sterg�tland");	
				var = 17;
				check();	
			}
			else if	(e.getSource() == btnV�sterg�tland) {
				lblKlickade.setText("Du klickade p� V�sterg�tland");	
				var = 18;
				check();	
			}
			else if	(e.getSource() == btnBohusl�n) {
				lblKlickade.setText("du klickade p� Bohusl�n");	
				var = 19;
				check();	
			}
			else if	(e.getSource() == btnSm�land) {
				lblKlickade.setText("du klickade p� Sm�land");
				var = 20;
				check();		
			}
			else if	(e.getSource() == btnHalland) {
				lblKlickade.setText("du klickade p� Halland");
				var = 21;
				check();		
			}
			else if	(e.getSource() == btnBlekinge) {
				lblKlickade.setText("du klickade p� Blekinge");	
				var = 22;
				check();	
			}
			else if	(e.getSource() == btnSk�ne) {
				lblKlickade.setText("du klickade p� Sk�ne");	
					var = 23;
				check();	
			}
			else if	(e.getSource() == btnGotland) {
				lblKlickade.setText("du klickade p� Gotland");
				var = 24;
				check();		
			}
			else if	(e.getSource() == btn�land) {
				lblKlickade.setText("du klickade p� �land");	
					var = 25;
				check();	
			}
			
			//st�derna..................................................
			else if	(e.getSource() == btnStockholm) {
				lblKlickade.setText("Du klickade p� Stockholm");
				var = 26;
				check();		
			}
			else if	(e.getSource() == btnG�teborg) {
				lblKlickade.setText("Du klickade p� G�teborg");
				var = 27;
				check();		
			}
			else if	(e.getSource() == btnMalm�) {
				lblKlickade.setText("Du klickade p� Malm�");	
					var = 28;
				check();	
			}
			else if	(e.getSource() == btnUppsala) {
				lblKlickade.setText("Du klickade p� Uppsala");
				var = 29;
				check();		
			}
			else if	(e.getSource() == btnV�ster�s) {
				lblKlickade.setText("Du klickade p� V�ster�s");	
					var = 30;
				check();	
			}
			else if	(e.getSource() == btn�rebro) {
				lblKlickade.setText("Du klickade p� �rebro");
				var = 31;
				check();		
			}
			else if	(e.getSource() == btnLink�ping) {
				lblKlickade.setText("Du klickade p� Link�ping");	
					var = 32;
				check();	
			}
			else if	(e.getSource() == btnHelsingborg) {
				lblKlickade.setText("Du klickade p� Helsingborg");
				var = 33;
				check();		
			}
			else if	(e.getSource() == btnJ�nk�ping) {
				lblKlickade.setText("Du klickade p� J�nk�ping");	
					var = 34;
				check();	
			}
			else if	(e.getSource() == btnNorrk�ping) {
				lblKlickade.setText("Du klickade p� Norrk�ping");
				var = 35;
				check();		
			}
			else if	(e.getSource() == btnLund) {
				lblKlickade.setText("Du klickade p� Lund");
				var = 36;
				check();		
			}
			else if	(e.getSource() == btnUme�) {
				lblKlickade.setText("Du klickade p� Ume�");	
				var = 37;
				check();	
			}
			else if	(e.getSource() == btnG�vle) {
				lblKlickade.setText("Du klickade p� G�vle");	
				var = 38;
				check();	
			}
			else if	(e.getSource() == btnBor�s) {
				lblKlickade.setText("Du klickade p� Bor�s");	
				var = 39;
				check();	
			}
			else if	(e.getSource() == btnKalmar) {
				lblKlickade.setText("Du klickade p� Kalmar");
				var = 40;
				check();		
			}
			else if	(e.getSource() == btnEskilstuna) {
				lblKlickade.setText("Du klickade p� Eskilstuna");
				var = 41;
				check();		
			}
			else if	(e.getSource() == btnKarlstad) {
				lblKlickade.setText("Du klickade p� Karlstad");
				var = 42;
				check();		
			}
			else if	(e.getSource() == btnHalmstad) {
				lblKlickade.setText("Du klickade p� Halmstad");	
					var = 43;
				check();	
			}
			else if	(e.getSource() == btnV�xj�) {
				lblKlickade.setText("Du klickade p� V�xj�");	
				var = 44;
				check();	
			}
			else if	(e.getSource() == btnSundsvall) {
				lblKlickade.setText("Du klickade p� Sundsvall");	
				var = 45;
				check();	
			}
			else if	(e.getSource() == btnKiruna) {
				lblKlickade.setText("Du klickade p� Kiruna");
				var = 46;
				check();		
			}
			else if	(e.getSource() == btnVisby) {
				lblKlickade.setText("Du klickade p� Visby");		
				var = 47;
				check();
			}
			else if	(e.getSource() == btnFalun) {
				lblKlickade.setText("Du klickade p� Falun");	
				var = 48;
				check();	
			}
			else if	(e.getSource() == btnLule�) {
				lblKlickade.setText("Du klickade p� Lule�");	
				var = 49;
				check();	
			}
			else if	(e.getSource() == btn�stersund) {
				lblKlickade.setText("Du klickade p� �stersund");	
				var = 50;
				check();	
			}
			else if (e.getSource() == timer){
				klickbara = true;
				if ((aktuellSida == "�vaSt�der") || (aktuellSida == "�vaLandskap")){
					lblr�ttSvar.setVisible(false);
					lblfelSvar.setVisible(false);
					lblKlickade.setVisible(false);
					if (posvektor == 25){
						posvektor = 0;
						slumpaVektor();
						nyttObjekt();	
					}
					else{					
					nyttObjekt();
					}
				}
				else if (aktuellSida == "testet"){
					lblr�ttSvar.setVisible(false);
					lblfelSvar.setVisible(false);
					lblKlickade.setVisible(false);
				
					if (posvektor == 25){
						if(highscore.getInList(antalPo�ng)){
							String namn = JOptionPane.showInputDialog(this,"Grattis du fick " + antalPo�ng + " po�ng, s� du kom in p� topplistan! \nSkriv in ditt namn: ");
							highscore.insList(namn, antalPo�ng);
							highscore.saveList();
							Sidan("testsidan");
						}
						else{
							JOptionPane.showMessageDialog(this,"Tack f�r att du gjorde testet! \nDu fick " + antalPo�ng + " po�ng, s� du kom tyv�rr inte in p� topplistan, men f�rs�k g�rna igen. ");
						Sidan("testsidan");	
						}
					}
					else{
						nyttObjekt();
					}
				}
			}
		}
		//---------------------------------------------------------------------------
		
		
		
		//Metoder
		//---------------------------------------------------------------------------
		//S�tter allt till osynligt
		public void Osynligt() {
			lblTips.setVisible(false);
			lblMaskotLiten.setVisible(false);
			lblPratbubblaTips.setVisible(false);
			lblTipsText.setVisible(false);
			lblfr�gaNummer.setVisible(false);
			lblMaskot.setVisible(false);
			lblPratbubblaStart.setVisible(false);
			lblPratbubblaTest.setVisible(false);
			lblPratbubbla�vning.setVisible(false);
			lblVapen.setVisible(false);
			lblText.setVisible(false);
			lblStarttext.setVisible(false);
			lblLogo.setVisible(false);
			btnHighscore.setVisible(false);
			btn�va.setVisible(false);
			btnTest.setVisible(false);
			btn�vaSt�der.setVisible(false);
			btn�vaLandskap.setVisible(false);
			lbl�vaSt�der.setVisible(false);
			lbl�vaLandskap.setVisible(false);
			lblAvsluta.setVisible(false);
			lblBak�t.setVisible(false);
			btnBak.setVisible(false);
			btnAvsluta.setVisible(false);
			btnStart.setVisible(false);
			radSt�der.setVisible(false);
			radLandskap.setVisible(false);
			lblKarta.setVisible(false);
			lblFr�ga.setVisible(false);
			lblKlickade.setVisible(false);
			lblr�ttSvar.setVisible(false);
			lblfelSvar.setVisible(false);
			btnStartaTest.setVisible(false);
			lblBeskrivning.setVisible(false);
			txtHighScore.setVisible(false);
			SynligaSt�der(false);
			SynligaLandskap(false);
		}
		
		//S�tter r�tt vapen...........................................
		public void setVapen(int a)
		{
			lblVapen.setVisible(true);
			if (a == 1){
				lblVapen.setIcon(vapenLappland);
			}
			else if (a == 2){
				lblVapen.setIcon(vapenNorrbotten);
			}
			else if (a == 3){
				lblVapen.setIcon(vapenV�sterbotten);
			}
			else if (a == 4){
				lblVapen.setIcon(vapenJ�mtland);
			}
			else if (a == 5){
				lblVapen.setIcon(vapen�ngermanland);
			}
			else if (a == 6){
				lblVapen.setIcon(vapenMedelpad);
			}
			else if (a == 7){
				lblVapen.setIcon(vapenH�rjedalen);
			}
			else if (a == 8){
				lblVapen.setIcon(vapenH�lsingland);
			}
			else if (a == 9){
				lblVapen.setIcon(vapenDalarna);
			}
			else if (a == 10){
				lblVapen.setIcon(vapenG�strikland);
			}
			else if (a == 11){
				lblVapen.setIcon(vapenUppland);
			}
			else if (a == 12){
				lblVapen.setIcon(vapenV�stmanland);
			}
			else if (a == 13){
				lblVapen.setIcon(vapenV�rmland);
			}
			else if (a == 14){
				lblVapen.setIcon(vapenS�dermanland);
			}
			else if (a == 15){
				lblVapen.setIcon(vapenN�rke);
			}
			else if (a == 16){
				lblVapen.setIcon(vapenDalsland);
			}
			else if (a == 17){
				lblVapen.setIcon(vapen�sterg�tland);
			}
			else if (a == 18){
				lblVapen.setIcon(vapenV�sterg�tland);
			}
			else if (a == 19){
				lblVapen.setIcon(vapenBohusl�n);
			}
			else if (a == 20){
				lblVapen.setIcon(vapenSm�land);
			}
			else if (a == 21){
				lblVapen.setIcon(vapenHalland);
			}
			else if (a == 22){
				lblVapen.setIcon(vapenBlekinge);
			}
			else if (a == 23){
				lblVapen.setIcon(vapenSk�ne);
			}
			else if (a == 24){
				lblVapen.setIcon(vapenGotland);
			}
			else if (a == 25){
				lblVapen.setIcon(vapen�land);
			}
			else if (a > 25){
				lblVapen.setVisible(false);
			}		 
		}
		
		//............................................................
		//S�tter alla st�der till synligt eller osynligt
		public void SynligaSt�der(boolean visible) {
			boolean v = visible;
			if (v == true) {
				btnStockholm.setVisible(true);
				btnG�teborg.setVisible(true);
				btnMalm�.setVisible(true);
				btnUppsala.setVisible(true);
				btnV�ster�s.setVisible(true);
				btn�rebro.setVisible(true);
				btnLink�ping.setVisible(true);
				btnHelsingborg.setVisible(true);
				btnJ�nk�ping.setVisible(true);	
				btnNorrk�ping.setVisible(true);
				btnLund.setVisible(true);
				btnUme�.setVisible(true);
				btnG�vle.setVisible(true);
				btnBor�s.setVisible(true);
				btnKalmar.setVisible(true);
				btnEskilstuna.setVisible(true);
				btnKarlstad.setVisible(true);
				btnHalmstad.setVisible(true);
				btnV�xj�.setVisible(true);
				btnSundsvall.setVisible(true);
				btnKiruna.setVisible(true);
				btnVisby.setVisible(true);
				btnFalun.setVisible(true);
				btnLule�.setVisible(true);
				btn�stersund.setVisible(true);
			}
			else if (v == false) {
				btnStockholm.setVisible(false);
				btnG�teborg.setVisible(false);
				btnMalm�.setVisible(false);
				btnUppsala.setVisible(false);
				btnV�ster�s.setVisible(false);
				btn�rebro.setVisible(false);
				btnLink�ping.setVisible(false);
				btnHelsingborg.setVisible(false);
				btnJ�nk�ping.setVisible(false);	
				btnNorrk�ping.setVisible(false);
				btnLund.setVisible(false);
				btnUme�.setVisible(false);
				btnG�vle.setVisible(false);
				btnBor�s.setVisible(false);
				btnKalmar.setVisible(false);
				btnEskilstuna.setVisible(false);
				btnKarlstad.setVisible(false);
				btnHalmstad.setVisible(false);
				btnV�xj�.setVisible(false);
				btnSundsvall.setVisible(false);
				btnKiruna.setVisible(false);
				btnVisby.setVisible(false);
				btnFalun.setVisible(false);
				btnLule�.setVisible(false);
				btn�stersund.setVisible(false);
			}
		}
		
		//............................................................
		//S�tter alla landskap till synligt eller osynligt
		public void SynligaLandskap(boolean visible) {
			boolean v = visible;
			if (v == true) {
				btnLappland.setVisible(true);
				btnNorrbotten.setVisible(true);
				btnV�sterbotten.setVisible(true);
				btnJ�mtland.setVisible(true);
				btn�ngermanland.setVisible(true);
				btnMedelpad.setVisible(true);
				btnH�rjedalen.setVisible(true);
				btnH�lsingland.setVisible(true);
				btnDalarna.setVisible(true);	
				btnG�strikland.setVisible(true);
				btnUppland.setVisible(true);
				btnV�stmanland.setVisible(true);;
				btnV�rmland.setVisible(true);
				btnS�dermanland.setVisible(true);
				btnN�rke.setVisible(true);
				btnDalsland.setVisible(true);
				btn�sterg�tland.setVisible(true);
				btnV�sterg�tland.setVisible(true);
				btnBohusl�n.setVisible(true);
				btnSm�land.setVisible(true);;
				btnHalland.setVisible(true);
				btnBlekinge.setVisible(true);
				btnSk�ne.setVisible(true);
				btnGotland.setVisible(true);
				btn�land.setVisible(true);
			}
			else if (v == false) {
				btnLappland.setVisible(false);
				btnNorrbotten.setVisible(false);
				btnV�sterbotten.setVisible(false);
				btnJ�mtland.setVisible(false);
				btn�ngermanland.setVisible(false);
				btnMedelpad.setVisible(false);
				btnH�rjedalen.setVisible(false);
				btnH�lsingland.setVisible(false);
				btnDalarna.setVisible(false);	
				btnG�strikland.setVisible(false);
				btnUppland.setVisible(false);
				btnV�stmanland.setVisible(false);;
				btnV�rmland.setVisible(false);
				btnS�dermanland.setVisible(false);
				btnN�rke.setVisible(false);
				btnDalsland.setVisible(false);
				btn�sterg�tland.setVisible(false);
				btnV�sterg�tland.setVisible(false);
				btnBohusl�n.setVisible(false);
				btnSm�land.setVisible(false);;
				btnHalland.setVisible(false);
				btnBlekinge.setVisible(false);
				btnSk�ne.setVisible(false);
				btnGotland.setVisible(false);
				btn�land.setVisible(false);
			}
		}
		//............................................................
		//Slumpar en vektor som �r 25 tal stor med olika tal i.
		public void slumpaVektor() {
			vektorSlump.clear();
	
			if (aktuellSida == "testet"){
				while (vektorSlump.size()<25) {
					int slump = (int)(1 + Math.random() * 50);
					if (!vektorSlump.contains(slump)){
						vektorSlump.add(slump);
					}
				}	
			}
			else if (aktuellSida != "testet"){
				while (vektorSlump.size()<25) {
					int slump = (int)(startPos + Math.random() * 25);
					if (!vektorSlump.contains(slump)){
						vektorSlump.add(slump);
					}
				}	
			}
		}
		//Ger tips om man har fem fel i rad p� en stad/landskap
		//............................................................
		public void tips(){
			
			if (obj.getNummer() == 1){
				lblTips.setText("Lappland ligger i norra Sverige.");
			}
			else if (obj.getNummer() == 2){
				lblTips.setText("Norrbotten ligger i norra Sverige,\n bredvid Lappland.");
			}
			else if (obj.getNummer() == 3){
				lblTips.setText("V�sterbotten ligger i norra Sverige,\n bredvid lappland.");
			}
			else if (obj.getNummer() == 4){
				lblTips.setText("J�mtland ligger v�ster om �ngermanland \n och norr om h�rjedalen.");
			}
			else if (obj.getNummer() == 5){
				lblTips.setText("�ngermanland ligger s�der om \n lappland  och �ster om j�mtland.");
			}
			else if (obj.getNummer() == 6){
				lblTips.setText("Medelpad ligger s�der om �ngermanland \n och norr om h�lsingland.");
			}
			else if (obj.getNummer() == 7){
				lblTips.setText("H�rjedalen ligger s�der om j�mtland \n och v�ster om h�lsingland.");
			}
			else if (obj.getNummer() == 8){
				lblTips.setText("H�lsingland gr�nsar till dalarna.");
			}
			else if (obj.getNummer() == 9){
				lblTips.setText("Dalarna gr�nsar till v�rmland.");
			}
			else if (obj.getNummer() == 10){
				lblTips.setText("G�strikland ligger p� �stkusten.");
			}
			else if (obj.getNummer() == 11){
				lblTips.setText("Uppland gr�nsar till v�stmanland.");
			}
			else if (obj.getNummer() == 12){
				lblTips.setText("V�stmanland ligger v�ster om uppland \n och s�der om dalarna.");
				
			}else if (obj.getNummer() == 13){
				lblTips.setText("V�rmland ligger s�der om dalarna \n och v�ster om n�rke.");
			}
			else if (obj.getNummer() == 14)	{
				lblTips.setText("S�dermanland gr�nsar till uppland.");
			}
			else if (obj.getNummer() == 15){
				lblTips.setText("N�rke ligger mellan v�rmland \n och s�dermanland.");
			}
			else if (obj.getNummer() == 16){
				lblTips.setText("Dalsland ligger norr om Bohusl�n \n p� V�stkusten.");
			}
			else if (obj.getNummer() == 17){
				lblTips.setText("�sterg�tland ligger s�der om \n s�dermanland p� �stkusten.");
			}
			else if (obj.getNummer() == 18){
				lblTips.setText("V�sterg�tland gr�nsar till sm�land.");
			}
			else if (obj.getNummer() == 19){
				lblTips.setText("Bohusl�n ligger p� v�stkusten.");	
			}
			else if (obj.getNummer() == 20){
				lblTips.setText("Sm�land ligger i s�dra Sverige.");
			}
			else if (obj.getNummer() == 21){
				lblTips.setText("Halland ligger v�ster om sm�land \n och norr om sk�ne.");	
			}
			else if (obj.getNummer() == 22){
				lblTips.setText("Blekinge ligger i s�dra Sverige.");
			}
			else if (obj.getNummer() == 23){
				lblTips.setText("Sk�ne ligger l�ngt S�derut.");
			}
			else if (obj.getNummer() == 24){
				lblTips.setText("Gotland �r en �.");
			}
			else if (obj.getNummer() == 25){
				lblTips.setText("�land ligger sydv�st om gotland.");
			}
			else if (obj.getNummer() == 26){
				lblTips.setText("Stockholm ligger p� �stkusten.");
			}
			else if (obj.getNummer() == 27){
				lblTips.setText("G�teborg ligger i halland.");
			}
			else if (obj.getNummer() == 28){
				lblTips.setText("Malm� ligger i s�dra Sverige.");
			}
			else if (obj.getNummer() == 29){
				lblTips.setText("Uppsala ligger nordv�st om Stockholm.");
			}
			else if (obj.getNummer() == 30){
				lblTips.setText("V�ster�s ligger v�ster om Stockholm.");
			}
			else if (obj.getNummer() == 31){
				lblTips.setText("�rebro ligger v�ster om Stockholm.");
			}
			else if (obj.getNummer() == 32){
				lblTips.setText("Link�ping ligger s�der om Norrk�ping.");
			}
			else if (obj.getNummer() == 33){
				lblTips.setText("Helsingborg ligger i s�dra\n Sverige p� v�stkusten.");
			}
			else if (obj.getNummer() == 34){
				lblTips.setText("J�nk�ping i sm�land.");
			}
			else if (obj.getNummer() == 35){
				lblTips.setText("Norrk�ping ligger i �sterg�tland.");
			}
			else if (obj.getNummer() == 36){
				lblTips.setText("Lund ligger i sk�ne.");
			}
			else if (obj.getNummer() == 37){
				lblTips.setText("Ume� ligger i v�sterbotten.");
			}
			else if (obj.getNummer() == 38){
				lblTips.setText("G�vle ligger i g�strikland.");
			}
			else if (obj.getNummer() == 39){
				lblTips.setText("Bor�s ligger V�sterg�tland.");
			}
			else if (obj.getNummer() == 40){
				lblTips.setText("Kalmar ligger i s�dra\n sverige p� �stkusten.");
			}
			else if (obj.getNummer() == 41){
				lblTips.setText("Eskilstuna ligger v�ster om Stockholm.");
			}
			else if (obj.getNummer() == 42){
				lblTips.setText("Karlstad ligger norr om v�nern.");
			}
			else if (obj.getNummer() == 43){
				lblTips.setText("Halmstad ligger i halland.");
			}
			else if (obj.getNummer() == 44){
				lblTips.setText("V�xj� ligger i sm�land.");
			}
			else if (obj.getNummer() == 45){
				lblTips.setText("Sundsvall ligger norr om G�vle.");
			}
			else if (obj.getNummer() == 46){
				lblTips.setText("Kiruna ligger i Lappland.");
			}
			else if (obj.getNummer() == 47){
				lblTips.setText("Visby ligger p� en �.");
			}
			else if (obj.getNummer() == 48){
				lblTips.setText("Falun ligger v�ster om G�vle.");
			}
			else if (obj.getNummer() == 49){
				lblTips.setText("Lule� ligger norr om Ume�.");
			}
			else if (obj.getNummer() == 50){
				lblTips.setText("�stersund ligger i J�mtland.");
			}
		}
		
		//............................................................
		//L�ser den f�rsta positionen i vektorn och h�mtar det objektet
		public void nyttObjekt() {
			
			try	{	
			Scanner infil = new Scanner(new File("Sverige.txt"));					
				while (infil.hasNext())	{
					obj = new SverigeObjekt(infil);
						if (vektorSlump.get(posvektor) == (obj.getNummer())) {
							setVapen(obj.getNummer());
							lblFr�ga.setText("Tryck p� " + obj.getNamn());
								break;
						}					
				}
			infil.close();
			}
			catch (FileNotFoundException a)	{
				System.out.println("Hittade ej filen");
			}
			
			if (vektorSlump.get(posvektor) > 0 && vektorSlump.get(posvektor) < 26){
				SynligaSt�der(false);
				SynligaLandskap(true);	
			}
			else if (vektorSlump.get(posvektor) > 25 && vektorSlump.get(posvektor) < 51){
				SynligaSt�der(true);
				SynligaLandskap(false);	
			}
			if (aktuellSida == "testet")
				lblfr�gaNummer.setText("Fr�ga nummer " + fr�gaNummer + " av 25");
		}
		
		//............................................................
		//Kollar om man svarade r�tt eller fel.
		public void check(){
			if (klickbara == true){
						
				if ((aktuellSida == "�vaSt�der") || (aktuellSida == "�vaLandskap")){
					
					lblKlickade.setVisible(true);
/*					System.out.println("----------------");
					System.out.println("posvektor: " + posvektor);
					System.out.println("Stadsnummer: " + var);
					System.out.println("Slumptal :" + vektorSlump.get(posvektor));
*/					
					if (vektorSlump.get(posvektor) == var){
						lblr�ttSvar.setVisible(true);
						lblfelSvar.setVisible(false);
						posvektor++;
						antalFel = 0;
						lblTips.setVisible(false);
						//lblMaskotLiten.setVisible(false);
						lblPratbubblaTips.setVisible(false);
						lblTipsText.setVisible(false);
						
					}
					else{
						lblr�ttSvar.setVisible(false);
						lblfelSvar.setVisible(true);
							antalFel++;
						if(antalFel==5){
							lblTips.setVisible(true);
							lblMaskotLiten.setVisible(true);
							lblPratbubblaTips.setVisible(true);
							lblTipsText.setVisible(true);
							tips();
							System.out.println("Du har 5 fel!!!!");
						}
					}
				}
				else if (aktuellSida == "testet"){
					if (vektorSlump.get(posvektor) == var){
						lblr�ttSvar.setVisible(true);
						lblfelSvar.setVisible(false);
						antalPo�ng++;
					}
					else{
						lblr�ttSvar.setVisible(false);
						lblfelSvar.setVisible(true);
					}
				fr�gaNummer++;
				posvektor++;
				}
			klickbara = false;	
			timer.setRepeats(false);
			timer.start();
			}
		}
	
		//............................................................
		//Sidhanteringsmetoden Sidan
		public void Sidan(String s) {
			aktuellSida = s;
			 
			if (aktuellSida == "start") {
				Osynligt();
				lblMaskot.setVisible(true);
				lblPratbubblaStart.setVisible(true);
				lblStarttext.setVisible(true);
				lblLogo.setVisible(true);
				btn�va.setVisible(true);
				btnTest.setVisible(true);
			}
			else if (aktuellSida == "�va") {
				
				antalFel=0;
			 	lblText.setText("V�lj ett alternativ och klicka p� startknappen.");
			 	Osynligt();
			 	lblAvsluta.setVisible(true);
			 	lblBak�t.setVisible(true);
			 	lblMaskot.setVisible(true);
			 	lblPratbubbla�vning.setVisible(true);
			 	lblText.setVisible(true);
				btn�vaSt�der.setVisible(true);
				btn�vaLandskap.setVisible(true);
				lbl�vaSt�der.setVisible(true);
				lbl�vaLandskap.setVisible(true);
				btnBak.setVisible(true);
				btnAvsluta.setVisible(true);
				btnStart.setVisible(true);
				radSt�der.setVisible(true);
				radLandskap.setVisible(true);
				posvektor=0;
			}
			 else if (aktuellSida == "�vaSt�der") {
			 	lblText.setText("H�r �var du p� st�der.");
			 	Osynligt();
			 	lblMaskotLiten.setVisible(true);
			 	lblBak�t.setVisible(true);
				lblAvsluta.setVisible(true);
			 	lblText.setVisible(true);
			 	lblFr�ga.setVisible(true);
			 	lblKlickade.setVisible(false);
				btnBak.setVisible(true);
				btnAvsluta.setVisible(true);
				lblKarta.setVisible(true);
				lblFr�ga.setVisible(true);
				SynligaSt�der(true);	
			}
			else if (aktuellSida == "�vaLandskap") {
			 	lblText.setText("H�r �var du p� landskap.");
			 	Osynligt();
			 	lblMaskotLiten.setVisible(true);
			 	lblBak�t.setVisible(true);
				lblAvsluta.setVisible(true);
			 	lblText.setVisible(true);
			 	lblFr�ga.setVisible(true);
			 	lblKlickade.setVisible(false);
				btnBak.setVisible(true);
				btnAvsluta.setVisible(true);
				lblKarta.setVisible(true);
				lblFr�ga.setVisible(true);
				SynligaLandskap(true);	
			}	
			else if (aktuellSida == "testsidan"){
				txtHighScore.setText(highscore.getList());
				lblText.setText("Klicka p� knappen f�r att starta testet.");
			 	Osynligt();
			 	lblBak�t.setVisible(true);
				lblAvsluta.setVisible(true);
			 	lblMaskot.setVisible(true);
			 	lblPratbubblaTest.setVisible(true);
			 	btnHighscore.setVisible(true);
			 	btnBak.setVisible(true);
				btnAvsluta.setVisible(true);
				btnStartaTest.setVisible(true);
				txtHighScore.setVisible(true);
				posvektor=0;
				fr�gaNummer =1;
			}
			else if (aktuellSida == "testet"){
			 	lblText.setText("Testet:");
			 	Osynligt();
			 	lblfr�gaNummer.setVisible(true);
				lblAvsluta.setVisible(true);
				lblBeskrivning.setVisible(true);
				btnAvsluta.setVisible(true);
				lblKarta.setVisible(true);
				lblFr�ga.setVisible(true);
				lblText.setVisible(true);
			}

		}
	//--------------------------------------------------------------------------
	public static void main(String[] args) {
		GUI gui = new GUI();
	}
}
