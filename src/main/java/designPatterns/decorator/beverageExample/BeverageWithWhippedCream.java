package designPatterns.decorator.beverageExample;

/** The decorator: adds Whipped cream to the Beverage
 *  The code is modified from the Head First Design Pattern book.
 *
 */
public class BeverageWithWhippedCream extends CondimentDecorator {
	// Since it extends CondimentDecorator, it also extends Beverage
	// Super class (CondimentDecorator) also stores an instance variable of type Beverage

	public BeverageWithWhippedCream(Beverage beverage) {
		this.setBeverage(beverage); //setting the value of instance variable from the super class
	}
 
	public String getDescription() {
		return getBeverage().getDescription() + ", Whipped cream";
	}
 
	public double cost() {
		return .10 + getBeverage().cost();
	}
}
