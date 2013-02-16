package controller;

import piece.BaseTopping;
import piece.Piece;
import proxy.Database;
import view.PieceView;
public class BaseToppingController extends PieceControlHandler{
	View view;
	Database db;
	public interface View{
		String[] getBaseIngredient();
		String[] getToppingIngredient();
	}
	public BaseToppingController(Database db){
		this.db = db;
		this.view = new PieceView(db.getStrBaseIngredient(),db.getStrToppingIngredient(),"BaseTopping");
	}
	protected Piece getPiece(int pieceType) {
		if (pieceType == BASE_TOPPING)
			//status is the status of placement of the ingredient, 1=inside, 2=outside..
			//the view returns a comma seperated strings where each str is an id,
			return new BaseTopping(db.getAllSelectedIngredient(1,view.getBaseIngredient()),
					db.getAllSelectedIngredient(2,view.getToppingIngredient()));
		else{
			return handler.getPiece(pieceType);
		}
	}
}
