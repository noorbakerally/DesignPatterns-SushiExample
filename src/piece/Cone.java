package piece;

import ingredient.Ingredient;

import java.util.ArrayList;
import java.util.List;

import App.helpers;

public class Cone extends Piece{
	List <Ingredient> inside = new ArrayList <Ingredient> ();
	List <Ingredient> outside = new ArrayList <Ingredient> ();
	public Cone(List<Ingredient> inside,List<Ingredient> outside) {
		this.inside = inside;
		this.outside = outside;
		allIngredients.addAll(inside);
		allIngredients.addAll(outside);
	}
	@Override
	public String toString() {
		String objStr = "\n";
		objStr += "TYPE: CONE\n";
		objStr +="Inside Ingredient:";
		for (Ingredient currentIngredient:inside){
			objStr +=currentIngredient.getName()+" ";
		}
		objStr +="\nOutside Ingredient:";
		for (Ingredient currentIngredient:outside){
			objStr +=currentIngredient.getName()+" ";
		}
		return objStr;
	}
	
	@Override
	public boolean isVegeterian() {
		boolean vegeterian = true;
		vegeterian = vegeterian && helpers.checkVegeterian(inside);
		vegeterian = vegeterian && helpers.checkVegeterian(outside);
		return vegeterian;
	}
}
