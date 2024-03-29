package view;
import java.util.ArrayList;
import java.util.List;import java.util.Scanner;import App.helpers;import controller.MainController;import plate.Plate;
public class MainView implements MainController.View{
	Scanner in;
	public MainView(){
		in = new Scanner(System.in);
	}
	@Override
	public int getPlateFranchise() {
		return Integer.valueOf(helpers.getChoice("Select a Plate",new ArrayList<String>() {{add("Japanese Plate");add("Western Plate"); }}));
	}
	@Override
	public int getNumberOfPieces() {
		System.out.print("Enter number of pieces:");
		return in.nextInt();
	}
	@Override
	public int getPieceType(int pieceNumber) {
		return Integer.valueOf(helpers.getChoice("SELECT TYPE OF PIECE "+pieceNumber,new ArrayList <String> (){{add("Roll");add("Hand Roll(Cone)");add("Base with Topping");}}));
	}
	@Override
	public void showPlate(String plateDetails) {
		System.out.println(plateDetails);
	}
	public String[] getIngredient(String ingredientType,List <String> ingredient){
		return helpers.getChoice("Enter "+ingredientType+" ingredient:",ingredient).split(",");
	}
	@Override
	public int getPlateDecorator() {
		return Integer.valueOf(helpers.getChoice("Select Plate decorator:",new ArrayList<String>() {{add("Decorate with tomato");add("Decorate with meat");add("No Decorator"); }}));
	}
	@Override
	public int getCustomerId() {
		System.out.print("Enter customer id:");
		return in.nextInt();
	}
}
