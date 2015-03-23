package com;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import FiguresDatabase.*;

public class DrawingsMade {
	
	public Point [] p = new Point[1000];
	public Point [] e = new Point[1000];
	int iterator = 0;
	public ArrayList<Shape> arr = new ArrayList<Shape>();
	public void add(Shape x, Point starting, Point ending){
		arr.add(x);
		p[iterator] = starting;
		e[iterator] = ending;
		iterator++;
	}
	public void DrawShapes(Graphics g){
		int j=0;
		for (Shape x : arr){
			x.draw(g, p[j].x, p[j].y, e[j].x, e[j].y);
			j++;
		}
	}
	
	public void clear(){
		arr.clear();
		iterator=0;
	}
	
	
	
	
}
