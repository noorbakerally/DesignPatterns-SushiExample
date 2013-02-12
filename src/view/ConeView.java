package view;
import java.util.List;
import controller.ConeController;

import controller.RollController;;
public class ConeView implements ConeController.View{
	List <String> inside;
	List <String> outside;
	public ConeView(List <String> inside,List <String> outside){
		this.inside = inside;
		this.outside = outside;
	}
	public String[] getInsideIngredient() {
		return ChoiceView.getChoice("Choose Inside Ingredient", inside).split(",");
	}
	public String[] getOutsideIngredient() {
		return ChoiceView.getChoice("Choose Outside Ingredient", outside).split(",");
	}

}
