package App;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import plate.Plate;

import store.JapaneseSushiStore;
import store.SimpleStoreFactory;
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
		SushiStore sushiStore;
		Plate plate;
		LoadDB loadDB = new LoadDB();
		int plateFranchise = Integer.valueOf(ChoiceDisplay.getChoices("Select a Plate",new ArrayList<String>() {{add("Japanese Plate");add("Western Plate"); }}));
		sushiStore = SimpleStoreFactory.createSushiStore(plateFranchise, loadDB);
		System.out.println(sushiStore.getDetails());
	}
	

}
