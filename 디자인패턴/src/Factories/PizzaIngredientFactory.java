package Factories;

import Factories.dough.*;
import Factories.sauce.*;
import Factories.cheese.*;
import Factories.veggies.*;
import Factories.pepperoni.*;
import Factories.clam.*;

public interface PizzaIngredientFactory {
 
	public Dough createDough();
	public Sauce createSauce();
	public Cheese createCheese();
	public Veggies[] createVeggies();
	public Pepperoni createPepperoni();
	public Clams createClam();
 
}
