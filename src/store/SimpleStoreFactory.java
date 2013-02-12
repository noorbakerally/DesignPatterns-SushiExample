package store;
import java.util.List;

import ingredient.*;
public class SimpleStoreFactory {
	public static SushiStore createSushiStore(int plateFranchise,List <Ingredient> sauceList){
		if (plateFranchise == 1){
			return new JapaneseSushiStore(sauceList);
		} else {
			return new WesternSushiStore(sauceList);
		}
	}
}
