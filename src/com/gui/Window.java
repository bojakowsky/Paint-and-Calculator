package com.gui;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;


public class Window extends JFrame {
	JPanel toolbox = new JPanel();
	Canvas canvas = null;
	JTextField edit = null;
	JMenuBar menu = null;
	JTabbedPane tab = null;
	JTabbedPane jtp = new JTabbedPane( ); 
	Calculator calc = null;
	SimplyCalculator calc1 = null;
	public Window() throws ParseException{
		
		setTitle("SimplePaint"); //tytuł okna
		setSize(600, 600); //rozmiar okna
		
		//okno zostanie zamknięte, domyślnie byłoby ukryte:
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		
		//dodanie layoutu do okna
		setLayout(new BorderLayout());
		
		
		//inicjalizacja menu
		setupMenu();
		
		//inicjalizacja paska narzędzi
		setupToolbox();
		
		setJMenuBar(menu);
		
		
		//dodanie panelu na górze okna
	    add(toolbox, BorderLayout.PAGE_START);
	   
	    //inicjalizacja klasy Canvas, przekazanie pola tekstowego jako argumentu w celu pobrania grubości linii
	    canvas = new Canvas(edit);
	    //dodanie płótna na środku okna
		add(canvas, BorderLayout.CENTER);
		
		calc = new Calculator(edit);
		add(calc,BorderLayout.WEST);
		
		calc1 = new SimplyCalculator(edit);
		add(calc1,BorderLayout.WEST);
		//utworzenie obiektu nasłuchującego zdarzenia okna
		WindowListener adapter = new WindowAdapter(){
			
			
			@Override
			public void windowClosing(WindowEvent e){
				//wyświetlenie okna dialogowego
				int ret = JOptionPane.showOptionDialog(Window.this, "Zamknąć?",
						                               "Potwierdź zamknięcie", 
						                               JOptionPane.YES_NO_OPTION,
						                               JOptionPane.QUESTION_MESSAGE, null, null, null);
			    if(ret == JOptionPane.YES_OPTION)
			    	Window.this.dispose(); //zamknięcie okna
			    
			    
			}
			
		};
		
		//dodanie nasłuchu do okna
		addWindowListener(adapter);	
		setVisible(true); //wyświetlenie okna
		
		/////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////
		jtp.addTab("<html><font color=red>Paint</font>", canvas);
		jtp.addTab("<html><font color=green>Calculator</font>", calc); 
		jtp.addTab("<html><font color=blue>Calculator</font>", calc1); 
		add(jtp);
		////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////
	}

	
	


	private void setupToolbox(){

		//utworzenie przycisku rysowania linii"
		java.net.URL imageURL = Canvas.class.getResource("images/line.png");
		ImageIcon icon = new ImageIcon(imageURL);
		JButton line = new JButton(icon);
		//przypisanie akcji do przycisku
		line.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				canvas.setActive(1);
			}
			
		});
		
		//utworzenie przycisku rysowania kwadratu/prostokata
		imageURL = Canvas.class.getResource("images/square.png");
		icon = new ImageIcon(imageURL);
		JButton square = new JButton(icon);
		
		//przypisanie akcji do przycisku
		square.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				canvas.setActive(2);
			}
			
		});
		
		
		//utworzenie przycisku trojkata
		imageURL = Canvas.class.getResource("images/triangle.png");
		icon = new ImageIcon(imageURL);
		JButton triangle = new JButton(icon);
		
		//przypisanie akcji do przycisku
		triangle.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				canvas.setActive(3);
			}
			
		});
		
		//utworz przycisk kolo
		imageURL = Canvas.class.getResource("images/circle.png");
		icon = new ImageIcon(imageURL);
		JButton circle = new JButton(icon);
		//przypisanie akcji do przycisku
		circle.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				canvas.setActive(4);
			}	
		});
		////utworz przycisk rysowanie olowkiem
		imageURL = Canvas.class.getResource("images/pen.png");
		icon = new ImageIcon(imageURL);
		JButton pen = new JButton(icon);
		//przypisanie akcji do przycisku
		pen.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				canvas.setActive(0);
			}	
		});
		toolbox.add(circle);
		toolbox.add(triangle);
		toolbox.add(square);
		toolbox.add(line);
		toolbox.add(pen);
		//utworzenie przycisku z tekstem "Wyczyść"
		JButton b = new JButton("Wyczyść");
		
		//przypisanie akcji do przycisku
		b.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				canvas.clear();
				canvas.setActive(0);
			}
			
		});
		toolbox.add(b);
		
		//inicjalizacja pola tekstowego o długości 4 z zawartością "1"
		edit = new JTextField("1", 4);
		toolbox.add(edit);
	}
	
	private void setupMenu(){
	
		//utworzenie paska menu
		menu = new JMenuBar();
		
		//utworzenie menu
        JMenu m = new JMenu("Plik");
        JMenu x = new JMenu("About");
        //utworzenie elementu w menu
        JMenuItem item = new JMenuItem("Zamknij");
        JMenuItem item1 = new JMenuItem("Wyjasnienie");
        //ustawienie skrótu klawiszowego Ctrl+Q
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_MASK));
        
        //przypisanie akcji do elementu
        item.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				//przekazanie do okna zdarzenia zamknięcia
				dispatchEvent(new WindowEvent(Window.this, WindowEvent.WINDOW_CLOSING));
			}
        	
        });
        item1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				//default title and icon
				JOptionPane.showMessageDialog(edit,
				    "Zadanie 1: mozliwosc rysowania ksztaltow o okreslonych \n"
				   +"wymiarach, panel rysowania celowo zostal zostawiony na gorze.\n"
				   +"Zadanie 2: utworzylem 2 kalkulatory, jeden z wykorzystaniem\n"
				   +"implementacji algorytmu Dijikstry (autor: Dmytro Titov) wraz z dolaczona biblioteka\n"
				   +"apache.org.math3, a drugi nastawiony na obsluge zdarzen myszy,\n"
				   + "parser obsluguje jedynie znaki podstawowe, bez funkcji\n"
				   +"autor: Krzysztof Bojakowski");
			}
        	
        });
		
        //dodanie elementu do menu
        m.add(item);
        x.add(item1);
        //dodanie menu do paska
        menu.add(m);
        menu.add(x);
        
	}
	
	
}
