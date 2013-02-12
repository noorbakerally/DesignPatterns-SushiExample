package App;
import java.util.List;
import java.util.Scanner;

import ingredient.Ingredient;;
public class helpers {

	public static boolean checkVegeterian(List <Ingredient> ingredientList){
		boolean isVegeterian = true;
		for (Ingredient ingredient:ingredientList){
			isVegeterian = isVegeterian && ingredient.getIsVegeterian();
		}
		return isVegeterian;
	}
	
	public static String getChoice(String title,List <String> choices){
		String mainChoice = null; 
		Scanner in = new Scanner(System.in);
		System.out.println("\n"+title);
		int choiceNum = 1;
		for (String currentChoice:choices){
			System.out.println(choiceNum+". "+currentChoice);
			choiceNum ++;
		}
		System.out.print("Enter Choice:");
		mainChoice = in.next();
		return mainChoice;
	}
}
