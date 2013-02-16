package ingredient;
import App.helpers;import ingredient.Ingredient;;
public class CompositeIngredient extends Ingredient{
	public CompositeIngredient(int id, String ingredientName,
			boolean isVegeterian,String presence) {
		super(id, ingredientName, isVegeterian,presence);
	}
	public CompositeIngredient(int id, String ingredientName) {
		super(id,ingredientName);
	}
	@Override
	public void addIngredient(Ingredient ingredient) {
		this.ingredientList.add(ingredient);
	}
	@Override
	public void removeIngredient(Ingredient ingredient) {}
	public boolean getIsVegeterian(){
		return helpers.checkVegeterian(ingredientList);
	}
	@Override
	public Ingredient getIngredient(Ingredient ingredient) {
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
