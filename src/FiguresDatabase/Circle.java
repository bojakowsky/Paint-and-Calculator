package FiguresDatabase;

import java.awt.Graphics;
import java.awt.Point;

public class Circle extends Ellipse {
	Double x ;
	Double y = 0d;
	public Circle(String name, Double radius) {
		super(name, radius, radius);
		this.x = length_a;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Double getPerimeter() {
		// TODO Auto-generated method stub
		return 2*3.1415*length_a;
	}

	@Override
	public Double getArea() {
		// TODO Auto-generated method stub
		return 3.1415*length_a*length_b;
	}
	public boolean if_contain(double x, double y){
		if (this.x==x && this.y==y) return true;
		else return false;
	}
	/////////////////
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
