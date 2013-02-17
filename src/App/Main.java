package App;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;import org.xml.sax.SAXException;import view.MainView;import controller.MainController;
import database.Database;
import database.XMLDB;
public class Main {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		Database db = new XMLDB("info/Plates.xml", null);
		new MainController(db,new MainView());
	}
}
