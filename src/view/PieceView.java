package view;
import java.util.List;
import App.helpers;
import controller.*;
public class PieceView implements BaseToppingController.View,RollController.View,ConeController.View{
	List <String> base;
	List <String> topping;
	List <String> inside;
	List <String> outside;
	
	//constructor for the basetopping piece
	public PieceView(List<String> arg1,	List<String> arg2,String argStatus) {
		if (argStatus.equals("BaseTopping")){
			this.base = arg1;
			this.topping = arg2;
		}
		else{
			this.inside = arg1;
			this.outside = arg2;
		}
	}
	
	//constructor for the Roll piece
	public PieceView(List <String> inside,List <String> outside,List <String> topping){
		this.inside = inside;
		this.outside = outside;
		this.topping = topping;
	}
	
	@Override
	public String[] getToppingIngredient() {
		return helpers.getChoice("Choose topping Ingredient", topping).split(",");
	}
	@Override
	public String[] getBaseIngredient() {
		return helpers.getChoice("Choose Base Ingredient", base).split(",");
	}
	public String[] getInsideIngredient() {
		return helpers.getChoice("Choose Inside Ingredient", inside).split(",");
	}
	public String[] getOutsideIngredient() {
		return helpers.getChoice("Choose Outside Ingredient", outside).split(",");
	}

}
