package view;
import java.util.List;
import controller.*;
public class BaseView implements BaseToppingController.View{
	List <String> base;
	List <String> topping;
	public BaseView(List<String> base,	List<String> topping) {
		this.base = base;
		this.topping = topping;
	}
	@Override
	public String[] getToppingIngredient() {
		// TODO Auto-generated method stub
		return ChoiceView.getChoice("Choose topping Ingredient", topping).split(",");
	}
	@Override
	public String[] getBaseIngredient() {
		// TODO Auto-generated method stub
		return ChoiceView.getChoice("Choose Base Ingredient", base).split(",");
	}

}
