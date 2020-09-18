package designPatterns.decorator.beverageExample;

/** The example demonstrates how to use the Decorator pattern.
 *  The code is from Head First Design Pattern book.
 *
 */
public class Decaf extends Beverage {
	public Decaf() {
		setDescription("Decaf Coffee");
	}

	@Override
	public double cost() {
		return 1.05;
	}
}

