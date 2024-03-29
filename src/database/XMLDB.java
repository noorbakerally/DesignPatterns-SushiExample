package database;

import ingredient.CompositeIngredient;import ingredient.Ingredient;import ingredient.SimpleIngredientFactory;import java.io.File;import java.io.IOException;import java.util.ArrayList;import java.util.HashMap;import java.util.List;import java.util.Map;import javax.xml.parsers.DocumentBuilder;import javax.xml.parsers.DocumentBuilderFactory;import javax.xml.parsers.ParserConfigurationException;import org.w3c.dom.Document;import org.w3c.dom.Node;import org.w3c.dom.NodeList;import org.xml.sax.SAXException;
public class XMLDB implements Database {
	
	public Document db;
	public List <Ingredient> ingredientList = new ArrayList <Ingredient> ();
	public List <Ingredient> sauceList = new ArrayList <Ingredient> ();
	public Map <Integer,Ingredient> insideIngredientList = new HashMap<Integer,Ingredient>();
	public Map <Integer,Ingredient> outsideIngredientList = new HashMap<Integer,Ingredient>();
	public Map <Integer,Ingredient> toppingIngredientList = new HashMap<Integer,Ingredient>();
	public Map <Integer,Ingredient> baseIngredientList = new HashMap<Integer,Ingredient>();	
	public Map <Integer,Customer> customerList = new HashMap<Integer,Customer>();	
	
	public List <String> strInsideIngredient = new ArrayList<String>();
	public List <String> strOutsideIngredient = new ArrayList<String>();
	public List <String> strBaseIngredient = new ArrayList<String>();
	public List <String> strToppingIngredient = new ArrayList<String>();
	
	
	public XMLDB(String location,Object configDetails) throws ParserConfigurationException, SAXException, IOException{
		File fXmlFile = new File(location);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		db = dBuilder.parse(fXmlFile);
		generateIngredient();
		generateCustomers();
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
		int baseIngredientCounter=1,toppingIngredientCounter=1,insideIngredientCounter=1,outsideIngredientCounter=1;
		for (Ingredient currentIngredient:ingredientList){
			if (currentIngredient.getPresence().contains("B")){
				baseIngredientList.put(baseIngredientCounter, currentIngredient);
				strBaseIngredient.add(currentIngredient.getName());
				baseIngredientCounter++;
			}
			if (currentIngredient.getPresence().contains("T")){
				toppingIngredientList.put(toppingIngredientCounter, currentIngredient);
				strToppingIngredient.add(currentIngredient.getName());
				toppingIngredientCounter++;
			}
			if (currentIngredient.getPresence().contains("I")){
				insideIngredientList.put(insideIngredientCounter, currentIngredient);
				strInsideIngredient.add(currentIngredient.getName());
				insideIngredientCounter++;
			}
			if (currentIngredient.getPresence().contains("O")){
				outsideIngredientList.put(outsideIngredientCounter, currentIngredient);
				strOutsideIngredient.add(currentIngredient.getName());
				outsideIngredientCounter++;
			}
		}
	}
	void generateCustomers(){
		NodeList customers = db.getElementsByTagName("customers").item(0).getChildNodes();
		for(int i=0; i<customers.getLength(); i++){
			  if (customers.item(i).getNodeType() == Node.ELEMENT_NODE) {
		          // do something with the current element
				  Node currentCustomer = customers.item(i);
				  int id = Integer.valueOf(currentCustomer.getAttributes().getNamedItem("id").getNodeValue());
				  String status = currentCustomer.getAttributes().getNamedItem("status").getNodeValue();
				  customerList.put(id, new Customer(id, status));
			  }
		}
	}
	public List <Ingredient> getAllSelectedIngredient(int Status,String [] selectedIngredient){
			List <Ingredient> selectedIngredientList = new ArrayList <Ingredient> ();
			if (Status ==1){ 
				for (String ingredientStr:selectedIngredient){
					selectedIngredientList.add(insideIngredientList.get(Integer.valueOf(ingredientStr)));
				}
			}
			if (Status ==2){
				for (String ingredientStr:selectedIngredient){
					selectedIngredientList.add(outsideIngredientList.get(Integer.valueOf(ingredientStr)));
				}
			}
			if (Status ==3){
				for (String ingredientStr:selectedIngredient){
					selectedIngredientList.add(toppingIngredientList.get(Integer.valueOf(ingredientStr)));
				}
			}
			if (Status ==4){
				for (String ingredientStr:selectedIngredient){
					selectedIngredientList.add(baseIngredientList.get(Integer.valueOf(ingredientStr)));
				}
			}
			return selectedIngredientList;
		}
	 
	public Ingredient getInsideIngredient(int id) {
		return insideIngredientList.get(id);
	}
	public Ingredient getOutsideIngredient(int id) {
		return outsideIngredientList.get(id);
	}
	public Ingredient getToppingIngredient(int id) {
		return toppingIngredientList.get(id);
	}
	public Ingredient getBaseIngredient(int id) {
		return baseIngredientList.get(id);
	}
	public List<String> getStrInsideIngredient() {
		return strInsideIngredient;
	}
	public List<String> getStrOutsideIngredient() {
		return strOutsideIngredient;
	}
	public List<String> getStrBaseIngredient() {
		return strBaseIngredient;
	}
	public List<String> getStrToppingIngredient() {
		return strToppingIngredient;
	}
	
	@Override
	public Customer getCustomer(int id) {
		return customerList.get(id);
	}
}
