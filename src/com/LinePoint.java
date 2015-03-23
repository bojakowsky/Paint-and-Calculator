package com;

import java.awt.Point;

//Klasa przechowująca parametry punktu linii
public class LinePoint {

	public Point pos = null; //punkt
	public int stroke = 1; //grubość linii
    public boolean start = true; //czy punkt jest początkiem?
	public int begin;
    public LinePoint(Point p, boolean st){
    	pos = p;
    	start = st;
    }
    
    public LinePoint(Point p, boolean st, int str){
    	
    	pos = p;
    	start = st;
    	stroke = str;
    	
    }
    ////////////
    public void StartingPoint(Point p, int begin){
    	pos = p;
    	this.begin = begin;
    }
}
