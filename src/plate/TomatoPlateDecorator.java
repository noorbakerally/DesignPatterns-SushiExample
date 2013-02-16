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
		String objStr = "";
		objStr = "Vegeterian:"+(isVegeterian()? "Plate is Vegeterian\n":"Plate is not Vegeterian\n");
		objStr += "Price:£"+getPrice()+"\n";
		return decoratedPlate.toString()+objStr;
	}
	public float getPrice(){
		return (decoratedPlate.getPrice()+2);
	} 
}
