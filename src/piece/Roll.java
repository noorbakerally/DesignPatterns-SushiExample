package piece;

import ingredient.Ingredient;

import java.util.ArrayList;
import java.util.List;

import App.helpers;

public class Roll extends Piece {
	List <Ingredient> inside;
	List <Ingredient> outside;
	List <Ingredient> topping;
	
	public Roll(List <Ingredient> inside,List <Ingredient> outside,List <Ingredient> topping){
		this.inside = inside;
		this.outside = outside;
		this.topping = topping;
	}
	
	@Override
	public String toString() {
		String objStr = "\n";
		objStr += "TYPE: ROLL\n";
		objStr +="Inside Ingredient:";
		for (Ingredient currentIngredient:inside){
			objStr +=currentIngredient.getName()+" ";
		}
		objStr +="\nOutside Ingredient:";
		for (Ingredient currentIngredient:outside){
			objStr +=currentIngredient.getName()+" ";
		}
		
		objStr +="\nTopping Ingredient:";
		for (Ingredient currentIngredient:topping){
			objStr +=(currentIngredient.getName()+" ");
		}
		return objStr;
	}
	
	@Override
	public boolean isVegeterian() {
		boolean vegeterian = true;
		vegeterian = vegeterian && helpers.checkVegeterian(inside);
		vegeterian = vegeterian && helpers.checkVegeterian(outside);
		vegeterian = vegeterian && helpers.checkVegeterian(topping);
		return vegeterian;
	}
}
