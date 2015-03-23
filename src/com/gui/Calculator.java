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


class Calculator extends JPanel implements MouseMotionListener, MouseListener {
	private JTextField edit = new JTextField(40);
	private JTextField result = new JTextField(40);
	JPanel toolbox = new JPanel();
	JToolBar toolbar1 = new JToolBar();
    JToolBar toolbar2 = new JToolBar();
    JToolBar toolbar3 = new JToolBar();
    JToolBar toolbar4 = new JToolBar();
    JToolBar toolbar5 = new JToolBar();
    JButton btn17 = new JButton(" Oblicz ");
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Calculator(JTextField field ) throws ParseException 
	{
		
        toolbox.setLayout(new BoxLayout(toolbox, BoxLayout.Y_AXIS));
		setBackground(Color.WHITE);
		addMouseMotionListener(this);
		addMouseListener(this);
		
		setupMenu();
        add(toolbox, BorderLayout.WEST);
		//toolbox.add(toolbar1);
		//toolbox.add(toolbar2);
		toolbox.add(toolbar3);
		toolbox.add(toolbar4);
		toolbox.add(toolbar5);
		// TODO Auto-generated method stub
				btn17.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
						BracerParser parser = new BracerParser(3);
						try {
							parser.parse(edit.getText());
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							result.setText(parser.evaluate());
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}	
				});
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@SuppressWarnings("deprecation")
	public void setupMenu() throws ParseException{
		/*
		java.net.URL imageURL = Canvas.class.getResource("images/1.png");
		ImageIcon icon = new ImageIcon(imageURL);
		JButton btn = new JButton(icon); 
		imageURL = Canvas.class.getResource("images/2.png");
		icon = new ImageIcon(imageURL);
		JButton btn2 = new JButton(icon); 
		imageURL = Canvas.class.getResource("images/3.png");
		icon = new ImageIcon(imageURL);
		JButton btn3 = new JButton(icon); 
		imageURL = Canvas.class.getResource("images/4.png");
		icon = new ImageIcon(imageURL);
		JButton btn4 = new JButton(icon); 
		imageURL = Canvas.class.getResource("images/5.png");
		icon = new ImageIcon(imageURL);
		JButton btn5 = new JButton(icon); 
		imageURL = Canvas.class.getResource("images/6.png");
		icon = new ImageIcon(imageURL);
		JButton btn6 = new JButton(icon); 
		imageURL = Canvas.class.getResource("images/7.png");
		icon = new ImageIcon(imageURL);
		JButton btn7 = new JButton(icon); 
		imageURL = Canvas.class.getResource("images/8.png");
		icon = new ImageIcon(imageURL);
		JButton btn8 = new JButton(icon); 
		imageURL = Canvas.class.getResource("images/9.png");
		icon = new ImageIcon(imageURL);
		JButton btn9 = new JButton(icon); 
		imageURL = Canvas.class.getResource("images/0.png");
		icon = new ImageIcon(imageURL);
		JButton btn0 = new JButton(icon);
		imageURL = Canvas.class.getResource("images/minus.png");
		icon = new ImageIcon(imageURL);
		JButton btn11 = new JButton(icon);
		imageURL = Canvas.class.getResource("images/plus.png");
		icon = new ImageIcon(imageURL);
		JButton btn12 = new JButton(icon);
		imageURL = Canvas.class.getResource("images/razy.png");
		icon = new ImageIcon(imageURL);
		JButton btn13 = new JButton(icon);
		imageURL = Canvas.class.getResource("images/podzielic.png");
		icon = new ImageIcon(imageURL);
		JButton btn14 = new JButton(icon);
		imageURL = Canvas.class.getResource("images/dopotegi.png");
		icon = new ImageIcon(imageURL);
		JButton btn15 = new JButton(icon);
		imageURL = Canvas.class.getResource("images/pierwiastek.png");
		icon = new ImageIcon(imageURL);
		JButton btn16 = new JButton(icon);
		
		JButton btn18 = new JButton(" C ");
		btn18.setFont(sizedFont);
		toolbar1.setAlignmentX(0);
		toolbar2.setAlignmentX(0);
		toolbar3.setAlignmentX(0);
		toolbar1.add(btn); 
		toolbar1.add(btn2); 
		toolbar1.add(btn3); 
		toolbar1.add(btn4); 
		toolbar1.add(btn5); 
		toolbar1.add(btn6); 
		toolbar1.add(btn7); 
		toolbar2.add(btn8);
		toolbar2.add(btn9);
		toolbar2.add(btn0);
		toolbar2.add(btn11);
		toolbar2.add(btn12);
		toolbar3.add(btn13);
		toolbar3.add(btn14);
		toolbar3.add(btn15);
		toolbar3.add(btn16);
		toolbar3.add(btn17);
		toolbar3.add(btn18);
		*/
		Font sizedFont = new Font("Arial", Font.BOLD, 30);
		btn17.setFont(sizedFont);
		
	
		toolbar3.add(edit);
		edit.setText("((3+4)*5/5)*3*cos(0)");
		toolbar4.add(result);
		toolbar5.add(btn17);
		result.disable();
	
	}
} 
