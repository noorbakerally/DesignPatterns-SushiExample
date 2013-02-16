package controller;
import piece.Piece;
import proxy.Database;
public abstract class PieceControlHandler {
	public static int ROLL = 1;
    public static int CONE = 2;
    public static int BASE_TOPPING = 3;
    
    protected PieceControlHandler handler;
    protected abstract Piece getPiece(int pieceType);
    protected Database db;
    public void setNext(PieceControlHandler handler){
    	this.handler = handler;
    }
}
