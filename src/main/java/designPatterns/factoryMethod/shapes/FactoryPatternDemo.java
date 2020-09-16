package designPatterns.factoryMethod.shapes;

public class FactoryPatternDemo {

	   public static void main(String[] args) {
	      ShapeFactory shapeFactory = new ShapeFactory();

	      //get an object of Circle and call its draw method.
	      Shape shape1 = shapeFactory.getShape("CIRCLE");

	      //call area method of Circle
	      shape1.area();

	      //get an object of Rectangle and call its draw method.
	      Shape shape2 = shapeFactory.getShape("Convex_Regular_Polygon");

	      //call area s method of Rectangle
	      shape2.area();

	      //get an object of Square and call its draw method.
	      Shape shape3 = shapeFactory.getShape("Parallelogram");

	      //call draw method of circle
	      shape3.area();
	   }
	}