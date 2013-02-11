package store;

import ingredient.CompositeIngredient;
import ingredient.Ingredient;
import ingredient.SimpleIngredientFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import App.ChoiceDisplay;

import piece.Piece;
import piece.builder.BaseToppingBuilder;
import piece.builder.ConeBuilder;
import piece.builder.PieceBuilder;
import piece.builder.RollBuilder;
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
			pieceChoice = Integer.valueOf(ChoiceDisplay.getChoices("SELECT TYPE OF PIECE "+ (pieceCounter+1),
					new ArrayList <String> (){{add("Roll");add("Hand Roll(Cone)");add("Base with Topping");}}));
			
			//pieceChoice=1;
			System.out.println();
			System.out.print("PERSONALISING PIECE "+(pieceCounter+1)+":"+pieceTypes.get(pieceChoice-1));
			if (pieceChoice == 1) pieceBuilder = (new RollBuilder(ingredientList));
			if (pieceChoice == 2) pieceBuilder = new ConeBuilder(ingredientList);
			if (pieceChoice == 3) pieceBuilder = new BaseToppingBuilder(ingredientList);
			pieceBuilder.selectIngredient();
			pieceBuilder.mixIngredient();
			Piece newPiece = pieceBuilder.buildPiece();
			plate.addPiece(newPiece);
		}
	}
	
	public String getDetails(){
		return plate.toString();
	}
	

}
