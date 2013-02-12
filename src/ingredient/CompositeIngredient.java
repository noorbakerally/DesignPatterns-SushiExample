package ingredient;
import App.helpers;
import ingredient.Ingredient;;
public class CompositeIngredient extends Ingredient{

	public CompositeIngredient(int id, String ingredientName,
			boolean isVegeterian,String presence) {
		super(id, ingredientName, isVegeterian,presence);
		// TODO Auto-generated constructor stub
	}

	public CompositeIngredient(int id, String ingredientName) {
		// TODO Auto-generated constructor stub
		super(id,ingredientName);
	}

	@Override
	public void addIngredient(Ingredient ingredient) {
		// TODO Auto-generated method stub
		this.ingredientList.add(ingredient);
	}

	@Override
	public void removeIngredient(Ingredient ingredient) {
		// TODO Auto-generated method stub
		
	}

	public boolean getIsVegeterian(){
		return helpers.checkVegeterian(ingredientList);
	}
	
	@Override
	public Ingredient getIngredient(Ingredient ingredient) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public float getPrice(){
		float tmpPrice = 0;
		for (Ingredient ingredient:ingredientList){
			tmpPrice += ingredient.getPrice();
		}
		return tmpPrice;
	}
}
