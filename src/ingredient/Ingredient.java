package ingredient;

import java.util.ArrayList;
import java.util.List;

public abstract class Ingredient {
	protected int id;
	protected String name;
	protected float pricePerUnit;
	protected int unit;
	protected boolean isVegeterian;
	protected String presence;
	protected String region;
	protected List <Ingredient> ingredientList = new ArrayList <Ingredient>();
	
	public abstract void addIngredient(Ingredient ingredient);
	public abstract void removeIngredient(Ingredient ingredient);
	public abstract Ingredient getIngredient(Ingredient ingredient);
	
	
	public Ingredient(int id,String ingredientName,boolean isVegeterian,String presence){
		this.id = id;this.name = ingredientName; this.isVegeterian = isVegeterian;
		this.presence = presence;
	}
	
	public Ingredient(int id, String ingredientName) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = ingredientName;
	}
	public String toString(){return name;}
	public boolean getIsVegeterian(){return isVegeterian;}
	public void setPresence(String presence){this.presence =  presence;}
	public String getPresence(){return presence;}
	public void setPricePerUnit(float pricePerUnit){this.pricePerUnit = pricePerUnit;}
	public float getPrice(){return pricePerUnit;}
	public void setRegion(String region){this.region = region;}
	public String getRegion(){return region;}
	public int getId(){	return id;}
	public String getName(){return name;}
}