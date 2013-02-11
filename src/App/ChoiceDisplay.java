package App;
import java.util.List;
import java.util.Scanner;
public class ChoiceDisplay {
	public static int getChoice(String title,List <String> choices){
		String mainChoice = null; 
		Scanner in = new Scanner(System.in);
		System.out.println("\n"+title);
		do {
			if (mainChoice != null) System.out.println("Please enter a 'decent' choice :-)");
			int choiceNum = 1;
			for (String currentChoice:choices){
				System.out.println(choiceNum+". "+currentChoice);
				choiceNum ++;
			}
			System.out.print("Enter Choice:");
			mainChoice = in.next();
		} while (!mainChoice.matches("^[1-"+((choices.size()>9)? 9:choices.size())+"]*$") && 
				Integer.valueOf(mainChoice) < 1 || Integer.valueOf(mainChoice) > choices.size());
		return Integer.valueOf(mainChoice).intValue();
	}
	
	public static String getChoices(String title,List <String> choices){
		String mainChoice = null; 
		Scanner in = new Scanner(System.in);
		System.out.println("\n"+title);
		//perform a validation for each choice
		//do {
			if (mainChoice != null) {
				System.out.println("Your choice is"+mainChoice);
				System.out.println("Please enter a choice between 1 and "+choices.size());
			}
			int choiceNum = 1;
			for (String currentChoice:choices){
				System.out.println(choiceNum+". "+currentChoice);
				choiceNum ++;
			}
			System.out.print("Enter Choice:");
			mainChoice = in.next();
			
			
		//} while (true);
		return mainChoice;
	}
	
}
