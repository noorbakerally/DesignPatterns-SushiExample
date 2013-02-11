package piece.builder;
import ingredient.Ingredient;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import App.ChoiceDisplay;


import piece.BaseTopping;
import piece.Piece;
public class BaseToppingBuilder extends PieceBuilder{
	Map <Integer,Ingredient> baseIngredientList = new HashMap<Integer,Ingredient>();
	Map <Integer,Ingredient> toppingIngredientList = new HashMap<Integer,Ingredient>();
	
	
	List <String> strBaseIngredient = new ArrayList<String>();
	List <String> strToppingIngredient = new ArrayList<String>();
	String selectedBaseIngredient;
	String selectedToppingIngredient;
	BaseTopping baseTopping = new BaseTopping();
	
	public BaseToppingBuilder(List<Ingredient> ingredientList) {
		super(ingredientList);
		int baseIngredientCounter=1,toppingIngredientCounter=1;
		for (Ingredient currentIngredient:ingredientList){
			if (currentIngredient.getPresence().contains("B")){
				baseIngredientList.put(baseIngredientCounter, currentIngredient);
				strBaseIngredient.add(currentIngredient.getName());
				baseIngredientCounter++;
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
		// TODO Auto-generated method stub
		selectIngredient();
		mixIngredient();
		return baseTopping;
	}
	@Override
	public void selectIngredient() {
		// TODO Auto-generated method stub
		selectedBaseIngredient = ChoiceDisplay.getChoices("Select base Ingredient(Separate by ,)", strBaseIngredient);
		selectedToppingIngredient = ChoiceDisplay.getChoices("Select Topping Ingredient(Separate by ,)", strToppingIngredient);
	}
	@Override
	public void mixIngredient() {
		for (String id:selectedBaseIngredient.split(",")){
			baseTopping.getHasBase().add(baseIngredientList.get(Integer.valueOf(id)));
		}
		for (String id:selectedToppingIngredient.split(",")){
			baseTopping.getHasTopping().add(toppingIngredientList.get(Integer.valueOf(id)));
		}
	}
}
