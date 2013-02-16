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
		String objStr = "";
		objStr = "Vegeterian:"+(isVegeterian()? "Plate is Vegeterian\n":"Plate is not Vegeterian\n");
		objStr += "Price:£"+getPrice()+"\n";
		return decoratedPlate.toString()+objStr;
	}
	public float getPrice(){
		return (decoratedPlate.getPrice()+5);
	} 

}
