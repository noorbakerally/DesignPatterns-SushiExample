package piece;
import java.util.ArrayList;
import java.util.List;

import ingredient.Ingredient;
public abstract class Piece {
	String name;
	
	protected List <Ingredient> allPricedIngredients = new ArrayList<Ingredient>(); 
	public abstract String toString();
	public abstract boolean isVegeterian();
	public abstract float getPrice();
}
