package App;

import ingredient.CompositeIngredient;
import ingredient.Ingredient;
import ingredient.SimpleIngredientFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class LoadDB {
	Document db;
	public List <Ingredient> ingredientList = new ArrayList <Ingredient> ();
	public List <Ingredient> sauceList = new ArrayList <Ingredient> ();
	
	public LoadDB() throws ParserConfigurationException, SAXException, IOException{
		File fXmlFile = new File("info/Plates.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		db = dBuilder.parse(fXmlFile);
		generateIngredient();
		
		
	}
	
	public List <Ingredient> getSauceList(){
		return sauceList;
	}
	
	public List <Ingredient> getIngredientList(){
		return ingredientList;
	}
	
	
	
	void generateIngredient(){
		NodeList ingredients = db.getElementsByTagName("ingredients").item(0).getChildNodes();
		for(int i=0; i<ingredients.getLength(); i++){
			  if (ingredients.item(i).getNodeType() == Node.ELEMENT_NODE) {
		          // do something with the current element
				  Node currentIngredient = ingredients.item(i);
				  String id= currentIngredient.getAttributes().getNamedItem("id").getNodeValue();
				  String ingredientName = currentIngredient.getAttributes().getNamedItem("name").getNodeValue();
				  String description = currentIngredient.getAttributes().getNamedItem("description").getNodeValue();
				  
				  String presence = currentIngredient.getAttributes().getNamedItem("presence").getNodeValue();
				  
				  Ingredient ingredient = SimpleIngredientFactory.createIngredient(Integer.valueOf(id).intValue(),ingredientName,description.contains("V"),
						  description.contains("S"),description.contains("D"),presence);
				  
				  if (currentIngredient.getAttributes().getNamedItem("composite") == null){
					  String pricePerUnit = currentIngredient.getAttributes().getNamedItem("pricePerUnit").getNodeValue();
					  ingredient.setPricePerUnit(Float.valueOf(pricePerUnit).floatValue());
					  if (currentIngredient.getAttributes().getNamedItem("isSauce") != null){
						 
						  ingredient.setRegion(currentIngredient.getAttributes().getNamedItem("region").getNodeValue());
						  sauceList.add(ingredient);
					  }
				  }
				  else {
					  String unitDescription []= description.split(",");
					  ingredient = new CompositeIngredient(Integer.valueOf(id).intValue(),ingredientName);
					  ingredient.setPresence(presence);
					  for (String currentUnitDescription:unitDescription){
						  for (Ingredient searchIng:ingredientList){
							  if (searchIng.getId() == Integer.valueOf(currentUnitDescription.substring
									  (0, currentUnitDescription.indexOf("#"))).intValue()){
								  ingredient.addIngredient(searchIng);
							  }
						  } 
					  }
				  }
				  ingredientList.add(ingredient);
		      }
		}
	}
}
