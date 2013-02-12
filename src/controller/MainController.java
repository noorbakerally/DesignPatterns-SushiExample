package controller;
import java.io.IOException;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import App.DB;
import piece.Piece;
import plate.Plate;
import store.*;
public class MainController {
	SushiStore sushiStore;DB db;int plateFranchise;int numberOfPieces;View view;PieceControlHandler handler;
	public interface View{
		int getPlateFranchise();
		int getNumberOfPieces();
		int getPieceType(int pieceNumber);
		void showPlate(Plate plate);
		String[] getIngredient(String ingredientTypeTitle,List <String> ingredient);
	}
	public MainController(View view) throws ParserConfigurationException, SAXException, IOException{
		db = new DB();
		this.view = view;
		handler = createPieceControlChain();
		launch();
	}
	void launch(){
		plateFranchise = view.getPlateFranchise();
		sushiStore = SimpleStoreFactory.createSushiStore(plateFranchise, db.sauceList);
		numberOfPieces = view.getNumberOfPieces();
		int currentPieceType;
		for  (int pieceCounter=1;pieceCounter<=numberOfPieces;pieceCounter++){
			currentPieceType = view.getPieceType(pieceCounter);
			Piece tmpPiece = handler.buildPiece(currentPieceType);
			sushiStore.addPieces(tmpPiece);
		}
		view.showPlate(sushiStore.getPlate());
	}
	PieceControlHandler createPieceControlChain(){
		PieceControlHandler controlHandler1 = new RollController(db);
		PieceControlHandler controlHandler2 = new ConeController(db);
		controlHandler1.setNext(controlHandler2);
		PieceControlHandler controlHandler3 = new BaseToppingController(db);
		controlHandler2.setNext(controlHandler3);
		return controlHandler1;
	}
}
