package view;
import java.util.List;

import App.helpers;

import controller.RollController;;
public class RollView implements RollController.View{
	List <String> inside;
	List <String> outside;
	List <String> topping;
	public RollView(List <String> inside,List <String> outside,List <String> topping){
		this.inside = inside;
		this.outside = outside;
		this.topping = topping;
	}
	public String[] getInsideIngredient() {
		return helpers.getChoice("Choose Inside Ingredient", inside).split(",");
	}
	public String[] getOutsideIngredient() {
		return helpers.getChoice("Choose Outside Ingredient", outside).split(",");
	}

	@Override
	public String[] getToppingIngredient() {
		// TODO Auto-generated method stub
		return helpers.getChoice("Choose topping Ingredient", topping).split(",");
	}

}
