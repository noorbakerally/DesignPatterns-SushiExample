package priceStrategy;
import database.Customer;
public class UsualPriceCalculator implements PriceCalculator{
	@Override
	public float getFinalCost(float currentCost,Customer customer) {
		return (float) (currentCost*0.8);
	}

}
