package store;

import ingredient.Ingredient;

import java.util.List;

import plate.JapanesePlate;
import plate.Plate;

public class JapaneseSushiStore extends SushiStore{

	public JapaneseSushiStore(List<Ingredient> ingredientList,
			List<Ingredient> baseSauceList) {
		super(ingredientList, baseSauceList);
		// TODO Auto-generated constructor stub
	}
	@Override
	public Plate createPlate() {
		// TODO Auto-generated method stub
		plate = new JapanesePlate();
		for (Ingredient temIngredient:baseSauceList){
			if (temIngredient.getRegion().contains("J")){
				plate.addBaseSauce(temIngredient);
			}
		}
		return plate;
	}

}
