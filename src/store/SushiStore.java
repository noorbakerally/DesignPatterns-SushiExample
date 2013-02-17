package store;
import ingredient.Ingredient;

import java.text.DecimalFormat;
import java.util.List;import database.Customer;import piece.Piece;import plate.MeatPlateDecorator;import plate.Plate;import plate.TomatoPlateDecorator;import priceStrategy.FaithfulPriceCalculator;import priceStrategy.FirsttimePriceCalculator;import priceStrategy.PriceCalculator;import priceStrategy.UsualPriceCalculator;public abstract class SushiStore {
	protected List<Ingredient> baseSauceList;
	Plate plate;
	static int TOMATO_DECORATOR = 1;
	static int MEAT_DECORATOR = 2;
	protected PriceCalculator priceCalculator;
	protected Customer currentCustomer;
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
	public String getPlateDetails(){
		DecimalFormat df = new DecimalFormat("0.00##");
		float platePrice = priceCalculator.getFinalCost(plate.getPrice(), currentCustomer);
		return plate.toString()+"Price:£"+df.format(plate.getPrice())
				+"\nDiscount:£"+df.format(plate.getPrice()-platePrice)
				+"\nFinal Price:£"+df.format(platePrice)+"\n";
	}
	public void setCurrentCustomer(Customer customer){
		currentCustomer = customer;
		setPriceCalculator(currentCustomer.getStatus());
	}
	public void decoratePlate(int plateDecorator) {
		if (plateDecorator == TOMATO_DECORATOR) this.plate = new TomatoPlateDecorator(plate);  //tomato decorator
		if (plateDecorator == MEAT_DECORATOR) this.plate = new MeatPlateDecorator(plate); //meat decorator
	}
	public void setPriceCalculator(String customerStatus){
		if (customerStatus.equals("faithful")) priceCalculator = new FaithfulPriceCalculator();
		if (customerStatus.equals("firsttime")) priceCalculator = new FirsttimePriceCalculator();
		if (customerStatus.equals("usual")) priceCalculator = new UsualPriceCalculator();
	}
}
