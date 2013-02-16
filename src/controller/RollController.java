package controller;
import piece.Piece;
import piece.Roll;import proxy.Database;import view.RollView;

public class RollController extends PieceControlHandler{
	View view;
	Database db;
	public interface View{
		String[] getInsideIngredient();
		String[] getOutsideIngredient();
		String[] getToppingIngredient();
	}
	
	public RollController(Database db){
		this.db = db;
		this.view = new RollView(db.getStrInsideIngredient(), db.getStrOutsideIngredient(), db.getStrToppingIngredient());
	}
	
	protected Piece getPiece(int pieceType) {
		if (pieceType == ROLL)
			return new Roll(db.getAllSelectedIngredient(1,view.getInsideIngredient()),
					db.getAllSelectedIngredient(2,view.getOutsideIngredient()),
					db.getAllSelectedIngredient(4,view.getToppingIngredient()));
		else{
			return handler.getPiece(pieceType);
		}
	}

	
}
