package designPatterns.factoryMethod.shapes;

public class ConvexRegularPolygon implements Shape {

	private int numSides; // the number of sides
	private double side; // the length of the side

	public ConvexRegularPolygon() {
		this.numSides = 3;
		side = 1.0;
	}

	@Override
	public double area() {
		// Use formula from https://en.wikipedia.org/wiki/Regular_polygon#Area
		double val = Math.PI / numSides;
		double cot = (Math.cos(val) / Math.sin(val));
		double ar = 0.25 * numSides * side * side * cot;
		// return 0;
		System.out.println(ar);
		return ar;
	}

}
