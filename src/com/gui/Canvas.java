package com.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTextField;

import com.DrawingsMade;
import com.LinePoint;

import FiguresDatabase.*;
//klasa implementuje interfejsy MouseMotionListener oraz MouseListener
//w celu przechwytywania zdarzeń związanych z myszą
public class Canvas extends JPanel implements MouseMotionListener, MouseListener {
    public Boolean [] active = new Boolean[5];
    
	private Color black = new Color(0, 0, 0);

	private JTextField edit = null;
	
	private List<LinePoint> el = null;
	
	private Point starting_pos = null;
	private Point ending_pos = null;
	private DrawingsMade drawings = new DrawingsMade();

	
	//pole tekstowe jako parametr w celu pobrania grubości linii
	//niezbyt ładne rozwiązanie, ale wprowadzenie singletonów mogło utrudnić odbiór kodu
	
	
	public void setActive(int j){
		for (int i = 0 ; i < 5 ; i++){
			if (i == j) active[j] = Boolean.TRUE;
			else active[i] = Boolean.FALSE;
		} 
	}
	
	public Canvas(JTextField field){
		
		edit = field;
		el = new ArrayList<>();
		
		setBackground(Color.WHITE); //ustawienie białego tła
		
		//klasa może nasłuchiwać poniższych zdarzeń, gdyż implementuje odpowiednie interfejsy
		addMouseMotionListener(this); //przechwytywanie zdarzeń związanych z ruchem kursora
		addMouseListener(this); //przechwytywanie zdarzeń związanych z pojedyńczymi akcjami myszy
		
		active[0] = Boolean.TRUE;
		
	}
	
	//metoda czyszcząca płótno
	public void clear(){
		
		//czyszczenie bufora
	    el.clear();
	    drawings.clear();
	    //aktualizacja komponentu
		repaint();
	}
	//Tutaj zainicjalizowane zostana klasy, oraz wypisane
	public Square square = new Square ("Kwadrat",15d);
	public Triangle triangle = new Triangle("x",1d,1d,1d,1d);
	public Rectangle rectangle = new Rectangle ("x",3d,2d);
	public Ellipse ellipse = new Ellipse("x",3d,2d);
	public Circle circle = new Circle ("x",1d);
	public Line line = new Line(1,1,1,1);
	
	
	//metoda rysująca wywoływana przy każdorazowym wywołaniu metody repaint()
	@Override
	public void paintComponent(Graphics gr){
		super.paintComponent(gr);
		Graphics2D g = (Graphics2D)gr; //pobranie bardziej zaawansowanego obiektu rysującego
		//ustawienie wygładzania
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		//ustawienie koloru
		g.setColor(black);
		
		//rysowanie linii z bufora
		//bufor musi być użyty, gdyć przy każdorazowym wywołaniu metody super.paintComponent()
		//zawartość panelu jest czyszczona
		drawings.DrawShapes(g);
			Point last = null;
			for(LinePoint p : el){
				g.setStroke(new BasicStroke(p.stroke)); //ustawienie grubości linii
				//jeżeli punkt jest startowy to linia nie jest rysowana
				if(last!=null && p.start != true){
					g.drawLine(last.x, last.y, p.pos.x, p.pos.y);
				}
			last = p.pos;
			}
		
		if (active[2]==Boolean.TRUE) 
			square.draw(g,starting_pos.x,starting_pos.y,ending_pos.x,ending_pos.y);
		else if (active[3]==Boolean.TRUE) 
			triangle.draw(g,starting_pos.x,starting_pos.y,ending_pos.x,ending_pos.y);
		else if (active[4]==Boolean.TRUE)
			circle.draw(g,starting_pos.x,starting_pos.y,ending_pos.x,ending_pos.y);
		else if (active[1]==Boolean.TRUE) 
			line.draw(g,starting_pos.x,starting_pos.y,ending_pos.x,ending_pos.y);
			
		
			
			
			
		
		
	}
	
	//metoda wspomagająca pobieranie grubości linii z pola tekstowego
	//w przypadku nieprawidłowej wartości jako grubość linii przyjmowane jest 1
	public Integer getLineWidth(){
		
		String s = edit.getText();
		Integer val;
		
		try{
		    val = Integer.valueOf(s);
		} catch(NumberFormatException e){
		    val = 1;
		}
		    
	    return val;
	}

	//metoda interfejsu MouseMotionListener
	//wywoływana podczas poruszania kursorem z jednoczesnym wciśnięciem przyciku myszy
	@Override
	public void mouseDragged(MouseEvent e) {
		
		//dodanie punktu do bufora wraz z grubością
		if (active[0]==Boolean.TRUE){
			el.add(new LinePoint(e.getPoint(), false, getLineWidth()));
			repaint();
		}
		
		//ponowne rysowanie panelu
	    //repaint();
	}

	//metoda interfejsu MouseMotionListener
	@Override
	public void mouseMoved(MouseEvent e) {
	    
	}

	//metoda interfejsu MouseListener
	@Override
	public void mouseClicked(MouseEvent e) {
	    
	}

	//metoda interfejsu MouseListener
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	//metoda interfejsu MouseListener
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	//metoda interfejsu MouseListener
	//wywoływana po wciśnięciu przycisku myszy
	@Override
	public void mousePressed(MouseEvent e) {
		//poinformowanie, że zdarzenie zostanie obsłużone
		e.consume();
		
		//dodanie punktu do bufora wraz z grubością i oznaczenie go jako początek
		if (active[0]==Boolean.TRUE){
			el.add(new LinePoint(e.getPoint(), true, getLineWidth()));
		}
		starting_pos = e.getPoint();
	}

	//metoda interfejsu MouseListener
	@Override
	public void mouseReleased(MouseEvent e) {
		ending_pos = e.getPoint();
		if (active[1]==Boolean.TRUE){
			drawings.add(line,starting_pos,ending_pos);
		}
		else if (active[2]==Boolean.TRUE){
			drawings.add(square,starting_pos,ending_pos);
		}
		else if (active[3]==Boolean.TRUE){
			drawings.add(triangle,starting_pos,ending_pos);
		}
		else if (active[4]==Boolean.TRUE){
			drawings.add(circle,starting_pos,ending_pos);
			
		}
		repaint();
		
	}
	
}
