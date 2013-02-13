package controller;

import ingredient.Ingredient;

import java.util.ArrayList;
import java.util.List;

import App.DB;
import piece.Piece;
import piece.Roll;
import view.RollView;

public class RollController extends PieceControlHandler{
	View view;
	public interface View{
		String[] getInsideIngredient();
		String[] getOutsideIngredient();
		String[] getToppingIngredient();
	}
	
	public RollController(DB db){
		this.db = db;
		this.view = new RollView(db.strInsideIngredient, db.strOutsideIngredient, db.strToppingIngredient);
	}
	
	protected Piece getPiece(int pieceType) {
		if (pieceType == ROLL)
			return new Roll(db.getSelectedIngredient(1,view.getInsideIngredient()),
					db.getSelectedIngredient(2,view.getOutsideIngredient()),
					db.getSelectedIngredient(4,view.getToppingIngredient()));
		else{
			return handler.getPiece(pieceType);
		}
	}

	
}
