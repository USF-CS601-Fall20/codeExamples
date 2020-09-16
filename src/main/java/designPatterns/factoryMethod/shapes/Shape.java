package designPatterns.factoryMethod.shapes;

import java.text.DecimalFormat;

/** An interface Shape.  */
interface Shape {
	public final DecimalFormat df = new DecimalFormat("#.00");

	/**
	 * An abstract method for computing the area or the surface area of the
	 * shape.
	 * 
	 * @return area of the shape
	 */
	double area();

	String toString();

}
