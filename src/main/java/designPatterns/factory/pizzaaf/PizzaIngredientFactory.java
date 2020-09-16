package designPatterns.factory.pizzaaf;

/** From Head First Design Patterns book. */
public interface PizzaIngredientFactory {
 
	Dough createDough();
	Sauce createSauce();
	Cheese createCheese();
	Veggies[] createVeggies();
	Pepperoni createPepperoni();

 
}
