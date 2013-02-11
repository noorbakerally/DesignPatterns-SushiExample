package store;


import ingredient.Ingredient;
import java.util.*;
import App.ChoiceDisplay;
import piece.*;
import piece.builder.*;
import plate.Plate;
public abstract class SushiStore {
	protected List<Ingredient> ingredientList;
	protected List<Ingredient> baseSauceList;
	List <String> pieceTypes = new ArrayList <String> () {{add("Roll");add("Cone");add("Base with Topping");}};
	Scanner in = new Scanner(System.in);
	Plate plate;
	public SushiStore(List <Ingredient> ingredientList,List <Ingredient> baseSauceList) {	
		this.ingredientList = ingredientList;
		this.baseSauceList = baseSauceList;
		addPieces();
	}
	public abstract Plate createPlate();
	public void addBaseSauce(Ingredient ingredient){
		baseSauceList.add(ingredient);
	}
	
	public void addPieces(){
		PieceBuilder pieceBuilder = null;
		System.out.print("Enter number of pieces:");
		int numberOfPieces = in.nextInt();
		
		plate = createPlate();
		for (int pieceCounter = 0;pieceCounter < numberOfPieces;pieceCounter++){
			int pieceChoice;
			
			System.out.println();
			pieceChoice = ChoiceDisplay.getChoice("SELECT TYPE OF PIECE "+ (pieceCounter+1),
					new ArrayList <String> (){{add("Roll");add("Hand Roll(Cone)");add("Base with Topping");}});
			//pieceChoice=1;
			System.out.println();
			System.out.print("PERSONALISING PIECE "+(pieceCounter+1)+":"+pieceTypes.get(pieceChoice-1));
			if (pieceChoice == 1) pieceBuilder = new RollBuilder(ingredientList);
			if (pieceChoice == 2) pieceBuilder = new ConeBuilder(ingredientList);
			if (pieceChoice == 3) pieceBuilder = new BaseToppingBuilder(ingredientList);
			Piece newPiece = pieceBuilder.buildPiece();
			plate.addPiece(newPiece);
		}
	}
	public void getDetails(){
		System.out.println(plate.toString());
	}
	

}
