package store;

import ingredient.Ingredient;

import java.util.List;

import plate.JapanesePlate;
import plate.Plate;

public class JapaneseSushiStore extends SushiStore{
	public JapaneseSushiStore(List<Ingredient> baseSauceList) {
		super(baseSauceList);
	}
	@Override
	public Plate createPlate() {
		plate = new JapanesePlate();
		for (Ingredient temIngredient:baseSauceList){
			if (temIngredient.getRegion().contains("J")){
				plate.addBaseSauce(temIngredient);
			}
		}
		return plate;
	}

}
