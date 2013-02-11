package piece;

import ingredient.Ingredient;

import java.util.ArrayList;
import java.util.List;

import javax.jws.Oneway;

import App.helpers;

public class BaseTopping extends Piece {
	List <Ingredient> hasBase = new ArrayList <Ingredient> ();
	List <Ingredient> hasTopping = new ArrayList <Ingredient> ();
	
	public List<Ingredient> getHasBase() {
		return hasBase;
	}
	public void setHasBase(List<Ingredient> hasBase) {
		this.hasBase = hasBase;
	}
	public List<Ingredient> getHasTopping() {
		return hasTopping;
	}
	public void setHasTopping(List<Ingredient> hasTopping) {
		this.hasTopping = hasTopping;
	}
	@Override
	public String  toString() {
		String objStr = "\n";
		objStr += "TYPE: BASE with Topping\n";
		objStr +="Base Ingredient:";
		for (Ingredient currentIngredient:hasBase){
			objStr +=currentIngredient.getName()+" ";
		}
		objStr +="\nTopping Ingredient:";
		for (Ingredient currentIngredient:hasTopping){
			objStr +=currentIngredient.getName()+" ";
		}
		return objStr;
	}
	
	@Override
	public boolean isVegeterian() {
		boolean vegeterian = true;
		vegeterian = vegeterian && helpers.checkVegeterian(hasBase);
		vegeterian = vegeterian && helpers.checkVegeterian(hasTopping);
		return vegeterian;
	}
}
