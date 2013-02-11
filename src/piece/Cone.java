package piece;

import ingredient.Ingredient;

import java.util.ArrayList;
import java.util.List;

import App.helpers;

public class Cone extends Piece{
	List <Ingredient> hasInside = new ArrayList <Ingredient> ();
	List <Ingredient> hasOutside = new ArrayList <Ingredient> ();
	@Override
	public String toString() {
		String objStr = "\n";
		objStr += "TYPE: CONE\n";
		objStr +="Inside Ingredient:";
		for (Ingredient currentIngredient:hasInside){
			objStr +=currentIngredient.getName()+" ";
		}
		objStr +="\nOutside Ingredient:";
		for (Ingredient currentIngredient:hasOutside){
			objStr +=currentIngredient.getName()+" ";
		}
		return objStr;
	}
	public List<Ingredient> getHasInside() {
		return hasInside;
	}
	public void setHasInside(List<Ingredient> hasInside) {
		this.hasInside = hasInside;
	}
	public List<Ingredient> getHasOutside() {
		return hasOutside;
	}
	public void setHasOutside(List<Ingredient> hasOutside) {
		this.hasOutside = hasOutside;
	}
	
	
	@Override
	public boolean isVegeterian() {
		boolean vegeterian = true;
		vegeterian = vegeterian && helpers.checkVegeterian(hasInside);
		vegeterian = vegeterian && helpers.checkVegeterian(hasOutside);
		return vegeterian;
	}
}
