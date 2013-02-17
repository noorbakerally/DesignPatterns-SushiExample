package priceStrategy;

import database.Customer;
public class FaithfulPriceCalculator implements PriceCalculator{
	@Override
	public float getFinalCost(float currentCost,Customer customer) {
		//a more complex pricing strategy will be developed
		//that takes into consideration the customer activity
		//reason why the method is parametrized with customer object
		return (float) (currentCost*0.7);
	}
}
