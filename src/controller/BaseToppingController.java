package controller;

import piece.BaseTopping;
import piece.Piece;
import view.BaseView;
import App.DB;
public class BaseToppingController extends PieceControlHandler{
	View view;
	public interface View{
		String[] getBaseIngredient();
		String[] getToppingIngredient();
	}
	public BaseToppingController(DB db){
		this.db = db;
		this.view = new BaseView(db.strBaseIngredient,db.strToppingIngredient);
	}
	protected Piece getPiece(int pieceType) {
		if (pieceType == BASE_TOPPING)
			return new BaseTopping(db.getSelectedIngredient(1,view.getBaseIngredient()),db.getSelectedIngredient(2,view.getToppingIngredient()));
		else{
			return handler.getPiece(pieceType);
		}
	}
}
