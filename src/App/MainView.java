package App;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import plate.Plate;

public class MainView implements MainController.View{
	Scanner in;
	public MainView(){
		in = new Scanner(System.in);
	}
	@Override
	public int getPlateFranchise() {
		return Integer.valueOf(ViewChoice.getChoices("Select a Plate",new ArrayList<String>() {{add("Japanese Plate");add("Western Plate"); }}));
	}
	@Override
	public int getNumberOfPieces() {
		System.out.print("Enter number of pieces:");
		return in.nextInt();
	}
	@Override
	public int getPieceType(int pieceNumber) {
		return Integer.valueOf(ViewChoice.getChoices("SELECT TYPE OF PIECE "+pieceNumber,new ArrayList <String> (){{add("Roll");add("Hand Roll(Cone)");add("Base with Topping");}}));
	}
	@Override
	public void showPlate(Plate plate) {
		System.out.println(plate.toString());
	}
	
	public String[] getIngredient(String ingredientType,List <String> ingredient){
		return ViewChoice.getChoices("Enter "+ingredientType+" ingredient:",ingredient).split(",");
	}
}
