package designPatterns.decorator.beverageExample;

/** The example demonstrates how to use the Decorator pattern.
 *  The code is from Head First Design Pattern book.
 *
 */
public class Espresso extends Beverage {
  
	public Espresso() {
		setDescription("Espresso");
	}

	@Override
	public double cost() {
		return 1.99;
	}
}

