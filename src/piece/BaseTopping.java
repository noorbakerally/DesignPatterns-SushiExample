package piece;

import ingredient.Ingredient;

import java.util.ArrayList;
import java.util.List;

import javax.jws.Oneway;

import App.helpers;

public class BaseTopping extends Piece {
	List <Ingredient> base = new ArrayList <Ingredient> ();
	List <Ingredient> topping = new ArrayList <Ingredient> ();
	
	public BaseTopping(List<Ingredient> base,	List<Ingredient> topping) {
		this.base = base;
		this.topping = topping;
		allPricedIngredients.addAll(base);
		allPricedIngredients.addAll(topping);
	}
	
	@Override
	public String  toString() {
		String objStr = "\n";
		objStr += "TYPE: BASE with Topping\n";
		objStr +="Base Ingredient:";
		for (Ingredient currentIngredient:base){
			objStr +=currentIngredient.getName()+" ";
		}
		objStr +="\nTopping Ingredient:";
		for (Ingredient currentIngredient:topping){
			objStr +=currentIngredient.getName()+" ";
		}
		return objStr;
	}
	
	@Override
	public boolean isVegeterian() {
		boolean vegeterian = true;
		vegeterian = vegeterian && helpers.checkVegeterian(base);
		vegeterian = vegeterian && helpers.checkVegeterian(topping);
		return vegeterian;
	}

	@Override
	public float getPrice() {
		// TODO Auto-generated method stub
		return 0;
	}
}
