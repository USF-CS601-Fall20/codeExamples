package designPatterns.factoryMethod.shapes;

public class Parallelogram implements Shape {
	private double a, b, angle;

	// angle in radians
	Parallelogram() {
		this.a = 1.0;
		this.b = 1.0;
		this.angle = 90;
	}


	@Override
	public double area() {
		// find height
		double height = b * Math.sin(angle);
		System.out.println(a*height);
		return a * height;
	}
	
}
