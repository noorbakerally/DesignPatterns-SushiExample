package priceStrategy;
import database.Customer;
public class FirsttimePriceCalculator implements PriceCalculator{
	@Override
	public float getFinalCost(float currentCost,Customer customer) {
		// TODO Auto-generated method stub
		return (float) (currentCost*0.1);
	}
}
