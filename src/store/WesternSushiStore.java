package store;

import ingredient.Ingredient;

import java.util.List;

import plate.JapanesePlate;
import plate.Plate;

public class WesternSushiStore extends SushiStore{

	public WesternSushiStore(List<Ingredient> baseSauceList) {
		super(baseSauceList);
	}

	@Override
	public Plate createPlate() {
		// TODO Auto-generated method stub
		plate = new JapanesePlate();
		for (Ingredient temIngredient:baseSauceList){
			if (temIngredient.getRegion().contains("W")){
				plate.addBaseSauce(temIngredient);
			}
		}
		return plate;
	}

}
