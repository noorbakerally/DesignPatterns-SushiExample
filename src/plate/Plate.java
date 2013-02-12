package plate;
import ingredient.Ingredient;

import java.util.ArrayList;
import java.util.List;

import App.helpers;

import piece.Piece;
public abstract class Plate {
		protected List <Piece> pieces = new ArrayList <Piece> ();
		protected List <Ingredient> baseSauce = new ArrayList <Ingredient> ();
		

		public void addPiece(Piece piece){
			pieces.add(piece);
		}
		
		public abstract String toString();
		
		
		public void addBaseSauce(Ingredient ingredient){
			baseSauce.add(ingredient);
		}
		
		public boolean isVegeterian(){
			boolean vegeterian = true;
			for (Piece piece:pieces){
				vegeterian = vegeterian && piece.isVegeterian();
			}
			vegeterian = vegeterian && helpers.checkVegeterian(baseSauce);
			return vegeterian;
		}
		
		
		public float getDefaultPrice(){
			float currentDefaultPrice = 0;
			
			return currentDefaultPrice;
		}
		public abstract float getPrice();
}
