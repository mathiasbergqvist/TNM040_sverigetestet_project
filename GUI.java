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
	private JLabel lblStarttext ,lblText, lblÖva, lblLogo, lblKarta, lblFråga, lblrättSvar, lblfelSvar, lblKlickade, lblBeskrivning, lblÖvaStäder, lblÖvaLandskap, lblMaskot, lblMaskotLiten, lblPratbubblaStart, lblPratbubblaTest, lblPratbubblaÖvning, lblPratbubblaTips;
	private JLabel lblVapen, lblBak,lblBakåt, lblAvsluta, lblfrågaNummer, lblTipsText;
	private JTextArea lblTips;
	private JRadioButton radStäder, radLandskap;
	private ImageIcon imgLogo, imgÖva, imgTest, imgBak, imgAvsluta, imgÖvaStäder, imgÖvaLandskap, imgStart, imgKarta, imgStad, imgLandskap, imgRätt,
					  imgFel, imgStartaTest, imgBeskrivning, imgTomBild, imgMaskot, imgPratbubblaStart, imgPratbubblaTest, imgPratbubblaÖvning, imgMaskotLiten, imgPratbubblaTips;
	private ImageIcon bakBlå, bakRöd, bakGul, bakGrön, bakRosa, bakTrä, imgTopp;
	private ImageIcon vapenBlekinge, vapenBohuslän, vapenDalarna, vapenDalsland, vapenGotland, vapenGästrikland, vapenHalland, vapenHälsingland,
					  vapenHärjedalen, vapenJämtland, vapenLappland, vapenMedelpad, vapenNorrbotten, vapenNärke, vapenSkåne, vapenSmåland, vapenSödermanland,
					  vapenUppland, vapenVärmland, vapenVästerbotten, vapenVästergötland, vapenVästmanland, vapenÅngermanland, vapenÖland, vapenÖstergötland;
	private JButton btnÖva, btnTest, btnÖvaStäder, btnÖvaLandskap, btnBak, btnAvsluta, btnStart, btnStartaTest, btnHighscore;
	private JButton btnStockholm, btnGöteborg, btnMalmö, btnUppsala, btnVästerås, btnÖrebro, btnLinköping, btnHelsingborg, btnJönköping,
					btnNorrköping, btnLund, btnUmeå, btnGävle, btnBorås, btnKalmar, btnEskilstuna, btnKarlstad, btnHalmstad, btnVäxjö, btnSundsvall,
					btnKiruna, btnVisby, btnFalun, btnLuleå, btnÖstersund;
	
	private JButton btnLappland, btnNorrbotten, btnVästerbotten, btnJämtland, btnÅngermanland,btnMedelpad, btnHärjedalen, btnHälsingland, btnDalarna,
					btnGästrikland,btnUppland, btnVästmanland, btnVärmland, btnSödermanland, btnNärke, btnDalsland, btnÖstergötland, btnVästergötland, 
					btnBohuslän, btnSmåland, btnHalland, btnBlekinge, btnSkåne, btnGotland, btnÖland;
	
	private ImageIcon bak;
	private JMenuBar menuBar;
	private JMenu färgMeny;
	private JMenuItem rödFärg, blåFärg, grönFärg, gulFärg, rosaFärg, träFärg;
	
	private Vector<Integer> vektorSlump = new Vector<Integer>();
	private	SverigeObjekt obj;
	private Highscore highscore;
	private javax.swing.Timer timer;
	private int var, antalPoäng=0, frågaNummer=1, antalFel=0;
	private int posvektor = 0, startPos = 0;
	private Boolean klickbara = true;
	private String aktuellSida, aktuellStad;
	private JOptionPane topplista;
	private JDialog d1;
	
	//--------------------------------------------------------------------------------------------------------------------------------------------
	public GUI() {
		
		//Sätter layout manager till null så att man kan sätta ut komponenter var man vill	
		Container c = getContentPane();
		c.setLayout(null);
		
		//--------------------------------------------------------------------------------------------		
		//Objekt sorterade i den ordning de visas på de olika sidorna
		//Menyraden
		
		bakBlå = new ImageIcon("Bilder/bakgrund_ver2.png");
		bakRöd = new ImageIcon("Bilder/röd_bak.png");
		bakGul = new ImageIcon("Bilder/gul_bak.png");
		bakGrön = new ImageIcon("Bilder/grön_bak.png");
		bakRosa = new ImageIcon("Bilder/rosa_bak.png");
		bakTrä = new ImageIcon("Bilder/bakgrund_trä.png");
		
		lblBak = new JLabel();
		lblBak.setBounds(0,0,800,600);
		lblBak.setIcon(bakBlå);
		
		menuBar = new JMenuBar();
		färgMeny = new JMenu("Bakgrundsfärg");
		rödFärg = new JMenuItem("Röd");
		blåFärg = new JMenuItem("Orginal");
		grönFärg = new JMenuItem("Grön");
		gulFärg = new JMenuItem("Gul");
		rosaFärg = new JMenuItem("Rosa");
		träFärg = new JMenuItem("Träfärgad");
		
		färgMeny.add(blåFärg);
		färgMeny.add(rödFärg);
		färgMeny.add(grönFärg);
		färgMeny.add(gulFärg);
		färgMeny.add(rosaFärg);
		färgMeny.add(träFärg);
		
		menuBar.add(färgMeny);
		
		setJMenuBar(menuBar);
		
		//Startsidan......................................................
		imgLogo = new ImageIcon("images/logo.png");
		imgÖva = new ImageIcon("images/ova.png");
		imgTest = new ImageIcon("Bilder/knapp_test.png");
		imgMaskot = new ImageIcon("Bilder/maskot kopiera.png");
		imgPratbubblaStart = new ImageIcon("Bilder/Start_bubbla.png");
		
		lblMaskot = new JLabel();
		lblPratbubblaStart = new JLabel();
		lblVapen = new JLabel();
		lblLogo = new JLabel();
		btnÖva = new JButton();
		btnTest = new JButton();
		
		lblMaskot.setIcon(imgMaskot);
		lblPratbubblaStart.setIcon(imgPratbubblaStart);
		lblLogo.setIcon(imgLogo);
		btnÖva.setIcon(imgÖva);
		btnTest.setIcon(imgTest);
		
		lblStarttext = new JLabel("Välj ett av alternativen för att gå vidare:");
		lblStarttext.setFont(new Font("SanSerif", Font.PLAIN, 22));
		
		lblMaskot.setBounds(430,340,400,250);
		lblPratbubblaStart.setBounds(130,65,580,363);

		lblLogo.setBounds(180,10,420,90);
		btnÖva.setBounds(20,150,200,100);
		btnTest.setBounds(20,280,200,100);
		
		aktuellSida = "start";
		
		//Objekt som visas på flera sidor..............................
		imgBak = new ImageIcon("Bilder/bak.png");
		imgAvsluta = new ImageIcon("Bilder/avsluta kopiera.png");
		imgTomBild = new ImageIcon("images/tombild.png");
		
		lblBakåt = new JLabel("Bakåt");
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
		
		lblBakåt.setBounds(45,500,80,40);
		lblAvsluta.setBounds(160,500,80,40);
		btnBak.setBounds(20,530,80,40);
		btnAvsluta.setBounds(140,530,80,40);
		lblText.setBounds(20,20,400,20);
		lblTips.setBounds(150,375,220,40);
		lblTipsText.setBounds(80,360,60,40);
		
		timer = new javax.swing.Timer(2300,this);
			
		//Övasidan....................................................................
		imgÖvaStäder = new ImageIcon("images/stad.png");
		imgÖvaLandskap = new ImageIcon("images/landskap.png");
		imgStart = new ImageIcon("images/start.png");
		imgRätt = new ImageIcon("images/rättknapp.png");
		imgFel = new ImageIcon("images/felknapp.png");
		imgBeskrivning = new ImageIcon("images/beskrivning.png");
		imgMaskotLiten = new ImageIcon("Bilder/maskotLiten.png");
		imgPratbubblaTips = new ImageIcon("Bilder/bubblaTipset.png");
		imgPratbubblaÖvning = new ImageIcon("Bilder/Öva_bubbla.png");
		
		lblrättSvar = new JLabel();
		lblfelSvar = new JLabel();
		lblFråga = new JLabel("");
		lblKlickade = new JLabel();
		lblMaskotLiten = new JLabel();
		lblPratbubblaTips = new JLabel();
		lblPratbubblaÖvning = new JLabel();
		lblBeskrivning = new JLabel();
		btnÖvaStäder = new JButton();
		btnÖvaLandskap = new JButton();
		btnStart = new JButton();
		radStäder = new JRadioButton();
		radLandskap = new JRadioButton();
		lblÖvaStäder = new JLabel("Öva på städer.");
		lblÖvaLandskap = new JLabel("Öva på landskap.");
		
		lblMaskotLiten.setIcon(imgMaskotLiten);
		lblPratbubblaTips.setIcon(imgPratbubblaTips);
		lblPratbubblaÖvning.setIcon(imgPratbubblaÖvning);
		lblBeskrivning.setIcon(imgBeskrivning);
		btnÖvaStäder.setIcon(imgÖvaStäder);
		btnÖvaLandskap.setIcon(imgÖvaLandskap);
		btnStart.setIcon(imgStart);
		lblrättSvar.setIcon(imgRätt);
		lblfelSvar.setIcon(imgFel);
		
		lblBeskrivning.setBounds(498,10,120,50);
		btnÖvaStäder.setBounds(20,100,100,100);
		btnÖvaLandskap.setBounds(20,270,100,100);
		btnStart.setBounds(245,420,120,50);
		lblPratbubblaÖvning.setBounds(130,65,580,363);
		lblPratbubblaTips.setBounds(40,320,388,176);
		lblMaskotLiten.setBounds(250,430,250,156);
		radStäder.setBounds(140,140,20,20);
		radLandskap.setBounds(140,310,20,20);
		lblÖvaStäder.setBounds(20,80,100,20);
		lblÖvaLandskap.setBounds(20,250,100,20);
		lblVapen.setBounds(300,60,120,146);
		lblrättSvar.setBounds(10,120,170,130);
		lblfelSvar.setBounds(1,120,170,130);
		lblFråga.setBounds(20,60,220,20);
		lblKlickade.setBounds(20,100,250,20);
				
		ButtonGroup gruppen = new ButtonGroup();
		gruppen.add(radStäder);
		gruppen.add(radLandskap);
	
		lblFråga.setFont(new Font("SanSerif", Font.PLAIN, 18));
		lblKlickade.setFont(new Font("SanSerif", Font.PLAIN, 18));
			
		lblFråga.setOpaque(true);
		lblFråga.setBackground(Color.white);
		lblFråga.setBorder(new LineBorder(Color.black));
		
		//Landskapsvapnen.........................................................
		vapenBlekinge = new ImageIcon("vapen/Blekinge_vapen.png");
		vapenBohuslän = new ImageIcon("vapen/Bohuslän_vapen.png");
		vapenDalarna = new ImageIcon("vapen/Dalarna_vapen.png");
		vapenDalsland = new ImageIcon("vapen/Dalsland_vapen.png");
		vapenGotland = new ImageIcon("vapen/Gotland_vapen.png");
		vapenGästrikland = new ImageIcon("vapen/Gästrikland_vapen.png");
		vapenHalland = new ImageIcon("vapen/Halland_vapen.png");
		vapenHälsingland = new ImageIcon("vapen/Hälsingland_vapen.png");
		vapenHärjedalen = new ImageIcon("vapen/Härjedalen_vapen.png");
		vapenJämtland = new ImageIcon("vapen/Jämtland_vapen.png");
		vapenLappland = new ImageIcon("vapen/Lappland_vapen.png");
		vapenMedelpad = new ImageIcon("vapen/Medelpad_vapen.png");
		vapenNorrbotten = new ImageIcon("vapen/Norrbotten_vapen.png");
		vapenNärke = new ImageIcon("vapen/Närke_vapen.png");
		vapenSkåne = new ImageIcon("vapen/Skåne_vapen.png");
		vapenSmåland = new ImageIcon("vapen/Småland_vapen.png");
		vapenSödermanland = new ImageIcon("vapen/Södermanland_vapen.png");
		vapenUppland = new ImageIcon("vapen/Uppland_vapen.png");
		vapenVärmland = new ImageIcon("vapen/Värmland_vapen.png");
		vapenVästerbotten = new ImageIcon("vapen/Västerbotten_vapen.png");
		vapenVästergötland = new ImageIcon("vapen/Västergötland_vapen.png");
		vapenVästmanland = new ImageIcon("vapen/Västmanland_vapen.png");
		vapenÅngermanland = new ImageIcon("vapen/Ångermanland_vapen.png");
		vapenÖland = new ImageIcon("vapen/Öland_vapen.png");
		vapenÖstergötland = new ImageIcon("vapen/Östergötland_vapen.png");
		
		//Städerna................................................................		
		imgStad = new ImageIcon("Bilder/kartknapp2.2.png");
		imgKarta = new ImageIcon("images/karta2.png");

		btnStockholm = new JButton();
		btnGöteborg  = new JButton();
		btnMalmö = new JButton();
		btnUppsala = new JButton();
		btnVästerås = new JButton();
		btnÖrebro = new JButton();
		btnLinköping = new JButton();
		btnHelsingborg = new JButton();
		btnJönköping = new JButton();	
		btnNorrköping = new JButton();
		btnLund = new JButton();
		btnUmeå = new JButton();
		btnGävle = new JButton();
		btnBorås = new JButton();
		btnKalmar = new JButton(); 
		btnEskilstuna = new JButton();
		btnKarlstad = new JButton();
		btnHalmstad = new JButton();
		btnVäxjö = new JButton();
		btnSundsvall = new JButton();
		btnKiruna = new JButton();
		btnVisby = new JButton();
		btnFalun = new JButton();
		btnLuleå = new JButton();
		btnÖstersund = new JButton();
		lblKarta = new JLabel();
	
		btnStockholm.setIcon(imgStad); btnGöteborg.setIcon(imgStad); btnMalmö.setIcon(imgStad); btnUppsala.setIcon(imgStad); 
		btnVästerås.setIcon(imgStad); btnÖrebro.setIcon(imgStad); btnLinköping.setIcon(imgStad); btnHelsingborg.setIcon(imgStad); 
		btnJönköping.setIcon(imgStad); btnNorrköping.setIcon(imgStad); btnLund.setIcon(imgStad); btnUmeå.setIcon(imgStad); 
		btnGävle.setIcon(imgStad); btnBorås.setIcon(imgStad); btnKalmar.setIcon(imgStad); btnEskilstuna.setIcon(imgStad); 
		btnKarlstad.setIcon(imgStad); btnHalmstad.setIcon(imgStad); btnVäxjö.setIcon(imgStad); btnSundsvall.setIcon(imgStad); 
		btnKiruna.setIcon(imgStad); btnVisby.setIcon(imgStad); btnFalun.setIcon(imgStad); btnLuleå.setIcon(imgStad); 
		btnÖstersund.setIcon(imgStad);
		lblKarta.setIcon(imgKarta);
				
		btnStockholm.setBounds(654,398,14,14);
		btnGöteborg.setBounds(515,472,14,14);		
		btnMalmö.setBounds(533,565,14,14);
		btnUppsala.setBounds(640,386,14,14);
		btnVästerås.setBounds(615,391,14,14);
		btnÖrebro.setBounds(585,415,14,14);
		btnLinköping.setBounds(594,449,14,14);
		btnJönköping.setBounds(565,476,14,14);	
		btnNorrköping.setBounds(610,442,14,14);
		btnHelsingborg.setBounds(530,546,14,14);
		btnLund.setBounds(546,556,14,14);
		btnUmeå.setBounds(690,220,14,14);
		btnGävle.setBounds(625,350,14,14);
		btnBorås.setBounds(536,478,14,14);
		btnKalmar.setBounds(604,513,14,14);
		btnEskilstuna.setBounds(616,409,14,14);
		btnKarlstad.setBounds(549,402,14,14);
		btnHalmstad.setBounds(530,516,14,14);
		btnVäxjö.setBounds(586,501,14,14);
		btnSundsvall.setBounds(632,280,14,14);
		btnKiruna.setBounds(675,70,14,14);
		btnFalun.setBounds(597,355,14,14);
		btnLuleå.setBounds(743,133,14,14);
		btnÖstersund.setBounds(570,250,14,14);
		btnVisby.setBounds(664,481,14,14);
		lblKarta.setBounds(495,5,292,578);
		
		btnStockholm.setContentAreaFilled(false);
		btnGöteborg.setContentAreaFilled(false);
		btnMalmö.setContentAreaFilled(false);	
		btnUppsala.setContentAreaFilled(false);
		btnVästerås.setContentAreaFilled(false);
		btnÖrebro.setContentAreaFilled(false);
		btnLinköping.setContentAreaFilled(false);
		btnHelsingborg.setContentAreaFilled(false);
		btnJönköping.setContentAreaFilled(false);
		btnNorrköping.setContentAreaFilled(false);
		btnLund.setContentAreaFilled(false);
		btnUmeå.setContentAreaFilled(false);
		btnGävle.setContentAreaFilled(false);
		btnBorås.setContentAreaFilled(false);
		btnKalmar.setContentAreaFilled(false);
		btnEskilstuna.setContentAreaFilled(false);
		btnKarlstad.setContentAreaFilled(false);
		btnHalmstad.setContentAreaFilled(false);
		btnVäxjö.setContentAreaFilled(false);
		btnSundsvall.setContentAreaFilled(false);
		btnKiruna.setContentAreaFilled(false);
		btnVisby.setContentAreaFilled(false);
		btnFalun.setContentAreaFilled(false);
		btnLuleå.setContentAreaFilled(false);
		btnÖstersund.setContentAreaFilled(false);
		btnVisby.setContentAreaFilled(false);
		
		lblKarta.setBorder(new LineBorder(Color.black));
		
		//Landkapen............................................................
		imgLandskap = new ImageIcon("Bilder/gulknapp2.png");

		btnLappland = new JButton();
		btnNorrbotten  = new JButton();
		btnVästerbotten = new JButton();
		btnJämtland = new JButton();
		btnÅngermanland = new JButton();
		btnMedelpad = new JButton();
		btnHärjedalen = new JButton();
		btnHälsingland = new JButton();
		btnDalarna = new JButton();	
		btnGästrikland = new JButton();
		btnUppland = new JButton();
		btnVästmanland = new JButton();
		btnVärmland = new JButton();
		btnSödermanland = new JButton();
		btnNärke = new JButton(); 
		btnDalsland = new JButton();
		btnÖstergötland = new JButton();
		btnVästergötland = new JButton();
		btnBohuslän = new JButton();
		btnSmåland = new JButton();
		btnHalland = new JButton();
		btnBlekinge = new JButton();
		btnSkåne = new JButton();
		btnGotland = new JButton();
		btnÖland = new JButton();		
		
		btnLappland.setIcon(imgLandskap);
		btnNorrbotten.setIcon(imgLandskap);
		btnVästerbotten.setIcon(imgLandskap);	
		btnJämtland.setIcon(imgLandskap);	
		btnÅngermanland.setIcon(imgLandskap);
		btnMedelpad.setIcon(imgLandskap);
		btnHärjedalen.setIcon(imgLandskap);
		btnHälsingland.setIcon(imgLandskap);
		btnDalarna.setIcon(imgLandskap);
		btnGästrikland.setIcon(imgLandskap); 
		btnUppland.setIcon(imgLandskap);	
		btnVästmanland.setIcon(imgLandskap);	
		btnVärmland.setIcon(imgLandskap);	
		btnSödermanland.setIcon(imgLandskap);
		btnNärke.setIcon(imgLandskap);
		btnDalsland.setIcon(imgLandskap);
		btnÖstergötland.setIcon(imgLandskap);
		btnVästergötland.setIcon(imgLandskap);	
		btnBohuslän.setIcon(imgLandskap);	
		btnSmåland.setIcon(imgLandskap);	
		btnHalland.setIcon(imgLandskap);	
		btnBlekinge.setIcon(imgLandskap);	
		btnSkåne.setIcon(imgLandskap);	
		btnGotland.setIcon(imgLandskap);	
		btnÖland.setIcon(imgLandskap);
			
		btnAvsluta.setContentAreaFilled(false);
		btnNorrbotten.setContentAreaFilled(false);
		btnVästerbotten.setContentAreaFilled(false);
		btnJämtland.setContentAreaFilled(false);
		btnÅngermanland.setContentAreaFilled(false);
		btnMedelpad.setContentAreaFilled(false); 
		btnHärjedalen.setContentAreaFilled(false);
		btnHälsingland.setContentAreaFilled(false); 
		btnDalarna.setContentAreaFilled(false);
		btnGästrikland.setContentAreaFilled(false);
		btnUppland.setContentAreaFilled(false);
		btnVästmanland.setContentAreaFilled(false);
		btnVärmland.setContentAreaFilled(false);
		btnSödermanland.setContentAreaFilled(false);
		btnNärke.setContentAreaFilled(false);
		btnDalsland.setContentAreaFilled(false);
		btnÖstergötland.setContentAreaFilled(false);
		btnVästergötland.setContentAreaFilled(false);
		btnBohuslän.setContentAreaFilled(false);
		btnSmåland.setContentAreaFilled(false);
		btnHalland.setContentAreaFilled(false);
		btnBlekinge.setContentAreaFilled(false);
		btnSkåne.setContentAreaFilled(false);
		btnGotland.setContentAreaFilled(false);
		btnÖland.setContentAreaFilled(false);
		
		btnLappland.setBounds(645,130,14,14);
		btnNorrbotten.setBounds(731,123,14,14);
		btnVästerbotten.setBounds(695,200,14,14);
		btnJämtland.setBounds(570,230,14,14);
		btnÅngermanland.setBounds(640,235,14,14);
		btnMedelpad.setBounds(622,275,14,14);
		btnHärjedalen.setBounds(560,290,14,14);
		btnHälsingland.setBounds(612,310,14,14);
		btnDalarna.setBounds(577,345,14,14);
		btnGästrikland.setBounds(620,355,14,14);
		btnUppland.setBounds(647,383,14,14);
		btnVästmanland.setBounds(600,390,14,14);
		btnVärmland.setBounds(545,389,14,14);
		btnSödermanland.setBounds(620,412,14,14);
		btnNärke.setBounds(585,415,14,14);
		btnDalsland.setBounds(517,422,14,14);
		btnÖstergötland.setBounds(593,442,14,14);
		btnVästergötland.setBounds(536,458,14,14);
		btnBohuslän.setBounds(500,442,14,14);
		btnSmåland.setBounds(586,501,14,14);
		btnHalland.setBounds(528,503,14,14);
		btnBlekinge.setBounds(586,531,14,14);
		btnSkåne.setBounds(545,545,14,14);
		btnGotland.setBounds(660,483,14,14);
		btnÖland.setBounds(616,520,14,14);	
			
		//Testsidan........................................................
		imgPratbubblaTest = new ImageIcon("Bilder/Test_bubbla.png");
		imgTopp = new ImageIcon("Bilder/toplista.png");
		imgStartaTest = new ImageIcon("images/start.png");
		
		lblfrågaNummer = new JLabel();
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

		lblfrågaNummer.setBounds(22,25,250,50);
		lblPratbubblaTest.setBounds(130,65,580,363);
		btnStartaTest.setBounds(20,130,120,50);
		btnHighscore.setBounds(20,200,120,50);

		//---------------------------------------------------------------------------
		
		
		//Actionlistners
		//---------------------------------------------------------------------------
		btnHighscore.addActionListener(this);
		btnÖva.addActionListener(this);
		btnTest.addActionListener(this);
		btnBak.addActionListener(this);
		btnAvsluta.addActionListener(this);
		btnÖvaStäder.addActionListener(this);
		btnÖvaLandskap.addActionListener(this);
		btnStart.addActionListener(this);
		radStäder.addActionListener(this);
		radLandskap.addActionListener(this);
		btnStartaTest.addActionListener(this);
		//städer......................................
		btnStockholm.addActionListener(this);
		btnGöteborg.addActionListener(this);
		btnMalmö.addActionListener(this);
		btnUppsala.addActionListener(this);
		btnVästerås.addActionListener(this);
		btnÖrebro.addActionListener(this);
		btnLinköping.addActionListener(this);
		btnHelsingborg.addActionListener(this);
		btnJönköping.addActionListener(this);	
		btnNorrköping.addActionListener(this);
		btnLund.addActionListener(this);
		btnUmeå.addActionListener(this);
		btnGävle.addActionListener(this);
		btnBorås.addActionListener(this);
		btnKalmar.addActionListener(this);
		btnEskilstuna.addActionListener(this);
		btnKarlstad.addActionListener(this);
		btnHalmstad.addActionListener(this);
		btnVäxjö.addActionListener(this);
		btnSundsvall.addActionListener(this);
		btnKiruna.addActionListener(this);
		btnVisby.addActionListener(this);
		btnFalun.addActionListener(this);
		btnLuleå.addActionListener(this);
		btnÖstersund.addActionListener(this);
		//landskap...................................
		btnLappland.addActionListener(this);
		btnNorrbotten.addActionListener(this);
		btnVästerbotten.addActionListener(this);
		btnJämtland.addActionListener(this);
		btnÅngermanland.addActionListener(this);
		btnMedelpad.addActionListener(this);
		btnHärjedalen.addActionListener(this);
		btnHälsingland.addActionListener(this);
		btnDalarna.addActionListener(this);	
		btnGästrikland.addActionListener(this);
		btnUppland.addActionListener(this);
		btnVästmanland.addActionListener(this);
		btnVärmland.addActionListener(this);
		btnSödermanland.addActionListener(this);
		btnNärke.addActionListener(this);
		btnDalsland.addActionListener(this);
		btnÖstergötland.addActionListener(this);
		btnVästergötland.addActionListener(this);
		btnBohuslän.addActionListener(this);
		btnSmåland.addActionListener(this);
		btnHalland.addActionListener(this);
		btnBlekinge.addActionListener(this);
		btnSkåne.addActionListener(this);
		btnGotland.addActionListener(this);
		btnÖland.addActionListener(this);
		//bakgrundsfärger
		rödFärg.addActionListener(this);
		blåFärg.addActionListener(this);
		grönFärg.addActionListener(this);
		gulFärg.addActionListener(this);
		rosaFärg.addActionListener(this);
		träFärg.addActionListener(this);
		//---------------------------------------------------------------------------
		
		//Sätter in objekten i containern som fyller hela rutan.
		//---------------------------------------------------------------------------
		c.add(lblfrågaNummer);
		c.add(lblTips);
		c.add(lblTipsText);
		c.add(lblLogo);
		c.add(lblMaskot);
		c.add(lblMaskotLiten);
		c.add(lblPratbubblaTips);
		c.add(lblPratbubblaStart);
		c.add(lblPratbubblaTest);
		c.add(lblPratbubblaÖvning);
		c.add(btnÖva);
		c.add(btnHighscore);
		c.add(btnTest);
		c.add(lblText);
		c.add(btnÖvaLandskap);
		c.add(btnÖvaStäder);
		c.add(lblÖvaStäder);
		c.add(lblÖvaLandskap);
		c.add(lblAvsluta);
		c.add(lblBakåt);
		c.add(btnBak);
		c.add(btnAvsluta);
		c.add(btnStart);
		c.add(radStäder);
		c.add(radLandskap);
		c.add(lblStarttext);
		c.add(lblFråga);
		c.add(lblrättSvar);
		c.add(lblfelSvar);
		c.add(btnStartaTest);
		c.add(lblBeskrivning);
		c.add(txtHighScore);
		c.add(lblKlickade);
		c.add(lblVapen);
		//städer...................
		c.add(btnStockholm);
		c.add(btnGöteborg);
		c.add(btnMalmö);
		c.add(btnUppsala);
		c.add(btnVästerås);
		c.add(btnÖrebro);
		c.add(btnLinköping);
		c.add(btnHelsingborg);
		c.add(btnJönköping);
		c.add(btnNorrköping);
		c.add(btnLund);
		c.add(btnUmeå);
		c.add(btnGävle);
		c.add(btnBorås);
		c.add(btnKalmar);
		c.add(btnEskilstuna);
		c.add(btnKarlstad);
		c.add(btnHalmstad);
		c.add(btnVäxjö);
		c.add(btnSundsvall);
		c.add(btnKiruna);
		c.add(btnVisby);
		c.add(btnFalun);
		c.add(btnLuleå);
		c.add(btnÖstersund);
		//Landskap.................
		c.add(btnLappland);
		c.add(btnNorrbotten);
		c.add(btnVästerbotten);
		c.add(btnJämtland);
		c.add(btnÅngermanland);
		c.add(btnMedelpad);
		c.add(btnHärjedalen);
		c.add(btnHälsingland);
		c.add(btnDalarna);
		c.add(btnGästrikland);
		c.add(btnUppland);
		c.add(btnVästmanland);
		c.add(btnVärmland);
		c.add(btnSödermanland);
		c.add(btnNärke);
		c.add(btnÖstergötland);
		c.add(btnVästergötland);
		c.add(btnBohuslän);
		c.add(btnDalsland);
		c.add(btnSmåland);
		c.add(btnHalland);
		c.add(btnBlekinge);
		c.add(btnSkåne);
		c.add(btnGotland);	
		c.add(btnÖland);
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
			
			//menyfärgen..........................................
			if (e.getSource() == blåFärg){
				lblBak.setIcon(bakBlå);
			}
			else if (e.getSource() == rödFärg){
				lblBak.setIcon(bakRöd);
			}
			else if (e.getSource() == grönFärg){
				lblBak.setIcon(bakGrön);
			}
			else if (e.getSource() == gulFärg){
				lblBak.setIcon(bakGul);
			}
			else if (e.getSource() == rosaFärg){
				lblBak.setIcon(bakRosa);
			}
			else if (e.getSource() == träFärg){
				lblBak.setIcon(bakTrä);	
			}
				
			//knapparna...........................................
			else if (e.getSource() == btnÖva) {
				Sidan("öva");
			}
			else if (e.getSource() == btnÖvaStäder) {
				radStäder.setSelected(true);
			}
			else if (e.getSource() == btnÖvaLandskap) {
				radLandskap.setSelected(true);
			}
			else if (e.getSource() == btnStart) {
				if (radStäder.isSelected() == true) {
						Sidan("övaStäder");
						startPos = 26;
						slumpaVektor();		
						nyttObjekt();
				}
				else if (radLandskap.isSelected() == true) {
						Sidan("övaLandskap");
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
				antalPoäng = 0;
				frågaNummer = 1;
			}
			else if (e.getSource() == btnBak) {
				if (aktuellSida == "öva"){
					Sidan("start");
				}
				else if ((aktuellSida == "övaStäder") || (aktuellSida == "övaLandskap")) {
					Sidan("öva");
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
				lblKlickade.setText("Du klickade på Lappland");	
				var = 1;
				check();	
			}
			else if	(e.getSource() == btnNorrbotten) {
				lblKlickade.setText("Du klickade på Norrbotten");
				var = 2;
				check();		
			}
			else if	(e.getSource() == btnVästerbotten) {
				lblKlickade.setText("Du klickade på Västerbotten");	
				var = 3;
				check();	
			}
			else if	(e.getSource() == btnJämtland) {
				lblKlickade.setText("Du klickade på Jämtland");	
				var = 4;
				check();	
			}
			else if	(e.getSource() == btnÅngermanland) {
				lblKlickade.setText("Du klickade på Ångermanland");	
				var = 5;
				check();	
			}
			else if	(e.getSource() == btnMedelpad) {
				lblKlickade.setText("Du klickade på Medelpad");	
				var = 6;
				check();	
			}
			else if	(e.getSource() == btnHärjedalen) {
				lblKlickade.setText("Du klickade på Härjedalen");
				var = 7;
				check();		
			}
			else if	(e.getSource() == btnHälsingland) {
				lblKlickade.setText("Du klickade på Hälsingland");
				var = 8;
				check();		
			}
			else if	(e.getSource() == btnDalarna) {
				lblKlickade.setText("Du klickade på Dalarna");	
				var = 9;
				check();	
			}
			
			else if	(e.getSource() == btnGästrikland) {
				lblKlickade.setText("Du klickade på Gästrikland");
				var = 10;
				check();		
			}
			else if	(e.getSource() == btnUppland) {
				lblKlickade.setText("Du klickade på Uppland");	
				var = 11;
				check();	
			}
			else if	(e.getSource() == btnVästmanland) {
				lblKlickade.setText("Du klickade på Västmanland");
				var = 12;
				check();		
			}
			else if	(e.getSource() == btnVärmland) {
				lblKlickade.setText("Du klickade på Värmland");	
				var = 13;
				check();	
			}
			else if	(e.getSource() == btnSödermanland) {
				lblKlickade.setText("Du klickade på Södermanland");
				var = 14;
				check();		
			}
			else if	(e.getSource() == btnNärke) {
				lblKlickade.setText("Du klickade på Närke");	
				var = 15;
				check();	
			}
			else if	(e.getSource() == btnDalsland) {
				lblKlickade.setText("Du klickade på Dalsland");
				var = 16;
				check();		
			}
			else if	(e.getSource() == btnÖstergötland) {
				lblKlickade.setText("Du klickade på Östergötland");	
				var = 17;
				check();	
			}
			else if	(e.getSource() == btnVästergötland) {
				lblKlickade.setText("Du klickade på Västergötland");	
				var = 18;
				check();	
			}
			else if	(e.getSource() == btnBohuslän) {
				lblKlickade.setText("du klickade på Bohuslän");	
				var = 19;
				check();	
			}
			else if	(e.getSource() == btnSmåland) {
				lblKlickade.setText("du klickade på Småland");
				var = 20;
				check();		
			}
			else if	(e.getSource() == btnHalland) {
				lblKlickade.setText("du klickade på Halland");
				var = 21;
				check();		
			}
			else if	(e.getSource() == btnBlekinge) {
				lblKlickade.setText("du klickade på Blekinge");	
				var = 22;
				check();	
			}
			else if	(e.getSource() == btnSkåne) {
				lblKlickade.setText("du klickade på Skåne");	
					var = 23;
				check();	
			}
			else if	(e.getSource() == btnGotland) {
				lblKlickade.setText("du klickade på Gotland");
				var = 24;
				check();		
			}
			else if	(e.getSource() == btnÖland) {
				lblKlickade.setText("du klickade på Öland");	
					var = 25;
				check();	
			}
			
			//städerna..................................................
			else if	(e.getSource() == btnStockholm) {
				lblKlickade.setText("Du klickade på Stockholm");
				var = 26;
				check();		
			}
			else if	(e.getSource() == btnGöteborg) {
				lblKlickade.setText("Du klickade på Göteborg");
				var = 27;
				check();		
			}
			else if	(e.getSource() == btnMalmö) {
				lblKlickade.setText("Du klickade på Malmö");	
					var = 28;
				check();	
			}
			else if	(e.getSource() == btnUppsala) {
				lblKlickade.setText("Du klickade på Uppsala");
				var = 29;
				check();		
			}
			else if	(e.getSource() == btnVästerås) {
				lblKlickade.setText("Du klickade på Västerås");	
					var = 30;
				check();	
			}
			else if	(e.getSource() == btnÖrebro) {
				lblKlickade.setText("Du klickade på Örebro");
				var = 31;
				check();		
			}
			else if	(e.getSource() == btnLinköping) {
				lblKlickade.setText("Du klickade på Linköping");	
					var = 32;
				check();	
			}
			else if	(e.getSource() == btnHelsingborg) {
				lblKlickade.setText("Du klickade på Helsingborg");
				var = 33;
				check();		
			}
			else if	(e.getSource() == btnJönköping) {
				lblKlickade.setText("Du klickade på Jönköping");	
					var = 34;
				check();	
			}
			else if	(e.getSource() == btnNorrköping) {
				lblKlickade.setText("Du klickade på Norrköping");
				var = 35;
				check();		
			}
			else if	(e.getSource() == btnLund) {
				lblKlickade.setText("Du klickade på Lund");
				var = 36;
				check();		
			}
			else if	(e.getSource() == btnUmeå) {
				lblKlickade.setText("Du klickade på Umeå");	
				var = 37;
				check();	
			}
			else if	(e.getSource() == btnGävle) {
				lblKlickade.setText("Du klickade på Gävle");	
				var = 38;
				check();	
			}
			else if	(e.getSource() == btnBorås) {
				lblKlickade.setText("Du klickade på Borås");	
				var = 39;
				check();	
			}
			else if	(e.getSource() == btnKalmar) {
				lblKlickade.setText("Du klickade på Kalmar");
				var = 40;
				check();		
			}
			else if	(e.getSource() == btnEskilstuna) {
				lblKlickade.setText("Du klickade på Eskilstuna");
				var = 41;
				check();		
			}
			else if	(e.getSource() == btnKarlstad) {
				lblKlickade.setText("Du klickade på Karlstad");
				var = 42;
				check();		
			}
			else if	(e.getSource() == btnHalmstad) {
				lblKlickade.setText("Du klickade på Halmstad");	
					var = 43;
				check();	
			}
			else if	(e.getSource() == btnVäxjö) {
				lblKlickade.setText("Du klickade på Växjö");	
				var = 44;
				check();	
			}
			else if	(e.getSource() == btnSundsvall) {
				lblKlickade.setText("Du klickade på Sundsvall");	
				var = 45;
				check();	
			}
			else if	(e.getSource() == btnKiruna) {
				lblKlickade.setText("Du klickade på Kiruna");
				var = 46;
				check();		
			}
			else if	(e.getSource() == btnVisby) {
				lblKlickade.setText("Du klickade på Visby");		
				var = 47;
				check();
			}
			else if	(e.getSource() == btnFalun) {
				lblKlickade.setText("Du klickade på Falun");	
				var = 48;
				check();	
			}
			else if	(e.getSource() == btnLuleå) {
				lblKlickade.setText("Du klickade på Luleå");	
				var = 49;
				check();	
			}
			else if	(e.getSource() == btnÖstersund) {
				lblKlickade.setText("Du klickade på Östersund");	
				var = 50;
				check();	
			}
			else if (e.getSource() == timer){
				klickbara = true;
				if ((aktuellSida == "övaStäder") || (aktuellSida == "övaLandskap")){
					lblrättSvar.setVisible(false);
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
					lblrättSvar.setVisible(false);
					lblfelSvar.setVisible(false);
					lblKlickade.setVisible(false);
				
					if (posvektor == 25){
						if(highscore.getInList(antalPoäng)){
							String namn = JOptionPane.showInputDialog(this,"Grattis du fick " + antalPoäng + " poäng, så du kom in på topplistan! \nSkriv in ditt namn: ");
							highscore.insList(namn, antalPoäng);
							highscore.saveList();
							Sidan("testsidan");
						}
						else{
							JOptionPane.showMessageDialog(this,"Tack för att du gjorde testet! \nDu fick " + antalPoäng + " poäng, så du kom tyvärr inte in på topplistan, men försök gärna igen. ");
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
		//Sätter allt till osynligt
		public void Osynligt() {
			lblTips.setVisible(false);
			lblMaskotLiten.setVisible(false);
			lblPratbubblaTips.setVisible(false);
			lblTipsText.setVisible(false);
			lblfrågaNummer.setVisible(false);
			lblMaskot.setVisible(false);
			lblPratbubblaStart.setVisible(false);
			lblPratbubblaTest.setVisible(false);
			lblPratbubblaÖvning.setVisible(false);
			lblVapen.setVisible(false);
			lblText.setVisible(false);
			lblStarttext.setVisible(false);
			lblLogo.setVisible(false);
			btnHighscore.setVisible(false);
			btnÖva.setVisible(false);
			btnTest.setVisible(false);
			btnÖvaStäder.setVisible(false);
			btnÖvaLandskap.setVisible(false);
			lblÖvaStäder.setVisible(false);
			lblÖvaLandskap.setVisible(false);
			lblAvsluta.setVisible(false);
			lblBakåt.setVisible(false);
			btnBak.setVisible(false);
			btnAvsluta.setVisible(false);
			btnStart.setVisible(false);
			radStäder.setVisible(false);
			radLandskap.setVisible(false);
			lblKarta.setVisible(false);
			lblFråga.setVisible(false);
			lblKlickade.setVisible(false);
			lblrättSvar.setVisible(false);
			lblfelSvar.setVisible(false);
			btnStartaTest.setVisible(false);
			lblBeskrivning.setVisible(false);
			txtHighScore.setVisible(false);
			SynligaStäder(false);
			SynligaLandskap(false);
		}
		
		//Sätter rätt vapen...........................................
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
				lblVapen.setIcon(vapenVästerbotten);
			}
			else if (a == 4){
				lblVapen.setIcon(vapenJämtland);
			}
			else if (a == 5){
				lblVapen.setIcon(vapenÅngermanland);
			}
			else if (a == 6){
				lblVapen.setIcon(vapenMedelpad);
			}
			else if (a == 7){
				lblVapen.setIcon(vapenHärjedalen);
			}
			else if (a == 8){
				lblVapen.setIcon(vapenHälsingland);
			}
			else if (a == 9){
				lblVapen.setIcon(vapenDalarna);
			}
			else if (a == 10){
				lblVapen.setIcon(vapenGästrikland);
			}
			else if (a == 11){
				lblVapen.setIcon(vapenUppland);
			}
			else if (a == 12){
				lblVapen.setIcon(vapenVästmanland);
			}
			else if (a == 13){
				lblVapen.setIcon(vapenVärmland);
			}
			else if (a == 14){
				lblVapen.setIcon(vapenSödermanland);
			}
			else if (a == 15){
				lblVapen.setIcon(vapenNärke);
			}
			else if (a == 16){
				lblVapen.setIcon(vapenDalsland);
			}
			else if (a == 17){
				lblVapen.setIcon(vapenÖstergötland);
			}
			else if (a == 18){
				lblVapen.setIcon(vapenVästergötland);
			}
			else if (a == 19){
				lblVapen.setIcon(vapenBohuslän);
			}
			else if (a == 20){
				lblVapen.setIcon(vapenSmåland);
			}
			else if (a == 21){
				lblVapen.setIcon(vapenHalland);
			}
			else if (a == 22){
				lblVapen.setIcon(vapenBlekinge);
			}
			else if (a == 23){
				lblVapen.setIcon(vapenSkåne);
			}
			else if (a == 24){
				lblVapen.setIcon(vapenGotland);
			}
			else if (a == 25){
				lblVapen.setIcon(vapenÖland);
			}
			else if (a > 25){
				lblVapen.setVisible(false);
			}		 
		}
		
		//............................................................
		//Sätter alla städer till synligt eller osynligt
		public void SynligaStäder(boolean visible) {
			boolean v = visible;
			if (v == true) {
				btnStockholm.setVisible(true);
				btnGöteborg.setVisible(true);
				btnMalmö.setVisible(true);
				btnUppsala.setVisible(true);
				btnVästerås.setVisible(true);
				btnÖrebro.setVisible(true);
				btnLinköping.setVisible(true);
				btnHelsingborg.setVisible(true);
				btnJönköping.setVisible(true);	
				btnNorrköping.setVisible(true);
				btnLund.setVisible(true);
				btnUmeå.setVisible(true);
				btnGävle.setVisible(true);
				btnBorås.setVisible(true);
				btnKalmar.setVisible(true);
				btnEskilstuna.setVisible(true);
				btnKarlstad.setVisible(true);
				btnHalmstad.setVisible(true);
				btnVäxjö.setVisible(true);
				btnSundsvall.setVisible(true);
				btnKiruna.setVisible(true);
				btnVisby.setVisible(true);
				btnFalun.setVisible(true);
				btnLuleå.setVisible(true);
				btnÖstersund.setVisible(true);
			}
			else if (v == false) {
				btnStockholm.setVisible(false);
				btnGöteborg.setVisible(false);
				btnMalmö.setVisible(false);
				btnUppsala.setVisible(false);
				btnVästerås.setVisible(false);
				btnÖrebro.setVisible(false);
				btnLinköping.setVisible(false);
				btnHelsingborg.setVisible(false);
				btnJönköping.setVisible(false);	
				btnNorrköping.setVisible(false);
				btnLund.setVisible(false);
				btnUmeå.setVisible(false);
				btnGävle.setVisible(false);
				btnBorås.setVisible(false);
				btnKalmar.setVisible(false);
				btnEskilstuna.setVisible(false);
				btnKarlstad.setVisible(false);
				btnHalmstad.setVisible(false);
				btnVäxjö.setVisible(false);
				btnSundsvall.setVisible(false);
				btnKiruna.setVisible(false);
				btnVisby.setVisible(false);
				btnFalun.setVisible(false);
				btnLuleå.setVisible(false);
				btnÖstersund.setVisible(false);
			}
		}
		
		//............................................................
		//Sätter alla landskap till synligt eller osynligt
		public void SynligaLandskap(boolean visible) {
			boolean v = visible;
			if (v == true) {
				btnLappland.setVisible(true);
				btnNorrbotten.setVisible(true);
				btnVästerbotten.setVisible(true);
				btnJämtland.setVisible(true);
				btnÅngermanland.setVisible(true);
				btnMedelpad.setVisible(true);
				btnHärjedalen.setVisible(true);
				btnHälsingland.setVisible(true);
				btnDalarna.setVisible(true);	
				btnGästrikland.setVisible(true);
				btnUppland.setVisible(true);
				btnVästmanland.setVisible(true);;
				btnVärmland.setVisible(true);
				btnSödermanland.setVisible(true);
				btnNärke.setVisible(true);
				btnDalsland.setVisible(true);
				btnÖstergötland.setVisible(true);
				btnVästergötland.setVisible(true);
				btnBohuslän.setVisible(true);
				btnSmåland.setVisible(true);;
				btnHalland.setVisible(true);
				btnBlekinge.setVisible(true);
				btnSkåne.setVisible(true);
				btnGotland.setVisible(true);
				btnÖland.setVisible(true);
			}
			else if (v == false) {
				btnLappland.setVisible(false);
				btnNorrbotten.setVisible(false);
				btnVästerbotten.setVisible(false);
				btnJämtland.setVisible(false);
				btnÅngermanland.setVisible(false);
				btnMedelpad.setVisible(false);
				btnHärjedalen.setVisible(false);
				btnHälsingland.setVisible(false);
				btnDalarna.setVisible(false);	
				btnGästrikland.setVisible(false);
				btnUppland.setVisible(false);
				btnVästmanland.setVisible(false);;
				btnVärmland.setVisible(false);
				btnSödermanland.setVisible(false);
				btnNärke.setVisible(false);
				btnDalsland.setVisible(false);
				btnÖstergötland.setVisible(false);
				btnVästergötland.setVisible(false);
				btnBohuslän.setVisible(false);
				btnSmåland.setVisible(false);;
				btnHalland.setVisible(false);
				btnBlekinge.setVisible(false);
				btnSkåne.setVisible(false);
				btnGotland.setVisible(false);
				btnÖland.setVisible(false);
			}
		}
		//............................................................
		//Slumpar en vektor som är 25 tal stor med olika tal i.
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
		//Ger tips om man har fem fel i rad på en stad/landskap
		//............................................................
		public void tips(){
			
			if (obj.getNummer() == 1){
				lblTips.setText("Lappland ligger i norra Sverige.");
			}
			else if (obj.getNummer() == 2){
				lblTips.setText("Norrbotten ligger i norra Sverige,\n bredvid Lappland.");
			}
			else if (obj.getNummer() == 3){
				lblTips.setText("Västerbotten ligger i norra Sverige,\n bredvid lappland.");
			}
			else if (obj.getNummer() == 4){
				lblTips.setText("Jämtland ligger väster om ångermanland \n och norr om härjedalen.");
			}
			else if (obj.getNummer() == 5){
				lblTips.setText("Ångermanland ligger söder om \n lappland  och öster om jämtland.");
			}
			else if (obj.getNummer() == 6){
				lblTips.setText("Medelpad ligger söder om ångermanland \n och norr om hälsingland.");
			}
			else if (obj.getNummer() == 7){
				lblTips.setText("Härjedalen ligger söder om jämtland \n och väster om hälsingland.");
			}
			else if (obj.getNummer() == 8){
				lblTips.setText("Hälsingland gränsar till dalarna.");
			}
			else if (obj.getNummer() == 9){
				lblTips.setText("Dalarna gränsar till värmland.");
			}
			else if (obj.getNummer() == 10){
				lblTips.setText("Gästrikland ligger på östkusten.");
			}
			else if (obj.getNummer() == 11){
				lblTips.setText("Uppland gränsar till västmanland.");
			}
			else if (obj.getNummer() == 12){
				lblTips.setText("Västmanland ligger väster om uppland \n och söder om dalarna.");
				
			}else if (obj.getNummer() == 13){
				lblTips.setText("Värmland ligger söder om dalarna \n och väster om närke.");
			}
			else if (obj.getNummer() == 14)	{
				lblTips.setText("Södermanland gränsar till uppland.");
			}
			else if (obj.getNummer() == 15){
				lblTips.setText("Närke ligger mellan värmland \n och södermanland.");
			}
			else if (obj.getNummer() == 16){
				lblTips.setText("Dalsland ligger norr om Bohuslän \n på Västkusten.");
			}
			else if (obj.getNummer() == 17){
				lblTips.setText("Östergötland ligger söder om \n södermanland på östkusten.");
			}
			else if (obj.getNummer() == 18){
				lblTips.setText("Västergötland gränsar till småland.");
			}
			else if (obj.getNummer() == 19){
				lblTips.setText("Bohuslän ligger på västkusten.");	
			}
			else if (obj.getNummer() == 20){
				lblTips.setText("Småland ligger i södra Sverige.");
			}
			else if (obj.getNummer() == 21){
				lblTips.setText("Halland ligger väster om småland \n och norr om skåne.");	
			}
			else if (obj.getNummer() == 22){
				lblTips.setText("Blekinge ligger i södra Sverige.");
			}
			else if (obj.getNummer() == 23){
				lblTips.setText("Skåne ligger långt Söderut.");
			}
			else if (obj.getNummer() == 24){
				lblTips.setText("Gotland är en ö.");
			}
			else if (obj.getNummer() == 25){
				lblTips.setText("Öland ligger sydväst om gotland.");
			}
			else if (obj.getNummer() == 26){
				lblTips.setText("Stockholm ligger på östkusten.");
			}
			else if (obj.getNummer() == 27){
				lblTips.setText("Göteborg ligger i halland.");
			}
			else if (obj.getNummer() == 28){
				lblTips.setText("Malmö ligger i södra Sverige.");
			}
			else if (obj.getNummer() == 29){
				lblTips.setText("Uppsala ligger nordväst om Stockholm.");
			}
			else if (obj.getNummer() == 30){
				lblTips.setText("Västerås ligger väster om Stockholm.");
			}
			else if (obj.getNummer() == 31){
				lblTips.setText("Örebro ligger väster om Stockholm.");
			}
			else if (obj.getNummer() == 32){
				lblTips.setText("Linköping ligger söder om Norrköping.");
			}
			else if (obj.getNummer() == 33){
				lblTips.setText("Helsingborg ligger i södra\n Sverige på västkusten.");
			}
			else if (obj.getNummer() == 34){
				lblTips.setText("Jönköping i småland.");
			}
			else if (obj.getNummer() == 35){
				lblTips.setText("Norrköping ligger i Östergötland.");
			}
			else if (obj.getNummer() == 36){
				lblTips.setText("Lund ligger i skåne.");
			}
			else if (obj.getNummer() == 37){
				lblTips.setText("Umeå ligger i västerbotten.");
			}
			else if (obj.getNummer() == 38){
				lblTips.setText("Gävle ligger i gästrikland.");
			}
			else if (obj.getNummer() == 39){
				lblTips.setText("Borås ligger Västergötland.");
			}
			else if (obj.getNummer() == 40){
				lblTips.setText("Kalmar ligger i södra\n sverige på östkusten.");
			}
			else if (obj.getNummer() == 41){
				lblTips.setText("Eskilstuna ligger väster om Stockholm.");
			}
			else if (obj.getNummer() == 42){
				lblTips.setText("Karlstad ligger norr om vänern.");
			}
			else if (obj.getNummer() == 43){
				lblTips.setText("Halmstad ligger i halland.");
			}
			else if (obj.getNummer() == 44){
				lblTips.setText("Växjö ligger i småland.");
			}
			else if (obj.getNummer() == 45){
				lblTips.setText("Sundsvall ligger norr om Gävle.");
			}
			else if (obj.getNummer() == 46){
				lblTips.setText("Kiruna ligger i Lappland.");
			}
			else if (obj.getNummer() == 47){
				lblTips.setText("Visby ligger på en ö.");
			}
			else if (obj.getNummer() == 48){
				lblTips.setText("Falun ligger väster om Gävle.");
			}
			else if (obj.getNummer() == 49){
				lblTips.setText("Luleå ligger norr om Umeå.");
			}
			else if (obj.getNummer() == 50){
				lblTips.setText("Östersund ligger i Jämtland.");
			}
		}
		
		//............................................................
		//Läser den första positionen i vektorn och hämtar det objektet
		public void nyttObjekt() {
			
			try	{	
			Scanner infil = new Scanner(new File("Sverige.txt"));					
				while (infil.hasNext())	{
					obj = new SverigeObjekt(infil);
						if (vektorSlump.get(posvektor) == (obj.getNummer())) {
							setVapen(obj.getNummer());
							lblFråga.setText("Tryck på " + obj.getNamn());
								break;
						}					
				}
			infil.close();
			}
			catch (FileNotFoundException a)	{
				System.out.println("Hittade ej filen");
			}
			
			if (vektorSlump.get(posvektor) > 0 && vektorSlump.get(posvektor) < 26){
				SynligaStäder(false);
				SynligaLandskap(true);	
			}
			else if (vektorSlump.get(posvektor) > 25 && vektorSlump.get(posvektor) < 51){
				SynligaStäder(true);
				SynligaLandskap(false);	
			}
			if (aktuellSida == "testet")
				lblfrågaNummer.setText("Fråga nummer " + frågaNummer + " av 25");
		}
		
		//............................................................
		//Kollar om man svarade rätt eller fel.
		public void check(){
			if (klickbara == true){
						
				if ((aktuellSida == "övaStäder") || (aktuellSida == "övaLandskap")){
					
					lblKlickade.setVisible(true);
/*					System.out.println("----------------");
					System.out.println("posvektor: " + posvektor);
					System.out.println("Stadsnummer: " + var);
					System.out.println("Slumptal :" + vektorSlump.get(posvektor));
*/					
					if (vektorSlump.get(posvektor) == var){
						lblrättSvar.setVisible(true);
						lblfelSvar.setVisible(false);
						posvektor++;
						antalFel = 0;
						lblTips.setVisible(false);
						//lblMaskotLiten.setVisible(false);
						lblPratbubblaTips.setVisible(false);
						lblTipsText.setVisible(false);
						
					}
					else{
						lblrättSvar.setVisible(false);
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
						lblrättSvar.setVisible(true);
						lblfelSvar.setVisible(false);
						antalPoäng++;
					}
					else{
						lblrättSvar.setVisible(false);
						lblfelSvar.setVisible(true);
					}
				frågaNummer++;
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
				btnÖva.setVisible(true);
				btnTest.setVisible(true);
			}
			else if (aktuellSida == "öva") {
				
				antalFel=0;
			 	lblText.setText("Välj ett alternativ och klicka på startknappen.");
			 	Osynligt();
			 	lblAvsluta.setVisible(true);
			 	lblBakåt.setVisible(true);
			 	lblMaskot.setVisible(true);
			 	lblPratbubblaÖvning.setVisible(true);
			 	lblText.setVisible(true);
				btnÖvaStäder.setVisible(true);
				btnÖvaLandskap.setVisible(true);
				lblÖvaStäder.setVisible(true);
				lblÖvaLandskap.setVisible(true);
				btnBak.setVisible(true);
				btnAvsluta.setVisible(true);
				btnStart.setVisible(true);
				radStäder.setVisible(true);
				radLandskap.setVisible(true);
				posvektor=0;
			}
			 else if (aktuellSida == "övaStäder") {
			 	lblText.setText("Här övar du på städer.");
			 	Osynligt();
			 	lblMaskotLiten.setVisible(true);
			 	lblBakåt.setVisible(true);
				lblAvsluta.setVisible(true);
			 	lblText.setVisible(true);
			 	lblFråga.setVisible(true);
			 	lblKlickade.setVisible(false);
				btnBak.setVisible(true);
				btnAvsluta.setVisible(true);
				lblKarta.setVisible(true);
				lblFråga.setVisible(true);
				SynligaStäder(true);	
			}
			else if (aktuellSida == "övaLandskap") {
			 	lblText.setText("Här övar du på landskap.");
			 	Osynligt();
			 	lblMaskotLiten.setVisible(true);
			 	lblBakåt.setVisible(true);
				lblAvsluta.setVisible(true);
			 	lblText.setVisible(true);
			 	lblFråga.setVisible(true);
			 	lblKlickade.setVisible(false);
				btnBak.setVisible(true);
				btnAvsluta.setVisible(true);
				lblKarta.setVisible(true);
				lblFråga.setVisible(true);
				SynligaLandskap(true);	
			}	
			else if (aktuellSida == "testsidan"){
				txtHighScore.setText(highscore.getList());
				lblText.setText("Klicka på knappen för att starta testet.");
			 	Osynligt();
			 	lblBakåt.setVisible(true);
				lblAvsluta.setVisible(true);
			 	lblMaskot.setVisible(true);
			 	lblPratbubblaTest.setVisible(true);
			 	btnHighscore.setVisible(true);
			 	btnBak.setVisible(true);
				btnAvsluta.setVisible(true);
				btnStartaTest.setVisible(true);
				txtHighScore.setVisible(true);
				posvektor=0;
				frågaNummer =1;
			}
			else if (aktuellSida == "testet"){
			 	lblText.setText("Testet:");
			 	Osynligt();
			 	lblfrågaNummer.setVisible(true);
				lblAvsluta.setVisible(true);
				lblBeskrivning.setVisible(true);
				btnAvsluta.setVisible(true);
				lblKarta.setVisible(true);
				lblFråga.setVisible(true);
				lblText.setVisible(true);
			}

		}
	//--------------------------------------------------------------------------
	public static void main(String[] args) {
		GUI gui = new GUI();
	}
}
