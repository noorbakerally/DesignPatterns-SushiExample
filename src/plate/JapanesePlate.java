package plate;

import ingredient.Ingredient;
import piece.Piece;
public class JapanesePlate extends Plate {
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String objStr = "\n";
		objStr += "Plate Type: Japanese Plate with "+pieces.size()+" Piece\n";
		objStr += "PLATE PIECE DETAILS:\n";
		
		int pieceCouter = 1;
		for (Piece currentPiece:pieces){
			objStr += "Piece "+pieceCouter+":\n";
			objStr += "=========";
			objStr += currentPiece.toString() + "\n";
			pieceCouter++;
		}
		objStr += "Japanese Sauce:";
		for (Ingredient currentSauce:baseSauce){
			objStr += currentSauce.toString()+" ";
		}
		objStr += "\n";
		return objStr;
	}

	@Override
	public float getPrice() {
		return getDefaultPrice();
	}
}
