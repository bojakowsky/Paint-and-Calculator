package FiguresDatabase;

import java.awt.Graphics;
import java.awt.Point;

public class Rectangle extends Shape {
	Double width;
	Double height;
	Double x;
	Double y = 0d;
	public Rectangle(String name,Double width, Double height){
		super(name);
		this.width = width;
		this.height = height;
		this.x = width;
	}
	@Override
	public Double getPerimeter() {
		// TODO Auto-generated method stub
		return 2*width + 2*height;
	}
	@Override
	public Double getArea() {
		// TODO Auto-generated method stub
		return width * height;
	}
	public boolean if_contain(double x, double y){
		if (this.x==x && this.y==y) return true;
		else return false;
	}
	////////////////////////
	public Point starting_point;
	public Point ending_point;
	public void draw(Graphics g, int x1, int y1, int x2, int y2){
		g.drawLine(x1, y1, x2, y1);
		g.drawLine(x1, y1, x1, y2);
		g.drawLine(x2,y1,x2,y2);
		g.drawLine(x1,y2,x2,y2);
	
	}
	
}
