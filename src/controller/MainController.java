package controller;
import java.io.IOException;
import java.util.List;import javax.xml.parsers.ParserConfigurationException;import org.xml.sax.SAXException;import piece.Piece;import plate.Plate;import proxy.Database;import store.*;
public class MainController {
	SushiStore sushiStore;Database db;int plateFranchise;int numberOfPieces;View view;PieceControlHandler handler;
	public interface View{
		int getPlateFranchise();
		int getPlateDecorator();
		int getNumberOfPieces();
		int getPieceType(int pieceNumber);
		void showPlate(Plate plate);
		String[] getIngredient(String ingredientTypeTitle,List <String> ingredient);
	}
	public MainController(Database db,View view) throws ParserConfigurationException, SAXException, IOException{
		this.db = db;
		this.view = view;
		handler = createPieceControlChain();
		launch();
	}
	void launch(){
		plateFranchise = view.getPlateFranchise();
		sushiStore = SimpleStoreFactory.createSushiStore(plateFranchise, db.getSauceList());
		numberOfPieces = view.getNumberOfPieces();
		int currentPieceType;
		for  (int pieceCounter=1;pieceCounter<=numberOfPieces;pieceCounter++){
			currentPieceType = view.getPieceType(pieceCounter);
			Piece tmpPiece = handler.getPiece(currentPieceType);
			sushiStore.addPieces(tmpPiece);
		}
		
		sushiStore.decoratePlate(view.getPlateDecorator());
		view.showPlate(sushiStore.getPlate());
	}
	//setting the control chain
	PieceControlHandler createPieceControlChain(){
		PieceControlHandler controlHandler1 = new RollController(db);
		PieceControlHandler controlHandler2 = new ConeController(db);
		controlHandler1.setNext(controlHandler2);
		PieceControlHandler controlHandler3 = new BaseToppingController(db);
		controlHandler2.setNext(controlHandler3);
		return controlHandler1;
	}
}
