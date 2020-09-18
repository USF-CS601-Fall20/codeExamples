package designPatterns.decorator.beverageExample;


/** The decorator: adds Soy Milk to the Beverage
 *  The code is modified from Head First Design Pattern book.
 *
 */
public class BeverageWithSoyMilk extends CondimentDecorator {
	// Since it extends CondimentDecorator, it also extends Beverage
	// Super class  (CondimentDecorator) also stores an instance variable of type Beverage

	public BeverageWithSoyMilk(Beverage beverage) {
		setBeverage(beverage); //setting the value of instance variable from the super class
	}

	public String getDescription() {
		return getBeverage().getDescription() + ", Soy Milk";
	}

	public double cost() {
		return .15 + getBeverage().cost();
	}
}
