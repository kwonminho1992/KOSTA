package shape;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangle rectangle = new Rectangle(3, 4); // create object has length = 3, height = 4
		rectangle.print(); //print "Rectangle (length = 3, height = 4)"
		
		rectangle.calculateArea(); //calculate the area of rectangle
		int area = rectangle.getArea(); // get the area of rectangle
		System.out.println("area : " + area); //print the area of the rectangle
	}

}

/**
 * A class to deal with rectangle
 * @author Kwon Minho
 *
 */
class Rectangle {
	int length;
	int height;
	int area;
	
	/**
	 * 
	 * @param length : length of rectangle
	 * @param height : height of rectangle
	 */
	//create constructor
	public Rectangle (int length, int height) {
		this.length = length;
		this.height = height;
	}
	//create this constructor (square)
	public Rectangle (int size) {
		this (size, size);
	}
	
	/**
	 * print length and height of the rectangle
	 */
	public void print () {
		System.out.println("Rectangle (length = " + this.length + ", height = " + this.height + ")");
	}
	
	/**
	 * @return calculate the area of the rectangle (length * height)
	 */
	public int calculateArea() {
		area = this.length * this.height;
		return area;
	}
	
	/*
	 * get result - the area of rectangle 
	 */
	public int getArea() {
		return area;
	}
}