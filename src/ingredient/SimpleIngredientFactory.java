package ingredient;
import org.w3c.dom.Node;
public class SimpleIngredientFactory {
	public static Ingredient createIngredient(int id,String ingredientName,boolean isVegeterian,boolean isShellFish,boolean isDairy,String presence){
		Ingredient newIngredient = null;
		if (ingredientName.equals("Rice")){
			newIngredient = new Rice(id,ingredientName,isVegeterian,presence);			
		}
		if (ingredientName.equals("Vinegar")){
			newIngredient = new Vinegar(id,ingredientName,isVegeterian,presence);			
		}
		if (ingredientName.equals("Mayonnaise")){
			newIngredient = new Mayonnaise(id,ingredientName,isVegeterian,presence);			
		}
		if (ingredientName.equals("Tuna")){
			newIngredient = new Tuna(id,ingredientName,isVegeterian,presence);			
		}
		if (ingredientName.equals("Nori")){
			newIngredient = new Nori(id,ingredientName,isVegeterian,presence);			
		}
		if (ingredientName.equals("Wasabi")){
			newIngredient = new Wasabi(id,ingredientName,isVegeterian,presence);			
		}
		if (ingredientName.equals("Cucumber")){
			newIngredient = new Cucumber(id,ingredientName,isVegeterian,presence);			
		}
		if (ingredientName.equals("SoyaBean")){
			newIngredient = new SoyaBean(id,ingredientName,isVegeterian,presence);			
		}
		if (ingredientName.equals("JapTea")){
			newIngredient = new JapTea(id,ingredientName,isVegeterian,presence);			
		}
		if (ingredientName.equals("WestWine")){
			newIngredient = new WestWine(id,ingredientName,isVegeterian, presence);			
		}
		return newIngredient;
	}

}
