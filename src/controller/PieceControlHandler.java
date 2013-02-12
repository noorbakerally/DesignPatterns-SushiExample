package controller;

import ingredient.Ingredient;

import java.util.ArrayList;
import java.util.List;

import App.DB;
import piece.Piece;

public abstract class PieceControlHandler {
	public static int ROLL = 1;
    public static int CONE = 2;
    public static int BASE_TOPPING = 3;
    
    protected PieceControlHandler handler;
    protected abstract Piece buildPiece(int pieceType);
    protected DB db;
    public void setNext(PieceControlHandler handler){
    	this.handler = handler;
    }
}
