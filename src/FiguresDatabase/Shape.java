package FiguresDatabase;

import java.awt.Graphics;
import java.awt.Point;

public class Shape {
	protected String name;
	public Point starting_point;
	public Point ending_point;
	Double x = 0d;
	Double y = 0d;
	public Shape(){
		this.name = ":)";
	}
	public Shape(String name){
		this.name = name;
	}
	public Double getPerimeter(){
		return 0d;
	}
	public Double getArea(){
		return 0d;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean if_contain(double x, double y){
		if (this.x==x && this.y==y) return true;
		else return false;
	}
	public void draw(Graphics g, int x1, int y1, int x2, int y2){
	}
	
}
