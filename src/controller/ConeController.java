package controller;

import piece.Cone;
import piece.Piece;
import piece.Roll;
import view.ConeView;
import view.RollView;
import App.DB;
import controller.RollController.View;

public class ConeController extends PieceControlHandler{
	View view;
	public interface View{
		String[] getInsideIngredient();
		String[] getOutsideIngredient();
	}
	public ConeController(DB db){
		this.db = db;
		this.view = new ConeView(db.strInsideIngredient, db.strOutsideIngredient);;
	}
	protected Piece getPiece(int pieceType) {
		if (pieceType == CONE)
			return new Cone(db.getSelectedIngredient(1,view.getInsideIngredient()),db.getSelectedIngredient(2,view.getOutsideIngredient()));
		else{
			return handler.getPiece(pieceType);
		}
	}
}
