package FiguresDatabase;
import java.awt.Graphics;
import java.awt.Point;
import java.io.ObjectInputStream.GetField;

public class Line extends Shape {
	int a;
	int b;
	int c;
	int d;
	public Line(int a, int b, int c, int d){
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}
	
	public Point starting_point;
	public Point ending_point;

	public void draw(Graphics g,int x1,int y1,int x2,int y2){
		g.drawLine(x1, y1, x2, y2);
	}
	
}


