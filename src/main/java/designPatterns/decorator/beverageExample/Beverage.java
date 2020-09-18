package designPatterns.decorator.beverageExample;

/** Class Beverage, a super class for two types of coffee drinks: Expresso and Decaf 
 * The code is from Head First Design Pattern book.
 *
 */
public abstract class Beverage {
	private String description = "Unknown Beverage";

	protected String getDescription() {
		return description;
	}

	protected void setDescription(String description) {
		this.description = description;
	}
 
	public abstract double cost();
	
}
