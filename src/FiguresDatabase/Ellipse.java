package FiguresDatabase;

import java.awt.Graphics;
import java.awt.Point;

public class Ellipse extends Shape {
	Double length_a;
	Double length_b;
	Double x;
	Double y = 0d;
	public Ellipse(String name, Double length_a, Double length_b){
		super(name);
		this.length_a = length_a;
		this.length_b = length_b;
		this.x = length_a;
	}
	@Override
	public Double getPerimeter() {
		// TODO Auto-generated method stub
		return 3.1415*(3/2*(length_a+length_b)-Math.sqrt(length_a*length_b));
	}
	@Override
	public Double getArea() {
		// TODO Auto-generated method stub
		return length_a*length_b*3.1415;
	}
	public boolean if_contain(double x, double y){
		if (this.x==x && this.y==y) return true;
		else return false;
	}
	///////////////
	public Point starting_point;
	public Point ending_point;
	public void draw(Graphics g, int x1, int y1, int x2, int y2){
		if (x1<x2&&y1<y2){
			g.drawOval(x1, y1, x2-x1, y2-y1);

		}
		if (x1>x2&&y1>y2)
		{
			g.drawOval(x2, y2,x1-x2, y1-y2);
			
		}
		if (x1>x2&&y1<y2){
			g.drawOval(x2, y1,x1-x2, y2-y1);
			
		}
		else{
			g.drawOval(x1,y2,x2-x1,y1-y2);
			
		}
	}
	
}
