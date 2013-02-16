package piece;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import ingredient.Ingredient;
public abstract class Piece {
	String name;
	protected List <Ingredient> allIngredients = new ArrayList<Ingredient>(); 
	public abstract String toString();
	public abstract boolean isVegeterian();
	public float getPrice(){
		float tmpPrice = 0;
		for (Ingredient ingredient:allIngredients){
			tmpPrice += ingredient.getPrice();
		}
		return tmpPrice;
	}
	
	
}
