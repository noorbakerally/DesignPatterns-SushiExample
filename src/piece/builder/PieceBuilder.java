package piece.builder;

import ingredient.Ingredient;

import java.util.List;

import piece.BaseTopping;
import piece.Cone;
import piece.Piece;
import piece.Roll;

public abstract class PieceBuilder {
	protected Piece piece;
	protected List <Ingredient> ingredientList;
	public PieceBuilder(List <Ingredient> ingredientList){
		this.ingredientList = ingredientList;
	}
	
	public Piece getPiece(){
		return piece;
	}
	abstract public void selectIngredient();
	abstract public void mixIngredient();
	abstract public Piece buildPiece();
}
