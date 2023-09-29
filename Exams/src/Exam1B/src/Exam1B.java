/**
 * 
 */
import java.util.Scanner; //needed for scanner class

/** DeWayne Rotenberry
 * September 29, 2023
 * Exam1B
 * Displays welcome message, ask user for text input, prints out length and location of character in text input
 */
public class Exam1B {
	public static void main (String[] args) {
		
		String name; //hold name
		
		//hello message
		System.out.println("Welcome!");
		
		//scanner object to read input 
		Scanner keyboard= new Scanner(System.in);
		
		//ask user for input
		System.out.print("What is your name? ");
		name = keyboard.nextLine();
		
		//prints length of input
		System.out.println(name.length());
		
		//ask for character from input
		System.out.print("Enter character from name: ");
		char input = keyboard.nextLine().charAt(0);
		
		//printout first occurrence of character
		System.out.println(name.indexOf(input));
	}
	

}
