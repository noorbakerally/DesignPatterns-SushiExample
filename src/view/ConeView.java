package view;
import java.util.List;
import App.helpers;import controller.ConeController;
public class ConeView implements ConeController.View{
	List <String> inside;
	List <String> outside;
	public ConeView(List <String> inside,List <String> outside){
		this.inside = inside;
		this.outside = outside;
	}
	public String[] getInsideIngredient() {
		return helpers.getChoice("Choose Inside Ingredient", inside).split(",");
	}
	public String[] getOutsideIngredient() {
		return helpers.getChoice("Choose Outside Ingredient", outside).split(",");
	}

}
