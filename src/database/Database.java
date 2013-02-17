package database;

import ingredient.Ingredient;
import java.util.List;
public interface Database {
	public List <Ingredient> getIngredientList();
	public List <Ingredient> getSauceList();
	public Ingredient getInsideIngredient(int id);
	public Ingredient getOutsideIngredient(int id);
	public Ingredient getToppingIngredient(int id);
	public Ingredient getBaseIngredient(int id);
	public Customer getCustomer(int id);
	
	//takes status:the status of the ingredient in the string, are they inside,outside,base,topping
	//strIngredientList is comma seperated string where each str is an id of an ingredient
	public List <Ingredient> getAllSelectedIngredient(int status,String strIngredientList []);
	
	//get all list in string  
	public List <String> getStrInsideIngredient();
	public List <String> getStrOutsideIngredient();
	public List <String> getStrBaseIngredient();
	public List <String> getStrToppingIngredient();
}
