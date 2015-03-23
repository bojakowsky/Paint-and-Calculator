package com.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.text.ParseException;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.plaf.ToolBarUI;
import javax.swing.plaf.metal.MetalBorders.ToolBarBorder;

import com.gui.BracerParser;


class SimplyCalculator extends JPanel implements MouseMotionListener, MouseListener {
	private JTextField result = new JTextField(40);
	private JTextField memory = new JTextField(40);
	JPanel toolbox = new JPanel();
	String container = "";
	JToolBar toolbar1 = new JToolBar();
    JToolBar toolbar2 = new JToolBar();
    JToolBar toolbar3 = new JToolBar();
    JToolBar toolbar4 = new JToolBar();
    JToolBar toolbar5 = new JToolBar();
    JButton btn20 = null;
    Integer clicked =0;
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SimplyCalculator(JTextField field )
	{
		
        toolbox.setLayout(new BoxLayout(toolbox, BoxLayout.Y_AXIS));
		setBackground(Color.WHITE);
		setupMenu();
        add(toolbox, BorderLayout.WEST);
		toolbox.add(toolbar1);
		toolbox.add(toolbar2);
		toolbox.add(toolbar3);
		toolbox.add(toolbar4);
		toolbox.add(toolbar5);
		addMouseMotionListener(this);
		addMouseListener(this);
	}


