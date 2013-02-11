package store;

import App.LoadDB;

public class SimpleStoreFactory {
	public static SushiStore createSushiStore(int plateFranchise,LoadDB loadDB){
		if (plateFranchise == 1){
			return new JapaneseSushiStore(loadDB.ingredientList,loadDB.sauceList);
		} else {
			return new WesternSushiStore(loadDB.ingredientList,loadDB.sauceList);
		}
	}
}
