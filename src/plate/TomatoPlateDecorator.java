package plate;

public class TomatoPlateDecorator extends PlateDecorator{

	public TomatoPlateDecorator(Plate decoratedPlate) {
		super(decoratedPlate);
		// TODO Auto-generated constructor stub
	}
	public boolean isVegeterian(){
		//can be false directly
		//just showing the use of the protected instance variable
		return (decoratedPlate.isVegeterian() && true);
	}
	
	public String toString(){
		return decoratedPlate.toString()+"\nPlate decorated with Tomato";
	}
	public float getPrice(){
		//hardcoding price for the Tomato
		return (decoratedPlate.getPrice()+2);
	} 
}
