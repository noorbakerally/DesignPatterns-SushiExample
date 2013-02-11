package piece.builder;

import ingredient.Ingredient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import App.ChoiceDisplay;


import piece.Cone;
import piece.Piece;
import piece.Roll;

public class RollBuilder extends PieceBuilder{

	Map <Integer,Ingredient> insideIngredientList = new HashMap<Integer,Ingredient>();
	Map <Integer,Ingredient> outsideIngredientList = new HashMap<Integer,Ingredient>();
	Map <Integer,Ingredient> toppingIngredientList = new HashMap<Integer,Ingredient>();
	
	List <String> strInsideIngredient = new ArrayList<String>();
	List <String> strOutsideIngredient = new ArrayList<String>();
	List <String> strToppingIngredient = new ArrayList<String>();
	String selectedInsideIngredient;
	String selectedOutisdeIngredient;
	String selectedToppingIngredient;
	Roll roll = new Roll();
	

	public RollBuilder(List<Ingredient> ingredientList) {
		super(ingredientList);
		int insideIngredientCounter=1,outsideIngredientCounter=1,toppingIngredientCounter=1;
		for (Ingredient currentIngredient:ingredientList){
			if (currentIngredient.getPresence().contains("I")){
				insideIngredientList.put(insideIngredientCounter, currentIngredient);
				strInsideIngredient.add(currentIngredient.getName());
				insideIngredientCounter++;
			}
			if (currentIngredient.getPresence().contains("O")){
				outsideIngredientList.put(outsideIngredientCounter, currentIngredient);
				strOutsideIngredient.add(currentIngredient.getName());
				outsideIngredientCounter++;
			}
			if (currentIngredient.getPresence().contains("T")){
				toppingIngredientList.put(toppingIngredientCounter, currentIngredient);
				strToppingIngredient.add(currentIngredient.getName());
				toppingIngredientCounter++;
			}
		}
	}

	@Override
	public Piece buildPiece() {
		return roll;
	}

	@Override
	public void selectIngredient() {
		selectedInsideIngredient = ChoiceDisplay.getChoices("Select Inside Ingredient(Separate by ,)", strInsideIngredient);
		
		selectedOutisdeIngredient = ChoiceDisplay.getChoices("Select Outside Ingredient(Separate by ,)", strOutsideIngredient);
		
		selectedToppingIngredient = ChoiceDisplay.getChoices("Select Topping Ingredient(Separate by ,)", strToppingIngredient);
	}

	@Override
	public void mixIngredient() {
		for (String id:selectedInsideIngredient.split(",")){
			roll.getHasInside().add(insideIngredientList.get(Integer.valueOf(id)));
		}
		for (String id:selectedOutisdeIngredient.split(",")){
			roll.getHasOutside().add(outsideIngredientList.get(Integer.valueOf(id)));
		}
		for (String id:selectedToppingIngredient.split(",")){
			roll.getHasTopping().add(toppingIngredientList.get(Integer.valueOf(id)));
		}
	}

}
