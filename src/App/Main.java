package App;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

import view.MainView;

import controller.MainController;
import controller.PieceControlHandler;
import controller.RollController;

public class Main {
	/**
	 * @param args
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// TODO Auto-generated method stub
		MainController mainController = new MainController(new MainView());
	}
	

}
