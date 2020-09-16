package designPatterns.factoryMethod.shapes;

public class Circle implements Shape {
	private double radius;
	
	public Circle() {
		radius = 1.0;
	}
	
	public double getRadius() {
		return radius;
	}
	
	

	@Override
	public double area() {
		System.out.println(Math.PI*radius*radius);
		return Math.PI*radius*radius;
	}

	
}
