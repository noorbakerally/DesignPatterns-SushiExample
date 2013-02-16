package plate;

import ingredient.Ingredient;
import piece.Piece;
public class WesternPlate extends Plate {
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String objStr = "\n";
		objStr += "Plate Type: Western Plate with "+pieces.size()+" Piece\n";
		objStr += "PLATE PIECE DETAILS:\n";
		
		int pieceCouter = 1;
		for (Piece currentPiece:pieces){
			objStr += "Piece "+pieceCouter+":\n";
			objStr += "=========";
			objStr += currentPiece.toString() + "\n";
			pieceCouter++;
		}
		objStr += "Western Sauce:";
		for (Ingredient currentSauce:baseSauce){
			objStr += currentSauce.toString()+" ";
		}
		objStr += "\n";
		objStr += "Vegeterian:"+(isVegeterian()? "Plate is Vegeterian\n":"Plate is not Vegeterian\n");
		objStr += "Price:£"+getPrice()+"\n";
		return objStr;
	}

	@Override
	public float getPrice() {
		return getDefaultPrice()+3;
	}

}
