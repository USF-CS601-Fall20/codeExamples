package designPatterns.factoryMethod.shapes;

// From https://www.tutorialspoint.com/design_pattern/factory_pattern.htm
public class ShapeFactory {

	// use getShape method to get object of type shape
	public Shape getShape(String shapeType) {
		if (shapeType == null) {
			return null;
		}
		if (shapeType.equalsIgnoreCase("Circle")) {
			return new Circle();

		} else if (shapeType.equalsIgnoreCase("Convex_Regular_Polygon")) {
			return new ConvexRegularPolygon();

		} else if (shapeType.equalsIgnoreCase("Parallelogram")) {
			return new Parallelogram();
		}

		return null;
	}
}