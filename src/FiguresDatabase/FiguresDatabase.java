package FiguresDatabase;

import java.util.ArrayList;

public class FiguresDatabase {
	ArrayList<Shape> arr = new ArrayList<Shape>();
	public void add_figure(Shape x){
		arr.add(x);
	}
	public void read_from_list(){
		for (Shape figure : arr) {
			System.out.println(figure.getName());
			System.out.printf("Perimeter: %3f\n",figure.getPerimeter());
			System.out.printf("Area: %3f\n",figure.getArea());
		}	
	}
	public void find_shapes_containing_x_y (Double x, Double y){
		System.out.printf("Figury zawierajace podany x: %3f i y: %3f \n",x,y);
		for (Shape figure : arr){
			if (figure.if_contain(x, y)) System.out.println(figure.getName());
			else System.out.println("--");
		}
	}
	
	
	
}
