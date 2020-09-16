package designPatterns.factory.pizzaaf;

public abstract class Pizza {
	private String name;

	private Dough dough;
	private Sauce sauce;
	private Veggies veggies[];
	private Cheese cheese;
	private Pepperoni pepperoni;

	abstract void prepare();

	void bake() {
		System.out.println("Bake for 25 minutes at 350");
	}

	void cut() {
		System.out.println("Cutting the pizza into diagonal slices");
	}

	void box() {
		System.out.println("Place pizza in official PizzaStore box");
	}

	void setName(String name) {
		this.name = name;
	}

	String getName() {
		return name;
	}

	public void setDough(Dough dough) {
		this.dough = dough;
	}

	public void setSauce(Sauce sauce) {
		this.sauce = sauce;
	}

	public void setVeggies(Veggies[] veggies) {
		this.veggies = new Veggies[veggies.length];

		for (int i = 0; i < veggies.length; i++) {
			Veggies veggie = veggies[i]; // would be better to create a copy
			this.veggies[i]  = veggie;
		}
	}

	public void setCheese(Cheese cheese) {
		this.cheese = cheese;
	}

	public void setPepperoni(Pepperoni pepperoni) {
		this.pepperoni = pepperoni;
	}

	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("---- " + name + " ----" + System.lineSeparator());
		if (dough != null) {
			result.append(dough);
			result.append(System.lineSeparator());
		}
		if (sauce != null) {
			result.append(sauce);
			result.append(System.lineSeparator());
		}
		if (cheese != null) {
			result.append(cheese);
			result.append(System.lineSeparator());
		}
		if (veggies != null) {
			for (int i = 0; i < veggies.length; i++) {
				result.append(veggies[i]);
				if (i < veggies.length-1) {
					result.append(", ");
				}
			}
			result.append(System.lineSeparator());
		}

		if (pepperoni != null) {
			result.append(pepperoni);
			result.append(System.lineSeparator());
		}
		return result.toString();
	}
}
