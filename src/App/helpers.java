package App;
import java.util.List;

import ingredient.Ingredient;;
public class helpers {

	public static boolean checkVegeterian(List <Ingredient> ingredientList){
		boolean isVegeterian = true;
		for (Ingredient ingredient:ingredientList){
			isVegeterian = isVegeterian && ingredient.getIsVegeterian();
		}
		return isVegeterian;
	}
}
