package App;

import ingredient.Ingredient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import piece.BaseTopping;
import piece.Cone;
import piece.Piece;
import piece.Roll;
import plate.Plate;
import store.SimpleStoreFactory;
import store.SushiStore;

public class MainController {
	SushiStore sushiStore;
	DB db;
	int plateFranchise;
	int numberOfPieces;
	View view;
	public interface View{
		int getPlateFranchise();
		int getNumberOfPieces();
		int getPieceType(int pieceNumber);
		void showPlate(Plate plate);
		String[] getIngredient(String ingredientTypeTitle,List <String> ingredient);
	}
	
	public MainController(View view) throws ParserConfigurationException, SAXException, IOException{
		db = new DB();
		this.view = view;
		launch();
	}
	
	void launch(){
		plateFranchise = view.getPlateFranchise();
		sushiStore = SimpleStoreFactory.createSushiStore(plateFranchise, db.sauceList);
		numberOfPieces = view.getNumberOfPieces();
		int currentPieceType;
		for  (int pieceCounter=1;pieceCounter<=numberOfPieces;pieceCounter++){
			currentPieceType = view.getPieceType(pieceCounter);
			Piece tmpPiece = null;
			if (currentPieceType == 1){
				//creating the roll
				tmpPiece = new Roll(getSelectedIngredient(1,view.getIngredient("inside",db.strInsideIngredient)),
						getSelectedIngredient(2,view.getIngredient("outside",db.strOutsideIngredient)),
						getSelectedIngredient(4,view.getIngredient("topping",db.strToppingIngredient)));
			}
			if (currentPieceType == 2){
				//creating the cone
				tmpPiece = new Cone(getSelectedIngredient(1,view.getIngredient("inside",db.strInsideIngredient)),
						getSelectedIngredient(2,view.getIngredient("outside",db.strOutsideIngredient)));
			}
			if (currentPieceType == 3){
				//creating the basetopping
				tmpPiece = new BaseTopping(getSelectedIngredient(3,view.getIngredient("base",db.strBaseIngredient)),
						getSelectedIngredient(4,view.getIngredient("topping",db.strToppingIngredient)));
			}
			sushiStore.addPieces(tmpPiece);
		}
		view.showPlate(sushiStore.getPlate());
	}
	
	
	List <Ingredient> getSelectedIngredient(int Status,String [] selectedIngredient){
		List <Ingredient> selectedIngredientList = new ArrayList <Ingredient> ();
		if (Status ==1){ 
			for (String ingredientStr:selectedIngredient){
				selectedIngredientList.add(db.insideIngredientList.get(Integer.valueOf(ingredientStr)));
			}
		}
		if (Status ==2){
			for (String ingredientStr:selectedIngredient){
				selectedIngredientList.add(db.outsideIngredientList.get(Integer.valueOf(ingredientStr)));
			}
		}
		if (Status ==3){
			for (String ingredientStr:selectedIngredient){
				selectedIngredientList.add(db.baseIngredientList.get(Integer.valueOf(ingredientStr)));
			}
		}
		if (Status ==4){
			for (String ingredientStr:selectedIngredient){
				selectedIngredientList.add(db.toppingIngredientList.get(Integer.valueOf(ingredientStr)));
			}
		}
		return selectedIngredientList;
	}
	
	
}
