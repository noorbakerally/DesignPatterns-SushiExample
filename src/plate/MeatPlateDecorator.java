package plate;

public class MeatPlateDecorator extends PlateDecorator{

	public MeatPlateDecorator(Plate decoratedPlate) {
		super(decoratedPlate);
	}
	
	public boolean isVegeterian(){
		//can be false directly
		//just showing the use of the protected instance variable
		return (decoratedPlate.isVegeterian() && false);
	}
	
	public String toString(){
		return decoratedPlate.toString()+"\nPlate decorated with Meat";
	}
	public float getPrice(){
		//hardcoding price for the meat
		return (decoratedPlate.getPrice()+5);
	} 

}
