package controller;

import piece.Cone;
import piece.Piece;
import piece.Roll;
import proxy.Database;
import view.ConeView;
import view.RollView;
import controller.RollController.View;

public class ConeController extends PieceControlHandler{
	View view;
	Database db;
	public interface View{
		String[] getInsideIngredient();
		String[] getOutsideIngredient();
	}
	public ConeController(Database db){
		this.db = db;
		this.view = new ConeView(db.getStrInsideIngredient(), db.getStrOutsideIngredient());;
	}
	protected Piece getPiece(int pieceType) {
		if (pieceType == CONE)
			return new Cone(db.getAllSelectedIngredient(1,view.getInsideIngredient()),db.getAllSelectedIngredient(2,view.getOutsideIngredient()));
		else{
			return handler.getPiece(pieceType);
		}
	}
}