	public void setupMenu(){
		java.net.URL imageURL = Canvas.class.getResource("images/0.png");
		ImageIcon icon = new ImageIcon(imageURL);
		JButton btn0 = new JButton(icon); 
		
		btn0.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String buf=result.getText();
				if (buf.length()>0){ 
						result.setText(result.getText()+"0");
				}
				else if (buf.length()==0){
					result.setText(result.getText()+"0.");
				}
			}	
		});
		
		
		imageURL = Canvas.class.getResource("images/1.png");
		icon = new ImageIcon(imageURL);
		JButton btn1 = new JButton(icon); 
		btn1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				result.setText(result.getText()+"1");
			}	
		});
		
		imageURL = Canvas.class.getResource("images/2.png");
		icon = new ImageIcon(imageURL);
		JButton btn2 = new JButton(icon); 
		btn2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				result.setText(result.getText()+"2");
			}	
		});
		
		imageURL = Canvas.class.getResource("images/3.png");
		icon = new ImageIcon(imageURL);
		JButton btn3 = new JButton(icon); 
		btn3.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				result.setText(result.getText()+"3");
			}	
		});
		
		imageURL = Canvas.class.getResource("images/4.png");
		icon = new ImageIcon(imageURL);
		JButton btn4 = new JButton(icon); 
		btn4.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				result.setText(result.getText()+"4");
			}	
		});
		
		
		imageURL = Canvas.class.getResource("images/5.png");
		icon = new ImageIcon(imageURL);
		JButton btn5 = new JButton(icon); 
		btn5.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				result.setText(result.getText()+"5");
			}	
		});
		
		imageURL = Canvas.class.getResource("images/6.png");
		icon = new ImageIcon(imageURL);
		JButton btn6 = new JButton(icon); 
		btn6.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				result.setText(result.getText()+"6");
			}	
		});
		
		imageURL = Canvas.class.getResource("images/7.png");
		icon = new ImageIcon(imageURL);
		JButton btn7 = new JButton(icon); 
		btn7.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				result.setText(result.getText()+"7");
			}	
		});
		
		
		imageURL = Canvas.class.getResource("images/8.png");
		icon = new ImageIcon(imageURL);
		JButton btn8 = new JButton(icon); 
		btn8.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				result.setText(result.getText()+"8");
			}	
		});
		
		
		imageURL = Canvas.class.getResource("images/9.png");
		icon = new ImageIcon(imageURL);
		JButton btn9 = new JButton(icon);
		btn9.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				result.setText(result.getText()+"9");
			}	
		});
		
		imageURL = Canvas.class.getResource("images/minus.png");
		icon = new ImageIcon(imageURL);
		JButton btn10 = new JButton(icon);
		btn10.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				container = result.getText();
				if (container.length()>0){
					memory.setText(memory.getText() + result.getText() + " - ");
					result.setText("");
				}
			}	
		});
		
		imageURL = Canvas.class.getResource("images/plus.png");
		icon = new ImageIcon(imageURL);
		JButton btn11 = new JButton(icon);
		btn11.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				container = result.getText();
				if (container.length()>0){
					memory.setText(memory.getText() + result.getText() + " + ");
					result.setText("");
				}
			}	
		});

		
		
		
		imageURL = Canvas.class.getResource("images/razy.png");
		icon = new ImageIcon(imageURL);
		JButton btn12 = new JButton(icon);
		btn12.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				container = result.getText();
				if (container.length()>0){
					memory.setText(memory.getText() + result.getText() + " * ");
					result.setText("");
				}
			}	
		});
		
		
		
		imageURL = Canvas.class.getResource("images/podzielic.png");
		icon = new ImageIcon(imageURL);
		JButton btn13 = new JButton(icon); 
		btn13.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				container = result.getText();
				if (container.length()>0){
					memory.setText(memory.getText() + result.getText() + " / ");
					result.setText("");
				}
			}	
		});
		
		
		imageURL = Canvas.class.getResource("images/plusminus.png");
		icon = new ImageIcon(imageURL);
		JButton btn14 = new JButton(icon); 
		btn14.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String bufor = result.getText();
				if (bufor.charAt(0)!='-'){
					result.setText("-"+result.getText());
				}
				else result.setText(bufor.substring(1));
			}	
		});
		
		
		imageURL = Canvas.class.getResource("images/jeden_przez_x.png");
		icon = new ImageIcon(imageURL);
		JButton btn15 = new JButton(icon); 
		btn15.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String bufor = result.getText();
				if (bufor.length()>0){
					Double x = Double.parseDouble(bufor);
					x = 1/x;
					result.setText(""+x);
				}
			}	
		});
		
		imageURL = Canvas.class.getResource("images/v.png");
		icon = new ImageIcon(imageURL);
		JButton btn16 = new JButton(icon); 
		btn16.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String bufor = result.getText();
				if (bufor.length()>0){
					Double x = Double.parseDouble(bufor);
					x = Math.sqrt(x);
					result.setText(""+x);
				}
			}	
		});
		
		imageURL = Canvas.class.getResource("images/wstecz.png");
		icon = new ImageIcon(imageURL);
		JButton btn18 = new JButton(icon); 
		btn18.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String bufor = result.getText();
				if (bufor.length()>0){
					bufor = bufor.substring(0,bufor.length()-1);
					result.setText(bufor);
				}
			}	
		});
		
		
		imageURL = Canvas.class.getResource("images/kropka.png");
		icon = new ImageIcon(imageURL);
		JButton btn17 = new JButton(icon); 
		btn17.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String bufor = result.getText();
				
				if (!bufor.contains(".") && bufor.length()==0)
					result.setText(result.getText()+"0.");
				else if (!bufor.contains("."))
					result.setText(result.getText()+".");
			}	
		});
		
		
		imageURL = Canvas.class.getResource("images/C.png");
		icon = new ImageIcon(imageURL);
		JButton btn19 = new JButton(icon); 
		btn19.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				result.setText("");
				memory.setText("");
				clicked = 0;
			}	
		});
		
		
		
		imageURL = Canvas.class.getResource("images/rowna.png");
		icon = new ImageIcon(imageURL);
		btn20 = new JButton(icon);
		btn20.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if (clicked==0)
					memory.setText(memory.getText() + result.getText());
				else memory.setText(memory.getText());
				container = memory.getText();
				clicked++;
				if (container.length()>0){
					result.setText("");
					Double wynik;
					StringTokenizer tokenizer = new StringTokenizer(memory.getText());
					if (tokenizer.countTokens()%2==1){
						wynik = Double.parseDouble(tokenizer.nextToken());
						while(tokenizer.hasMoreTokens()){
							String bufor = tokenizer.nextToken();
							if (bufor.equals("*")){
								bufor = tokenizer.nextToken();
								wynik = wynik * Double.parseDouble(bufor);
								continue;
							}
							else if (bufor.equals("/")){
								bufor = tokenizer.nextToken();
								wynik = wynik / Double.parseDouble(bufor);
								continue;
							}
							else if (bufor.equals("+")){
								bufor = tokenizer.nextToken();
								wynik = wynik + Double.parseDouble(bufor);
								continue;
							}
							else if (bufor.equals("-")){
								bufor = tokenizer.nextToken();
								wynik = wynik * Double.parseDouble(bufor);
								continue;
							}
							
						}
						container = "" + wynik;
						result.setText(container);
					}
				
				}
			}	
		});
		
		
		toolbar1.setAlignmentX(0);
		toolbar2.setAlignmentX(0);
		toolbar3.setAlignmentX(0);
		toolbar1.add(btn0);
		toolbar1.add(btn1);
		toolbar1.add(btn2); 
		toolbar1.add(btn3); 
		toolbar1.add(btn4); 
		toolbar1.add(btn5); 
		toolbar1.add(btn6); 
		toolbar1.add(btn7); 
		toolbar1.add(btn8);
		toolbar2.add(btn9);
		toolbar2.add(btn10);
		toolbar2.add(btn11);
		toolbar2.add(btn12);
		toolbar2.add(btn13);
		toolbar2.add(btn14);
		toolbar2.add(btn15);
		toolbar2.add(btn16);
		toolbar2.add(btn17);
		toolbar3.add(btn18);
		toolbar3.add(btn19);
		toolbar3.add(btn20);
		toolbar3.add(result);
		toolbar4.add(memory);
		toolbar4.setAlignmentX(0);
		result.disable();
		memory.disable();
		
		
	
		
	}


	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
} 
