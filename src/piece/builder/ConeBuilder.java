package piece.builder;

import ingredient.Ingredient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import App.ChoiceDisplay;


import piece.BaseTopping;
import piece.Cone;
import piece.Piece;

public class ConeBuilder extends PieceBuilder{
	
	Map <Integer,Ingredient> insideIngredientList = new HashMap<Integer,Ingredient>();
	Map <Integer,Ingredient> outsideIngredientList = new HashMap<Integer,Ingredient>();
	
	
	List <String> strInsideIngredient = new ArrayList<String>();
	List <String> strOutsideIngredient = new ArrayList<String>();
	String selectedInsideIngredient;
	String selectedOutisdeIngredient;
	Cone cone = new Cone();
	

	public ConeBuilder(List<Ingredient> ingredientList) {
		super(ingredientList);
		int insideIngredientCounter=1,outsideIngredientCounter=1;
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
		}
	}

	@Override
	public Piece buildPiece() {
		// TODO Auto-generated method stub
		return cone;
	}

	@Override
	public void selectIngredient() {
		selectedInsideIngredient = ChoiceDisplay.getChoices("Select Inside Ingredient(Separate by ,)", strInsideIngredient);
		
		selectedOutisdeIngredient = ChoiceDisplay.getChoices("Select Outside Ingredient(Separate by ,)", strOutsideIngredient);
	}

	@Override
	public void mixIngredient() {
		for (String id:selectedInsideIngredient.split(",")){
			cone.getHasInside().add(insideIngredientList.get(Integer.valueOf(id)));
		}
		for (String id:selectedOutisdeIngredient.split(",")){
			cone.getHasOutside().add(outsideIngredientList.get(Integer.valueOf(id)));
		}
	}
}
