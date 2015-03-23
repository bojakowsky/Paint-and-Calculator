package FiguresDatabase;

import java.awt.Graphics;
import java.awt.Point;

public class Triangle extends Rectangle {
	Double side_b;
	Double side_c;
	Double x ;
	Double y = 0d;
	public Triangle(String name, Double width,Double height, Double side_b, Double side_c) {
		super(name, width, height);
		this.x = width;
		this.side_b = side_b;
		this.side_c = side_c;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Double getPerimeter() {
		// TODO Auto-generated method stub
		return side_b + side_c + width;
	}

	@Override
	public Double getArea() {
		// TODO Auto-generated method stub
		return width * height / 2;
	}
	public boolean if_contain(double x, double y){
		if (this.x==x && this.y==y) return true;
		else return false;
	}
	/////////////////////////////////
	public Point starting_point;
	public Point ending_point;
	public void draw(Graphics g, int x1, int y1, int x2, int y2){
		if (x1<x2 && y1<y2){
			g.drawLine(x1, y2, x2, y2);
			g.drawLine(x1, y2, (x2+x1)/2, y1);
			g.drawLine(x2, y2, (x1+x2)/2, y1);
			
		}
		else if (x1>x2&&y1<y2){
			g.drawLine(x1, y2, x2, y2);
			g.drawLine(x1,y2,(x2+x1)/2,y1);
			g.drawLine(x2, y2, (x2+x1)/2, y1);
		}
		else {
			g.drawLine(x1, y1,x2, y1);
			g.drawLine((x2+x1)/2, y2,x2, y1);
			g.drawLine((x1+x2)/2, y2,x1, y1);
		}
		
	}

}
