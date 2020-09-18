package designPatterns.decorator.beverageExample;

/**  The code is from Head First Design Pattern book.
 *   Super class for all decorators. Extends Beverage and stores Beverage as an instance variable.
 */
public abstract class CondimentDecorator extends Beverage {
	private Beverage beverage;

	protected Beverage getBeverage() {
		return beverage;
	}
	protected void setBeverage(Beverage beverage) {
		this.beverage = beverage;
	}

	// inherits getDescription() and cost() methods from Beverage
}
