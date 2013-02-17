package priceStrategy;
import database.Customer;
public interface PriceCalculator {
	float getFinalCost(float currentCost,Customer customer);
}
