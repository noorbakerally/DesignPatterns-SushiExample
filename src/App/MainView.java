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
		return Integer.valueOf(getChoices("Select a Plate",new ArrayList<String>() {{add("Japanese Plate");add("Western Plate"); }}));
	}
	@Override
	public int getNumberOfPieces() {
		System.out.print("Enter number of pieces:");
		return in.nextInt();
	}
	@Override
	public int getPieceType(int pieceNumber) {
		return Integer.valueOf(getChoices("SELECT TYPE OF PIECE "+pieceNumber,new ArrayList <String> (){{add("Roll");add("Hand Roll(Cone)");add("Base with Topping");}}));
	}
	@Override
	public void showPlate(Plate plate) {
		System.out.println(plate.toString());
	}
	
	public String[] getIngredient(String ingredientType,List <String> ingredient){
		return getChoices("Enter "+ingredientType+" ingredient:",ingredient).split(",");
	}
	
	public String getChoices(String title,List <String> choices){
		String mainChoice = null; 
		Scanner in = new Scanner(System.in);
		System.out.println("\n"+title);
		int choiceNum = 1;
		for (String currentChoice:choices){
			System.out.println(choiceNum+". "+currentChoice);
			choiceNum ++;
		}
		System.out.print("Enter Choice:");
		mainChoice = in.next();
		return mainChoice;
	}
}
