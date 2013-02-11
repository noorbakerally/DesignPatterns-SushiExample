package App;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import plate.Plate;

import store.JapaneseSushiStore;
import store.SushiStore;
import store.WesternSushiStore;



public class Main {
	/**
	 * @param args
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// TODO Auto-generated method stub
		SushiStore s1;
		Plate plate;
		LoadDB loadDB = new LoadDB();
		int plateFranchise = ChoiceDisplay.getChoice("Select a Plate",new ArrayList<String>() {{add("Japanese Plate");add("Western Plate"); }});
		if (plateFranchise == 1){
			s1 = new JapaneseSushiStore(loadDB.ingredientList,loadDB.sauceList);
		} else {
			s1 = new WesternSushiStore(loadDB.ingredientList,loadDB.sauceList);
		}
		s1.getDetails();
	}
	

}
