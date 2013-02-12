package piece;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import ingredient.Ingredient;
public abstract class Piece {
	String name;
	
	protected List <Ingredient> allPricedIngredients = new ArrayList<Ingredient>(); 
	public abstract String toString();
	public abstract boolean isVegeterian();
	public float getPrice(){
		float tmpPrice = 0;
		for (Ingredient ingredient:allPricedIngredients){
			tmpPrice += ingredient.getPrice();
		}
		return tmpPrice;
	}
	
	
}
