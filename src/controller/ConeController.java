package controller;
import database.Database;
import piece.Cone;
import piece.Piece;import view.PieceView;
public class ConeController extends PieceControlHandler{
	View view;
	Database db;
	public interface View{
		String[] getInsideIngredient();
		String[] getOutsideIngredient();
	}
	public ConeController(Database db){
		this.db = db;
		this.view = new PieceView(db.getStrInsideIngredient(), db.getStrOutsideIngredient(),"Cone");;
	}
	protected Piece getPiece(int pieceType) {
		if (pieceType == CONE)
			return new Cone(db.getAllSelectedIngredient(1,view.getInsideIngredient()),db.getAllSelectedIngredient(2,view.getOutsideIngredient()));
		else{
			return handler.getPiece(pieceType);
		}
	}
}
