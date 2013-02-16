package store;


import ingredient.Ingredient;
import java.util.List;
import piece.Piece;
import plate.MeatPlateDecorator;
import plate.Plate;
import plate.TomatoPlateDecorator;
public abstract class SushiStore {
	protected List<Ingredient> baseSauceList;
	Plate plate;
	static int TOMATO_DECORATOR = 1;
	static int MEAT_DECORATOR = 2;
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
	public void decoratePlate(int plateDecorator) {
		if (plateDecorator == TOMATO_DECORATOR) this.plate = new TomatoPlateDecorator(plate);  //tomato decorator
		if (plateDecorator == MEAT_DECORATOR) this.plate = new MeatPlateDecorator(plate); //meat decorator
	}
}
