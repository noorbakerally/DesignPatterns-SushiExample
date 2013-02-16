package plate;

public abstract class PlateDecorator extends Plate{
	protected Plate decoratedPlate;
	
	public PlateDecorator(Plate decoratedPlate){
			this.decoratedPlate = decoratedPlate;
	}
	public boolean isVegeterian(){
		return decoratedPlate.isVegeterian();
	}
	public String toString(){
		return decoratedPlate.toString();
	}
	public float getPrice(){
		return decoratedPlate.getPrice();
	} 
}
