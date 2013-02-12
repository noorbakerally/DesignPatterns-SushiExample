package store;


import ingredient.Ingredient;
import java.util.List;
import piece.Piece;
import plate.Plate;
public abstract class SushiStore {
	protected List<Ingredient> baseSauceList;
	Plate plate;
	public SushiStore(List <Ingredient> baseSauceList) {	
		this.baseSauceList = baseSauceList;
		plate = createPlate();
	}
	public abstract Plate createPlate();
	public void addBaseSauce(Ingredient ingredient){
		baseSauceList.add(ingredient);
	}
	public void addPieces(Piece piece){
			plate.addPiece(piece);
	}
	public Plate getPlate(){
		return plate;
	}
}
